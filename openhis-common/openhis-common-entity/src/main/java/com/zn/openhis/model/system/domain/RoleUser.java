package com.zn.openhis.model.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.zn.openhis.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和角色关联表
 * @TableName sys_role_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="sys_role_user")
@Data
public class RoleUser extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 角色ID
     */
    @TableId(value = "role_id")
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}