import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 친구의 수
        int totalFriends = friends.length;

        // 처음 친구부터 1부터 넘버링
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < totalFriends; i++) {
            map.put(friends[i], i);
        }
        
        int giftChart[][] = new int[totalFriends][totalFriends];
        
        // 선물 지수
        int giftScore[] = new int[totalFriends];
        
        // 선물 차트표, 선물 지수
        for (int i = 0; i < gifts.length; i++) {
            String str[] = gifts[i].split(" ");
            // str[0] = 준사람, str[1] = 받은사람
            
            giftChart[map.get(str[0])][map.get(str[1])]++;
            giftScore[map.get(str[0])]++;
            giftScore[map.get(str[1])]--;
        }
        
        // 받을 선물의 개수를 저장할 배열
        int giftCount[] = new int[totalFriends];

        for (int i = 0; i < totalFriends; i++) {
            for (int j = i+1; j < totalFriends; j++) {
                if(giftChart[i][j] > giftChart[j][i]) {
                    giftCount[i]++;
                } else if(giftChart[i][j] < giftChart[j][i]) {
                    giftCount[j]++;
                    // 주고받은 개수가 같은 경우
                } else if(giftChart[i][j] == giftChart[j][i]) {
                    // 선물 지수가 큰 친구에게 +
                    if(giftScore[i] > giftScore[j]) giftCount[i]++;
                    else if(giftScore[i] < giftScore[j]) giftCount[j]++;
                }
            }
        }
        
        Arrays.sort(giftCount);
        
        return giftCount[totalFriends-1];
    }
}