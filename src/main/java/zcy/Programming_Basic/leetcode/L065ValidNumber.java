package zcy.Programming_Basic.leetcode;

public class L065ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isNumber(String s) {
        
        if (s == null)
            return false;
        s = s.trim().toLowerCase();
        if (s.length() == 0)
            return false;
        
        int enumber = getNumber(s, 'e');
        
        if (enumber >=2)
            return false;
        else if (enumber == 1) {
            if (s.charAt(0)=='e' || s.charAt(s.length()-1)=='e')
                return false;
            else {
                String[] arr = s.split("e");
                return validBase(arr[0])&&validExp(arr[1]);
            }
                
        } else {
            return validBase(s);
        }
        
    }
    
    private boolean validExp(String s) {
        if (s.charAt(0)=='+' || s.charAt(0)=='-')
            s = s.substring(1);
        if (s.length()==0)
            return false;
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                continue;
            else
                return false;
        }
        return true;
    }
    
    private boolean validBase(String s) {
        int pnumber = getNumber(s, '.');
        if (pnumber >=2)
            return false;
        else if (pnumber == 1) {   // 判断base是小数的情况。 这里处理的比较麻烦，但是思路还是清晰的
            if (s.equals(".") || s.equals("+.") || s.equals("-.") )
                return false;
            if (s.charAt(0) == '.'){
                return validDeciWithoutInte(s.substring(1));
            } else if (s.charAt(s.length()-1)=='.') {
                return validInteWithoutDeci(s.substring(0, s.length()-1));
            } else {
                String[] arr = s.split("\\.");
                return validInte(arr[0])&&validDeci(arr[1]);
            }
        } else {
            return validInteWithoutPoint(s);
        }
    }
    
    private boolean validInte(String s) {
        if (s.charAt(0)=='+' || s.charAt(0)=='-')
            s = s.substring(1);
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                continue;
            else
                return false;
        }
        return true;
    }
    private boolean validDeci(String s) {
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                continue;
            else
                return false;
        }
        return true;
    }
    
    private boolean validInteWithoutDeci(String s) {
        if (s.charAt(0)=='+'||s.charAt(0)=='-')
            s = s.substring(1);
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                continue;
            else
                return false;
        }
        return true;
    }
    
    private boolean validDeciWithoutInte(String s) {
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9')
                continue;
            else
                return false;
        }
        return true;
    }
    
    private boolean validInteWithoutPoint(String s) {
        return validExp(s);
    }
    
    private int getNumber(String s, char c) {
        int num = 0;
        for (int i=0;i<s.length(); i++){
            if (s.charAt(i) == c)
                num++;
        }
        return num;
    }

}
