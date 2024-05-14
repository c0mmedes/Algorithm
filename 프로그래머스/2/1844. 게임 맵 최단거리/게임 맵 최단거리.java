import java.util.*;

class Solution {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static class Node {
        int x, y;
        public Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] maps) {
        int answer = 0;
        
        bfs(maps);
        
        return bfs(maps);
    }

    private static int bfs(int[][] maps) {
        boolean visited[][] = new boolean[maps.length][maps[0].length];
        int ans = 1;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(size-- > 0) {
                Node n = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = n.x + dr[d];
                    int ny = n.y + dc[d];

                    if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                    if (visited[nx][ny] || maps[nx][ny] == 0) continue;

                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;

                    if(nx == maps.length -1 && ny == maps[0].length - 1) {
                        return ans+1;
                    }
                }     
            }
            ans++;
        }
        
        return -1;
    }
}