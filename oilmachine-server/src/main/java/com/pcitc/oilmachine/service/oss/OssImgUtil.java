package com.pcitc.oilmachine.service.oss;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.pcitc.oilmachine.commons.exception.PTPECAppException;


public class OssImgUtil {
	/**
	 *  @param path 文件相对根目录路径
	 *  删除文件
	 *  @throws PTPECAppException 
	 */
	public static void deleteFile(final String filePath) throws PTPECAppException{
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			fss.deleteFile(filePath);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
	}
	
	/**
	 *  @param path 文件相对根目录路径
	 *  下载文件
	 */
	public static InputStream getFile(final String filePath) throws PTPECAppException{
		InputStream is = null;
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			is = fss.getFile(filePath);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
		return is;
	}
	
	/**
	 *  @param from - 原文件路径， 相对于sys.properties中img.ftp.ftproot的路径
	 *	@param to - 目标文件路径，相对于sys.properties中img.ftp.ftproot的路径\
	 *  @param path - 相对于sys.properties中img.ftp.ftproot的路径
	 *  删除目录，包括子目录及文件。
	 * @throws PTPECAppException 
	 */
	public static void removeDirectory(String path) throws PTPECAppException{
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			fss.removeDirectory(path);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
	}
	
	/**
	 *  @param from - 原文件路径， 相对于sys.properties中img.ftp.ftproot的路径
	 *	@param to - 目标文件路径，相对于sys.properties中img.ftp.ftproot的路径
	 *  重命名ftp上的文件，对于oss只能对文件重命名.
	 * @throws PTPECAppException 
	 */
	public static void removeDirectory(String from, String to) throws PTPECAppException{
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			fss.renameFile(from, to);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
	}
	
	/**
	 *  @param moduleName - 业务模块名称
	 *  将文件上传到服务器，在moduleName下随机命名目录，文件名采用uuid生成 OSS和ftp均适用。
	 *  返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException 
	 */
	public static String uploadFileToModule(String moduleName, File file, String contentType) throws PTPECAppException{
		String result = null;
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			result = fss.uploadFileToModule(moduleName, file, contentType);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
		return result;
	}
	
	/**
	 * 将流上传到服务器，在moduleName下随机命名目录，文件名采用uuid生成 OSS和ftp均适用。
	 * moduleName - 业务模块名
	 * fileinstream - 要上传文件流
     * suffixName - 文件后缀名,如.jpg
	 */
	public static String uploadStreamToModule(String moduleName, InputStream fileInStream, String suffixName, String contentType) throws PTPECAppException{
		String result = null;
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			result = fss.uploadStreamToModule(moduleName, fileInStream, suffixName, contentType);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
		return result;
	}
	
	/**
	 *  uploadFileToModuleAndFixdPath
	 *  将文件上传到服务器某模块下的固定路径
	 *  @param moduleName - 业务模块名称
        srcFileFullPath - 要上传的文件路径
        fixedPath - 在模块名目录下要创建的目录
	 */
	public static String uploadFileToModuleAndFixdPath(String moduleName, File file, String fixedPath, String contentType) throws PTPECAppException{
		String result = null;
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			result = fss.uploadFileToModuleAndFixdPath(moduleName,file, fixedPath, contentType);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
		return result;
	}
	
	/**
	 *  uploadFileToModuleAndFixdPath
	 *  将流上传到服务器某模块下的固定路径
	 *  @param moduleName - 模块名
        fileInStream - 文件输入流
        fileName - 文件名
        fixedPath - 在模块名目录下要创建的目录
	 */
	public static String uploadStreamToModuleAndFixdPath(String moduleName, InputStream fileInStream, String fileName, String fixedPath, String contentType) throws PTPECAppException{
		String result = null;
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			result = fss.uploadStreamToModuleAndFixdPath(moduleName,fileInStream, fileName, fixedPath, contentType);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
		return result;
	}
	
	/** 
	 *   path - 相对ftp根的路径，如a/b/c,如果路径不存在就报错
	 *	 fileInStream - 文件内容
	 *	 fileName - 保存在ftp上的文件命，不含路径，如abc.jpg
	 *   将流写到服务器某路径下
	 */
	public static void uploadToFixedPath(String path, InputStream fileInStream, String fileName) throws PTPECAppException{
		FileStoreService fss;
		try {
			fss = FileStoreFactory.getInstance();
			fss.uploadToFixedPath(path, fileInStream, fileName);
		} catch (FileStoreException e) {
			throw new PTPECAppException(e);
		}
	}
	
	public static void inputstreamtofile(InputStream ins,File file) {
		  try {
		   OutputStream os = new FileOutputStream(file);
		   int bytesRead = 0;
		   byte[] buffer = new byte[8192];
		   while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
		    os.write(buffer, 0, bytesRead);
		   }
		   os.close();
		   ins.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
}