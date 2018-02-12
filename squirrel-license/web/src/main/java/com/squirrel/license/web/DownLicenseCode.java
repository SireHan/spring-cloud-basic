package com.squirrel.license.web;

import com.squirrel.license.common.LicenseInfo;
import com.squirrel.license.common.standalone.StandaloneLicenseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author: JoinHan
 * @Date: Created in 16:05 2018/2/12
 * @Modified By：
 */
@Controller
@RequestMapping(value = "license/")
public class DownLicenseCode {

    /**
     * 下载license文件
     * @param request
     * @param response
     * @param licenseInfo
     */
    @RequestMapping(value = "/down")
    public void download(HttpServletRequest request, HttpServletResponse response, LicenseInfo licenseInfo) {
        //TODO 日志记录 who when down license 验证licenseInfo信息
        if(licenseInfo!=null){
            String license = StandaloneLicenseUtil.generatorLicense(licenseInfo);
            byte[] buff = new byte[1024];
            OutputStream os = null;
            try(ByteArrayInputStream bis = new ByteArrayInputStream(license.getBytes())) {
                String name = "license.lic";
                response.setContentType("application/vnd.ms-excel;charset=UTF-8");
                response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
                os = response.getOutputStream();

                int i = bis.read(buff);
                while (i != -1) {
                    os.write(buff, 0, i);
                    os.flush();
                    i = bis.read(buff);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
