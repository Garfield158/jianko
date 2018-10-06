package com.x.jk.po.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "LB")
@PropertySource(value = "classpath:config/webSetting.properties")
public class WebSetting {
   private String baiduYU;

    public String getBaiduYU() {
        return baiduYU;
    }

    public void setBaiduYU(String baiduYU) {
        this.baiduYU = baiduYU;
    }
}
