package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author a
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @Entity com.itbaizhan.openhis.domain.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {

    List<Long> queryMenuIdsByRoleId(@Param("roleId") Long roleId);

    Long queryChildCountByMenuId(@Param("menuId") Long menuId);
}




