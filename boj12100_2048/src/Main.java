import java.util.*;
public class Main {
	static int N;
	static int max = 0;
	
	static void print(int[][] tmpMap,String what,int cnt) {
		System.out.println(what + ": " + cnt);
		for(int i = 0;i < N;i++) {
			for(int j = 0;j < N;j++) {
				System.out.print(tmpMap[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int cnt,int[][] map) {
		if(cnt > 5) return;
		
		for(int i = 0;i< 4; i++) {			
			int[][] tmpMap = new int[N][N];			
			for(int j = 0;j < N;j++)
				for(int k = 0;k < N;k++)
					tmpMap[j][k] = map[j][k];
			
			if(i == 0) { //오른쪽			
				for(int j = 0;j < N;j++) {
					for(int k = N - 1;k > 0;k--) {
						if(tmpMap[j][k] != 0) { //0이 아니면
							for(int h = k - 1; h >= 0;h--) { //다음 숫자가 같은지
								if(tmpMap[j][h] != 0) {
									if(tmpMap[j][h] == tmpMap[j][k]) {  //다음 숫자가 같으면
										tmpMap[j][h] *= 2;
										tmpMap[j][k] = 0;
										k = h;
									}else
										k = h + 1;
									break;
								}
							}
						}
					}
				}			
				for(int j = 0;j < N;j++) {
					for(int k = N - 1 ;k > 0;k--) {
						if(tmpMap[j][k] == 0) {
							for(int h = k - 1; h >= 0;h--) {
								if(tmpMap[j][h] != 0) {
									tmpMap[j][k] = tmpMap[j][h];
									tmpMap[j][h] = 0;
									break;
								}
							}
						}
					}
				}	
				//print(tmpMap,"오른쪽", cnt);	
				
			}else if(i == 1) { //왼쪽
				for(int j = 0;j < N;j++) {
					for(int k = 0;k < N - 1;k++) {
						if(tmpMap[j][k] != 0) { //0이 아니면
							for(int h = k + 1; h < N;h++) { //다음 숫자가 같은지
								if(tmpMap[j][h] != 0) {
									if(tmpMap[j][h] == tmpMap[j][k]) {  //다음 숫자가 같으면
										tmpMap[j][h] *= 2;
										tmpMap[j][k] = 0;
										k = h;
									}else
										k = h - 1;
									break;
								}
							}							
						}
					}
				}		
				for(int j = 0;j < N;j++) {
					for(int k = 0 ;k < N - 1;k++) {
						if(tmpMap[j][k] == 0) {
							for(int h = k + 1; h < N;h++) {
								if(tmpMap[j][h] != 0) {
									tmpMap[j][k] = tmpMap[j][h];
									tmpMap[j][h] = 0;
									break;
								}
							}
						}
					}
				}	
				//print(tmpMap,"왼쪽", cnt);			
			}else if(i == 2) { //위쪽				
				for(int j = 0;j < N;j++) {
					for(int k = 0;k < N - 1;k++) {
						if(tmpMap[k][j] != 0) { //0이 아니면
							for(int h = k + 1; h < N;h++) { //다음 숫자가 같은지
								if(tmpMap[h][j] != 0) {
									if(tmpMap[h][j] == tmpMap[k][j]) {  //다음 숫자가 같으면
										tmpMap[h][j] *= 2;
										tmpMap[k][j] = 0;
										k = h;
									}else
										k = h - 1;
									break;
								}
							}							
						}
					}
				}
				for(int j = 0;j < N;j++) {
					for(int k = 0 ;k < N - 1;k++) {
						if(tmpMap[k][j] == 0) {
							for(int h = k + 1; h < N;h++) {
								if(tmpMap[h][j] != 0) {
									tmpMap[k][j] = tmpMap[h][j];
									tmpMap[h][j] = 0;
									break;
								}
							}
						}
					}
				}	
				//print(tmpMap,"위쪽", cnt);
			}else if(i == 3) {  //아래쪽
				for(int j = 0;j < N;j++) {
					for(int k = N - 1;k > 0;k--) {
						if(tmpMap[k][j] != 0) { //0이 아니면
							for(int h = k - 1; h >= 0;h--) { //다음 숫자가 같은지
								if(tmpMap[h][j] != 0) {
									if(tmpMap[h][j] == tmpMap[k][j]) {  //다음 숫자가 같으면
										tmpMap[h][j] *= 2;
										tmpMap[k][j] = 0;
										k = h;
									}else
										k = h + 1;
									break;
								}
							}
						}
					}
				}				
				for(int j = 0;j < N;j++) {
					for(int k = N - 1 ;k > 0;k--) {
						if(tmpMap[k][j] == 0) {
							for(int h = k - 1; h >= 0;h--) {
								if(tmpMap[h][j] != 0) {
									tmpMap[k][j] = tmpMap[h][j];
									tmpMap[h][j] = 0;
									break;
								}
							}
						}
					}
				}	
				//print(tmpMap,"아래쪽", cnt);
			}			
			for(int j = 0 ;j < N;j++)
				for(int k = 0;k < N;k++)
					max = Math.max(max, tmpMap[j][k]);
			dfs(cnt + 1, tmpMap);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int i = 0;i < N;i++) 
			for(int j = 0;j < N;j++)
				map[i][j] = sc.nextInt();
		dfs(0, map);
		System.out.println(max);
	}
}
