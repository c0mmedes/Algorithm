import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D, ans;
    static int arr[][], numbers[];
    static List<int[]> list;
    static class Info {
        int x, y, d;

        public Info(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격자의 행
        M = Integer.parseInt(st.nextToken()); // 격자의 열
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

        arr = new int[N][M];
        numbers = new int[3];
        ans = 0;

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 리스트에 적의 좌표 넣어주기
                if (arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0);
        System.out.println(ans);
    }

    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            int count = 0;

            int newArr[][] = new int[N][M];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
            }

            List<int[]> newList = new ArrayList<>();
            for (int l[] : list) newList.add(l);

            // 한 턴
            for (int i = N; i > 0; i--) {
                // 뽑힌 궁수의 위치
                for (int j = 0; j < 3; j++) {
                    // pq는 궁수마다 생성
                    // 이때 pq는 거리 우선 열이 작은 애 우선
                    PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
                        @Override
                        public int compare(Info o1, Info o2) {
                            if(o1.d == o2.d) {
                                return Integer.compare(o1.y, o2.y);
                            } else {
                                return Integer.compare(o1.d, o2.d);
                            }
                        }
                    });

                    // list를 돌면서 현재 궁수의 거리가 d 이하인 애들을 pq에
                    for (int arr[] : newList) {
                        if(arr[0] >= i) continue;

                        int d = Math.abs(i - arr[0]) + Math.abs(numbers[j] - arr[1]);
                        if(d <= D) {
                            pq.add(new Info(arr[0], arr[1], d));
                        }
                    }

                    // pq를 poll 해준 후 그 애의 인덱스에 해당하는 arr 배열을 2로 처리
                    if(!pq.isEmpty()) {
                        Info nf = pq.poll();

                        if(newArr[nf.x][nf.y] == 1) {
                            newArr[nf.x][nf.y] = 2;
                            count++;
                        }
                    }
                }

                // 한 턴이 끝나면 list를 돌면서 2로 되어있는 애들을 remove
                for (int x = newList.size()-1; x >= 0; x--) {
                    int temp[] = newList.get(x);
                    if(newArr[temp[0]][temp[1]] == 2) {
                        newList.remove(x);
                    }
                }
            }

            ans = Math.max(count, ans);
            return;
        }

        for (int i = start; i < M; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}

// 0은 빈칸 1은 적
// 궁수 3명 성이 있는 칸(N+1)에 배치
// 턴 마다 궁수와의 거리가 D이하인 적 중 제일 가까운 적 일대일 공격가능, 여러명이면 가장왼쪽에 있는 적 공격
// 공격받으면 적은 사라짐
// 턴이 끝나면 적은 아래로 한칸 이동, 성이 있는 칸으로 이동한 경우 사라짐
// 모든 적이 격자판에서 제외되면 끝