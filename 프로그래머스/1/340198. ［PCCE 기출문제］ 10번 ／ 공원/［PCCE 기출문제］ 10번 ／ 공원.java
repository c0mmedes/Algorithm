import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        
        for (int m = mats.length-1; m >= 0; m--) {
            int len = mats[m];
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    // 돗자리의 시작점 찾기
                    // 비어있지 않으면 패스
                    if(!park[i][j].equals("-1")) continue;
                    
                    // 비어있다면 거기서부터 탐색
                    if(func(i, j, len, park)) return len;
                }
            }    
        }
        return -1;
    }
    
    private static boolean func(int r, int c, int len, String[][] park) {
        for (int i = r; i < r+len; i++) {
            for (int j = c; j < c+len; j++) {
                if(i >= park.length || j >= park[0].length || !park[i][j].equals("-1")) return false;
            }
        }
        
        return true;        
    }
}


