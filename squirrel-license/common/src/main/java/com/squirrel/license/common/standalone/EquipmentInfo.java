package com.squirrel.license.common.standalone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

/**
 *  该类用于获取 系统，设备基本信息
 * @Author: JoinHan
 * @Date: Created in 16:35 2018/2/11
 * @Modified By：
 */
public class EquipmentInfo {
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(EquipmentInfo.class);
    private static volatile InetAddress LOCAL_ADDRESS = null;

    /**
     * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
     */
    public static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    /**
     * @return 本机cpu 序列号
     */
    public static String getCPUSerial(){
        String os = getOSName();
        String serial = null;
        if (os.startsWith("windows")) {
            serial = WindowsEquipment.getCPUSerial();
        } else if (os.startsWith("linux")) {
            serial = LinuxEquipment.getCPUSerial();
        }
        return serial;
    }

    /**
     *  获取主板编号 不一定能读出来 泪奔
     * @return
     */
    public static String getMainBordId(){
        String os = getOSName();
        String mainBordId = null;
        if (os.startsWith("windows")) {
            mainBordId = WindowsEquipment.getMainBordId();
        } else if (os.startsWith("linux")) {
            mainBordId = LinuxEquipment.getMainBordId();
        }
        return mainBordId;
    }

    public static void main(String[] args) {
        //获取ip ips
        System.out.println("获取本机可用的一个ip：" + NetUtils.getLocalIP());
        System.out.println("获取本机所有ip地址：" + NetUtils.getLocalIPAll());

        //获取ip ips
        System.out.println("获取本机可用的一个mac：" + NetUtils.getLocalMAC());
        System.out.println("获取本机所有mac地址：" + NetUtils.getLocalMACAll());
        //cpu
        System.out.println("获取本机cpu序列号：" + WindowsEquipment.getCPUSerial());
        //mainBord
        System.out.println("获取本机主板序列号：" + getMainBordId());
    }

    /**
     * 获取机器码 md5 加密
     * @return
     */
    public static String getEquipmentCode() throws Exception{
        //获取设备信息 目前只针对cup 序列号
        String equipmentInfo = getCPUSerial();
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(equipmentInfo.getBytes("utf-8")));
        return newstr;
    }
}
