package com.itbaizhan.openhis.controller.system;

import com.itbaizhan.openhis.dto.DictTypeDto;
import com.itbaizhan.openhis.service.DictTypeService;
import com.itbaizhan.openhis.vo.AjaxResult;
import com.itbaizhan.openhis.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system/dict/type")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    /**
     * 分页查询字典类型
     * @param dictTypeDto
     * @return
     */
    @GetMapping("listForPage")
    private AjaxResult listForPage(DictTypeDto dictTypeDto){
        DataGridView dataGridView = dictTypeService.listForPage(dictTypeDto);
        return AjaxResult.success("查询成功",dataGridView.getData(),dataGridView.getTotal());
    }

    @GetMapping("dictCacheAsync")
    public AjaxResult dictCacheAsync(){
        dictTypeService.dictCacheAsync();
        return AjaxResult.success();
    }
}
