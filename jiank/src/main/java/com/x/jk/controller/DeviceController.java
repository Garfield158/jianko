package com.x.jk.controller;

import com.x.jk.HttpClientUtil;
import com.x.jk.common.Result;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.po.entity.Token;
import com.x.jk.service.DeviceService;
import com.x.jk.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {
    @Autowired
    TokenService tokenService;
    @Autowired
    DeviceService deviceService;
    @RequestMapping("res/dev/getDev")
    public Result getDeviceBySchoolId(Integer id,Integer page,Integer size){
        if (page==null){
            page=1;
        }
        if (size==null){
            size=10;
        }
        List<DeviceInfo> deviceInfos=deviceService.getDevBySchoolId(id,page,size);
        return Result.bulid(deviceInfos);
    }

    @RequestMapping("res/dev/controlOne")
    public Result controlOneById(Integer id,String direction){
        DeviceInfo deviceInfo = deviceService.getDeviceById(id);
        Token token = tokenService.getToken();
        Map map = new HashMap();
        map.put("accessToken",token.getToken_rs());
        map.put("deviceSerial",deviceInfo.getDevNum());
        map.put("channelNo",String.valueOf(deviceInfo.getChannleNum()));
        map.put("direction",direction);
        map.put("speed","2");
        String data = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/device/ptz/start",map);
        return Result.bulid(data);
    }

    @RequestMapping("res/dev/stopDevice")
    public Result stopDevice(Integer id){
        DeviceInfo deviceInfo = deviceService.getDeviceById(id);
        Token token = tokenService.getToken();
        Map map = new HashMap();
        map.put("accessToken",token.getToken_rs());
        map.put("deviceSerial",deviceInfo.getDevNum());
        map.put("channelNo",String.valueOf(deviceInfo.getChannleNum()));
        String data = HttpClientUtil.sendHttpsPost("https://open.ys7.com/api/lapp/device/ptz/stop",map);
        return Result.bulid(data);
    }

}
