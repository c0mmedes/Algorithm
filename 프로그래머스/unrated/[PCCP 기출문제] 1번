class Solution {
    // bandage - (기술시전시간, 1초당회복량, 추가회복량)
    // health - 최대 체력
    // attacks - 몬스터의 공격 시간과 피해량을 담은 2차원 정수배열
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 연속 시간
        int continuity = 0;
        // 몬스터의 마지막 공격 시간
        int endTime = 0;
        
        // endTime 계산
        for (int i = 0; i < attacks.length; i++) {
            if(endTime < attacks[i][0]) {
                endTime = attacks[i][0];
            }
        }
        
        int curHealth = health;
        
        for (int i = 1; i <= endTime; i++) {
            
            continuity++;

            curHealth += bandage[1];
            boolean flag = false;
            
            for (int j = 0; j < attacks.length; j++) {
                   // 몬스터의 공격시간 
                   if(i == attacks[j][0]) {
                       // System.out.println("여기" + i);
                       // 위에서 더해줬으니까 빼주기
                       curHealth -= bandage[1];
                       if (curHealth > health) {
                           curHealth = health;
                           flag = true;
                       }
                       // 연속성공 초기화
                       continuity = 0;
                       // 피 깎기
                       curHealth -= attacks[j][1];
                       // 체력이 0 이하가 되면 사망
                       if(curHealth <= 0) {
                           return -1;
                       }  
                       break;
                   }
            }  
            if(flag && (curHealth > health)) {
                curHealth = health;
            }
            System.out.println(continuity);
            if(continuity == bandage[0]) {
                curHealth += bandage[2];
                continuity = 0;
            }
        }

        int answer = curHealth;
        return answer;
    }
}

// t초동안 붕대감으면 x만큼 체력회복 -> t초당 x회복
// t초 연속으로 붕대 감으면 y만큼 추가회복
// 최대 체력보다 커지는 건 불가능
// 기술 쓰다가 공격당하면 기술취소, 공격 당하는 순간에는 체력회복x -> 연속성공 0으로 초기화
// 0이되면 캐릭터 사망
