package com.squirrel.license.client.config;

import com.squirrel.license.common.standalone.EquipmentInfo;
import com.squirrel.license.common.standalone.StandaloneLicenseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  liscence 验证类
 * @Author: JoinHan
 * @Date: Created in 15:57 2018/2/12
 * @Modified By：
 */
@Component
public class LicenseVerify{
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(LicenseVerify.class);

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("----------------------");
        //获取设备信息
        String equipmentInfo = "";
        try(FileInputStream fileInputStream = new FileInputStream(getClassPathFile("classpath:license.lic"))) {
            equipmentInfo = EquipmentInfo.getEquipmentCode();
            StringBuffer sb = new StringBuffer();
            byte[] buff = new byte[1024];
            int i = fileInputStream.read(buff);
            while(i!=-1){
                sb.append(new String(buff,0,i));
                i = fileInputStream.read(buff);
            }
            String license = sb.toString();
            //license 验证失败 退出程序
            if(!StandaloneLicenseUtil.licenseCheck(equipmentInfo,license)){
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File getClassPathFile(String fileName){
        Resource resource = new ClassPathResource(fileName);
        try {
            return resource.getFile();
        }catch (IOException e){
            try {
                return ResourceUtils.getFile(fileName);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
                return null;
            }
        }
    }

}
