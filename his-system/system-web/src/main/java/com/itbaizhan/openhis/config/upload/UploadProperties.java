package com.itbaizhan.openhis.config.upload;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "upload")
@Data
public class UploadProperties {
    /**
     * @Description 文件上传属性
     * @Author
     */
    private String baseUrl;

    private List<String> allowTypes;
}
