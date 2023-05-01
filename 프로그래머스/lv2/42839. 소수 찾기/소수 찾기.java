import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static int cnt = 0;
    static String inputs[];
	static boolean visited[];
    static List<Integer> list;
    static StringBuilder sb;
	static void subset(int cnt) {
	if (cnt == N) {
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) { 
            if(!visited[i]) continue;
            sb.append(inputs[i]);
        }
        String str = sb.toString();
        String reverseStr = sb.reverse().toString();
        System.out.println(str);
        
        if (str.length() > 0 && (!str.equals("0") || !str.equals("1"))) {
            int num = Integer.parseInt(str);
            int rNum = Integer.parseInt(reverseStr);
            
            list.add(num);
            list.add(rNum);
        }
  
		return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
    
    static void check(int num) {
        System.out.println(num);
        for (int i = 2; i < Math.sqrt(cnt); i++){
            if(cnt % i == 0) break;                   
        }
        cnt++;
	}
    
    public int solution(String numbers) {
        N = numbers.length();
        inputs = new String[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++){
            inputs[i] = numbers.charAt(i) + "";
        }

        list = new ArrayList<>();
        subset(0);
        Set<Integer> set = new HashSet<>();
        
        for (int num : list) {
            if (num == 0 || num == 1) continue; 
            set.add(num);
        }
        
        // Iterator iter = set.iterator();
        for (Integer value : set) {
            int intValue = value.intValue();
            check(intValue);
        }
        
        // while(iter.hasNext()){
        //     int num = iter.next();
            // check();
        // }
        
        return cnt;
    }
}