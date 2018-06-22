package com.pcitc.oilmachine.service.oss;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileStoreConfigure {
	private int dirMaxCnt;
	private String tempDir;
	private String virtualServerPath;
	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String folderDelimiters = "/";
	private String ftpServer;
	private int ftpPort;
	private String ftpUser;
	private String ftpPass;
	private String ftprootOffset;
	private String fileStoreType;
	private String ossDomainName;

	public FileStoreConfigure() {
		Properties prop = new Properties();
		InputStream in = getClass().getClassLoader().getResourceAsStream("conf" + File.separatorChar + "fileStore.properties");
		try {
			prop.load(in);
			this.dirMaxCnt = Integer.parseInt(prop.getProperty("dirMaxCnt").trim());
			this.tempDir = prop.getProperty("tempDir").trim();
			this.virtualServerPath = prop.getProperty("virtualServerPath").trim();

			
			this.endpoint = prop.getProperty("oss_endpoint").trim();
			this.accessKeyId = prop.getProperty("oss_accessKeyId").trim();
			this.accessKeySecret = prop.getProperty("oss_accessKeySecret").trim();
			this.bucketName = prop.getProperty("oss_bucketName").trim();
			this.folderDelimiters = prop.getProperty("oss_folderDelimiters").trim();

			this.ftpServer = prop.getProperty("img.ftp.server").trim();
			this.ftpPort = Integer.parseInt(prop.getProperty("img.ftp.port").trim());
			this.ftpUser = prop.getProperty("img.ftp.username").trim();
			this.ftpPass = prop.getProperty("img.ftp.password").trim();
			this.ftprootOffset = prop.getProperty("img.ftp.ftprootOffset").trim();

			this.fileStoreType = prop.getProperty("fileStoreType").trim();

			this.ossDomainName = prop.getProperty("ossDomainName").trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFileStoreType() {
		return this.fileStoreType;
	}

	public String getVirtualServerPath() {
		return this.virtualServerPath;
	}

	public void setVirtualServerPath(String virtualServerPath) {
		this.virtualServerPath = virtualServerPath;
	}

	public String getFtpServer() {
		return this.ftpServer;
	}

	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}

	public int getFtpPort() {
		return this.ftpPort;
	}

	public void setFtpPort(int ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUser() {
		return this.ftpUser;
	}

	public void setFtpUser(String ftpUser) {
		this.ftpUser = ftpUser;
	}

	public String getFtpPass() {
		return this.ftpPass;
	}

	public void setFtpPass(String ftpPass) {
		this.ftpPass = ftpPass;
	}

	public String getFtprootOffset() {
		return this.ftprootOffset;
	}

	public void setFtprootOffset(String ftprootOffset) {
		this.ftprootOffset = ftprootOffset;
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKeyId() {
		return this.accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return this.accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	public String getBucketName() {
		return this.bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public int getDirMaxCnt() {
		return this.dirMaxCnt;
	}

	public void setDirMaxCnt(int dirMaxCnt) {
		this.dirMaxCnt = dirMaxCnt;
	}

	public String getFolderDelimiters() {
		return this.folderDelimiters;
	}

	public void setFolderDelimiters(String folderDelimiters) {
		this.folderDelimiters = folderDelimiters;
	}

	public String getTempDir() {
		return this.tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public String getOssDomainName() {
		return ossDomainName;
	}

	public void setOssDomainName(String ossDomainName) {
		this.ossDomainName = ossDomainName;
	}

}