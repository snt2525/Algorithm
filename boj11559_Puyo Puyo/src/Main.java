import java.util.*;

class Pair{
	int x = 0;
	int y = 0; 
	Pair(int a,int b){
		this.x = a;
		this.y = b;
	}
}

public class Main {
	static LinkedList<LinkedList<String>> q = new LinkedList<LinkedList<String>>();
	static int[][] remove;
	static int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};	
	static int[][] log;
	static int cnt = 1;
	static int result = 0;
	
	static void dfs(String word, int a,int b) {
		for(int i =0;i<4;i++) {
			int x = a + dir[i][0];
			int y = b + dir[i][1];
			if(x<0||y<0||x>=6||y>=12)continue;
			if(q.get(x).get(y).equals(word) && log[x][y] == 0) {
				log[x][y] = 1;
				cnt++;
				dfs(word,x,y); 
				if(cnt >= 4) remove[x][y] = 1;
			}
		}
	}
	
	static void removeBlock() {
		for(int j = 0;j < 6; j++) {
			for(int i = 11; i >= 0; i--) {
				if(remove[j][i] == 1) {
					q.get(j).remove(i);
					q.get(j).addLast(".");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i =0;i<6;i++)
			q.add(new LinkedList<String>());
		
		for(int i =0;i<12;i++) {
			String[] s = sc.nextLine().trim().split("");
			for(int j=0;j<6;j++) {
				q.get(j).addFirst(s[j]);
			}
		}
		
		boolean flag = true;
		while(flag) {
			flag = false;
			remove = new int[6][12];
			log = new int[6][12];
			for(int i = 11;i >= 0; i--) {
				for(int j = 0;j < 6; j++) {
					if(!q.get(j).get(i).equals(".")&&log[j][i] == 0) {
						cnt = 1;
						log[j][i] = 1;
						dfs(q.get(j).get(i),j,i);
						if(cnt >= 4) {
							remove[j][i] = 1;
							flag = true;
						}
					}
				}
			}	
			if(flag) {
				removeBlock();
				result++;
			}			
		}
		
		System.out.println(result);		
	}
}
