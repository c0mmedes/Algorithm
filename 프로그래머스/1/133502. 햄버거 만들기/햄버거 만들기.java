import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();        
        
        for (int a : ingredient) {
            sb.append(a);
            
            if (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
                answer++;
                sb.delete(sb.length() - 4, sb.length());
            }

        }
        
        return answer;
    }
}

// 1231
// 아래부터 빵 야채 고기 빵
// 빵 - 1, 야채 - 2, 고기 - 3
// 야채 빵 빵 야채 고기 빵 야채 고기 빵