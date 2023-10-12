import java.util.*;
import java.io.*;


class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String word[] = {"aya", "ye", "woo", "ma"};    
        
        for(String s : babbling) {
            int count = 0;
            int prevSize = s.length();
            
            if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
                continue;
            }
          
            
            for (int i = 0; i < word.length; i++) {
                if(count == 2) {
                    i = 0;
                    count = 0;
                }
                
                // 앞에서부터 돌리면서 있다면 처음꺼만 치환시킨다.
                s = s.replaceFirst(word[i], " ");
                
                // 사이즈가 바뀌었다(치환되었다)면 카운트 늘려줌
                if(prevSize != s.length()) {
                    count++;
                    i = 0;
                }
                prevSize = s.length();
            }
            
            s = s.replace(" ", "");
            
            if(s.length()==0) {
                answer++;
            }
        }
        return answer;
    }
}
        
        // 테스트코드
// class Solution {
//     public int solution(String[] babbling) {
//         int answer = 0;
//         String word[] = {"aya", "ye", "woo", "ma"};    
        
//         // 반례 ayayeye가 0이 돼야함
//         // 반례 ayayeayayeaya가 1이 돼야함
//         String s = "mawoomawoo"; 

//         if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) {
//             return answer = 0;
//         }
//         int count = 0;
//         int prevSize = s.length();
//         int index = -1;
        
//         for (int i = 0; i < word.length; i++) {
//             System.out.println(s);
//             // if (index == i) {
//             //     continue;
//             // }
            
//                 if(count == 2) {
//                     i = 0;
//                     count = 0;
//                 }
                
//                 // 앞에서부터 돌리면서 있다면 처음꺼만 치환시킨다.
//                 s = s.replaceFirst(word[i], " ");
                
//                 // 사이즈가 바뀌었다(치환되었다)면 카운트 늘려줌
//                 if(prevSize != s.length()) {
//                     // index = i;
//                     i = 0;
//                     count++;
//                 }
//                 prevSize = s.length();
//         }
            
//             s = s.replace(" ", "");
            
//             if(s.length()==0) {
//                 answer++;
//             }
        
//         return answer;
//     }
// }
// 여기까지
// ayaaya
// ayayeaya -> aya ye aya 
// 앞에서 제거되면 다음껀 해당하는 인덱스 제외하고 처음부터 돌려서 없애면 될듯