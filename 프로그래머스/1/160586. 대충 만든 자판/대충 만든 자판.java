import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> hashmap = new HashMap<>();
        
        // keymap = new String[]{"ABCE"};
        // targets = new String[]{"ABDE"};
        
        for(String map : keymap) {
            // 문자에 할당된 수 넣어주기
            for(int i = 0; i < map.length(); i++) {
                String key = map.charAt(i) + "";                              
                
                // 비어있을 땐 그냥 넣고 
                if(hashmap.get(key) == null) {
                    hashmap.put(key, i+1);
                } 
                // 비어있지 않을 때는 작을 때만 넣기
                else if (hashmap.get(key) > (i+1)) {
                    hashmap.put(key, i+1);
                }
            }
        }
        

        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            String target = targets[i];
            for(int j = 0; j < target.length(); j++) {
                String key = target.charAt(j) + "";                              
                if(hashmap.get(key) != null) {
                    sum += hashmap.get(key);
                } else {
                    sum = -1;
                    break;
                }
            }
            
            if(sum == 0) sum = -1;
            
            answer[i] = sum;
        }
        
        return answer;               
    }
}