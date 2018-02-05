package com.squirrel.springcloud.provider.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Author: JoinHan
 * @Date: Created in 22:44 2018/2/1
 * @Modified By：
 */
public class PropertyUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    public static Properties loadProps(String fileName){
        Properties props = new Properties();
        try(FileInputStream in = new FileInputStream(ResourceUtils.getFile(fileName));){
            //in = PropertyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            props.load(in);
            return props;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
