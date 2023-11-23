import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) { 
        String[][] arr = new String[park.length][park[0].length()];
        
        int startX = 0;
        int startY = 0;
        
        // 2차원으로 만들고
        for (int i = 0; i < park.length; i++){
            for (int j = 0; j < park[0].length(); j++) {
                arr[i][j] = park[i].charAt(j) + "";
                if(arr[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }
    
          
        for (int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            String dir = str[0];
            int count = Integer.parseInt(str[1]);
            
            boolean flag = true;
            switch (dir) {
                // 북쪽
                case "N":
                    for (int j = 0; j < count; j++) {
                        if((startX - j - 1) < 0 || arr[(startX - j - 1)][startY].equals("X")) {
                        flag = false;
                        break;
                        }
                    }
                    if(flag) startX -= count;
                    break;
                // // 남쪽
                case "S":
                    for (int j = 0; j < count; j++) {
                        if((startX + j + 1) >= park.length || 
                           arr[(startX + j + 1)][startY].equals("X")) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) startX += count;
                    break;
                // // 서쪽
                case "W":
                    for (int j = 0; j < count; j++) {
                        if((startY-j-1) < 0 || 
                           arr[startX][startY-j-1].equals("X")) {
                            flag = false;
                            break;
                          } 
                    }
                    if(flag) startY -= count;
                    break;
                // // 동쪽
                case "E":
                    for (int j = 0; j < count; j++) {
                        if((startY + j + 1) >= park[0].length() || 
                           arr[startX][startY + j + 1].equals("X")) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) startY += count;
                    break;    
            }
        }
            
        int[] answer = {startX, startY};

        
        return answer;
    }
}