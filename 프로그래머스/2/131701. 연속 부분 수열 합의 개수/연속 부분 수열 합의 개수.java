import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int size = elements.length;
        HashSet<Integer> set = new HashSet();
        
        // 길이만큼 돌릴 for 문
        for (int i = 1; i <= size; i++) {
            int j = 1;
            // while(j%size!=0) {
            while(true) {    
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    int plus = (j-1)+k;
                    sum += elements[plus%size];
                }
                j++;
                // System.out.print("sum = " + sum + " ");
                // System.out.print("j의 값 = " + j + " ");

                set.add(sum);
                
                if((j-1)%size == 0) break;
            }
                            // System.out.println();
        }
        
        return set.size();
    }

}

// 원형이니까 시작점이 다시 제자리로 올때까지 돌리면 된다.
// 즉 시작점을 저장해놨다가 다시 거기로올 떄 까지 계산하면될듰?