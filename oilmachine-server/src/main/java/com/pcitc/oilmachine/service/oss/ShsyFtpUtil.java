package com.pcitc.oilmachine.service.oss;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;

import com.pcitc.oilmachine.commons.exception.PTPECAppException;
import com.pcitc.oilmachine.commons.utils.ConfigUtil;
import com.pcitc.oilmachine.commons.utils.DateUtils;

public class ShsyFtpUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	private static String ftpServer = "";
	private static int port = 21;
	private static String ftpUserName = "";
	private static String ftpPassword = "";
	private static String ftproot = "";
	static {
		ConfigUtil instance = ConfigUtil.getInstance();
		// 建立FTP连接
		ftpServer = instance.getPropertyValue("shsy.ftp.server").trim();
		ftpUserName = instance.getPropertyValue("shsy.ftp.username").trim();
		ftpPassword = instance.getPropertyValue("shsy.ftp.password").trim();
	}
	/**
	 * 
	 * @param modelName
	 *            业务模块名
	 * @param fileinstream
	 *            要上传文件流
	 * @param suffixName
	 *            文件后缀名,如.jpg
	 * @throws PTPECAppException
	 */
	public static void txtUploadToFTP(final InputStream fileInStream, final String suffixName)
			throws PTPECAppException {
		// 日期转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if (fileInStream == null)
			throw new PTPECAppException("文件流为null");
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
			
			Date date = DateUtils.getTime();
			String RemoteFileName = "o2o"+sdf.format(date).replace("-", "")
					+ suffixName;

			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

			boolean f = false;

			f = ftp.storeFile(RemoteFileName, fileInStream);

			if (!f)
				throw new PTPECAppException("ftp权限可能有问题，请检查");
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
}
