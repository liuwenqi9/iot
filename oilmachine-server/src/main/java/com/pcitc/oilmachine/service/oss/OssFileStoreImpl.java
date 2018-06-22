package com.pcitc.oilmachine.service.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OssFileStoreImpl implements FileStoreService {
	private static FileStoreConfigure configure = new FileStoreConfigure();
	private static OSSClient client = new OSSClient(configure.getEndpoint(),
			configure.getAccessKeyId(), configure.getAccessKeySecret());

	public String uploadFileToModule(String modelName, File file, String contentType)
			throws FileStoreException {
		if ((modelName == null) || (modelName.trim().length() == 0))
			throw new FileStoreException("modelName参数不能为空");
		if (file == null) {
			throw new FileStoreException("file参数不能为空");
		}
		String fileName = null;
		String key = modelName;
		try {
			fileName = file.getName();

			int dotIndex = fileName.indexOf(".");
			String suffixName = "";
			if (dotIndex >= 0) {
				suffixName = fileName.substring(dotIndex);
			}
			int randomPath = (int) (Math.random() * configure.getDirMaxCnt());
			key = key + configure.getFolderDelimiters() + randomPath;

			UUID uuid = UUID.randomUUID();
			String RemoteFileName = uuid.toString().replace("-", "")
					+ suffixName;

			key = key + configure.getFolderDelimiters() + RemoteFileName;
			uploadFileToOss(file, key, contentType);

			return key;
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		}
	}

	private PutObjectResult uploadFileToOss(File file, String key, String contentType)
			throws FileNotFoundException {
		InputStream content = new FileInputStream(file);

		ObjectMetadata meta = new ObjectMetadata();

		meta.setContentLength(file.length());
		meta.setContentType(contentType);
		PutObjectResult result = client.putObject(configure.getBucketName(),
				key, content, meta);

		System.out.println(result.getETag());
		return result;
	}

	public String uploadStreamToModule(String modelName,
			InputStream fileInStream, String suffixName, String contentType)
			throws FileStoreException {
		if (fileInStream == null) {
			throw new FileStoreException("文件流为null");
		}
		String key = modelName;
		try {
			int randomPath = (int) (Math.random() * configure.getDirMaxCnt());
			key = key + configure.getFolderDelimiters() + randomPath;
			UUID uuid = UUID.randomUUID();
			String RemoteFileName = uuid.toString().replace("-", "")
					+ suffixName;
			key = key + configure.getFolderDelimiters() + RemoteFileName;

			String localFilePath = configure.getTempDir() + File.separator
					+ RemoteFileName;
			byte[] tempbytes = new byte[1024];
			int byteread = 0;

			OutputStream os = new FileOutputStream(new File(localFilePath));

			while ((byteread = fileInStream.read(tempbytes)) != -1) {
				os.write(tempbytes, 0, byteread);
			}
			os.close();

			File localFileObject = new File(localFilePath);
			uploadFileToOss(localFileObject, key, contentType);

			return key;
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		}
	}

	public String uploadFileToModuleAndFixdPath(String modelName, File file,
			String fixedPath, String contentType) throws FileStoreException {
		if ((modelName == null) || (modelName.trim().length() == 0))
			throw new FileStoreException("modelName参数不能为空");
		if (file == null) {
			throw new FileStoreException("file参数不能为空");
		}
		String fileName = null;
		InputStream fileInStream = null;
		try {
			fileName = file.getName();
			String key = modelName + configure.getFolderDelimiters()
					+ fixedPath + configure.getFolderDelimiters() + fileName;
			uploadFileToOss(file, key, contentType);
			return key;
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

	public String uploadStreamToModuleAndFixdPath(String modelName,
			InputStream fileInStream, String fileName, String fixedPath, String contentType)
			throws FileStoreException {
		if (fileInStream == null) {
			throw new FileStoreException("文件流为null");
		}
		String key = modelName;
		try {
			key = key + configure.getFolderDelimiters() + fixedPath
					+ configure.getFolderDelimiters() + fileName;

			String localFilePath = configure.getTempDir() + File.separator
					+ fileName;
			byte[] tempbytes = new byte[1024];
			int byteread = 0;
			OutputStream os = new FileOutputStream(new File(localFilePath));

			while ((byteread = fileInStream.read(tempbytes)) != -1) {
				os.write(tempbytes, 0, byteread);
			}
			os.close();

			File localFileObject = new File(localFilePath);
			uploadFileToOss(localFileObject, key, contentType);

			return key;
		} catch (Exception ex) {
			throw new FileStoreException(ex);
		}
	}

	public void uploadToFixedPath(String path, InputStream fileInStream,
			String fileName) throws FileStoreException {
		if (fileInStream == null) {
			throw new FileStoreException("文件流为null");
		}
		if ((fileName == null) || (fileName.trim().length() == 0)) {
			throw new FileStoreException("文件名不能为空");
		}
		String key = path + configure.getFolderDelimiters() + fileName;
		try {
			UUID uuid = UUID.randomUUID();
			String tempFile = uuid.toString().replace("-", "") + fileName;
			String localFilePath = configure.getTempDir() + File.separator
					+ tempFile;
			byte[] tempbytes = new byte[1024];
			int byteread = 0;

			OutputStream os = new FileOutputStream(new File(localFilePath));

			while ((byteread = fileInStream.read(tempbytes)) != -1) {
				os.write(tempbytes, 0, byteread);
			}
			os.close();

			File localFileObject = new File(localFilePath);
//			result = uploadFileToOss(localFileObject, key);
		} catch (Exception ex) {
			PutObjectResult result;
			throw new FileStoreException(ex);
		}
	}

	public void deleteFile(String pathname) throws FileStoreException {
		client.deleteObject(configure.getBucketName(), pathname);
	}

	public void renameFile(String from, String to) throws FileStoreException {
		client.copyObject(configure.getBucketName(), from,
				configure.getBucketName(), to);
		client.deleteObject(configure.getBucketName(), from);
	}

	public void removeDirectory(String pathname) throws FileStoreException {
		deleteFolder(client, configure, pathname);
	}

	private void deleteFolder(OSSClient client, FileStoreConfigure configure,
			String folder) {
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest(
				configure.getBucketName());

		listObjectsRequest.setDelimiter("/");

		String folderKey = folder;
		listObjectsRequest.setPrefix(folderKey);
		ObjectListing listing = client.listObjects(listObjectsRequest);

		for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
			String key = objectSummary.getKey();
			System.out.println("key is " + key);
			client.deleteObject(configure.getBucketName(), key);
		}

		for (String childFolder : listing.getCommonPrefixes()) {
			System.out.println(childFolder);
			deleteFolder(client, configure, childFolder);
		}
	}

	public InputStream getFile(String pathName) throws FileStoreException {
		InputStream stream = null;
		try{
			stream = client.getObject(configure.getBucketName(), pathName).getObjectContent();
		}catch(Exception e){
			
		}
		return stream;
	}
}