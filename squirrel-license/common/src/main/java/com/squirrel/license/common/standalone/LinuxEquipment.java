package com.squirrel.license.common.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @Author: JoinHan
 * @Date: Created in 11:42 2018/2/12
 * @Modified By：
 */
public class LinuxEquipment {
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(EquipmentInfo.class);
    /**
     * 获取主板序列号
     *
     * @return
     */
    public static String getMainBordId() {
        String result = "";
        String maniBord_cmd = "dmidecode | grep 'Serial Number' | awk '{print $3}' | tail -1";
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[] { "sh", "-c", maniBord_cmd });// 管道
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
                break;
            }
            br.close();
        } catch (IOException e) {
            logger.error("获取主板信息错误",e);
        }
        return result;
    }

    /**
     * 获取硬盘序列号
     *
     * @param drive
     *            盘符
     * @return
     */
    public static String getHardDiskSN(String drive) {
        String result = "";
        String maniBord_cmd = "dmidecode -s system-serial-number";
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[] { "sh", "-c", maniBord_cmd });// 管道
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
                break;
            }
            br.close();
        } catch (IOException e) {
            logger.error("获取系统序列号错误",e);
        }
        return result;
    }

    /**
     * 获取CPU序列号
     *
     * @return
     */
    public static String getCPUSerial() {
        String result = "";
        String maniBord_cmd = "dmidecode -t processor | grep 'ID'";
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[] { "sh", "-c", maniBord_cmd });// 管道
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
                break;
            }
            br.close();
        } catch (IOException e) {
            logger.error("获取系统序列号错误",e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("CPU  SN:" + WindowsEquipment.getCPUSerial());
        System.out.println("主板  SN:" + WindowsEquipment.getMainBordId());
        System.out.println("C盘   SN:" + WindowsEquipment.getHardDiskSN("c"));
    }
}
