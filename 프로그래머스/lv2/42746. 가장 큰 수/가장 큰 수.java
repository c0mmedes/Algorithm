import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String str[] = new String[numbers.length];
        boolean flag = true;
        
        for (int i = 0; i < str.length; i++){
            str[i] = numbers[i] + "";
        }
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        for (int i = 0; i < str.length; i++) {
            answer += str[i];
            if(!str[i].equals("0")) flag = false;
        }
        
        if (flag) return "0";
        return answer;
    }
}