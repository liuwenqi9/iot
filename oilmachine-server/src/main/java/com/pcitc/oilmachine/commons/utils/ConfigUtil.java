package com.pcitc.oilmachine.commons.utils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ConfigUtil {
	final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);
	/**
	 * 属性文件所对应的属性对象变量
	 */
	private long m_lastModifiedTime = 0;

	/**
	 * 对应于属性文件的文件对象变量
	 */
	private File m_file = null;

	/**
	 * 属性文件所对应的属性对象变量
	 */
	private Properties m_props = null;

	/**
	 * 唯一实例
	 */
	private static ConfigUtil m_instance = new ConfigUtil();

	/**
	 * 私有构造函数
	 * 
	 * @throws URISyntaxException
	 */
	private ConfigUtil() {
		try {
			m_lastModifiedTime = getFile().lastModified();
			if (m_lastModifiedTime == 0) {
				logger.error("sys.properties" + "file does not exist!");
			}
			m_props = new Properties();
			m_props.load(new FileInputStream(getFile()));

		} catch (URISyntaxException e) {
			logger.error("文件路径不正确" + e);
		} catch (Exception e) {
			logger.error("文件读取异常" + e);
		}
	}

	/**
	 * 查找ClassPath路径获取文件
	 * 
	 * @return File对象
	 * @throws URISyntaxException
	 */

	private File getFile() throws URISyntaxException,Exception {
		/**
		 * 原来的写法
		   URI fileUri = this.getClass().getClassLoader().getResource("sys.properties").toURI();
		   m_file = new File(fileUri);
		*/
		/**
		 * 孙俊虎改的写法
		 */
		org.springframework.core.io.Resource res3 = new org.springframework.core.io.ClassPathResource("config"+File.separatorChar+"sys.properties");
		m_file = res3.getFile();
		return m_file;
	}
	public static Properties getFileCusFilePath(String fileName){
		Properties properties = null;
		try{
			org.springframework.core.io.Resource res3 = new org.springframework.core.io.ClassPathResource("config"+File.separatorChar+fileName);
			properties = new Properties(); 
			FileInputStream inputFile = new FileInputStream(res3.getFile());
			properties.load(inputFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return properties;
	}
	

	/**
	 * 静态工厂方法
	 * 
	 * @return 返回ConfigUtil的单一实例
	 */
	public synchronized static ConfigUtil getInstance() {
		return m_instance;
	}

	/**
	 * 设置一特定的属性项
	 */
	public void setPropertyValue(String name, String value) {
		long newTime = m_file.lastModified();
		// 检查属性文件是否被修改
		if (newTime == 0) {
			// 属性文件不存在
			if (m_lastModifiedTime == 0) {
				logger.error("文件不存在," + "sys.properties");
			} else {
				logger.error("文件不存在," + "sys.properties");
			}
		} else if (newTime > m_lastModifiedTime) {
			m_props.clear();
			try {
				m_props.load(new FileInputStream(getFile()));
			} catch (Exception e) {
				logger.error("文件重新读取异常," + "sys.properties");
			}
		}
		m_lastModifiedTime = newTime;
		m_props.setProperty(name, value);

	}

	/**
	 * 读取一特定的属性项
	 * @param name
	 * @param defaultVal 若name配置为空则返回默认值defaultVal
	 * @return
	 */
	public String getPropertyValue(String name, String defaultVal) {
		long newTime = m_file.lastModified();
		// 检查属性文件是否被修改
		if (newTime == 0) {
			// 属性文件不存在
			if (m_lastModifiedTime == 0) {
				logger.error("文件不存在," + "sys.properties");
			} else {
				logger.error("文件不存在," + "sys.properties");
			}
			return defaultVal;
		} else if (newTime > m_lastModifiedTime) {
			m_props.clear();
			try {
				m_props.load(new FileInputStream(getFile()));
			} catch (Exception e) {
				logger.error("文件重新读取异常," + "sys.properties");
			}
		}
		m_lastModifiedTime = newTime;
		String val = m_props.getProperty(name);
		if (val == null) {
			return defaultVal;
		} else {
			return val;
		}
	}

	/**
	 * 读取一特定的属性项
	 * 
	 * @param name
	 *            属性项的项名
	 * @return 属性项的值（如此项存在）， 空（如此项不存在）
	 */
	public String getPropertyValue(String name) {
		return getPropertyValue(name, "");
	}
	
	/**
	 * 图片上传及CMS发发布　路经
	 * author :qiands
	 * @return
	 */
	public  String cmsUrl() {
		String url=ConfigUtil.getInstance().getPropertyValue("com.ptpec.file.path");
		//获取相对 路经
		String cmsurl=url;
		return cmsurl;
	}
	/**
	 *手机OPENFIRE服务器地址　路经
	 * author :qiands
	 * @return
	 */
	public  String serverUrl() {
		String serverurl=ConfigUtil.getInstance().getPropertyValue("sms.server.list");
		//获取相对 路经 
		return serverurl;
	}
	/**
	 *手机OPENFIRE服务器IP　路经
	 * author :qiands
	 * @return
	 */
	public  String serverIP() {
		String result="";
		String serverurl=ConfigUtil.getInstance().getPropertyValue("sms.server.list");
		if(StringUtils.isNotBlank(serverurl)){
			String[] getserverurl=serverurl.split(",");
			result=getserverurl[0];
		}
		//获取相对 路经 
		return result;
	}
	/**
	 * 单卡编号
	 * author :qiands
	 * @return String
	 */  
	public  String[] getCardCode() {
		String url=ConfigUtil.getInstance().getPropertyValue("cardcode"); 
		if(StringUtils.isNotBlank(url)){
			return url.split(",");
		}
		return null;
	}
	/**
	 * 单卡租户编号
	 * author :qiands
	 * @return String
	 */  
	public  String getCardTenantId() {
		String url=ConfigUtil.getInstance().getPropertyValue("tenantid"); 
		return url;
	}
	/**
	 * 是否任务调度
	 * author :qiands
	 * @return boolean
	 */
	public  boolean getJobStart() {
		boolean result=false;
		String getStart=ConfigUtil.getInstance().getPropertyValue("quartz.job.enable");
		if(StringUtils.isNotBlank(getStart)){
			getStart=getStart.trim();
		}
		if(getStart.equals("true")){
			result=true;
		} 
		return result;
	}
	
	/**
	 * @author zizhi.zhang
	 * @date 2016年11月15日 上午10:19:25
	 */
	public static void closeReader(Closeable reader){
		try {
			if(reader != null){
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
