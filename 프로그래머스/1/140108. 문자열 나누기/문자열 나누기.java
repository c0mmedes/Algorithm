class Solution {
    public int solution(String s) {
        int answer = 0;
  
        String prev = "";
        int xCount = 1;
        int yCount = 0;
        
        // s = "abcdee";
        
        for (int i = 0; i < s.length(); i++) {
             
            // 처음 문자가 비어있을 때 현재꺼 넣어주고 continue;
            if(prev.equals("")) {
                if(i == s.length()-1) {
                    answer++;
                }
                
                prev = s.charAt(i) + "";    
                continue;
            }
            
            // 비교할 문자
            String cur = s.charAt(i) + "";
            
            // 처음 문자랑 같은 경우 xcount 증가
            if(prev.equals(cur)) {
                xCount++;
            } 
            // 처음 문자랑 같지 않은 경우 ycount 증가
            if(!prev.equals(cur)) {
                yCount++;
            }
               
            // 카운트가 같을 경우 answer 1개 증가시키기
            if(xCount == yCount) {
                answer++;
                
                // 전값과의 비교를 위한 prev도 초기화
                prev = "";
                
                // 다음 카운트를 위해 xCount와 yCount는 초기화
                xCount = 1;
                yCount = 0;
            } 
            
             // 처음부터 끝까지 같지 않을 때 처리
                if(i == s.length()-1) {
                    if(xCount > 1 && yCount >= 0) {
                        answer++;
                    }
            }
        }
        
        
        return answer;
    }
}