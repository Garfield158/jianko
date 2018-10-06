package com.x.jk.service;

import com.x.jk.po.entity.DeviceInfo;

import java.util.List;

public interface DeviceService {
    List<DeviceInfo> getDevBySchoolId(int id,int page,int size);

    DeviceInfo getDeviceById(Integer id);
}
