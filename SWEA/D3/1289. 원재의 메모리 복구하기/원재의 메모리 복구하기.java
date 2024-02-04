import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            int answer = 0;
            String oriMemory = br.readLine();
            
            int oriSize = oriMemory.length();
            int arr[] = new int[oriSize];
            
            for (int i = 0; i < oriSize; i++) {
                // 두개가 다를 경우 oriMemory의 문자로 다채우기
                if(!(oriMemory.charAt(i)+"").equals(arr[i] + "")) {
                    answer++;
                    if(oriMemory.charAt(i) == '1') {
                        for (int j = i; j < oriSize; j++) {
                            arr[j] = 1;
                        }
                    } else {
                        for (int j = i; j < oriSize; j++) {
                            arr[j] = 0;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}