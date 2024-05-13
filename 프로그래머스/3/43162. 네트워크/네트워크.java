class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(i, computers);
            answer++;
        }
        return answer;
    }
    
    private static void dfs(int start, int[][] computers) {
        visited[start] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if(i == start) continue;
            if(computers[start][i] != 1 || visited[i]) continue;
            dfs(i, computers);
        }
    }
}