package com.squirrel.springcloud.provider.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Map;

/**
 * @Author: JoinHan
 * @Date: Created in 11:06 2018/2/7
 * @Modified By：
 */
public class TemplateUtil {

    public static String renderString(String templateString, Map<String, ?> model) throws Exception{
        StringWriter result = new StringWriter();
        Template t = new Template("name", new StringReader(templateString), new Configuration(Configuration.getVersion()));
        t.process(model, result);
        return result.toString();
    }

    public static String renderTemplate(Template template, Object model) throws Exception {
        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }

    public static Configuration buildConfiguration(String directory) throws IOException {
        Configuration cfg = new Configuration(Configuration.getVersion());
        Resource path = new DefaultResourceLoader().getResource(directory);
        cfg.setDirectoryForTemplateLoading(path.getFile());
        return cfg;
    }
}
