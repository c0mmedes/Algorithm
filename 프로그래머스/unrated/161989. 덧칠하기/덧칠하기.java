import java.util.*;
import java.io.*;

class Solution {
    // 1M 길이의 구역 n개로 나눔, 롤러의 길이 m, 
    public int solution(int n, int m, int[] section) {
//         int answer = section[section.length-1] - section[0] + 1;    
    
//         if(answer%m==0) answer /= m;
//         else {
//             answer = answer / m + 1;
//         }
        
        int answer = 1;
        int a = section[0] + m - 1;
        for (int i = 0; i < section.length; i ++){
            if(section[i] <= a) {
                continue;
            } else {
                a = section[i] + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}