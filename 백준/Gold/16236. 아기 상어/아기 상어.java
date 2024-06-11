import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ans;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};
    static int map[][];
    static Coor baby;
    static List<Coor> sharks = new ArrayList<>();
    static class Coor {
        int r, c, size, exp, d;

        public Coor (int r, int c, int size, int exp, int d) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.exp = exp; // 먹은 마리수
            this.d = d; // 상어와의 거리
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N * N 공간
        map = new int[N][N];

        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) baby = new Coor(i, j,2, 0, 0); // 아기상어의 위치
                else if(map[i][j] != 0) sharks.add(new Coor(i, j, map[i][j],0, 0)); // 물고기들의 위치
            }
        }

        map[baby.r][baby.c] = 0;

        while(true) {
            PriorityQueue<Coor> q = new PriorityQueue<>(new Comparator<Coor>() {
                //  1.거리 2.행이 작을수록 3. 열이 작을수록
                @Override
                public int compare(Coor o1, Coor o2) {
                    if (o1.d != o2.d) return Integer.compare(o1.d, o2.d);
                    else if (o1.r != o2.r) return Integer.compare(o1.r, o2.r);
                    else return Integer.compare(o1.c, o2.c);
                }
            });

            // 현재 베이비의 사이즈보다 작고 이동가능한 곳만 큐에 넣기
            for (int i = sharks.size()-1; i >= 0; i--) {
                Coor shark = sharks.get(i);
                if((shark.size < baby.size)) {
                    int distance = bfs(shark);
                    if(distance != 0) {
                        shark.d = distance;
                        q.add(shark);
                        sharks.remove(i);
                    }
                }
            }

            // 종료조건
            if(q.isEmpty()) break;

            Coor shark = q.poll();
            baby.r = shark.r;
            baby.c = shark.c;
            baby.exp++;
            if(baby.exp == baby.size) {
                baby.exp = 0;
                baby.size++;
            }
            ans += shark.d;

            // 우선순위에서 밀린 애들 다시 넣어주기
            while(!q.isEmpty()) {
                sharks.add(q.poll());
            }
        }

        System.out.println(ans);
    }

    private static int bfs(Coor shark) {
        int distance = 1;
        boolean visited[][] = new boolean[N][N];
        Queue<Coor> q = new ArrayDeque<>();
        q.add(baby);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Coor shk = q.poll();
                for (int d = 0; d < 4; d++){
                    int nr = shk.r + dr[d];
                    int nc = shk.c + dc[d];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(map[nr][nc] > baby.size) continue;
                    if(visited[nr][nc]) continue;
                    if(nr == shark.r && nc == shark.c) return distance;

                    q.offer(new Coor(nr, nc, 0, 0, 0));
                    visited[nr][nc] = true;
                }
            }
            distance++;
        }
        return 0;
    }
}

// 조건
// 아기상어의 처음 크기 2
// 아기 상어의 위치 9
// 상하좌우로 1초에 1칸 이동가능
// 자신과 같거나 작은 칸만 지나갈 수 있다.
// 자신보다 작은 칸만 먹을 수 있다.
// 자신의 크기가 2일 떄 2마리를 먹어야 크기가 1올라감
// 더 이상 먹을 수 있는 물고기가 공간에 없다면 엄마 상어에게 도움 요청 (종료 조건)
// 잡아먹은 시간 초 출력

// 이동 경로
// 먹을 수 있는 물고기가 1마리일 경우 그 물고기를 먹으러 가고
// 초과일 경우 가장 가까운 물고기 먹방(|x1 - x2| + |y1 - y2|)
// 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때 지나야 하는 칸의 개수
// 거리가 가까운 물고기가 많다면 1. 상 2. 좌 우선으로 먹는다.
// 먹으면 그 칸은 빈칸이 됨