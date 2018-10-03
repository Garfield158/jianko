package com.x.jk.controller;

import com.x.jk.common.Result;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
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
}
