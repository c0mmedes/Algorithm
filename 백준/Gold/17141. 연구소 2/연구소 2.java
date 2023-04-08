//combination 돌려서 M개 뽑기
//뽑은 인덱스의 해당하는 좌표를 큐에 넣어줌
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   static class Virus {
      int x, y;

      public Virus(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
   }

   static int N, M, time, virusCnt, min;
   static int dr[] = { -1, 1, 0, 0 };
   static int dc[] = { 0, 0, -1, 1 };
   static int map[][];
   static int[] numbers;
   static List<Virus> list;
   static boolean visited[][];
   static Queue<Virus> q;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken()); // 연구소의 크기
      M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스의 개수

      map = new int[N][N]; // 바이러스 맵

      numbers = new int[M];
      list = new ArrayList<>();

      virusCnt = 0;
      min = Integer.MAX_VALUE;

// 0은 빈 칸, 1은 벽, 2는 바이러스 놓을 수 있는 칸
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine(), " ");
         for (int j = 0; j < N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == 2) {
               list.add(new Virus(i, j));
               virusCnt++;
            }
         }
      }

      comb(0, 0);
      
      min = Math.min(min, time);
      System.out.println(min);
   }

   private static void comb(int cnt, int start) {
      if (cnt == M) {
         visited = new boolean[N][N];
         q = new ArrayDeque<>();
         for (int i = 0; i < M; i++) {
            q.offer(list.get(numbers[i]));
            visited[list.get(numbers[i]).x][list.get(numbers[i]).y] = true;
         }
         bfs();
         return;
      }

      for (int i = start; i < virusCnt; i++) {
         numbers[cnt] = i;
         comb(cnt + 1, i + 1);
      }
   }

   private static void bfs() {
      time = -1;

      while (!q.isEmpty()) {
         int size = q.size();

         while (size-- > 0) {
            Virus t = q.poll();

            for (int d = 0; d < 4; d++) {
               int nx = t.x + dr[d];
               int ny = t.y + dc[d];

               if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                  continue;
               if (map[nx][ny] == 1 || visited[nx][ny])
                  continue;

               q.offer(new Virus(nx, ny));
               visited[nx][ny] = true;
            }
         }
         time++;
      }

      boolean flag = false;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if (map[i][j] != 1 && !visited[i][j]) {
               flag = true;
               break;
            }
         }
      }

      if (flag)
         if(min == Integer.MAX_VALUE) {
            time = -1;            
         }

      if (!flag) {
         min = Math.min(min, time);
      }
   }
}