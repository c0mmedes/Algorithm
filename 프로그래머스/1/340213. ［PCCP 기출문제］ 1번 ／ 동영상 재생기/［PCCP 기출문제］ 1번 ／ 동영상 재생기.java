import java.util.*;
import java.io.*;
// 10초전이동 - prev, 10초미만일 경우 0분0초
// 10초후이동 - next, 남은시간이 10초미만일 경우 영상의 마지막(동영상길이)
// 오프닝건너뛰기 - op_start ≤ 현재 재생 위치 ≤ op_end 인 경우 자동으로 오프닝이 끝나는 위치로

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 영상의길이, 현재 재생위치, 오프닝의 시작과 끝시간, 입력배열
        int video_lenInt = Integer.parseInt(video_len.replace(":", ""));
        video_lenInt = video_lenInt/100 * 60 + video_lenInt%100;
        int posInt = Integer.parseInt(pos.replace(":", ""));
        posInt = posInt/100 * 60 + posInt%100;
        int op_startInt = Integer.parseInt(op_start.replace(":", ""));
        op_startInt = op_startInt/100 * 60 + op_startInt%100;
        int op_endInt = Integer.parseInt(op_end.replace(":", ""));
        op_endInt = op_endInt/100 * 60 + op_endInt%100;
        
        for (int i = 0; i < commands.length; i++) {
            // 오프닝구간인 경우
            if(op_startInt <= posInt && posInt <= op_endInt) {
                posInt = op_endInt;                                    
            }
            if(commands[i].equals("prev")) {
                if(posInt < 10) {
                    posInt = 0;     

                } else {
                    posInt -= 10;
                }                
            }
            if(commands[i].equals("next")) {
                if(video_lenInt - posInt < 10) {
                    posInt = video_lenInt;    
                } else {
                    posInt += 10;
                }          
            }            
        }

        // 명령어를 다 수행 후 오프닝 구간일 경우
        if(op_startInt <= posInt && posInt <= op_endInt) {
                posInt = op_endInt;                                    
        }
        
        // 영상의 길이가 비디오의 전체 영상 길이를 넘어간 경우
        if(posInt > video_lenInt) posInt = video_lenInt;
        
        String mm = (posInt/60 < 10) ? ("0" + posInt/60) : String.valueOf(posInt/60);
        String ss = (posInt%60 < 10) ? ("0" + posInt%60) : String.valueOf(posInt%60);
        String answer = mm + ":" + ss; 
        
        return answer;
    }
}                         