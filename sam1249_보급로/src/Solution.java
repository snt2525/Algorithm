import java.util.* ;
public class Solution {
	int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
	int[][]map;
	int[][]log;
	int[][]visit;
	int n =0;
	int min=Integer.MAX_VALUE;
	Solution(int n){
		this.n=n;
		map=new int[n][n];
		visit=new int[n][n];
		log=new int[n][n];
	}
	void dfs(int sX,int sY){
		if(sX==n-1&&sY==n-1){
			min=Math.min(min, log[sX][sY]);
			return;
		}		
		if(min<=log[sX][sY])return;
		for(int i=0;i<4;i++){
			int x = sX+dir[i][0];
			int y = sY+dir[i][1];
			if(x<0||y<0||x>=n||y>=n)continue;	
			if(visit[x][y]==0&&!(log[sX][sY]+map[x][y]>=log[x][y])){
				log[x][y]=log[sX][sY]+map[x][y];
				visit[x][y]=1;
				dfs(x,y);
				visit[x][y]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] w = sc.nextLine().trim().split(" ");
		int size =Integer.parseInt(w[0]);
		for(int t=1;t<=size;t++){
			w = sc.nextLine().trim().split(" ");
			int num =Integer.parseInt(w[0]);
			Solution s = new Solution(num);
			for (int i = 0; i < num; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < num; j++) {
                    s.map[i][j] = line.charAt(j)-48;
                   s.log[i][j] = Integer.MAX_VALUE;
                }
            }
			s.log[0][0]=s.map[0][0];
			s.dfs(0, 0);			
			System.out.println("#"+t+" "+s.min);
		}
	}
}