import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int m, int[] score) { 
        // k는 최대점수, m은 한 상자의 사과 수, score는 사과의 점수
        Arrays.sort(score);
        int size = score.length / m;
        int answer = 0;
        
        for (int i = 0; i < size; i++){
            int min = Integer.MAX_VALUE;
            // for (int j = score.length-1-(i*m); j < m; j--){
            for (int j = 0; j < m; j++){
                int c = score.length-1-j-(i*m);   
                min = Math.min(score[c], min);
            }
            answer += (min * m);        
        }
       

        return answer;
    }
}