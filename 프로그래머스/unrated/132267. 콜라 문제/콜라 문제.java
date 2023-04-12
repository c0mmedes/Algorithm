class Solution {
    public int solution(int a, int b, int n) { 
        // a : 마트에 주어야 하는 빈 병 수, b : 마트가 주는 콜라 병 수, n : 상빈이가 가지고 있는 빈 병의 개수 
        int answer = 0;
        int c = 0;
        while (true) {
            if (n < a) break;
            c = n / a * b;
            n = (n % a) + c; 
            answer += c;
            
        }
        
        return answer;
    }
}