package com.squirrel.springcloud.squirrel.common.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<Record,Example> {

    long countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(Example example);

    default List<Record> selectByExampleWithBLOBs(Example example){
        return null;
    }

    Record selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    default int updateByPrimaryKeyWithBLOBs(Record record){
        return 0;
    }

    default int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example){
        return 0;
    }
}