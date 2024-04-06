package com.itbaizhan.openhis;

import com.itbaizhan.openhis.domain.OperLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.OperLogDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Service
*/
public interface OperLogService extends IService<OperLog> {

    DataGridView listForPage(OperLogDto operLogDto);

    int deleteOperLogByIds(Long[] infoIds);

    int clearAllOperLog();

    int insertOperLog(OperLog operLog);

}
