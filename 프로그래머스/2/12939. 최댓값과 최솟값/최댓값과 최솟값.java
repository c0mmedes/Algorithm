import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String str[] = s.split(" ");
        int answer[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            answer[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(answer);
        String ans = answer[0] + " " + answer[answer.length-1];
        return ans;
    }
}