package com.itbaizhan.openhis.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 短息发送记录表
 * @TableName sys_sms_log
 */
@TableName(value ="sys_sms_log")
@Data
public class SmsLog extends BaseEntity implements Serializable {
    /**
     * 表id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 发送时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 验证码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 0.发送成功1发送失败
     */
    @TableField(value = "status")
    private String status;

    /**
     * 0注册验证码，1，挂号提醒
     */
    @TableField(value = "type")
    private String type;

    /**
     * 发送失败的错误信息
     */
    @TableField(value = "error_info")
    private String errorInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}