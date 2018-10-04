package com.x.jk.service.impl;



import com.alibaba.fastjson.JSONObject;
import com.x.jk.HttpClientUtil;
import com.x.jk.mybatis.mapper.TokenMapper;
import com.x.jk.po.entity.Token;
import com.x.jk.service.GetToken2Local;
import freemarker.template.SimpleDate;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class GetToken2LocalImpl implements GetToken2Local {
    @Autowired
    private TokenMapper tokenMapper;

    /**定时任务取token*/
    @Scheduled(cron = "0 0 0 * * ?")
    public void getTokenFromServer(){
        String dateStart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("=====自动任务开始"+dateStart+"=====");
        //查询本地的appKey,appSecret
        Token token = getToken();
        Map map = new HashMap();
        map.put("appKey",token.getAppKey());
        map.put("appSecret",token.getSecret());
        String json = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/token/get",map);
        JSONObject jsonObj = JSONObject.parseObject(json);
        JSONObject obj = JSONObject.parseObject(jsonObj.get("data").toString());
        //取得时间戳
        Long expireTime = Long.parseLong(obj.get("expireTime").toString());
        //取得accessToken
        String accessToken = obj.get("accessToken").toString();
        Token token_new = new Token();
        token_new.setExpireTime(expireTime);
        token_new.setToken_rs(accessToken);
        updateToken(token_new);
        String dateEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("=====自动任务结束"+dateEnd+"=====");
    }
    private Token getToken(){
        return tokenMapper.getToken();
    }
    private void updateToken(Token token){
        tokenMapper.updateToken(token);
    }
}
