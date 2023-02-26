import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++){
            int num = sc.nextInt();
            if (num == 0) stk.pop();
            else { 
                stk.push(num); 
            }
        }

        int sum = 0;

        while(!stk.isEmpty()) {
            sum += stk.pop();
        }
        
        System.out.println(sum);
    }
}