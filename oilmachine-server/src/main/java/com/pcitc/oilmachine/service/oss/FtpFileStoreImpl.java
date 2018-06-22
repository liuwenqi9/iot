package com.pcitc.oilmachine.service.oss;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.apache.commons.net.ftp.FTPClient;

public class FtpFileStoreImpl implements FileStoreService {
	private static FileStoreConfigure fsc = null;
	static {
		fsc = new FileStoreConfigure();
	}
	private static String ftpServer = fsc.getFtpServer();
	private static int port = fsc.getFtpPort();
	private static String ftpUserName = fsc.getFtpUser();
	private static String ftpPassword = fsc.getFtpPass();
	private static String ftproot = fsc.getFtprootOffset();
	private static int dirMaxCnt = fsc.getDirMaxCnt();

	

	public String uploadFileToModule(String moduleName, File file, String contentType)
			throws FileStoreException {
		if ((moduleName == null) || (moduleName.trim().length() == 0))
			throw new FileStoreException("moduleName参数不能为空");
		if (file == null) {
			throw new FileStoreException("srcFileFullPath参数不能为空");
		}
		String fileName = null;
		InputStream fileInStream = null;
		try {
			fileName = file.getName();

			int dotIndex = fileName.indexOf(".");
			String suffixName = "";
			if (dotIndex >= 0) {
				suffixName = fileName.substring(dotIndex);
			}
			fileInStream = new FileInputStream(file);
			return uploadStreamToModule(moduleName, fileInStream, suffixName,contentType);
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		} finally {
			try {
				if (fileInStream != null)
					fileInStream.close();
			} catch (IOException e) {
				throw new FileStoreException(e);
			}
		}
	}

	public String uploadStreamToModule(String moduleName,
			InputStream fileInStream, String suffixName,String contentType)
			throws FileStoreException {
		if (fileInStream == null) {
			throw new FileStoreException("文件流为null");
		}
		FTPClient ftp = null;
		String virtualAppPath = "";
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin) {
				throw new FileStoreException("登录ftp服务器失败");
			}

			if (!ftp.changeWorkingDirectory(ftproot)) {
				throw new FileStoreException("改变根工作目录异常" + ftproot);
			}

			virtualAppPath = virtualAppPath + moduleName;
			boolean fexist = ftp.changeWorkingDirectory(moduleName);
			if (!fexist) {
				boolean f1 = ftp.makeDirectory(moduleName);
				if (!f1)
					throw new FileStoreException("创建Ftp目录异常,目标目录为:"
							+ moduleName.toString());
				ftp.changeWorkingDirectory(moduleName);
			}
			String randomPath = String.valueOf(Math.random() * dirMaxCnt);
			virtualAppPath = virtualAppPath + File.separator + randomPath;
			fexist = ftp.changeWorkingDirectory(randomPath);
			if (!fexist) {
				boolean f2 = ftp.makeDirectory(randomPath);
				if (!f2)
					throw new FileStoreException("创建Ftp目录异常,目标目录为:"
							+ randomPath);
				ftp.changeWorkingDirectory(randomPath);
			}
			UUID uuid = UUID.randomUUID();
			String RemoteFileName = uuid.toString().replace("-", "")
					+ suffixName;

			ftp.setFileType(2);

			boolean f = false;

			f = ftp.storeFile(RemoteFileName, fileInStream);

			if (!f) {
				throw new FileStoreException("ftp权限可能有问题，请检查");
			}
			return virtualAppPath + File.separator + RemoteFileName;
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new FileStoreException(e);
			}
		}
	}

	public String uploadFileToModuleAndFixdPath(String moduleName, File file,
			String fixedPath,String contentType) throws FileStoreException {
		if ((moduleName == null) || (moduleName.trim().length() == 0))
			throw new FileStoreException("moduleName参数不能为空");
		if (file == null) {
			throw new FileStoreException("file参数不能为空");
		}
		String fileName = null;
		InputStream fileInStream = null;
		try {
			fileName = file.getName();

			fileInStream = new FileInputStream(file);
			return uploadStreamToModuleAndFixdPath(moduleName, fileInStream,
					fileName, fixedPath,contentType);
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		} finally {
			try {
				if (fileInStream != null)
					fileInStream.close();
			} catch (IOException e) {
				throw new FileStoreException(e);
			}
		}
	}

	public String uploadStreamToModuleAndFixdPath(String moduleName,
			InputStream fileInStream, String fileName, String fixedPath, String contentType)
			throws FileStoreException {
		if (fileInStream == null) {
			throw new FileStoreException("文件流为null");
		}
		FTPClient ftp = null;
		String virtualAppPath = "";
		try {
			ftp = new FTPClient();
			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			if (!flogin) {
				throw new FileStoreException("登录ftp服务器失败");
			}

			if (!ftp.changeWorkingDirectory(ftproot)) {
				throw new FileStoreException("改变根工作目录异常" + ftproot);
			}

			virtualAppPath = virtualAppPath + moduleName;
			boolean fexist = ftp.changeWorkingDirectory(moduleName);
			if (!fexist) {
				boolean f1 = ftp.makeDirectory(moduleName);
				if (!f1)
					throw new FileStoreException("创建Ftp目录异常,目标目录为:"
							+ moduleName.toString());
				ftp.changeWorkingDirectory(moduleName);
			}

			virtualAppPath = virtualAppPath + File.separator + fixedPath;
			fexist = ftp.changeWorkingDirectory(fixedPath);
			if (!fexist) {
				boolean f2 = ftp.makeDirectory(fixedPath);
				if (!f2)
					throw new FileStoreException("创建Ftp目录异常,目标目录为:" + fixedPath);
				ftp.changeWorkingDirectory(fixedPath);
			}

			ftp.setFileType(2);
			boolean f = false;
			f = ftp.storeFile(fileName, fileInStream);
			if (!f) {
				throw new FileStoreException("ftp权限可能有问题，请检查");
			}
			return virtualAppPath + File.separator + fileName;
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		} finally {
			try {
				ftp.disconnect();
			} catch (IOException e) {
				throw new FileStoreException(e);
			}
		}
	}

	// ERROR //
	public void uploadToFixedPath(String path, InputStream fileInStream,
			String fileName) throws FileStoreException {
	}

	public void deleteFile(String pathname) throws FileStoreException {
	}

	public void renameFile(String from, String to) throws FileStoreException {
	}

	public void removeDirectory(String pathname) throws FileStoreException {

	}

	public InputStream getFile(String pathName) throws FileStoreException {
		if ((pathName == null) || (pathName.trim().length() == 0)) {
			throw new FileStoreException("文件路径不能为null");
		}
		FTPClient ftp = null;
		try {
			ftp = new FTPClient();

			ftp.connect(ftpServer, port);
			boolean flogin = ftp.login(ftpUserName, ftpPassword);
			ftp.enterLocalPassiveMode();
			ftp.setConnectTimeout(60000);
			if (!flogin) {
				throw new FileStoreException("登录ftp服务器失败");
			}

			if (!ftp.changeWorkingDirectory(ftproot)) {
				throw new FileStoreException("改变根工作目录异常" + ftproot);
			}

			ftp.setFileType(2);
			InputStream is = ftp.retrieveFileStream(pathName);
			BufferedInputStream bis = null;

			if (is != null)
				;
			return new BufferedInputStream(is);
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		}
	}
}