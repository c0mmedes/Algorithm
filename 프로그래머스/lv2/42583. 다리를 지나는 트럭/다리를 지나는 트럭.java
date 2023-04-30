import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int currentSum = 0;
        
        for (int i = 0; i < truck_weights.length; i++){
            while(true) {
                if(q.isEmpty()) { // 비어있을 때
                    q.offer(truck_weights[i]);
                    currentSum += truck_weights[i];
                    answer++;       
                    break;
                } else if(q.size() == bridge_length) { // 꽉찼을 때
                    currentSum -= q.poll();
                } else { 
                    if (currentSum + truck_weights[i] <= weight) { // 무게 안넘을 때
                        q.offer(truck_weights[i]);
                        currentSum += truck_weights[i];
                        answer++;
                        break;
                    } else { // 넘을 때
                        q.offer(0);
                        answer++;
                    }     
                }
            }
        }
        
        
        
        return answer + bridge_length;
    }
}