import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    
    static int rowLimit;
    static int columnLimit;
    static int[][] board;
    
    static int type = 0;
    static int maxSize = 0;
    
    public static boolean inRange(int x, int y) {
        return (0 <= x && x < rowLimit && 0 <= y && y < columnLimit);
    }
    
    public static void check(int x, int y) {
        if (board[x][y] == 0) return; // 이미 방문한 곳은 무시
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int std = board[x][y];
        board[x][y] = 0; // 방문 처리
        
        int size = 1;
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = v[0] + dx[i];
                int ny = v[1] + dy[i];
                
                if (inRange(nx, ny) && board[nx][ny] == std) {
                    queue.offer(new int[]{nx, ny});
                    board[nx][ny] = 0; // 방문 처리
                    size++;
                }
            }
        }
        
        type++;
        maxSize = Math.max(maxSize, size);
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        rowLimit = m;
        columnLimit = n;
        board = picture;
        
        type = 0;
        maxSize = 0;
        
        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < columnLimit; j++) {
                if (board[i][j] != 0) {
                    check(i, j);
                }
            }
        }
    
        return new int[]{type, maxSize};
    }
}
