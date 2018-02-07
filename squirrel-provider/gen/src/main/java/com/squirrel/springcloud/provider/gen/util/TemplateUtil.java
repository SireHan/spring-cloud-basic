package com.squirrel.springcloud.provider.gen.util;

import com.squirrel.springcloud.provider.common.util.FileUtils;
import com.squirrel.springcloud.provider.common.util.StringUtils;
import com.squirrel.springcloud.provider.common.util.XmlUtil;
import com.squirrel.springcloud.provider.gen.entity.xml.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * @Author: JoinHan
 * @Date: Created in 11:06 2018/2/7
 * @Modified By：
 */
public class TemplateUtil extends com.squirrel.springcloud.provider.common.util.TemplateUtil{

    private static Logger logger = LoggerFactory.getLogger(TemplateUtil.class);

    /**
     * 生成到文件
     * @param tpl
     * @param model
     * @param isReplaceFile
     * @return
     */
    public static String generateToFile(Template tpl, Map<String, Object> model, boolean isReplaceFile) throws Exception {
        // 获取生成文件
        String fileName = FileUtils.getProjectPath() + File.separator
                + StringUtils.replaceEach(renderString(tpl.getFilePath() + "/", model),new String[]{"//", "/", "."}, new String[]{File.separator, File.separator, File.separator})
                + renderString(tpl.getFileName(), model);
        logger.debug(" fileName === " + fileName);
        System.out.println(fileName);

        // 获取生成文件内容
        String content = renderString(StringUtils.trimToEmpty(tpl.getContent()), model);
        logger.debug(" content === \r\n" + content);

        // 如果选择替换文件，则删除原文件
        if (isReplaceFile){
            FileUtils.deleteFile(fileName);
        }

        // 创建并写入文件
        if (FileUtils.createFile(fileName)){
            FileUtils.writeToFile(fileName, content, true);
            logger.debug(" file create === " + fileName);
            return "生成成功："+fileName+"<br/>";
        }else{
            logger.debug(" file extents === " + fileName);
            return "文件已存在："+fileName+"<br/>";
        }
    }
}
