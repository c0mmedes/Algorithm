import java.util.*;

class Solution {
    static boolean visited[];
    static List<String> list;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();       
        dfs("ICN", "ICN", tickets, 0);
 
        Collections.sort(list);     
        
        String[] answer = list.get(0).split(",");
      
        return answer;
    }
    private static void dfs(String start, String route, String[][] tkts, int cnt) {
        if (cnt == tkts.length) {
            list.add(route);
            return;
        }
        
        for (int i = 0; i < tkts.length; i++) {
            if(!start.equals(tkts[i][0]) || visited[i]) continue;
            
            visited[i] = true;
            dfs(tkts[i][1], route + "," + tkts[i][1], tkts, cnt + 1);
            visited[i] = false;
        }
    }
}

// 일단 [?][0] 이 ICN인 곳을 찾아서 돌리고 [?][1]이 시작인 곳을 찾는다.
// 그런식으로 돌리고 
// 출발점은 ICN 공항
// 주어진 항공권을 모두 이용하여 여행경로 짜기
// 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return
