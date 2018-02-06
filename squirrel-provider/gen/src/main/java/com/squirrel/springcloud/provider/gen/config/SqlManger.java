package com.squirrel.springcloud.provider.gen.config;

import com.squirrel.springcloud.provider.gen.status.DBTypeEnum;
import com.squirrel.springcloud.provider.gen.status.GenTypeEnum;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成必要的sql 语句
 * <var> 代表要替换的变量
 * @Author: JoinHan
 * @Date: Created in 17:25 2018/2/6
 * @Modified By：
 */
public class SqlManger {

    //查询数据库中所有的表
    public String ALL_TABLE_INFO_SQL;
    //查询数据库某表的字段
    public String ALL_COULMN_INFO_SQL;

    public static SqlManger initSql(GenConfig genConfig, DbManger dbManger) {
        SqlManger sqlManger = new SqlManger();
        if(genConfig.genTypeEnum == GenTypeEnum.DBTableAssign){
            if(dbManger.dbTypeEnum == DBTypeEnum.MysqlDB){
                sqlManger.ALL_TABLE_INFO_SQL = "select table_name tableName,table_schema schemaName from information_schema.tables where table_schema = '"+dbManger.dbName+"' ";
                sqlManger.ALL_COULMN_INFO_SQL = "select table_name tableName,column_name columnName,data_type dataType,column_comment columnComment,table_schema schemaName " +
                        "from information_schema.columns where table_schema = '"+dbManger.dbName+"' and table_name = '<tableName>'";
            }
        }
        return sqlManger;
    }

    public static String replaceVar(String orignal,Map<String,String> param){
        Pattern p = Pattern.compile("<(\\S*)>");
        Matcher matcher = p.matcher(orignal);
        while (matcher.find()) {
            String matcherStr = matcher.group();
            String sub = matcherStr.substring(1, matcherStr.length() - 1);
            String value = param.get(sub);
            if (value!=null) {
                orignal = orignal.replace(matcherStr, value);
            }
        }
        return orignal;
    }
}
