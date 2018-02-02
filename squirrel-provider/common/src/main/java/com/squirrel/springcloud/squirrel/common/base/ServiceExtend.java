package com.squirrel.springcloud.squirrel.common.base;

public interface ServiceExtend<Record,Example> extends BaseService<Record,Example> {
    /**
     * 根据Example 进行复杂查询并按页码分页 返回dataTable 所需数据
     * @param example 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    BaseTableData findDataTableByExampleForPage(Example example, Integer pageNum, Integer pageSize);

    /**
     * 根据Example 进行复杂查询并按页码分页 返回dataTable 所需数据
     * @param record 条件
     * @param pageNum 页数
     * @param pageSize 每页记录数
     * @return
     */
    BaseTableData findDataTableByRecordForPage(Record record, Integer pageNum, Integer pageSize);

    /**
     * 根据Record 虚拟删除记录
     * @param record
     * @return int
     */
    int deleteVirtualByRecord(Record record);

    /**
     * 根据Example 虚拟删除记录
     * @param example
     * @return int
     */
    int deleteVirtualByExample(Example example);

    /**
     * 根据主键 虚拟删除记录
     * @param id
     * @return
     */
    int deleteVirtualByPrimaryKey(Long id);

    /**
     * 根据主键 虚拟批量删除记录
     * @param ids
     * @return
     */
    int deleteVirtualByPrimaryKeys(String ids);
}
