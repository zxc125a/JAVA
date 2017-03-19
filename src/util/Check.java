package util;

/**
 * 封装代码，提高代码的复用性
 * @author john
 *
 */
public class Check {

	/**
	 * 判断字符串是否为空
	 * @return
	 */
	
	public static boolean isEmpty(String str){
		if("".equals(str) || str == null) {
			return true;
		} else {
			return false;
		}
	}
}
