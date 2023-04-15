import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        List<String> cardss1 = new ArrayList<>();
        List<String> cardss2 = new ArrayList<>();
        
        for (int i = 0; i < cards1.length; i++) cardss1.add(cards1[i]);
        for (int i = 0; i < cards2.length; i++) cardss2.add(cards2[i]);
        
        for (int i = 0; i < goal.length; i++){
            
            if(goal[i].equals(cardss1.get(0))) {
                if(cardss1.size() > 1) {
                    cardss1.remove(0);
                }
            } else if(goal[i].equals(cardss2.get(0))) {
                if(cardss2.size() > 1) {
                    cardss2.remove(0);
                }
            } else {
                answer = "No";
                break;        
            }
        }
        
        return answer;
    }
}