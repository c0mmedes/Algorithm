/*
 이전의 선택 결과가 이후의 결과에 영향을 미치지 않으려면 먼저 '이전 선택의 종료 시간'과 '이후 선택의 시작 시간'이 서로 겹치지 않으면 된다. 
 그리고 최대한 많은 활동을 선택하려면 종료시간이 빨라야 할 수 밖에 없을 것
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Time {
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		int N = Integer.parseInt(br.readLine());
		List<Time> time = new ArrayList<>();
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time.add(new Time(start, end));
		}
		
		// 종료시간이 같을 경우 시작시간 기준으로 오름차순
		Collections.sort(time, new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				if(o1.end == o2.end) {
					return o1.start - o2.start;
				}
				return (o1.end) - (o2.end);
			}
		});
		
//		for (int i = 0; i < time.size(); i++) {
//			System.out.println("start: " + time.get(i).start + ", end: " + time.get(i).end);
//		}
		
		int prev = 0;
		int cnt = 0;
		
		for (int i = 0; i < time.size(); i++) {
			// 이전의 종료시간보다 현재인덱스의 시작시간이 크거나 같을 경우 현재의 종료시간을 prev에 갱신
			if(prev <= time.get(i).start) {
				prev = time.get(i).end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
