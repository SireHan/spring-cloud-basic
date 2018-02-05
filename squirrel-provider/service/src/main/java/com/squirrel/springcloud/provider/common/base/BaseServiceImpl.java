package com.squirrel.springcloud.provider.common.base;

import com.github.pagehelper.PageHelper;
import com.squirrel.springcloud.provider.common.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * service支持类
 * Created by JoinHan on 2017/4/17.
 */
public abstract class BaseServiceImpl<Mapper, Record, Example> implements BaseService<Record, Example> {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 错误信息文本
	 */
	protected String errorInfo = "";

	public Mapper mapper;

	/**
	 * 获取service出错原因
	 * @return String
	 */
	public String getErrorInfo(){ return errorInfo;}

	@Override
	public List<Record> findListByExample(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", Object.class);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Record> findListByExampleWithBLOBs(Example example) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", Object.class);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Record> findListByExampleForPage(Example example, Integer pageNum, Integer pageSize) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample", Object.class);
			PageHelper.startPage(pageNum, pageSize, false);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Record> findListByExampleWithBLOBsForPage(Example example, Integer pageNum, Integer pageSize) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExampleWithBLOBs", Object.class);
			PageHelper.startPage(pageNum, pageSize, false);
			Object result = selectByExample.invoke(mapper, example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Record selectByPrimaryKey(Long id) {
		try {
			Method selectByExample = mapper.getClass().getDeclaredMethod("selectByPrimaryKey", Long.class);
			Object result = selectByExample.invoke(mapper,id);
			return (Record) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int countByExample(Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("countByExample", Object.class);
			Object result = countByExample.invoke(mapper, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByExample(Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("deleteByExample", Object.class);
			Object result = countByExample.invoke(mapper, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", Long.class);
			Object result = countByExample.invoke(mapper, id);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKeys(String ids) {
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
				Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey", Long.class);
				Object result = deleteByPrimaryKey.invoke(mapper, id);
				count += Integer.parseInt(String.valueOf(result));
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertRecord(Record record) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("insert", Object.class);
			Object result = countByExample.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertSelective(Record record) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("insertSelective", Object.class);
			Object result = countByExample.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByExample(Record record, Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByExample", Object.class, Object.class);
			Object result = countByExample.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Record record) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective", Object.class);
			Object result = countByExample.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Record record) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByPrimaryKeyWithBLOBs", Object.class);
			Object result = countByExample.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByExampleSelective(Record record, Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByExampleSelective", Object.class, Object.class);
			Object result = countByExample.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByExampleWithBLOBs(Record record, Example example) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByExampleWithBLOBs", Object.class, Object.class);
			Object result = countByExample.invoke(mapper, record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Record record) {
		try {
			Method countByExample = mapper.getClass().getDeclaredMethod("updateByPrimaryKey", Object.class);
			Object result = countByExample.invoke(mapper, record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void initMapper() {
		this.mapper = SpringContextUtil.getBean(getMapperClass());
	}

	/**
	 * 获取类泛型class
	 * @return
	 */
	public Class<Mapper> getMapperClass() {
		return (Class<Mapper>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
