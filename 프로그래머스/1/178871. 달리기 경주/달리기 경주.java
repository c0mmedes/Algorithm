import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            // 호출된 선수의 등수
            int calledRank = map.get(callings[i]);
            // 호출된 선수의 등수의 앞에 있는 사람
            String beforeRanker = players[calledRank-1];
            
            // 자리바꿔주기
            players[calledRank] = beforeRanker;
            players[calledRank-1] = callings[i];
            
            // map도 바꿔주기
            map.put(beforeRanker, calledRank);
            map.put(callings[i], calledRank-1);
        }
        
        return players;
    }
}