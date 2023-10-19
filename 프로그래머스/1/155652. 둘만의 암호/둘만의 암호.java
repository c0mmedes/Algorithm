import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            // 문자 하나를 아스키로
            int ascii = (int) s.charAt(i);
            
            String plus = "";
            
            // String str = char(ascii + j) + "";
            String str = "";
            
            for (int j = 1; j <= index; j++) {
                ascii++;
                
                // z 넘어가는 경우 처리
                if(ascii > 122) {
                    ascii = ascii - 26;
                }
                
                str = (char) ascii + "";
                
                // skip에 포함된 문자면 j 하나 빼주고 넘어가기
                if (skip.contains(str)) {
                    j--;
                    continue;
                }  
            }
            
            answer += str;            
        }
        
        return answer;
    }
}