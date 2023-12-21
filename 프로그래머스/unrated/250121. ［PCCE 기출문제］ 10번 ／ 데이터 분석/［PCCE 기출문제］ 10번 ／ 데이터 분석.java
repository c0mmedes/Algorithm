import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Integer[]> list = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            switch (ext) {
                case "code":
                    // data의 ext 값이 val_ext 보다 작은 애들만 일단 data에 추가하고 sort_by에 따라서 정렬하면 될듯.
                    if(data[i][0] < val_ext) {
                        list.add(new Integer[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                    }
                    break;
                case "date":
                    if(data[i][1] < val_ext) {
                        list.add(new Integer[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                    }
                    break;
                case "maximum":
                    if(data[i][2] < val_ext) {
                        list.add(new Integer[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                    }
                    break;
                case "remain":
                    if(data[i][3] < val_ext) {
                        list.add(new Integer[]{data[i][0], data[i][1], data[i][2], data[i][3]});
                    }
                    break;             
            }
            
            // data[]
        }
        
        switch (sort_by) {
                case "code":
                    Collections.sort(list, Comparator.comparing(array -> array[0]));
                    break;
                case "date":
                    Collections.sort(list, Comparator.comparing(array -> array[1]));
                    break;
                case "maximum":
                    Collections.sort(list, Comparator.comparing(array -> array[2]));
                    break;
                case "remain":
                    Collections.sort(list, Comparator.comparing(array -> array[3]));
                    break;      
        }
        

        
        int[][] answer = new int[list.size()][4];
        
        int i = 0;
        
        for (Integer[] arr : list) {
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
            answer[i][2] = arr[2];
            answer[i][3] = arr[3];
            i++;
        }

        
        return answer;
    }
}

// data : 정렬한 데이터들의 리스트 -> 코드번호(code), 제조일(date), 최대수량(maxinum), 현재수량(remain) 으로 구성
// ext : 데이터를 뽑아낼 기준이 될 정보의 문자열
// val_ext : 뽑아낼 정보의 기준값을 나타내는 정수
// sort_by : 정보를 정렬할 기준이 되는 문자열