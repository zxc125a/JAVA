package util;
import info.Contacts;

import java.util.Comparator;
import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinComparator implements Comparator<Contacts> {

	private int sign;
	private String str1;
	private String str2;
	private int counter;
	
    public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
	
	public PinyinComparator(int counter){
		this.counter = counter;
	}
	public PinyinComparator(){
	}
	
	public int compare(Contacts o1, Contacts o2) {
		//选择要比较的信息
		if(this.counter % 2 == 0){
			selectString(o1, o2);
		} else {
			selectString(o2, o1);
		}
	
		if(Check.isEmpty(str1) && Check.isEmpty(str2)){
			str1 = o1.getName();
			str2 = o2.getName();
		} else if(Check.isEmpty(str1)) {
			return 1;
		} else if(Check.isEmpty(str2)) {
			return -1;
		}
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {

            int codePoint1 = str1.charAt(i);
            int codePoint2 = str2.charAt(i);

            if (Character.isSupplementaryCodePoint(codePoint1)
                    || Character.isSupplementaryCodePoint(codePoint2)) {
                i++;
            }

            if (codePoint1 != codePoint2) {
                if (Character.isSupplementaryCodePoint(codePoint1)
                        || Character.isSupplementaryCodePoint(codePoint2)) {
                    return codePoint1 - codePoint2;
                }

                String pinyin1 = pinyin((char) codePoint1);
                String pinyin2 = pinyin((char) codePoint2);

                if (pinyin1 != null && pinyin2 != null) { // 两个字符都是汉字
                    if (!pinyin1.equals(pinyin2)) {
                        return pinyin1.compareTo(pinyin2);
                    }
                } else {
                    return codePoint1 - codePoint2;
                }
            }
        }
        return str1.length() - str2.length();
    }

    /**
     * 字符的拼音，多音字就得到第一个拼音。不是汉字，就return null。
     */
    private String pinyin(char c) {
        String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
        if (pinyins == null) {
            return null;
        }
        return pinyins[0];
    }
    
    private void selectString(Contacts o1, Contacts o2){
    	switch(this.sign){
		case 0:
			str1 = o1.getGroupName();
			str2 = o2.getGroupName();
			break;
		case 1:
			str1 = o1.getName();
			str2 = o2.getName();
			break;	
		case 2:
			str1 = o1.getSex();
			str2 = o2.getSex();
			break;		
		case 3:
			str1 = o1.getPhone();
			str2 = o2.getPhone();
			break;		
		case 4:
			str1 = o1.getBirthday();
			str2 = o2.getBirthday();
			break;
		case 5:
			str1 = o1.getAddress();
			str2 = o2.getAddress();
			break;	
		case 6:
			str1 = o1.getEmail();
			str2 = o2.getEmail();
			break;		
		case 7:
			str1 = o1.getWorkplace();
			str2 = o2.getWorkplace();
			break;	
		case 8:
			str1 = o1.getTelephone();
			str2 = o2.getTelephone();
			break;	
	}
    }
}