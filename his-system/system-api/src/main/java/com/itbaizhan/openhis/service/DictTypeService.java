package com.itbaizhan.openhis;

import com.itbaizhan.openhis.domain.DictType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.DictTypeDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service
*/
public interface DictTypeService extends IService<DictType> {

    DataGridView listForPage(DictTypeDto dictTypeDto);

    void dictCacheAsync();
}
