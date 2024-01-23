import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int size = 0;
        
        for (int num : number) {
            size += num;
        }
            
        Map<String, Integer> map = new HashMap();
                
        for (int i = 0; i < (discount.length - size + 1); i++) {
            
            // 맵 초기화
            for (int j = 0; j < number.length; j++) {
                map.put(want[j], number[j]);
            }
            
            // 싸이즈만큼 
            for (int j = i; j < (i+size); j++) {
                if(map.get(discount[j]) == null) continue;
                map.put(discount[j], map.get(discount[j])-1);
            }
            
            boolean flag = true;
    
            for (int j = 0; j < map.size(); j++) {
                if(map.get(want[j]) != 0) flag = false;
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}

// 10일동안 회원자격
// 매일 한가지 제품 할인
// 할인 제품은 하루에 하나만 구매가능
// 