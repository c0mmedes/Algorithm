import java.util.*;
import java.io.*;

class Solution {
    static int numbers[];
    static boolean visited[];
    static int N, answer, mine;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        mine = k;
        
        for (int i = N; i > 0; i--) {
            numbers = new int[i];
            visited = new boolean[N];
            perm(i, 0, dungeons);
            if(answer > 0) break;
        }
        
        return answer;
    }
    private static void perm(int size, int cnt, int[][] dungeons) {
        if(cnt == size) {
            int temp = mine;
            int count = 0;
            for (int i = 0; i < numbers.length; i++){
                int index = numbers[i];
                int min = dungeons[index][0];// 최소 필요 피로도
                int use = dungeons[index][1];// 소모 피로도 
                if (temp < min) return;
                else {
                    temp -= use;
                    count++;
                }
            }
            answer = Math.max(count, answer);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = i;
            perm(size, cnt + 1, dungeons);
            visited[i] = false;
        }
    }
}

// 각 던전마다 탐험 시작 최소 필요 피로도와 던전 탐험 후 소모 피로도가 있다.
// k - 현재 피로도, dungeons - 최소필요피로도, 소모피로도가 담긴 2차원 배열 던전
// 유저가 탐험할 수 있는 최대 던전 수 return