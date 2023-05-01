import java.util.*;
import java.io.*;

class Solution {
    static class Coor{
        int x, y;
        
        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static int map[][];
    public int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        N = maps.length;
        M = maps[0].length;
        return bfs(0,0);
    }
    
    public int bfs(int startX, int startY) {
        int cnt = 2;
        visited = new boolean[N][M];
        Queue<Coor> q = new ArrayDeque();
        q.offer(new Coor(startX, startY));
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0){
                Coor cur = q.poll();
                int r = cur.x;
                int c = cur.y;
                for (int d = 0; d < 4; d++){
                    int nx = r + dr[d];
                    int ny = c + dc[d];

                    if(nx < 0 || ny < 0 || N <= nx || M <= ny) continue;
                    if(map[nx][ny] == 0 || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    q.offer(new Coor(nx, ny));
                    if(nx == (N-1) && ny == (M-1)) return cnt;
                }
            }
            cnt++;
            
            
        }
        return -1;
    }
}