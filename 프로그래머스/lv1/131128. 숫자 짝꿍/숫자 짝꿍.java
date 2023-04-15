import java.util.*;
import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        int arrX[] = new int[10];
        int arrY[] = new int[10];
        
        for (int i = 0; i < X.length(); i++) arrX[X.charAt(i) - '0']++;
        for (int i = 0; i < Y.length(); i++) arrY[Y.charAt(i) - '0']++;

        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 9; i >= 0; i--){
            while(arrX[i] > 0 && arrY[i] > 0) {
                sb.append(i);
                arrX[i]--;
                arrY[i]--;
            } 
        }
        
        
        if(sb.toString().equals("")) return "-1";
        else if (sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}
