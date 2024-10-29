import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        Arrays.sort(bill);
        
        while(true) {
            if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;
            else {
                bill[1] /= 2;
                Arrays.sort(bill);
                answer++;
            }
        }

        return answer;
    }
}
// 15, 30 => 17, 26

// 1. 긴 쪽을 반으로 접음
// 2. 접기 전 길이가 홀수 -> 접은 후 소수점 이하 생략
