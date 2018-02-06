package com.squirrel.springcloud.provider.gen.config;

import com.squirrel.springcloud.provider.common.util.PropertyUtil;
import com.squirrel.springcloud.provider.common.util.XmlUtil;
import com.squirrel.springcloud.provider.gen.status.DBTypeEnum;
import com.squirrel.springcloud.provider.gen.status.GenTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 配置类
 * @Author: JoinHan
 * @Date: Created in 12:56 2018/2/2
 * @Modified By：
 */
public class GenConfig {
    private static Logger logger = LoggerFactory.getLogger(GenConfig.class);

    private static String DICTIONARY_PATH = "classpath:dictionary.xml";
    private static String PRPPERTIES_PATH = "classpath:gen.properties";

    private GenDictionary dictionary = null;//基础数据 字典数据
    private Properties properties = null;//默认 properties 配置数据
    private Properties dbproperties = null;//dbproperties 数据库配置

    //默认从数据库中指定表生成 （作为jar使用）
    public GenTypeEnum genTypeEnum = GenTypeEnum.DBTableAssign;
    private List<TableDataModal> tableNames;//要生成的表列表

    //用户配置
    private static String GEN_PREFIX = "gen.";
    private Map<String,String> genMap = new HashMap<>();


    // 暂不生成页面Map 页面属性数据 支持自定义

    //默认各个包的路径

    public GenConfig() {
        //读基础数据 字典数据 properties数据 （默认  有新的配置数据会替换掉）
        logger.info("加载dictionary文件......."+DICTIONARY_PATH);
        this.dictionary = (GenDictionary) XmlUtil.xmlToObject(DICTIONARY_PATH, GenDictionary.class);
        logger.info("加载properties文件......."+PRPPERTIES_PATH);
        this.properties = PropertyUtil.loadProps(PRPPERTIES_PATH);
        //初始化要处理的表
        tableNames = new ArrayList<>();

        dbproperties = new Properties();
        for(Object obj :properties.keySet()){//遍历取出数据的配置
            String key = (String)obj;
            if(key.contains(DbManger.DBPREFIX)){
                String propertiesName = key.replace(DbManger.DBPREFIX,"");
                dbproperties.setProperty(propertiesName,(String)properties.get(key));
            }
            if(key.contains(GEN_PREFIX)){
                String propertiesName = key.replace(GEN_PREFIX,"");
                genMap.put(propertiesName,(String)properties.get(key));
            }

        }

    }

    public Properties getDBProperties(){
        return dbproperties;
    }

    public GenDictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(GenDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void updateProperties(String name, String value){
        properties.setProperty(name,value);
    }

    public List<TableDataModal> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<TableDataModal> tableNames) {
        this.tableNames = tableNames;
    }

    public void addTable(TableDataModal tableName) {
        this.tableNames.add(tableName);
    }

    public GenTypeEnum getGenTypeEnum() {
        return genTypeEnum;
    }

    public void setGenTypeEnum(GenTypeEnum genTypeEnum) {
        this.genTypeEnum = genTypeEnum;
    }

    public String getBasicPackage() {
        return genMap.get("basicPackage");
    }

    public void setBasicPackage(String basicPackage) {
        genMap.put("basicPackage",basicPackage);
    }

    public String getModuleName() {
        return genMap.get("moduleName");
    }

    public void setModuleName(String moduleName) {
        genMap.put("moduleName",moduleName);
    }

    public String getLocation() {
        return genMap.get("location");
    }

    public void setLocation(String location) {
        genMap.put("location",location);
    }

    public String getAuthor() {
        return genMap.get("author");
    }

    public void setAuthor(String author) {
        genMap.put("author",author);
    }

    public String getVersion() {
        return genMap.get("version");
    }

    public void setVersion(String version) {
        genMap.put("version",version);
    }
}
