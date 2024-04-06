package com.itbaizhan.openhis.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.itbaizhan.openhis.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.UserDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
*/
public interface UserService extends IService<User> {

    User queryUserByPhone(String phone);

    DataGridView listUserForPage(UserDto userDto);

    int addUser(UserDto userDto);

    int updateUser(UserDto userDto);

    int deleteUserByIds(Long[] userIds);

    void resetPassword(Long[] userIds);

    List<User> queryUsersNeedScheduling(Long userId,Long deptId);

    /**
     * 查询所有可用的用户
     * @return
     */
    List<User> getAllUsers();
}
