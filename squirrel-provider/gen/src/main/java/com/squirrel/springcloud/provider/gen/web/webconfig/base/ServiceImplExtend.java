package com.squirrel.springcloud.provider.gen.web.webconfig.base;

import com.squirrel.springcloud.provider.common.base.BaseEntity;
import com.squirrel.springcloud.provider.common.base.BaseTableData;
import com.squirrel.springcloud.provider.common.base.ServiceExtend;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class ServiceImplExtend<Mapper, Record, Example> extends BaseServiceImpl<Mapper, Record, Example> implements ServiceExtend<Record, Example>{
    @Override
    public BaseTableData findDataTableByExampleForPage(Example example, Integer pageNum, Integer pageSize) {
        BaseTableData<Record> baseTableData = new BaseTableData();
        List<Record> recordList = findListByExampleForPage(example,pageNum,pageSize);
        baseTableData.setData(recordList);
        baseTableData.setRecordsFiltered(recordList.size());
        //查询总条数
        baseTableData.setRecordsTotal(recordList.size());
        return baseTableData;
    }

    @Override
    public int deleteVirtualByExample(Example example) {
        try {
            Method updateByExample = mapper.getClass().getDeclaredMethod("updateByExample", Object.class);
            Record record = ((Class<Record>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
            Method setDelFlag = record.getClass().getDeclaredMethod("setDelFlag",String.class);
            setDelFlag.invoke(record,BaseEntity.DEL_FLAG_DELETE);
            Object result = updateByExample.invoke(mapper, record, example);
            return Integer.parseInt(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteVirtualByPrimaryKey(Long id) {
        try {
            Record record = ((Class<Record>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
            Method updateByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", Object.class);
            Method setId = record.getClass().getDeclaredMethod("setId",Long.class);
            setId.invoke(record,id);
            Object result = updateByPrimaryKey.invoke(mapper, record);
            return Integer.parseInt(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteVirtualByPrimaryKeys(String ids) {
        try {
            if (StringUtils.isBlank(ids)) {
                return 0;
            }
            String[] idArray = ids.split(",");
            int count = 0;
            for (String idStr : idArray) {
                if (StringUtils.isBlank(idStr)) {
                    continue;
                }
                Long id = Long.parseLong(idStr);
                Object result = deleteVirtualByPrimaryKey(id);
                count += Integer.parseInt(String.valueOf(result));
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Record> findListByRecord(Record record) {
        //仅提供最简单条件的查询   复杂情况需自己实现
        Example example = getExampleFromEntity(record);
        return findListByExample(example);
    }

    @Override
    public Record selectByRecord(Record record) {
        //仅提供最简单条件的查询   复杂情况需自己实现
        Example example = getExampleFromEntity(record);
        List<Record> list = findListByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Record> findListByRecordForPage(Record record, Integer pageNum, Integer pageSize) {
        Example example = getExampleFromEntity(record);
        return findListByExampleForPage(example,pageNum,pageSize);
    }

    @Override
    public BaseTableData findDataTableByRecordForPage(Record record, Integer pageNum, Integer pageSize) {
        Example example = getExampleFromEntity(record);
        return findDataTableByExampleForPage(example,pageNum,pageSize);
    }

    @Override
    public int deleteVirtualByRecord(Record record) {
        Example example = getExampleFromEntity(record);
        return deleteVirtualByExample(example);
    }

    @Override
    public int countByRecord(Record record) {
        Example example = getExampleFromEntity(record);
        return countByExample(example);
    }

    @Override
    public int deleteByRecord(Record record) {
        Example example = getExampleFromEntity(record);
        return deleteByExample(example);
    }
}
