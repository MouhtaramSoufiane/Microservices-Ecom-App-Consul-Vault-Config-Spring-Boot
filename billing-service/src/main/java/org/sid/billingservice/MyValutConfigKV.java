package org.sid.billingservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "")
public class MyValutConfigKV {
    private String privateKey;
    private String privateKey1;
    private String privateKey3;
}
