import java.util.*;
import java.io.*;

class Solution {
    static int numbers[], answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        int len = q[0].length;
        numbers = new int[len];
        comb(len, n, 0, 1, q, ans);
        
        return answer;
    }
    private static void comb(int len, int n, int cnt, int start, int[][] q, int[] ans) {
        if (cnt == len) {
            // 여기서 len만큼 뽑고
            List<Integer> list = new ArrayList<>();
            // System.out.println(Arrays.toString(numbers));
            for (int i = 0; i < numbers.length; i++) list.add(numbers[i]);
            boolean check = true;
            out:for (int i = 0; i < q.length; i++) {
                int count = 0;
                for (int j = 0; j < q[i].length; j++) {
                    if (list.contains(q[i][j])) {
                        count++;
                    }
                }
                if (count != ans[i]) {
                    check = false; 
                    break out;
                }
            }
            if(check) {
                // System.out.println(Arrays.toString(numbers));
answer++;
            }
            
            return;
        }
        
        for (int i = start; i <= n; i++) {
            numbers[cnt] = i;
            comb(len, n, cnt + 1, i + 1, q, ans);
        }
    }
}

// 1. 모든 정수를 