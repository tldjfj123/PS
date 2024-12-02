class Solution {
    public int solution(int[] numbers) {
        int res = 0;
        
        int[] std = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int i = 0; i < std.length; i++) {
            int n = std[i];
            
            boolean check = false;
            
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == n) {
                    check = true;
                }
            }
            
            if (!check) {
                res += n;
            }
            
        }
        
        
        return res;
    }
}