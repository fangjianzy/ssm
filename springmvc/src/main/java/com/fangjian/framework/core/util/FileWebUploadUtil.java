package com.fangjian.framework.core.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.fangjian.framework.common.util.Config;
import com.fangjian.framework.common.util.Tools;
import com.fangjian.framework.core.cenum.FileUpalodTypeEnum;

/**   
 * 类名称：FileWebUploadUtil   </br>
 * 类描述：在SpringMvc基础上进行文件保存工具类   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月26日 上午10:49:54   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月26日 上午10:49:54   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
public class FileWebUploadUtil {

	private final static Logger log= Logger.getLogger(FileWebUploadUtil.class);
	
	/**
	 * 多文件上传保存文件保存数据库列表List，获取保存文件目录地址
	 * @param upload
	 * @return
	 * @throws IOException
	 */
	public static List uploadfile(MultipartFile[] upload,FileUpalodTypeEnum filetypeenum) throws IOException{
		log.info("多文件上传业务处理");
		List<String> return_str = new ArrayList<String>();
		String file_path ="";
		for(MultipartFile myfile : upload){
			if(myfile.isEmpty()){  
				log.info("文件未上传");  
            }else{ 
            	log.info("文件长度: " + myfile.getSize());  
            	log.info("文件类型: " + myfile.getContentType());  
            	log.info("文件名称: " + myfile.getName());  
            	log.info("文件原名: " + myfile.getOriginalFilename());  
            	log.info("========================================");  
            	//文件存放路径
            	String temp_dir = Config.getInstance().getValue("imgage_dir")+filetypeenum+"/";
            	log.info("文件存放目录: " + temp_dir);  
            	String dir = Tools.getCurrentDate()+"/";
            	String newfiledir= temp_dir+dir;
            	String filename = myfile.getOriginalFilename();    //得到上传时的文件名
            	long _lTime = System.nanoTime();
            	String _ext = filename.substring(filename.lastIndexOf("."));
            	      filename = _lTime + _ext;
            	FileUtils.writeByteArrayToFile(new File(newfiledir,filename), myfile.getBytes());
            	//设置图片所在路径
            	file_path = filetypeenum+"/"+dir+filename;
            	log.info("数据库保存存放目录: " + file_path);  
            	return_str.add(file_path);
            }
		}
		
		return return_str;
	}
	
	/**
	 * 上传单个上传
	 * @param myfile
	 * @return
	 * @throws IOException
	 */
	public static String upload_singfile(MultipartFile myfile,FileUpalodTypeEnum filetypeenum) throws IOException{
		String file_path ="";
		if(myfile.isEmpty()){  
			log.info("文件未上传");  
        }else{ 
        	log.info("文件长度: " + myfile.getSize());  
        	log.info("文件类型: " + myfile.getContentType());  
        	log.info("文件名称: " + myfile.getName());  
        	log.info("文件原名: " + myfile.getOriginalFilename());  
        	log.info("========================================");  
        	//文件存放路径
        	String temp_dir = Config.getInstance().getValue("imgage_dir")+filetypeenum+"/";
        	log.info("文件存放目录: " + temp_dir);  
        	String dir = Tools.getCurrentDate()+"/";
        	String newfiledir= temp_dir+dir;
        	String filename = myfile.getOriginalFilename();    //得到上传时的文件名
        	long _lTime = System.nanoTime();
        	String _ext = filename.substring(filename.lastIndexOf("."));
        	      filename = _lTime + _ext;
        	FileUtils.writeByteArrayToFile(new File(newfiledir,filename), myfile.getBytes());
        	//设置图片所在路径
        	file_path = filetypeenum+"/"+dir+filename;
        	log.info("数据库保存存放目录: " + file_path);  
        }
		return file_path;
	}

}

