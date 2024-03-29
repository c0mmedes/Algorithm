import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        int answer[] = {};
        
        for (int j = 0; j < privacies.length; j++) {
            String arr1[] = privacies[j].split(" ");
            // arr1[0] 수집 날짜
            // arr1[1] 약관
                
            for (int i = 0; i < terms.length; i++){
                String arr2[] = terms[i].split(" ");
                // arr2[0] 약관
                // arr2[1] 유효기간
                if(arr2[0].equals(arr1[1])) {

                    // day[0] = 년도, day[1] = 월, day[2] = 일
                    int plusDay = Integer.parseInt(arr2[1]) * 28;
                    
                    String time[] = arr1[0].split("\\.");
                    int timeYear = Integer.parseInt(time[0]);
                    int timeDay = Integer.parseInt(time[2]) + plusDay; 
                    int timeDayToMonth = timeDay/28; // 기존 달에 추가할 달 수
                    timeDay = timeDay % 28; // 일자
                    int timeMonth = Integer.parseInt(time[1]) + timeDayToMonth;
                    timeYear += timeMonth / 12;
                    timeMonth = timeMonth % 12;

                    String now[] = today.split("\\.");
                    int nowYear = Integer.parseInt(now[0]);
                    int nowMonth = Integer.parseInt(now[1]);
                    int nowDay = Integer.parseInt(now[2]);

                    int daySum = timeYear*12*28 + timeMonth*28 + timeDay;
                    
                    int nowSum = Integer.parseInt(now[0])*12*28 + Integer.parseInt(now[1])*28 + Integer.parseInt(now[2]); 
                        
                    if(daySum <= nowSum) {
                        list.add(j+1);
                    }
                    break;
                }
            }
            
            answer = new int[list.size()];
            
            for (int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }

}
    // today "2022.05.19" 유효기간 terms ["A 6", "B 12", "C 3"] 
    // 수집된 정보 privacies ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
    // 유효기간 지나면 파기 2021.1.5 -> 유효기간 12 -> 2022.1.4 보관 2022.1.5 파기
    // 모든 달은 28일까지 