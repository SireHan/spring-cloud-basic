package com.squirrel.springcloud.provider.gen.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by JoinHan on 2017/7/13.
 */
@XmlRootElement(name="template")
public class Template {
    private String name; 	// 名称
    private String filePath;		// 生成文件路径
    private String fileName;		// 文件名
    private String content;		// 内容

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
