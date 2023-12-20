class Solution {
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        for (int d = 0; d < 4; d++) {
            int x = h + dr[d];
            int y = w + dc[d];
            
            if(x < 0 || y < 0 || x >= board.length|| y >= board[0].length) continue;
            
            if(board[x][y].equals(board[h][w])) answer++;
        }
        
        return answer;
    }
}