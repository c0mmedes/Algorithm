import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '#') {
                    if(i < x1) x1 = i;
                    if(i > x2) x2 = i;
                    if(j < y1) y1 = j;
                    if(j > y2) y2 = j;
                }
            }
        }
        
        int[] answer = {x1, y1, x2+1, y2+1};
        
        return answer;
    }
}

// . # . . .
// . . # . .
// . . . # .
// (x, y) 일 때 x가 가장 작은 애를 x1, y가 가장 작은애를 y1 으로 설정
// x가 가장 큰애를 x2, y가 가장 큰 애를 y2