package util;


/**
 * ��װ���룬��ߴ���ĸ�����
 * @author john
 *
 */
public class Check {

	/**
	 * �ж��ַ����Ƿ�Ϊ��,���Ϊ�գ��򷵻�true�����򷵻�false
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
	 * �����ʽ��֤
	 */
	public static boolean isEmail(String str){
		if(str.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �ֻ���ʽ��֤
	 */
	public static boolean isPhone(String str){
		if(str.matches("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ������ʽ��֤
	 */
	public static boolean isName(String str){
		if(str.matches("[\u4E00-\u9FA5]{2,5}(?:��[\u4E00-\u9FA5]{2,5})*")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �û�����֤
	 */
	public static boolean isUsername(String str) {
		if(str.matches("^[a-zA-z][a-zA-Z0-9_]{5,16}$")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ���ո�ʽ��֤
	 */
	public static boolean isBirthday(String str) {
		if(str.matches("^(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * �绰������֤
	 */
	public static boolean isTelephone(String str) {
		if(str.matches("(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,14}")){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * ��֤ͼƬ��ʽ
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
