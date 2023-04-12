import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tLength = t.length(); // 문자열의 길이
        int pLength = p.length(); // p의 길이
        int length = tLength - pLength + 1;
        Long arr[] = new Long[length];
        
        // p의 길이만큼 잘라서 배열에 저장
        for (int i = 0; i < length; i++){
            arr[i] = Long.parseLong(t.substring(i, i+pLength));    
        }

        for (Long num : arr) {
            if(num <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}