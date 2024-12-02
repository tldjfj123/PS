class Solution {
    public boolean solution(String s) {
        
        char[] arr = s.toCharArray();
        
        for (char a : arr) {
            if (!Character.isDigit(a)) {
                return false;
            }
        }
        
        
        if (s.length() == 4 || s.length() == 6) {
            return true;
        }
        
        return false;
    }
}