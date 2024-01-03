// 수확한 귤 중 k개를 고를 때 종류를 가장 작게 만들기

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        HashMap<Integer, Integer> map = new HashMap();
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : map.keySet()) {
            pq.add(map.get(num));
        }
        
        while(k > 0) {
            int num = pq.poll();
            k -= num;
            answer++;
            
        }
        
        return answer;
    }
}