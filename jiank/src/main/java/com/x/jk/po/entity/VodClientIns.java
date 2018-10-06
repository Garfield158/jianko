package com.x.jk.po.entity;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.vod.VodClient;
import com.x.jk.po.properties.WebSetting;
import org.springframework.beans.factory.annotation.Autowired;


public class VodClientIns {


    private static String ACCESS_KEY_ID = "1865d0004d2c4cc8898268b5b6bf493b";
    private static String SECRET_ACCESS_KEY ="1d1675c67a2b471e88be39346eb01a2f";

    public static VodClient VodClientInstent(){
        BceClientConfiguration config = new BceClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
       // config.setEndpoint("http://vod.bj.baidubce.com");
        config.setEndpoint("http://vod.bj.baidubce.com");
        return new VodClient(config);
    }

    public  void setAccessKeyId(String accessKeyId) {
        ACCESS_KEY_ID = accessKeyId;
    }
    public  void setSecretAccessKey(String secretAccessKey) {
        SECRET_ACCESS_KEY = secretAccessKey;
    }
}
