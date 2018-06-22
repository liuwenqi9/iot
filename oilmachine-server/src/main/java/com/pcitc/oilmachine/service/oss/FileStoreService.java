package com.pcitc.oilmachine.service.oss;

import java.io.File;
import java.io.InputStream;

public abstract interface FileStoreService {
	public abstract String uploadFileToModule(String paramString, File paramFile, String contentType)
			throws FileStoreException;

	public abstract String uploadStreamToModule(String paramString1,
			InputStream paramInputStream, String paramString2, String contentType)
			throws FileStoreException;

	public abstract String uploadFileToModuleAndFixdPath(String paramString1,
			File paramFile, String paramString2, String contentType) throws FileStoreException;

	public abstract String uploadStreamToModuleAndFixdPath(String paramString1,
			InputStream paramInputStream, String paramString2,
			String paramString3, String contentType) throws FileStoreException;

	public abstract void uploadToFixedPath(String paramString1,
			InputStream paramInputStream, String paramString2)
			throws FileStoreException;

	public abstract void deleteFile(String paramString)
			throws FileStoreException;

	public abstract void renameFile(String paramString1, String paramString2)
			throws FileStoreException;

	public abstract void removeDirectory(String paramString)
			throws FileStoreException;

	public abstract InputStream getFile(String paramString)
			throws FileStoreException;
}