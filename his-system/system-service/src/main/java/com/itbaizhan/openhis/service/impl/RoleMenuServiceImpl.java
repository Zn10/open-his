package com.itbaizhan.openhis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.domain.RoleMenu;
import com.itbaizhan.openhis.mapper.RoleMenuMapper;
import com.itbaizhan.openhis.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Service实现
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService {

}




