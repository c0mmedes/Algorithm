import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<String> stk = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if(stk.isEmpty()) {
                stk.push(str);        
            } else if((stk.peek().equals("(") && str.equals(")")) || (stk.peek().equals(")") && str.equals(")"))) {
                stk.pop();
            } else {
                stk.push(str);
            }
        }

        if(stk.isEmpty()) {
            answer = true;
        }
        
        return answer;
    }
}