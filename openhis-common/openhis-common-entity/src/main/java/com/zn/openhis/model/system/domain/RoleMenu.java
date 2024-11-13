package com.zn.openhis.model.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.zn.openhis.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色和菜单关联表
 * @TableName sys_role_menu
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_role_menu")
@Data
public class RoleMenu extends BaseEntity implements Serializable {
    /**
     * 角色ID
     */
    @TableId(value = "role_id")
    private Long roleId;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id")
    private Long menuId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}