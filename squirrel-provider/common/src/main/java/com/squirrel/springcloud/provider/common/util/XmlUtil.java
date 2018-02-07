package com.squirrel.springcloud.provider.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Xml 操作
 * Created by JoinHan on 2017/7/13.
 */
public class XmlUtil {

    private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * XML文件转换为对象
     * @param fileName
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(String fileName, Class<?> clazz){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = FileUtils.getClassPathFile(fileName);
            Object object = unmarshaller.unmarshal(file);
            return (T)object;
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("Error file convert: {}", e.getMessage());
        }
        return null;
    }

    /**
     * XML文件转换为对象
     * @param is
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(InputStream is, Class<?> clazz){
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object object = unmarshaller.unmarshal(is);
            return (T)object;
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("Error inputStream convert: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 对象转换为xml 输出流
     * @param obj 要转换的对象
     * @param os 输出流
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> void objectToXml(Object obj,OutputStream os){
        try {
            JAXBContext context = JAXBContext.newInstance(((T)obj).getClass());
            Marshaller m = context.createMarshaller();
            m.marshal(obj, os);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("Error Object convert: {}", e.getMessage());
        }
    }

    /**
     * 对象转换为xml
     * @param obj 要转换的对象
     * @param fileName 输出文件
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean objectToXml(Object obj,String fileName){
        try {
            JAXBContext context = JAXBContext.newInstance(((T)obj).getClass());
            Marshaller m = context.createMarshaller();
            File file = new File(fileName);
            // 创建并写入文件
            if (FileUtils.createFile(fileName)){
                m.marshal(obj, file);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("Error Object convert: {}", e.getMessage());
        }
        return false;
    }

}
