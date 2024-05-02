import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // 높이
            int W = Integer.parseInt(st.nextToken()); // 너비

            char map[][] = new char[H][W];

            int x = 0;
            int y = 0;

            int dir = 0; // 방향 1 - 상, 2 - 하, 3 - 좌, 4 - 우

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '^') {
                        x = i;
                        y = j;
                        dir = 1;
                    }
                    if(map[i][j] == 'v') {
                        x = i;
                        y = j;
                        dir = 2;
                    }
                    if(map[i][j] == '<') {
                        x = i;
                        y = j;
                        dir = 3;
                    }
                    if(map[i][j] == '>') {
                        x = i;
                        y = j;
                        dir = 4;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine()); // 사용자가 넣을 입력의 개수

            String cmd[] = br.readLine().split("");

            // 방향 1 - 상, 2 - 하, 3 - 좌, 4 - 우
            for (int i = 0; i < N; i++) {
                String motion = cmd[i];

                switch (motion) {
                    case "U":
                        dir = 1;
                        map[x][y] = '^';
                        if((x-1) >= 0 && map[x-1][y] == '.') {
                            // 이미 있던 자리는 평지로 바꾸고
                            map[x][y] = '.';
                            // 한칸 위로 이동시키고 이동한 자리는 전차로
                            x-=1;
                            map[x][y] = '^';
                        }
                        break;
                    case "D":
                        dir = 2;
                        map[x][y] = 'v';
                        if((x+1) < H && map[x+1][y] == '.') {
                            // 이미 있던 자리는 평지로 바꾸고
                            map[x][y] = '.';
                            // 한칸 아래로 이동시키고 이동한 자리는 전차로
                            x+=1;
                            map[x][y] = 'v';
                        }
                        break;
                    case "L":
                        dir = 3;
                        map[x][y] = '<';
                        if((y-1) >= 0 && map[x][y-1] == '.') {
                            // 이미 있던 자리는 평지로 바꾸고
                            map[x][y] = '.';
                            // 한칸 왼쪽으로 이동시키고 이동한 자리는 전차로
                            y-=1;
                            map[x][y] = '<';
                        }
                        break;
                    case "R":
                        dir = 4;
                        map[x][y] = '>';
                        if((y+1) < W && map[x][y+1] == '.') {
                            // 이미 있던 자리는 평지로 바꾸고
                            map[x][y] = '.';
                            // 한칸 오른쪽로 이동시키고 이동한 자리는 전차로
                            y+=1;
                            map[x][y] = '>';
                        }
                        break;
                    case "S":
                        // 상 방향
                        if(dir==1) {
                            int newX = x-1;
                            while(true) {
                                if (newX < 0) break;
                                // 벽돌일 때 부딪히면 평지로 바뀌고 break
                                if(map[newX][y] == '*') {
                                    map[newX][y] = '.';
                                    break;
                                } else if (map[newX][y] == '#') {
                                    break;
                                }
                                newX--;
                            }
                            // 하 방향
                        } else if(dir==2) {
                            int newX = x+1;
                            while(true) {
                                if (newX >= H) break;
                                // 벽돌일 때 부딪히면 평지로 바뀌고 break
                                if(map[newX][y] == '*') {
                                    map[newX][y] = '.';
                                    break;
                                } else if (map[newX][y] == '#') {
                                    break;
                                }
                                newX++;
                            }
                            // 좌
                        } else if(dir==3) {
                            int newY = y-1;
                            while(true) {
                                if (newY < 0) break;
                                // 벽돌일 때 부딪히면 평지로 바뀌고 break
                                if(map[x][newY] == '*') {
                                    map[x][newY] = '.';
                                    break;
                                } else if (map[x][newY] == '#') {
                                    break;
                                }
                                newY--;
                            }
                        } else if(dir==4) {
                            int newY = y+1;
                            while(true) {
                                if (newY >= W) break;
                                // 벽돌일 때 부딪히면 평지로 바뀌고 break
                                if(map[x][newY] == '*') {
                                    map[x][newY] = '.';
                                    break;
                                } else if (map[x][newY] == '#') {
                                    break;
                                }
                                newY++;
                            }
                        }
                        break;
                }

//                System.out.println("motion = " + motion);
//                for (int c = 0; c < H; c++) {
//                    System.out.println(Arrays.toString(map[c]));
//                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            System.out.print("#" + t + " " + sb);
        }
    }
}
//        .	평지(전차가 들어갈 수 있다.)
//        *	벽돌로 만들어진 벽
//        #	강철로 만들어진 벽
//        -	물(전차는 들어갈 수 없다.)
//        ^	위쪽을 바라보는 전차(아래는 평지이다.)
//        v	아래쪽을 바라보는 전차(아래는 평지이다.)
//        <	왼쪽을 바라보는 전차(아래는 평지이다.)
//        >	오른쪽을 바라보는 전차(아래는 평지이다.)
//        다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
//
//        U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//        D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//        L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//        R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//        S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.