import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
    
        // +10
        for (int i = 0; i < schedules.length; i++) {
            if(schedules[i]%100 >= 50) schedules[i] += 50;
            else schedules[i] += 10;
        }
        
        for (int i = 0; i < schedules.length; i++) {
            boolean flag = true;
            for (int j = 1; j <= 7; j++) {    
                if(startday == 1 && (j == 6 || j == 7)) continue;   
                if(startday == 2 && (j == 5 || j == 6)) continue;   
                if(startday == 3 && (j == 4 || j == 5)) continue;  
                if(startday == 4 && (j == 3 || j == 4)) continue;   
                if(startday == 5 && (j == 2 || j == 3)) continue;   
                if(startday == 6 && (j == 1 || j == 2)) continue;   
                if(startday == 7 && (j == 1 || j == 7)) continue;   

                // System.out.println("startday = " + startday + ", i = " + i + ", j = " + j + ", time = " + timelogs[i][j] + 
                //                    ", limit = " + schedules[i]);
                
                if(timelogs[i][j-1] > schedules[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}

// 600 ≤ timelogs[i][j] ≤ 2359 이거해결

// 출근희망시간 + 10분까지 어플로 출근(주말제외) ex) 9:58 -> 10:8까지
// 모든 시각은 '시간*100+분' 으로 표현 ex) 10:13 -> 1013
// 직원들이 설정한 출근 희망 시각과 실제로 출근한 기록을 바탕으로 상품을 받을 직원이 몇 명인지 ?