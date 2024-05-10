import java.util.*;

class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            answer++;
            dfs(i, computers);
        }

        return answer;
    }
    private static void dfs(int start, int[][] computers) {
        visited[start] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if(start == i) continue;
            if(visited[i]) continue;
            if(computers[start][i] != 1 || computers[i][start] != 1) continue;
            dfs(i, computers);
        }
    }
}
