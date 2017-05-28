package util;

import info.Contacts;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Tool {
	
	/**
	 * 获取手机号码比较器对象
	 * @return
	 */
	public static Comparator<Contacts> getPhoneComparator(){
		Comparator<Contacts> phoneComparator = new Comparator<Contacts>(){

			@Override
			public int compare(Contacts o1, Contacts o2) {
				// TODO Auto-generated method stub
				return o1.getPhone().compareTo(o2.getPhone());
			}
		};
		return phoneComparator;
	}
	
	/**
	 * 获取人名比较器对象
	 */
    public static PinyinComparator  getPinyinComparator(){
    	return new PinyinComparator();
    }
    
    /**
     * 电话号码排序
     */
/*    public static void getTelephoneComparator(){
    	Comparator<Contacts> telephoneComparator = new Comparator<Contacts>() {
			@Override
			public int compare(Contacts o1, Contacts o2) {
				return o1.getTelephone().compareTo(o2.getTelephone());
			}
		};
    }*/
    
    /**
     * 为内置框架左上角设置透明背景
     */
	 public static Icon createIcon(Image image, int width, int height) {  
	        // TODO Auto-generated method stub  
	        BufferedImage iconImage = new BufferedImage(width, height,  
	                BufferedImage.TYPE_INT_RGB);  
	        Graphics2D g2 = iconImage.createGraphics();  
	        // 增加下面代码使得背景透明  
	        iconImage = g2.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);  
	        g2.dispose();  
	        g2 = iconImage.createGraphics();  
	        // 背景透明代码结束  
/*	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,  
	                RenderingHints.VALUE_INTERPOLATION_BILINEAR);  */
	        g2.drawImage(image, 0, 0, width, height, null);  
	        g2.dispose();  
	        return new ImageIcon(iconImage);  
	    }  
	
	 
	/**
	 * 将指定图片描绘到头像框中
	 * @throws IOException 
	 */
	 public static String paintImage(String imagePath, Contacts contact, String format) throws IOException{
		 
		 if(Check.isEmpty(imagePath))
			 return "";
		 //String newPath = "";
		 File file = new File(imagePath);
		 FileInputStream fis = new FileInputStream(file);
		 //创建新文件的名字
	     Date date = new Date();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	     String fileName = sdf.format(date);
	     fileName += "."+format;
	     //创建新文件的目录
		 File newDirectory = new File("image/" );
		 if(!newDirectory.exists()){
			 newDirectory.mkdir();
		 }
		 //新文件的相对路径
		 File newFile = new File(newDirectory, fileName);
		 FileOutputStream fos = new FileOutputStream(newFile);
		 byte[] ch = new byte[1024];
		 int len = 0;
		 try {
			while((len = fis.read(ch))!= -1){
				 fos.write(ch, 0, len);
			 }
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return newFile.getAbsolutePath();
	 }
	 
	 public static String copyImage(String imagePath, Contacts contact, String format) throws IOException{
		 
		 if(Check.isEmpty(imagePath))
			 return "";
		// String newPath = "";
		 File file = new File(imagePath);
		 FileInputStream fis = new FileInputStream(file);
		 //创建新文件的名字
	     Date date = new Date();
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	     String fileName = sdf.format(date);
	     fileName += "."+format;
	     //创建新文件的目录
		 File newDirectory = new File("image/" );
		 if(!newDirectory.exists()){
			 newDirectory.mkdir();
		 }
		 //新文件的相对路径
		 File newFile = new File(newDirectory, fileName);
		 FileOutputStream fos = new FileOutputStream(newFile);
		 byte[] ch = new byte[1024];
		 int len = 0;
		 try {
			while((len = fis.read(ch))!= -1){
				 fos.write(ch, 0, len);
			 }
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fos.close();
			fis.close();
		}
		 return newFile.getAbsolutePath();
	 }
	 
	 public static boolean deleFile(String path){
		 
		 File file = new File(path);
		 
		 return file.delete();
	 }
	 
	 
}
