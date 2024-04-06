package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.LoginInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.LoginInfoDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【sys_login_info(系统访问记录)】的数据库操作Service
*/
public interface LoginInfoService extends IService<LoginInfo> {

    int insertLoginInfo(LoginInfo loginInfo);

    DataGridView listForPage(LoginInfoDto loginInfoDto);

    int deleteLoginInfoByIds(Long[] infoIds);

    int clearLoginInfo();

}
