package com.squirrel.springcloud.squirrel.common.base;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * service支持类
 * Created by JoinHan on 2017/4/17.
 */
public interface BaseService<Record, Example> {

	/**
	 * 根据Record 实体类 进行简单查询
	 * @param record
	 * @return List<Record>
	 */
    List<Record> findListByRecord(Record record);

	/**
	 * 根据Example 进行复杂查询
	 * @param example
	 * @return
	 */
	List<Record> findListByExample(Example example);

	/**
	 * 根据Record 实体类 进行简单查询，附带BLOB字段
	 * @param record
	 * @return List<Record>
	 */
	default List<Record> findListByRecordWithBLOBs(Record record){
	     return null;
    }

	/**
	 * 根据Example 进行复杂查询，附带BLOB字段
	 * @param example
	 * @return List<Record>
	 */
    default List<Record> findListByExampleWithBLOBs(Example example){
	    return null;
    }

	/**
	 * 根据Record 实体类 进行简单查询并按页码分页
	 * @param record
	 * @param pageNum 页数
	 * @param pageSize 每页记录数
	 * @return List<Record>
	 */
	List<Record> findListByRecordForPage(Record record, Integer pageNum, Integer pageSize);

	/**
	 * 根据Example 进行复杂查询并按页码分页
	 * @param example 条件
	 * @param pageNum 页数
	 * @param pageSize 每页记录数
	 * @return
	 */
	List<Record> findListByExampleForPage(Example example, Integer pageNum, Integer pageSize);

	/**
	 * 根据Record 实体类 进行简单查询并按页码分页，附带BLOB字段
	 * @param record
	 * @param pageNum 页数
	 * @param pageSize 每页记录数
	 * @return List<Record>
	 */
    default List<Record> findListByRecordWithBLOBsForPage(Record record, Integer pageNum, Integer pageSize){
        return null;
    }

	/**
	 * 根据Example 进行复杂查询并按页码分页，附带BLOB字段
	 * @param example 条件
	 * @param pageNum 页数
	 * @param pageSize 每页记录数
	 * @return
	 */
    default List<Record> findListByExampleWithBLOBsForPage(Example example, Integer pageNum, Integer pageSize){
        return null;
    }

	/**
	 * 根据主键 查询记录
	 * @param id
	 * @return
	 */
	Record selectByPrimaryKey(Long id);

	/**
	 * 根据Record 查询记录 有多个返回第一条
	 * @param record
	 * @return
	 */
	Record selectByRecord(Record record);

	/**
	 * 根据Record 实体类 查询记录数量
	 * @param record
	 * @return int
	 */
	int countByRecord(Record record);

	/**
	 * 根据Example 查询记录数量
	 * @param example
	 * @return int
	 */
	int countByExample(Example example);

	/**
	 * 根据Record 删除记录 注意 物理删除
	 * @param record
	 * @return int
	 */
	int deleteByRecord(Record record);

	/**
	 * 根据Example 删除记录 注意 物理删除
	 * @param example
	 * @return int
	 */
	int deleteByExample(Example example);

	/**
	 * 根据主键 删除记录
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 根据主键 批量删除记录
	 * @param ids
	 * @return
	 */
	int deleteByPrimaryKeys(String ids);

	/**
	 * 新增记录
	 * @param record
	 * @return int
	 */
    int insertRecord(Record record);

	/**
	 * 插入记录有效字段
	 * @param record
	 * @return
	 */
	int insertSelective(Record record);

	/**
	 * 根据Example 更新记录
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExample(@Param("record") Record record, @Param("example") Example example);

	/**
	 * 根据主键更新记录有效字段
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Record record);

	/**
	 * 根据主键更新记录，附带BLOB字段
	 * @param record
	 * @return
	 */
    default int updateByPrimaryKeyWithBLOBs(Record record){
        return 0;
    }

	/**
	 * 根据Example 更新有效字段
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

	/**
	 * 根据Example 更新记录有效字段，附带BLOB字段
	 * @param record
	 * @param example
	 * @return
	 */
    default int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example){
        return 0;
    }

	/**
	 * 根据主键更新记录
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Record record);


	/**
	 * 获取service出错原因
	 * @return String
	 */
    String getErrorInfo();

	/**
	 * 初始化mapper
	 */
	void initMapper();

	/**
	 * 必须实现的方法 这个方法是系统根据 record 查询数据的依据
	 * 只用于简单的快速查询
	 * 复杂查询需要自己手动实现example
	 * @param record
	 * @return
	 */
	Example getExampleFromEntity(Record record);
}
