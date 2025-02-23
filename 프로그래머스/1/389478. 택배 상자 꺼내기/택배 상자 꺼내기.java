class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = 0;

        if(n%w == 0) row = n/w;
        else row = n/w + 1;
        
        if (w == 1) {
            return n - num + 1;
        }
        
        int arr[][] = new int[row][w];
        
        int r = row-1;
        int c = 0;
        int curNum = 1;
        boolean flag = true;
        
        while(true) {
            arr[r][c] = curNum;
            
            if(curNum == n) break;
            
            if (curNum%w == 0) {
                r--;
                curNum++;
                arr[r][c] = curNum;
                
                if(flag) flag = false;
                else flag = true;
                
                continue;
            }
           
            if(flag) {
                c++;
            } else {
                c--;
            }
            curNum++;   
        }

        int posX = 0;
        int posY = 0;
        
        out:for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < w; j++) {
                if(arr[i][j] == num) {
                    posX = i;
                    posY = j;
                    break out;
                }
            }       
        }
        
        for (int i = posX; i >= 0; i--) {
            if(arr[i][posY] == 0) break;
            answer++;
        }
        
        return answer;
    }
}

