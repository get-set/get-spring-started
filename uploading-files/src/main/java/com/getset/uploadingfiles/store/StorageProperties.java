package com.getset.uploadingfiles.store;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "upload-dir";
}
