import java.util.*;
import java.io.*;

class Solution {
    static int numbers[], answer, len;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        numbers = new int[q[0].length];
        comb(n, 0, 1, q, ans);
        
        return answer;
    }
    private static void comb(int n, int cnt, int start, int[][] q, int[] ans) {
        if (cnt == numbers.length) {
            List<Integer> list = new ArrayList<>();
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
                answer++;
            }
            
            return;
        }
        
        for (int i = start; i <= n; i++) {
            numbers[cnt] = i;
            comb(n, cnt + 1, i + 1, q, ans);
        }
    }
}