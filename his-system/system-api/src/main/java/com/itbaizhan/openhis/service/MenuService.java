package com.itbaizhan.openhis.service;

import com.itbaizhan.openhis.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.dto.MenuDto;

import java.util.List;

/**
* @author a
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
*/
public interface MenuService extends IService<Menu> {

    List<Menu> selectMenuTree(boolean isAdmin);

    List<Menu> listAllMenus(MenuDto menuDto);

    List<Long> getMenuIdsByRoleId(Long roleId);

    Menu getOne(Long menuId);

    int addMenu(MenuDto menuDto);

    int updateMenu(MenuDto menuDto);

    boolean hasChildByMenuId(Long menuId);

    int deleteMenuById(Long menuId);
}
