package com.itbaizhan.openhis.mapper;

import com.itbaizhan.openhis.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author a
* @description 针对表【sys_role(角色信息表)】的数据库操作Mapper
* @Entity com.itbaizhan.openhis.domain.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
    void deleteRoleUserByUserIds(@Param("userId") List<Long> userId);

    void saveRoleUser(@Param("userId") Long userId, @Param("roleId") Long roleId);

    List<Long> selectRoleIdsByUserId(@Param("userId") Long userId);

    void deleteRoleMenuByRoleIds(@Param("ids") List<Long> ids);

    void deleteRoleUserByRoleIds(@Param("ids") List<Long> ids);

    void saveRoleMenu(@Param("roleId") Long roleId, @Param("menuId") Long menuId);

    void deleteRoleMenuByMenuIds(@Param("ids") List<Long> ids);
}




