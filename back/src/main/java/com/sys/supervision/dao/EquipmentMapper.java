package com.sys.supervision.dao;

import com.alibaba.fastjson.JSONObject;
import com.sys.supervision.entity.db.Equipment;
import com.sys.supervision.model.enhance.EquipGroupByProject;
import com.sys.supervision.model.request.EquipmentListRequest;
import com.sys.supervision.model.response.EquipmentListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    List<Equipment> getAll();

    int count(EquipmentListRequest request);
    List<EquipmentListResponse> query(EquipmentListRequest request);

    List<EquipGroupByProject> getAllGroupByProject();

    int countByDevCode(@Param("devCode") String devCode);

    List<JSONObject> countByGroup();

    void updateStatusByDevCode(@Param("devCode") String devCode,
                               @Param("status") Integer status);
}