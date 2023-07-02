import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<String> list= new ArrayList<>();
		
		for (int tc = 0; tc < T; tc++) {
			Deque<String> deq = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			String p = br.readLine(); // 수행할 함수 
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
			String str = br.readLine(); // 배열
			
			if(p.contains("D") && n == 0) {
				list.add("error");
				continue;
			}
			
			str = str.replace("[", "");
			str = str.replace("]", "");
			String strArr[] = str.split(",");
			for (String s : strArr) deq.add(s);
			
			boolean errorFlag = false;
			boolean flag = true; // 앞
			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'R') {
					if (flag) flag = false; // 앞일 땐 뒤로 바꿔줌
					else if (!flag) flag = true; // 뒤일 땐 앞으로 바꿔줌
				} else if (p.charAt(i) == 'D') {
					if (deq.isEmpty()) {
						list.add("error");
						errorFlag = true;
						break;
					}
					if (flag) deq.removeFirst();
					if (!flag) deq.removeLast();
				}
			}
			
			if(deq.isEmpty() && errorFlag) continue;
			
			// flag가 false면 뒤부터 넣어주고 
			// flag가 true면 앞부터 넣어주고
			Deque<String> deq2 = new ArrayDeque<>();
			if (!flag) {
//				System.out.println(deq.size());
				while(!deq.isEmpty()) {
					String input = deq.removeLast();
					deq2.add(input);
				}
				String res = deq2.toString();
				res = res.replace(" ", "");
				
				list.add(res);
			} else {
				String res = deq.toString();
				res = res.replace(" ", "");
				
				list.add(res);
			}
			
		}
		
		for (String s : list) System.out.println(s);
		
	}
}

// R - 배열에 있는 수의 순서를 뒤집는다, D - 첫 번째 수를 버린다(배열이 비어있는데 D를 사용하면 error 출력)