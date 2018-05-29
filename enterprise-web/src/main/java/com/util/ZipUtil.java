package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Zip工具类
 * @author Administrator
 *
 */
public class ZipUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

	/**
	* 解压zip文件
	* @param sourceFile,待解压的zip文件; toFolder,解压后的存放路径
	* @throws Exception
	**/

	public static void zipToFile(String sourceFile, String toFolder) throws Exception {
		String toDisk = toFolder;//接收解压后的存放路径
		ZipFile zfile = new ZipFile(sourceFile);//连接待解压文件
		Enumeration zList = zfile.entries();//得到zip包里的所有元素
		ZipEntry ze = null;
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				logger.info("打开zip文件里的文件夹:"+ ze.getName() +"skipped...");
				continue;
			}
			OutputStream outputStream=null;
			InputStream inputStream =null;
			try {
				//以ZipEntry为参数得到一个InputStream，并写到OutputStream中
				outputStream = new BufferedOutputStream(new FileOutputStream(getRealFileName(toDisk, ze.getName())));
				inputStream = new BufferedInputStream(zfile.getInputStream(ze));
				int readLen = 0;
				while ((readLen = inputStream.read(buf, 0, 1024)) != -1) {
					outputStream.write(buf, 0, readLen);
				}
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				logger.info("解压失败："+e.toString());
				throw new IOException("解压失败：" + e.toString());
			}finally{
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException ex) {
	
					}
				}
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				inputStream=null;
				outputStream=null;
			}
		}
		zfile.close();
	}
	
	/**

	* 给定根目录，返回一个相对路径所对应的实际文件名.

	* @param zippath 指定根目录

	* @param absFileName 相对路径名，来自于ZipEntry中的name

	* @return java.io.File 实际的文件

	*/

	public static File getRealFileName(String zippath, String absFileName){
		logger.info("文件名："+absFileName);
		String[] dirs = absFileName.split("/" , absFileName.length());
		File ret = new File(zippath);// 创建文件对象
		if (dirs.length > 1) {
		for (int i = 0; i < dirs.length - 1; i++) {
		ret = new File(ret, dirs[i]);
		}
		}
		if (!ret.exists()) {// 检测文件是否存在
		ret.mkdirs();// 创建此抽象路径名指定的目录
		}
		ret = new File(ret, dirs[dirs.length - 1]);// 根据 ret 抽象路径名和 child 路径名字符串创建一个新 File 实例
		return ret;
	}
	
	/**
	 * 修改文件大小写
	 * @param url
	 */
	public static void updateFileNames(String url, String sign){
    	File file = new File(url);
    	//判断文件目录是否存在，且是文件目录，非文件
    	if(file.exists() && file.isDirectory()){
    		File[] childFiles = file.listFiles();
    		String path = file.getAbsolutePath();
    		for(File childFile : childFiles){
    			//如果是文件
    			if(childFile.isFile()){
    				String newName = childFile.getName();
    				if("big".equals(sign)){
    					newName = newName.toUpperCase();
    				}else if("small".equals(sign)){
    					newName = newName.toLowerCase();
    				}
    				childFile.renameTo(new File(path + "\\" +  newName));
    			}
    		}
    	}
    	
    }
    
    public static void main(String[] args) {
		try {
			zipToFile("d:/活动作品图片.zip", "d:/wxvote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
