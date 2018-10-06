package com.x.jk.mybatis.mapper;

import com.x.jk.po.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeviceMapper {
    List<DeviceInfo> getAllBySchoolId(int id,int first,int last);

    DeviceInfo getDeviceById(Integer id);

    Integer getDevCounts(Integer id);
}
