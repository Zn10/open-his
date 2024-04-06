package com.itbaizhan.openhis;

import com.itbaizhan.openhis.domain.DictData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.DictDataDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service
*/
public interface DictDataService extends IService<DictData> {

    DataGridView listForPage(DictDataDto dictDataDto);

    DictData selectDictDataById(Long dictId);

    int insert(DictDataDto dictDataDto);

    int update(DictDataDto dictDataDto);

    int deleteDictData(Long[] dictIds);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType
     * @return
     */
    List<DictData> selectDictDataByDictType(String dictType);
}
