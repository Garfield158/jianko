package com.x.jk.service.impl;

import com.x.jk.mybatis.mapper.DeviceMapper;
import com.x.jk.po.entity.DeviceInfo;
import com.x.jk.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public List<DeviceInfo> getDevBySchoolId(int id, int page, int size) {
        List<DeviceInfo> infos = deviceMapper.getAllBySchoolId(id);
        int firstIndex = (page - 1) * size;
        int lastIndex = page * size;
        if (lastIndex>infos.size()){
            return infos.subList(firstIndex, infos.size());
        }
        return infos.subList(firstIndex, lastIndex);
    }

    @Override
    public DeviceInfo getDeviceById(Integer id) {
        return deviceMapper.getDeviceById(id);
    }
}
