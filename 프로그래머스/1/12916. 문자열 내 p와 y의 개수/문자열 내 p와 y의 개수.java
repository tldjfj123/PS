class Solution {
    boolean solution(String s) {
        String tmp = s.toLowerCase();
        char[] arr = tmp.toCharArray();
        
        int cntP = 0;
        int cntY = 0;
        for (char c : arr) {
            if (c == 'p') {
                cntP++;
            } else if (c == 'y') {
                cntY++;
            }
        }
        
        if (cntP == cntY) {
            return true;
        }

        return false;
    }
}