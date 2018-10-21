import java.util.*;
public class Solution {
	int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	int[][] log;
	int[][] map;
	int n,max=0;	
	Solution(int n){
		this.log = new int[n][n];
		this.map = new int[n][n];
		this.n = n;
	}
	void dfs(int x,int y,int count,int sum) {
		log[x][y]=1;
		for(int i=0;i<4;i++) {
			int xx =x+dir[i][0];
			int yy =y+dir[i][1];
			if(xx<0||yy<0||xx>=n||yy>=n)continue;
			if(map[x][y]+1!=map[xx][yy]) {
				max = Math.max(max,count);
				continue;
			}else if(log[xx][yy]==0) {
				dfs(xx,yy,count+=1,sum+=map[xx][yy]);				
				log[xx][yy]=0;
			}
		}
		log[x][y]=0;
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test =1;test<=tc;test++) {
			int n =sc.nextInt();
			Solution s = new Solution(n);
			int maxStart=Integer.MAX_VALUE,max=0;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					s.map[i][j]=sc.nextInt();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) { 
					s.max = 0;
					s.dfs(i, j, 1,s.map[i][j]);
					if(s.max>=max) {
						if(s.max==max)
							maxStart = Math.min(maxStart,s.map[i][j]);
						else 
							maxStart = s.map[i][j];
						max =s.max;
					}
				}
			}
			System.out.println("#"+test+" "+maxStart+" "+max);
		}
		
	}
}
