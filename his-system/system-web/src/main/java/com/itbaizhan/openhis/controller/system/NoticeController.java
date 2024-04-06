package com.itbaizhan.openhis.controller.system;

import com.itbaizhan.openhis.dto.NoticeDto;
import com.itbaizhan.openhis.service.NoticeService;
import com.itbaizhan.openhis.utils.ShiroSecurityUtils;
import com.itbaizhan.openhis.vo.AjaxResult;
import com.itbaizhan.openhis.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("system/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 分页查询通知
     * @param noticeDto
     * @return
     */
    @GetMapping("listNoticeForPage")
    public AjaxResult listNoticeForPage(NoticeDto noticeDto){
        DataGridView dataGridView = noticeService.listNoticeForPage(noticeDto);
        return AjaxResult.success("查询成功",dataGridView.getData(),dataGridView.getTotal());
    }

    /**
     * 新增通知
     * @param noticeDto
     * @return
     */
    @PostMapping("addNotice")
    public AjaxResult addNotice(@Validated NoticeDto noticeDto){
        noticeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(noticeService.addNotice(noticeDto));
    }

    /**
     * 修改通知
     * @param noticeDto
     * @return
     */
    @PostMapping("updateNotice")
    public AjaxResult updateNotice(@Validated NoticeDto noticeDto){
        noticeDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(noticeService.updateNotice(noticeDto));
    }

    /**
     * 批量删除通知
     * @param noticeIds
     * @return
     */
    @DeleteMapping("deleteNoticeByIds/{noticeIds}")
    public AjaxResult deleteNoticeByIds(@PathVariable @Validated @NotEmpty(message = "要删除的id不能为空")
                                                Long[] noticeIds){
        return AjaxResult.toAjax(noticeService.deleteNoticeByIds(noticeIds));
    }
}
