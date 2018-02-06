package com.squirrel.springcloud.provider.gen.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.squirrel.springcloud.provider.gen.status.DBTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 数据库管理类
 * @Author: JoinHan
 * @Date: Created in 10:45 2018/2/2
 * @Modified By：
 */
public class DbManger {

    private static Logger logger = LoggerFactory.getLogger(DbManger.class);
    public static String DBPREFIX = "spring.datasource.master.";//配置文件中数据库配置前缀 默认

    private DruidDataSource druidDataSource = null;
    private Map<String,String> propertiesMap = new HashMap<>();//数据库配置保存
    public DBTypeEnum dbTypeEnum;
    public String dbName;

    private DbManger(Properties properties) throws Exception {
        //提取有用的数据库配置 并替换默认配置 创建连接池
        druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(beforeInit(properties));
    }

    private Properties beforeInit(Properties properties) {
        Properties dbproperties = new Properties();
        for(Object obj :properties.keySet()){//遍历取出数据的配置
            String propertiesName = (String)obj;
            if(propertiesMap.get(propertiesName)==null){
                dbproperties.setProperty(propertiesName,(String)properties.get(propertiesName));
            }else{
                dbproperties.setProperty(propertiesName,propertiesMap.get(propertiesName));
            }
            if(propertiesName.equals("driverClassName")){
                if("com.mysql.jdbc.Driver".equals(properties.get(propertiesName))){
                    dbTypeEnum = DBTypeEnum.MysqlDB;
                }
            }
            if(propertiesName.equals("dbname")){
                dbName=(String)properties.get(propertiesName);
            }
        }
        return dbproperties;
    }

    /**
     * 数据库连接池
     * @return
     */
    public static DbManger initDb(Properties properties){
//        if (null == dbManger){
            try {
                DbManger dbManger = new DbManger(properties);
                return dbManger;
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("初始化数据库连接池失败");
            }
//        }else {
//            logger.error("数据库连接池以有，取默认配置");
//        }
        return null;
    }

    /**
     * 返回druid数据库连接
     * @return
     * @throws SQLException
     */
    public DruidPooledConnection getConnection() throws SQLException {
        return druidDataSource.getConnection();
    }

    public String getName() {
        return propertiesMap.get("name");
    }

    public void setName(String name) {
        propertiesMap.put("name",name);
    }

    public String getUrl() {
        return propertiesMap.get("url");
    }

    public void setUrl(String url) {
        propertiesMap.put("url",url);
    }

    public String getUsername() {
        return propertiesMap.get("username");
    }

    public void setUsername(String username) {
        propertiesMap.put("username",username);
    }

    public String getPassword() {
        return propertiesMap.get("password");
    }

    public void setPassword(String password) {
        propertiesMap.put("password",password);
    }

    public String getDriverClassName() {
        return propertiesMap.get("driverClassName");
    }

    public void setDriverClassName(String driverClassName) {
        propertiesMap.put("driverClassName",driverClassName);
    }
}
