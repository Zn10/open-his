package com.itbaizhan.openhis.dto;

import com.itbaizhan.openhis.domain.SimpleUser;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author:
 * 封装页面上传过来的修改的数据
 */
@ApiModel(value="com-itbaizhan-openhis-dto-SchedulingFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingFormDto implements Serializable {

    private SimpleUser simpleUser;

    private String beginDate;

    private List<SchedulingData> data;

    @Data
    public static class SchedulingData implements  Serializable{
        private Long userId;
        private Long deptId;
        private String subsectionType;//上  下  晚
        //星期几的值班值
        private Collection<String> schedulingType;
    }
}
