package util;


/**
 * 封装代码，提高代码的复用性
 * @author john
 *
 */
public class Check {

	/**
	 * 判断字符串是否为空,如果为空，则返回true，反则返回false
	 * @return
	 */
	public static boolean isEmpty(String str){
		if("".equals(str) || str == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 邮箱格式验证
	 */
	public static boolean isEmail(String str){
		if(str.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 手机格式验证
	 */
	public static boolean isPhone(String str){
		if(str.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 人名格式验证
	 */
	public static boolean isName(String str){
		if(str.matches("[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 用户名验证
	 */
	public static boolean isUsername(String str) {
		if(str.matches("^[a-zA-z][a-zA-Z0-9_]{5,16}$")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 生日格式验证
	 */
	public static boolean isBirthday(String str) {
		if(str.matches("^(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 电话号码验证
	 */
	public static boolean isTelephone(String str) {
		if(str.matches("(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,14}")){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 验证图片格式
	 * @param str
	 * @return
	 */
	public static boolean judformat(String str){
		if("bmp".equals(str)){
			return true;
		}
		if("png".equals(str)){
			return true;
		}
		if("jpeg".equals(str)){
			return true;
		}
		if("jpg".equals(str)){
			return true;
		}
		return false;
	}
}
