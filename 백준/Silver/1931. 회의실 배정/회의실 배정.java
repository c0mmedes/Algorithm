import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Time {
        int start, end;

        public Time (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의의 수
        int N = Integer.parseInt(br.readLine());

        Time t[] = new Time[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            t[i] = new Time(start, end);
        }

        // end 오름차순 후 start 오름차순
        Arrays.sort(t, new Comparator<Time>() {
            @Override
            public int compare(Time a, Time b) {
                if (a.end != b.end) {
                    return Integer.compare(a.end, b.end);
                } else {
                    return Integer.compare(a.start, b.start);
                }
            }
        });

        int ans = 0;
        int s = 0;

        for (int i = 0; i < N; i++) {
            int curEnd = t[i].end;
            int curStart = t[i].start;
            if(curStart >= s) {
                s = curEnd;
                ans++;
            }
        }
        System.out.println(ans);
    }
}