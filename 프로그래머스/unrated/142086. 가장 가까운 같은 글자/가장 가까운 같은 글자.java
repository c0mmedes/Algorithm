class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 1; i < s.length(); i++){
            String str = s.charAt(i) + "";
            int cnt = 0;
            for (int j = i-1; j >= 0; j--){
                cnt++;
                String cmp = s.charAt(j) + "";
                if (str.equals(cmp)) {
                    answer[i] = cnt;
                    break;
                }
            }
           // answer[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++){
            if(answer[i] == 0) answer[i] = -1;
        }
        
        return answer;
    }
}