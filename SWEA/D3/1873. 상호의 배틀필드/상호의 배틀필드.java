import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken()); // 맵의 높이
			int W = Integer.parseInt(st.nextToken()); // 맵의 너비
			
			String arr[][] = new String[H][W];
			x = 0;
			y = 0;
			
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j) + "";
					if (arr[i][j].equals("^") || arr[i][j].equals("v") || arr[i][j].equals("<") || 
							arr[i][j].equals(">")) {
						x = i;
						y = j;
					}
				}
			}
			
			br.readLine();
			char[] cmd = br.readLine().toCharArray();
			
			for (int i = 0; i < cmd.length; i++) {
				switch (cmd[i]) {
				case 'U':
					if (((x-1) >= 0)  && arr[x-1][y].equals(".")) {
						arr[x][y] = ".";
						arr[x-1][y] = "^";
						x = x - 1;
					} else {
						arr[x][y] = "^";
					}
					break;
				case 'D':
					if (((x+1) < H) && arr[x+1][y].equals(".")) {
						arr[x][y] = ".";
						arr[x+1][y] = "v";
						x = x + 1;
					} else {
						arr[x][y] = "v";
					}
					break;
				case 'L':
					if (((y-1) >= 0) && arr[x][y-1].equals(".")) {
						arr[x][y] = ".";
						arr[x][y-1] = "<";
						y = y - 1;
					} else {
						arr[x][y] = "<";
					}
					break;
				case 'R':
					if (((y+1) < W) && arr[x][y+1].equals(".")) {
						arr[x][y] = ".";
						arr[x][y+1] = ">";
						y = y + 1;
					} else {
						arr[x][y] = ">";
					}
					break;
				case 'S':
					if (arr[x][y].equals(">")) {
						int p = 1;
						while(true) {
							if ((y+p < W)) {
								if (arr[x][y+p].equals("*")) {
									arr[x][y+p] = ".";
									break;
								} else if (arr[x][y+p].equals("#")) {
									break;
								}
							} else break;
							p++;
						}
					}
					if (arr[x][y].equals("<")) {
						int p = 1;
						while(true) {
							if ((y-p >= 0)) {
								if (arr[x][y-p].equals("*")) {
									arr[x][y-p] = ".";
									break;
								} else if (arr[x][y-p].equals("#")) {
									break;
								}
							} else break;
							p++;
						}
					}
					if (arr[x][y].equals("^")) {
						int p = 1;
						while(true) {
							if ((x-p >= 0)) {
								if (arr[x-p][y].equals("*")) {
									arr[x-p][y] = ".";
									break;
								} else if (arr[x-p][y].equals("#")) {
									break;
								}
							} else break;
							p++;
						}
					}
					if (arr[x][y].equals("v")) {
						int p = 1;
						while(true) {
							if ((x+p < H)) {
								if (arr[x+p][y].equals("*")) {
									arr[x+p][y] = ".";
									break;
								} else if (arr[x+p][y].equals("#")) {
									break;
								}
							} else break;
							p++;
						}
					}
					break;
				}
			
			}
            
			sb.append("#").append(tc).append(" ");
			for (int a = 0; a < H; a++) {
				for (int b = 0; b < W; b++) {
					sb.append(arr[a][b]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
/*
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)

U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

*/