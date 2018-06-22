package com.pcitc.oilmachine.service.oss;

import java.io.File;

import com.pcitc.oilmachine.service.oss.common.ConTentType;

public class FileStoreFactory {
	public static FileStoreService getInstance() throws FileStoreException {
		FileStoreConfigure fsc = new FileStoreConfigure();
		String type = fsc.getFileStoreType();
		if ((type == null) || (type.trim().length() == 0)) {
			throw new FileStoreException("type is null");
		}
		if (type.trim().equalsIgnoreCase("ftp")) {
			return new FtpFileStoreImpl();
		}
		if (type.trim().equalsIgnoreCase("oss")) {
			return new OssFileStoreImpl();
		}
		throw new FileStoreException("not support type");
	}

	public static void main(String[] args) throws FileStoreException {
		FileStoreService fileStore = getInstance();
		File files = new File("D:\\e_1603\\test.txt");
		if(files.isFile() && files.exists()){
			String path = fileStore.uploadFileToModule("a", files, ConTentType.OSS_TXT);
			System.out.println("返回地址："+path);
		}else{
			System.out.println("找不到指定的文件");
		}
	}
}