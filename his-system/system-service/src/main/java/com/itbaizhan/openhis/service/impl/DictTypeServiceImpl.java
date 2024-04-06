package com.itbaizhan.openhis.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.DictTypeService;
import com.itbaizhan.openhis.constants.Constants;
import com.itbaizhan.openhis.domain.DictData;
import com.itbaizhan.openhis.domain.DictType;
import com.itbaizhan.openhis.dto.DictTypeDto;
import com.itbaizhan.openhis.mapper.DictDataMapper;
import com.itbaizhan.openhis.mapper.DictTypeMapper;
import com.itbaizhan.openhis.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author a
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
*/
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Autowired
    private DictDataMapper dictDataMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public DataGridView listForPage(DictTypeDto dictTypeDto) {
        Page<DictType> page = new Page<>(dictTypeDto.getPageNum(), dictTypeDto.getPageSize());
        QueryWrapper<DictType> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(dictTypeDto.getDictName()),
                DictType.COL_DICT_NAME,dictTypeDto.getDictName());
        wrapper.like(StringUtils.isNotBlank(dictTypeDto.getDictType()),
                DictType.COL_DICT_TYPE,dictTypeDto.getDictType());
        wrapper.eq(StringUtils.isNotBlank(dictTypeDto.getStatus()),
                DictType.COL_STATUS,dictTypeDto.getStatus());
        wrapper.ge(dictTypeDto.getBeginTime()!=null,
                DictType.COL_CREATE_TIME,dictTypeDto.getBeginTime());
        wrapper.le(dictTypeDto.getEndTime()!=null,
                DictType.COL_CREATE_TIME,dictTypeDto.getEndTime());
        dictTypeMapper.selectPage(page,wrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public void dictCacheAsync() {
        QueryWrapper<DictType> wrapper = new QueryWrapper<>();
        wrapper.eq(DictType.COL_STATUS, Constants.STATUS_TRUE);
        List<DictType> dictTypes = dictTypeMapper.selectList(wrapper);
        for (DictType dictType : dictTypes) {
            QueryWrapper<DictData> wrapper1 = new QueryWrapper<>();
            wrapper1.eq(DictData.COL_STATUS,Constants.STATUS_TRUE);
            wrapper1.eq(DictData.COL_DICT_TYPE,dictType.getDictType());
            wrapper1.orderByAsc(DictData.COL_DICT_SORT);
            List<DictData> dataList = dictDataMapper.selectList(wrapper1);
            String jsonString = JSON.toJSONString(dataList);
            ValueOperations<String, String> value = redisTemplate.opsForValue();
            value.set(Constants.DICT_REDIS_PREFIX + dictType.getDictType(),jsonString);
        }

    }
}




