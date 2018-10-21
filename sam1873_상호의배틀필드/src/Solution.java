import java.util.*;
public class Solution {	
	int x=0,y=0;
	int move(String state,int di) {
		if(state.equals("<")) di = 2;
		else if (state.equals(">")) di = 0;
		else if (state.equals("^")) di = 3;
		else di = 1;
		return di;
	}
	void game(String[][]map,int di,int n,int m) {
		int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
		int xx=x+dir[di][0]; 
		int yy= y+dir[di][1];
		if(xx<0||xx>=n||yy<0||yy>=m)return;		
		if(map[xx][yy].equals(".")) {
			x=xx; y=yy;
		}
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
		int tc = sc.nextInt();
		String[] temp = sc.nextLine().trim().split("");
		for(int test = 1;test<=tc;test++) {
			Solution s = new Solution();
			temp = sc.nextLine().trim().split(" ");
			int n = Integer.parseInt(temp[0]);
			int m = Integer.parseInt(temp[1]);
			String[][] map = new String[n][m];
			boolean find = true;
			int di=0;
			String state ="";			
			for(int i=0;i<n;i++) {
				map[i]=temp = sc.nextLine().trim().split("");
				if(find) { 
					for(int j=0;j<m;j++) {
						if(map[i][j].equals("<")||map[i][j].equals(">")
								||map[i][j].equals("^")||map[i][j].equals("v")) {
							s.x=i;s.y=j; state=map[i][j];
							di=s.move(state,0);
							find = false;
							map[i][j]=".";
						}						
					}
				}
			}
			temp = sc.nextLine().trim().split("");
			temp = sc.nextLine().trim().split("");
			for(int i=0;i<temp.length;i++) {			
				switch(temp[i]) {
					case"U": di= 3;	state ="^";
						s.game(map,di,n,m);
						break;
					case"D": di= 1; state ="v";
						s.game(map,di,n,m);
						break;
					case"L": di= 2; state ="<";
						s.game(map,di,n,m);
						break;
					case"R": di= 0; state =">"; 
						s.game(map,di,n,m);
						break;
					case"S":
						int xx=s.x,yy=s.y;						
						while(true){
							xx+=dir[di][0];
							yy+=dir[di][1];
							if(xx<0||xx>=n||yy<0||yy>=m||map[xx][yy].equals("#"))break;
							if(map[xx][yy].equals(".")||map[xx][yy].equals("-")||map[xx][yy].equals("*")) {
								if(map[xx][yy].equals("*")) {
									map[xx][yy]="."; break;
								}
							}
						}
						break;
				}
			}
			map[s.x][s.y]=state;
			System.out.print("#"+test+" ");
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) 
					System.out.print(map[i][j]);				
				System.out.println();
			}			
		}		
	}
}
