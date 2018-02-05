package com.squirrel.springcloud.provider.common.base;


import java.io.File;

/**
 * 文件基础信息类
 * @author JoinHan
 * Created by JoinHan on 2017/6/7.
 */
public class BaseFile {
	
	//文件
	private File file;
	//访问位置
	private String url;
	//文件位置
	private String local;
	//对应数据库
	//private SysFile sysFile;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	/*public SysFile getSysFile() {
		return sysFile;
	}

	public void setSysFile(SysFile sysFile) {
		this.sysFile = sysFile;
	}*/
}
