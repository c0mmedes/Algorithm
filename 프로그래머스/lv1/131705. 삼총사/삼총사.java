class Solution {
    static int students[] = new int[3];
    static int N, ans;
    
    private static void comb(int cnt, int start, int inputs[]) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++){
                sum += students[i];
            }
            
            if(sum == 0){
                ans++;
            }
            return;
        }
            
        for (int i = start; i < N; i++){
            students[cnt] = inputs[i];
            comb(cnt + 1, i + 1, inputs);
        }
         
    }

    public int solution(int[] number) {
        int answer = 0;
        N = number.length;
        ans = 0;
        
        comb(0, 0, number);
        
        return ans;
    }
}