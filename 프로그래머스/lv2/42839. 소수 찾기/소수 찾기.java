import java.util.*;
import java.io.*;

class Solution {
    static Set<Integer> set = new HashSet<>();    
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    private void recur(String comb, String others){
        if(!comb.equals("")) {
            set.add(Integer.valueOf(comb));
        } 
        
        for (int i = 0; i < others.length(); i++){
            recur(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    public int solution(String numbers) {
        recur("", numbers);
        
        
        int cnt = 0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) cnt++;
        }
        return cnt;
    }
}