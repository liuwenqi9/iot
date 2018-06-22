package com.pcitc.oilmachine.service.oss;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pcitc.oilmachine.commons.exception.PTPECAppException;

@Component
public class FtpImgUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String ftpServer;
	
	private static String ftpUserName;
	
	private static String ftpPassword;
	
	private static String ftproot;
	
	private static int port = 21;
	private static int dirMaxCnt = 200;
	
	public static String getFtpServer() {
		return ftpServer;
	}
	@SuppressWarnings("static-access")
	@Value("${img.ftp.server}")
	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}

	public static String getFtpUserName() {
		return ftpUserName;
	}
	@SuppressWarnings("static-access")
	@Value("${img.ftp.username}")
	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}

	public static String getFtpPassword() {
		return ftpPassword;
	}
	@SuppressWarnings("static-access")
	@Value("${img.ftp.password}")
	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public static String getFtproot() {
		return ftproot;
	}
	@SuppressWarnings("static-access")
	@Value("${img.ftp.ftprootOffset}")
	public void setFtproot(String ftproot) {
		this.ftproot = ftproot;
	}

	/*static {
		ConfigUtil instance = ConfigUtil.getInstance();
		// 建立FTP连接
		ftpServer = instance.getPropertyValue("img.ftp.server").trim();
		port = Integer.parseInt(instance.getPropertyValue("img.ftp.port")
				.trim());
		ftpUserName = instance.getPropertyValue("img.ftp.username").trim();
		ftpPassword = instance.getPropertyValue("img.ftp.password").trim();
		ftproot = instance.getPropertyValue("img.ftp.ftproot").trim();
		dirMaxCnt = Integer.parseInt(instance.getPropertyValue(
				"img.ftp.dirMaxCnt").trim());
	}*/

	/**
	 * 
	 * @param modelName
	 *            业务模块名称
	 * @param srcFileFullPath
	 *            要上传的文件路径
	 * @return 返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException
	 */
	public static String imgUploadToFTP(final String modelName,
			final String srcFileFullPath) throws PTPECAppException {
		if (modelName == null || modelName.trim().length() == 0)
			throw new PTPECAppException("modelName参数不能为空");
		if (srcFileFullPath == null || srcFileFullPath.trim().length() == 0)
			throw new PTPECAppException("srcFileFullPath参数不能为空");

		String fileName = null;
		InputStream fileInStream = null;
		try {
			File file_in = new File(srcFileFullPath);
			fileName = file_in.getName();

			// 取文件的后缀名
			int dotIndex = fileName.indexOf(".");
			String suffixName = "";
			if (dotIndex >= 0)
				suffixName = fileName.substring(dotIndex);

			fileInStream = new FileInputStream(file_in);
			return imgUploadToFTP(modelName, fileInStream, suffixName);

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				if (fileInStream != null)
					fileInStream.close();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

	/**
	 * 路径和文件名都由业务模块指定
	 * 
	 * @param modelName
	 *            业务模块名称
	 * @param srcFileFullPath
	 *            要上传的文件路径
	 * @param fixedPath
	 *            在模块名目录下要创建的目录
	 * @return 返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException
	 */
	public static String imgUploadToFTP(final String modelName,
			final String srcFileFullPath, String fixedPath)
			throws PTPECAppException {
		if (modelName == null || modelName.trim().length() == 0)
			throw new PTPECAppException("modelName参数不能为空");
		if (srcFileFullPath == null || srcFileFullPath.trim().length() == 0)
			throw new PTPECAppException("srcFileFullPath参数不能为空");

		String fileName = null;
		InputStream fileInStream = null;
		try {
			File file_in = new File(srcFileFullPath);
			fileName = file_in.getName();

			fileInStream = new FileInputStream(file_in);
			return imgUploadToFTP(modelName, fileInStream, fileName, fixedPath);

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				if (fileInStream != null)
					fileInStream.close();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

	/**
	 * 
	 * @param modelName
	 *            业务模块名
	 * @param fileinstream
	 *            要上传文件流
	 * @param suffixName
	 *            文件后缀名,如.jpg
	 * @return 返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException
	 */
	public static String imgUploadToFTP(final String modelName,
			final InputStream fileInStream, final String suffixName)
			throws PTPECAppException {

		if (fileInStream == null)
			throw new PTPECAppException("文件流为null");

		FTPClient ftp = null;
		String virtualAppPath = "";
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			virtualAppPath += File.separator + modelName;
			boolean fexist = ftp.changeWorkingDirectory(modelName);
			if (!fexist) {
				boolean f1 = ftp.makeDirectory(modelName);
				if (!f1)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:"
							+ modelName.toString());
				ftp.changeWorkingDirectory(modelName);
			}
			String randomPath = (int) (Math.random() * dirMaxCnt) + "";
			virtualAppPath += File.separator + randomPath;
			fexist = ftp.changeWorkingDirectory(randomPath);
			if (!fexist) {
				boolean f2 = ftp.makeDirectory(randomPath);
				if (!f2)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:" + randomPath);
				ftp.changeWorkingDirectory(randomPath);
			}
			UUID uuid = java.util.UUID.randomUUID();
			String RemoteFileName = uuid.toString().replace("-", "")
					+ suffixName;

			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			boolean f = false;

			f = ftp.storeFile(RemoteFileName, fileInStream);

			if (!f)
				throw new PTPECAppException("ftp权限可能有问题，请检查");
			// ftp.storeFileStream(remote);
			return virtualAppPath + File.separator + RemoteFileName;
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}
	/**
	 * 
	 * @param modelName
	 *            业务模块名
	 * @param fileInStream
	 *            要上传文件流
	 * @param suffixName
	 *            文件后缀名,如.jpg
	 * @return 返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException
	 */
	public static String imgUploadToFTPECMS(final String modelName,
			final InputStream fileInStream, final String suffixName,String pathName)
			throws PTPECAppException {

		if (fileInStream == null)
			throw new PTPECAppException("文件流为null");

		FTPClient ftp = null;
		String virtualAppPath = "";
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			virtualAppPath += File.separator + modelName;
			boolean fexist = ftp.changeWorkingDirectory(modelName);
			if (!fexist) {
				boolean f1 = ftp.makeDirectory(modelName);
				if (!f1)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:"
							+ modelName.toString());
				ftp.changeWorkingDirectory(modelName);
			}
			String randomPath = pathName;
			virtualAppPath += File.separator + randomPath;
			fexist = ftp.changeWorkingDirectory(randomPath);
			if (!fexist) {
				boolean f2 = ftp.makeDirectory(randomPath);
				if (!f2)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:" + randomPath);
				ftp.changeWorkingDirectory(randomPath);
			}
			UUID uuid = java.util.UUID.randomUUID();
			String RemoteFileName = uuid.toString().replace("-", "")
					+ suffixName;

			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			boolean f = false;

			f = ftp.storeFile(RemoteFileName, fileInStream);

			if (!f)
				throw new PTPECAppException("ftp权限可能有问题，请检查");
			// ftp.storeFileStream(remote);
			return virtualAppPath + File.separator + RemoteFileName;
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

	/**
	 * 路径和文件名都由业务模块指定
	 * 
	 * @param modelName
	 *            业务模块名
	 * @param fileinstream
	 *            要上传文件流
	 * @param suffixName
	 *            文件后,如abc.jpg
	 * @param fixedPath
	 *            在模块路径下要创建的目录名
	 * @return 返回文件在图片服务器上的相对路径
	 * @throws PTPECAppException
	 */
	public static String imgUploadToFTP(final String modelName,
			final InputStream fileInStream, final String fileName,
			String fixedPath) throws PTPECAppException {

		if (fileInStream == null)
			throw new PTPECAppException("文件流为null");

		FTPClient ftp = null;
		String virtualAppPath = "";
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			virtualAppPath += modelName;
			boolean fexist = ftp.changeWorkingDirectory(modelName);
			if (!fexist) {
				boolean f1 = ftp.makeDirectory(modelName);
				if (!f1)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:"
							+ modelName.toString());
				ftp.changeWorkingDirectory(modelName);
			}

			virtualAppPath += File.separator + fixedPath;
			fexist = ftp.changeWorkingDirectory(fixedPath);
			if (!fexist) {
				boolean f2 = ftp.makeDirectory(fixedPath);
				if (!f2)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:" + fixedPath);
				ftp.changeWorkingDirectory(fixedPath);
			}

			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			boolean f = false;
			f = ftp.storeFile(fileName, fileInStream);
			if (!f)
				throw new PTPECAppException("ftp权限可能有问题，请检查");

			return virtualAppPath + File.separator + fileName;
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

    /**
     * 将文件上传到ftp制定的路径
     * @param path 相对ftp根的路径，如a/b/c,如果路径不存在就报错
     * @param fileInStream 文件内容
     * @param fileName     保存在ftp上的文件命，不含路径，如abc.jpg
     * @throws PTPECAppException
     */
    public static void uploadToFixedPath(final String path,
                                         final InputStream fileInStream, final String fileName) throws PTPECAppException {

        if (fileInStream == null){
            throw new PTPECAppException("文件流为null");
        }
        if (fileName == null || fileName.trim().length()==0){
            throw new PTPECAppException("文件名不能为空");
        }

        FTPClient ftp = null;
        String virtualAppPath = "";
        try {
            ftp = new FTPClient();
            ftp.connect(ftpServer, port);
            boolean flogin = ftp.login(ftpUserName, ftpPassword);
            ftp.enterLocalPassiveMode();
            if (!flogin)
                throw new PTPECAppException("登录ftp服务器失败");
            // 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

            if (!ftp.changeWorkingDirectory(ftproot)){
                throw new PTPECAppException("改变根工作目录异常" + ftproot);
            }

            boolean fexist = ftp.changeWorkingDirectory(path);
            if (!fexist) {
                throw new PTPECAppException("ftp path:" + path +" not exist");
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            boolean f = false;
            f = ftp.storeFile(fileName, fileInStream);
            if (!f){
                throw new PTPECAppException("ftp权限可能有问题，请检查");
            }
        } catch (Exception ex) {
            throw new PTPECAppException(ex);
        } finally {
            try {
                ftp.disconnect();
            } catch (IOException e) {
                throw new PTPECAppException(e);
            }
        }
    }

	/**
	 * 在ftp服务器上创建目录
	 * 
	 * @param ftpath
	 *            要创建目录路径，从ftp根开始。例:
	 *            sys.properties中配置的img.ftp.ftproot=noil_shared/pic.war，则
	 *            如果要在noil_shared
	 *            /pic.war下创建目录a,则ftpPath传""或者null,如果再在a下创建b，则传a,在b下创建c则传a/b
	 * @param dirName
	 *            要创建的目录名
	 * @return
	 * @throws PTPECAppException
	 */
	public static String createFtpDir(final String ftpPath, final String dirName)
			throws PTPECAppException {

		if (dirName == null || dirName.trim().length() == 0) {
			throw new PTPECAppException("要创建的目录名不能为空");
		}

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);

			if (ftpPath != null && ftpPath.trim().length() > 0) {
				boolean fexist = ftp.changeWorkingDirectory(ftpPath);
				if (!fexist) {
					throw new PTPECAppException("改变工作目录异常:" + ftpPath);
				}
			}

			boolean fDicName = ftp.changeWorkingDirectory(dirName);
			if (!fDicName) {
				boolean f2 = ftp.makeDirectory(dirName);
				if (!f2)
					throw new PTPECAppException("创建Ftp目录异常,目标目录为:" + dirName);
			}
			return ftpPath == null ? "" : ftpPath +"/" + dirName;

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

	/**
	 * 返回对应ftp文件的输出流
	 * 
	 * @param pathName
	 *            相对ftp根的全路径 ，如"mty/recomd/809001/abc.html"
	 * @return OutputStream
	 * @throws PTPECAppException
	 */
	public static FTPClient getFtpOutStream(final String pathName)
			throws PTPECAppException {

		if (pathName == null || pathName.trim().length() == 0)
			throw new PTPECAppException("文件路径不能为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();

			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(60000);
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			// 解析pathName，确定路径是否存在
			String[] singlePath = pathName.split("/");

			for (int i = 0; i < singlePath.length - 1; i++) {
				boolean fexist = ftp.changeWorkingDirectory(singlePath[i]);
				if (!fexist) {
					boolean f1 = ftp.makeDirectory(singlePath[i]);
					if (!f1)
						throw new PTPECAppException("创建Ftp目录异常,目标目录为:"
								+ singlePath[i].toString());
					ftp.changeWorkingDirectory(singlePath[i]);
				}
			}

			ftp.setFileType(FTPClient.ASCII_FILE_TYPE);

			return ftp;// ftp.storeFileStream(singlePath[singlePath.length-1]);
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {

		}
	}

	/**
	 * 下载文件
	 * 
	 * @param pathName
	 *            相对ftp根的全路径
	 *            ，如"standar/135/0963ab6ec4be4905b4517be4cb5773ac.jpg"
	 * @return InputStream
	 * @throws PTPECAppException
	 */
	public static InputStream getFtpFile(final String pathName)
			throws PTPECAppException {

		if (pathName == null || pathName.trim().length() == 0)
			throw new PTPECAppException("文件路径不能为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();

			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(60000);
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			InputStream is = ftp.retrieveFileStream(pathName);
			BufferedInputStream bis = null;

			if (is != null) {
				bis = new BufferedInputStream(is);
			}

			return bis;// ftp.storeFileStream(singlePath[singlePath.length-1]);

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {

		}
	}

	/**
	 * 下载文件
	 * 
	 * @param pathName
	 *            相对ftp根的全路径
	 *            ，如"standar/135/0963ab6ec4be4905b4517be4cb5773ac.jpg"
	 * @return InputStream
	 * @throws PTPECAppException
	 */
	public static InputStream getFtpFile(final String pathName,String ftpUserName,String ftpPassword,String ftproot) throws PTPECAppException {

		if (pathName == null || pathName.trim().length() == 0)
			throw new PTPECAppException("文件路径不能为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();

			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(60000);
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;
			
			ftp.setFileType(ftp.BINARY_FILE_TYPE);
			InputStream is = ftp.retrieveFileStream(pathName);
			BufferedInputStream bis = null;

			if (is != null) {
				bis = new BufferedInputStream(is);
			}

			return bis;// ftp.storeFileStream(singlePath[singlePath.length-1]);

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {

		}
	}
	
	/**
	 * 文件重命名
	 * 
	 * @param pathName
	 *            相对ftp根的全路径
	 *            ，如"standar/135/0963ab6ec4be4905b4517be4cb5773ac.jpg"
	 * @param pathNameNew
	 *            相对ftp根的全路径
	 *            ，如"standar/135/0963ab6ec4be4905b4517be4cb5773ac.jpg"
	 * @return Boolean
	 * @throws PTPECAppException
	 */
	public static Boolean renameFtpFile(final String pathName,final String pathNameNew,String ftpUserName,String ftpPassword,String ftproot) throws PTPECAppException {

		if (pathName == null || pathName.trim().length() == 0)
			throw new PTPECAppException("文件路径不能为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();

			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(60000);
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			// 首先进入ftpRoot,即图片虚拟目录相对ftp的路径

			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;
			Boolean result = ftp.rename(pathName, pathNameNew);
			
			return result;// ftp.storeFileStream(singlePath[singlePath.length-1]);

		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {

		}
	}
	
	/**
	 * 删除ftp文件
	 * @param pathname 文件名，相对于sys.properties中img.ftp.ftproot的路径
	 * @throws PTPECAppException
	 */
	public static void deleteFile(final String pathname)
			throws PTPECAppException {

		if (pathname == null || pathname.trim().length() == 0)
			throw new PTPECAppException("路径为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);

			boolean f = ftp.deleteFile(pathname);
			if (!f)
				throw new PTPECAppException("delete file not successed");
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

	/**
	 * 删除指定目录下的ftp文件
	 * @param pathname 文件名
	 * @throws PTPECAppException
	 */
	public static void deleteFile(final String pathname,String url)
			throws PTPECAppException {

		if (pathname == null || pathname.trim().length() == 0)
			throw new PTPECAppException("路径为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			if (!ftp.changeWorkingDirectory(url))
				throw new PTPECAppException("改变根工作目录异常" + url);

			boolean f = ftp.deleteFile(pathname);
			if (!f)
				throw new PTPECAppException("delete file not successed");
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}
	
	/**
	 * 重命名ftp上的文件
	 * @param from 原文件路径， 相对于sys.properties中img.ftp.ftproot的路径
	 * @param to 目标文件路径，相对于sys.properties中img.ftp.ftproot的路径
	 * @throws PTPECAppException
	 */
	public static void renameDicOrFile(final String from, final String to)
			throws PTPECAppException {

		if (from == null || from.trim().length() == 0)
			throw new PTPECAppException("路径为null");
		if (to == null || to.trim().length() == 0)
			throw new PTPECAppException("路径为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			if (!ftp.changeWorkingDirectory(ftproot)){
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			}
			
			boolean f = ftp.rename(from, to);
			if (!f)
				throw new PTPECAppException("rename file not successed");
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}


    /**
     * 删除目录，包括子目录及文件
     * @param pathname 相对于sys.properties中img.ftp.ftproot的路径
     * @throws PTPECAppException
     */
	public static void removeDic(final String pathname) throws PTPECAppException {
		if (pathname == null || pathname.trim().length() == 0)
			throw new PTPECAppException("路径为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			FTPFile[] files = ftp.listFiles(pathname);
			for (FTPFile f : files) {
				if (f.isDirectory()) {
					removeDic(pathname + "/" + f.getName());

				}
				if (f.isFile()) {
					boolean fDeleteFile = ftp.deleteFile(pathname + "/"
							+ f.getName());
					if (!fDeleteFile) {
						throw new PTPECAppException("remove " + f.getName()
								+ " not successed");
					}
				}
			}
			boolean fRemoveDic = ftp.removeDirectory(pathname);
			if (!fRemoveDic) {
				throw new PTPECAppException("remove " +pathname
						+ " not successed");
			}
			
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}

    /**
     * 返回ftp文件下内容列表
     * @param pathname
     * @throws PTPECAppException
     */
	public static FTPFile[] listFtp(final String pathname) throws PTPECAppException {
		if (pathname == null || pathname.trim().length() == 0)
			throw new PTPECAppException("路径为null");

		FTPClient ftp = null;
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin)
				throw new PTPECAppException("登录ftp服务器失败");
			if (!ftp.changeWorkingDirectory(ftproot))
				throw new PTPECAppException("改变根工作目录异常" + ftproot);
			;

			FTPFile[] files = ftp.listFiles(pathname);

			return files;
		} catch (Exception ex) {
			throw new PTPECAppException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new PTPECAppException(e);
			}
		}
	}	

    /**
     * 返回ftp文件下内容列表
     * @param pathname
     * @throws PTPECAppException
     */
	public static List<FTPFile> listFtp2(final String pathname) throws PTPECAppException {
		return Arrays.asList(listFtp(pathname));
	}	
	
	public static void main(String[] args) throws IOException {
		System.out.println("server="+ftpServer);
//		 testFile();
		// testStream();
		// testgetFtpOutStream();
//		 testGetFtpFile();
		// testCreateFtpDir();
		listFtp();
		System.out.println("finish");
	}

	protected static void listFtp(){
		try {
			FTPFile[] list = FtpImgUtil.listFtp("test");
			for(FTPFile f:list){
				System.out.println(f.getName());
			}
		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
	}
	
	protected static void testCreateFtpDir() {
		try {
			String s1 = FtpImgUtil.createFtpDir(null, "a1");
			String s2 = FtpImgUtil.createFtpDir("a1", "b1");
			String s3 = FtpImgUtil.createFtpDir("a1/b1", "c1");

			System.out.println("s1 = " + s1);
			System.out.println("s2 = " + s2);
			System.out.println("s3 = " + s3);

		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
	}

	protected static void testDeleteFile() {
		try {
			FtpImgUtil.deleteFile("a3");

		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
	}

	protected static void remove() {
		try {
			FtpImgUtil.removeDic("a3");

		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
	}

	protected static void testRenameDir() {
		try {
			FtpImgUtil.renameDicOrFile("a3/a.txt", "a3/b.txt");

		} catch (PTPECAppException e) {
			e.printStackTrace();
		}
	}

	protected static void testgetFtpOutStream() {
		FTPClient ftp = null;
		try {

			FileInputStream fis = new FileInputStream("d:\\aabb2.shtml");

			String remoteFileName = "aabb2.shtml";
			ftp = getFtpOutStream(remoteFileName);
			int reply = ftp.getReplyCode();

			OutputStream os = ftp.storeFileStream(remoteFileName);

			byte[] b = new byte[1024];
			fis.read(b);
			os.write(b);
			fis.close();
			os.close();
			ftp.disconnect();
			System.out.println("finish");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void testGetFtpFile() {
		try {
			InputStream is = getFtpFile("lins.txt");

			File file = new File("e://a.txt");
			OutputStream os = new FileOutputStream(file);

			byte[] b = new byte[1024];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				os.write(b, 0, len);

			}
			os.flush();
			os.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void testFile() {
		try {
			String filename = imgUploadToFTP("test", "e://a.txt", "808001");
			System.out.println("filename=" + filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void testStream() throws IOException {
		String suffixName = "abc.jpg".substring("abc.jpg".indexOf("."));
		System.out.println("suffixName=" + suffixName);
		InputStream fileStream = null;
		try {
			File file = new File("c:\\abc.jpg");
			fileStream = new FileInputStream(file);

			String filename = imgUploadToFTP("standar", fileStream, ".jpg");

			System.out.println("filename=" + filename);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileStream != null)
				fileStream.close();
		}
	}

}
