import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coor {
        int x, y;

        public Coor (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Coor home, festival;
    static List<Coor> store;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine()); // 편의점의 개수

            // 상근이네
            st = new StringTokenizer(br.readLine());
            home = new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 편의점
            store = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                store.add(new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // 페스티벌
            st = new StringTokenizer(br.readLine());
            festival = new Coor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if(bfs()) sb.append("happy\n");
            else sb.append("sad\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(home);

        while(!q.isEmpty()) {
            Coor c = q.poll();
            if (Math.abs(c.x - festival.x) + Math.abs(c.y - festival.y) <= 1000) {
                return true;
            }

            for (int i = store.size()-1; i >= 0; i--) {
                if(Math.abs(c.x - store.get(i).x) + Math.abs(c.y - store.get(i).y) <= 1000) {
                    q.offer(store.get(i));
                    store.remove(i);
                }
            }
        }

        return false;
    }
}