package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.NoticeDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【sys_notice(通知公告表)】的数据库操作Service
*/
public interface NoticeService extends IService<Notice> {

    DataGridView listNoticeForPage(NoticeDto noticeDto);

    int addNotice(NoticeDto noticeDto);

    int updateNotice(NoticeDto noticeDto);

    int deleteNoticeByIds(Long[] noticeIds);
}
