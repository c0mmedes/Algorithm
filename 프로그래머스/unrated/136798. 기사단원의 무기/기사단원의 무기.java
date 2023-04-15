import java.util.*;
import java.io.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        list.add(1);
        
        for (int i = 2; i <= number; i++){
            List<Integer> list2 = new ArrayList<>();
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if(i%j == 0) {
                    list2.add(j);
                    if (i/j != j) {
                        list2.add(i/j);
                    }
                }
            }
            list.add(list2.size());
            // System.out.println(list2.toString());
        }
        
        // for (int i = 2; i <= number; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for (int j = 1; j <= Math.sqrt(i); j++) {
        //         if(i%j == 0) {
        //             set.add(i/j);    
        //         }
        //     }
        //     list.add(set.size());
        // }
        
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) > limit) {
                answer += power;
            } else {
                answer += list.get(i);
            }
        }
        
        return answer;
    }
}