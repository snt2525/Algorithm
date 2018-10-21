import java.util.*;
class Pair{
	int a;
	int b;
	int Num;
	Pair(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.Num = c;
	}
}
class Pair2{
	int a;
	int b;
	Pair2(int a,int b){
		this.a = a;
		this.b = b;
	}
}
public class Main {
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][][] dir2 = {{{-1,0},{0,1}},{{0,1},{1,0}},{{1,0},{0,-1}},{{0,-1},{-1,0}}};
	static int[][][] dir3 = {{{-1,0},{0,1},{1,0}},{{0,1},{1,0},{0,-1}},{{1,0},{0,-1},{-1,0}},{{0,-1},{-1,0},{0,1}}};
	static LinkedList<Pair> camera = new LinkedList<Pair>();
	static int[][] arr;
	static int N,M;
	static int min = Integer.MAX_VALUE;
	public static void DFS(int cnt,int[][] log) {
		if(cnt == camera.size()) {
			findMin(log);
			return;
		}
		
		Pair tmp = camera.get(cnt);		
		if(tmp.Num == 1) {
			Queue<Pair2> tQ = new LinkedList<Pair2>();
			for(int i =0;i < 4;i++) {
				int tmpA = tmp.a + dir[i][0];
				int tmpB = tmp.b + dir[i][1];
				if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) continue;
				//ÂÒ¸£¸£¸¤ ¿¬°á
				while(true) {
					if(log[tmpA][tmpB] == 0) {
						tQ.add(new Pair2(tmpA,tmpB));
						log[tmpA][tmpB] = 1;
					}
					tmpA += dir[i][0];
					tmpB += dir[i][1];
					if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) break;					
				}
				DFS(cnt + 1,log);
				int size = tQ.size();
				for(int j =0;j<size;j++) {
					Pair2 tmpQ = tQ.remove();
					log[tmpQ.a][tmpQ.b] = 0;
				}
			}			
		}else if(tmp.Num == 2) {
			Queue<Pair2> tQ = new LinkedList<Pair2>();
			int tmp2Cnt = 0; //2¹ø¾¿ µ¹·Á¾ßÇÑ´Ù.
			for(int i =0;i < 4;i++) { 
				tmp2Cnt ++;
				int tmpA = tmp.a + dir[i][0];
				int tmpB = tmp.b + dir[i][1];
				//¿¬°á
				while(tmpA>=0&&tmpB>=0&&tmpA<N&&tmpB<M&&arr[tmpA][tmpB]!=6) {
					if(log[tmpA][tmpB] == 0) {
						tQ.add(new Pair2(tmpA,tmpB));
						log[tmpA][tmpB] = 1;
					}
					tmpA += dir[i][0];
					tmpB += dir[i][1];				
				}						
				if(tmp2Cnt % 2 == 0) { //2¹øµ¹µ¹·ÁÀ½
					DFS(cnt + 1,log);
					int size = tQ.size();
					for(int j =0;j<size;j++) {
						Pair2 tmpQ = tQ.remove();
						log[tmpQ.a][tmpQ.b] = 0;
					}
				}
			}
		}else if(tmp.Num == 3) {
			for(int i = 0;i < 4;i++) {
				Queue<Pair2> tQ = new LinkedList<Pair2>();
				for(int j = 0;j<2;j++) {
					int tmpA = tmp.a + dir2[i][j][0];
					int tmpB = tmp.b + dir2[i][j][1];
					if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) continue;
					//ÂÒ¸£¸£¸¤ ¿¬°á
					while(true) {
						if(log[tmpA][tmpB] == 0) {
							tQ.add(new Pair2(tmpA,tmpB));
							log[tmpA][tmpB] = 1;
						}
						tmpA += dir2[i][j][0];
						tmpB += dir2[i][j][1];
						if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) break;					
					}
				}
				DFS(cnt + 1,log);
				int size = tQ.size();
				for(int j =0;j<size;j++) {
					Pair2 tmpQ = tQ.remove();
					log[tmpQ.a][tmpQ.b] = 0;
				}
			}
		}else if(tmp.Num == 4) {
			for(int i = 0;i < 4;i++) {
				Queue<Pair2> tQ = new LinkedList<Pair2>();
				for(int j = 0;j<3;j++) {
					int tmpA = tmp.a + dir3[i][j][0];
					int tmpB = tmp.b + dir3[i][j][1];
					if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) continue;
					//ÂÒ¸£¸£¸¤ ¿¬°á
					while(true) {
						if(log[tmpA][tmpB] == 0) {
							tQ.add(new Pair2(tmpA,tmpB));
							log[tmpA][tmpB] = 1;
						}
						tmpA += dir3[i][j][0];
						tmpB += dir3[i][j][1];
						if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) break;					
					}
				}
				DFS(cnt + 1,log);
				int size = tQ.size();
				for(int j =0;j<size;j++) {
					Pair2 tmpQ = tQ.remove();
					log[tmpQ.a][tmpQ.b] = 0;
				}
			}
		}else if(tmp.Num == 5) {
			Queue<Pair2> tQ = new LinkedList<Pair2>();
			for(int i =0;i < 4;i++) {
				int tmpA = tmp.a + dir[i][0];
				int tmpB = tmp.b + dir[i][1];
				if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) continue;
				//ÂÒ¸£¸£¸¤ ¿¬°á
				while(true) {
					tQ.add(new Pair2(tmpA,tmpB));
					log[tmpA][tmpB] = 1;
					tmpA += dir[i][0];
					tmpB += dir[i][1];
					if(tmpA < 0|| tmpB < 0||tmpA >= N||tmpB >= M||arr[tmpA][tmpB] == 6) break;					
				}				
			}
			DFS(cnt + 1,log);
			int size = tQ.size();
			for(int j =0;j<size;j++) {
				Pair2 tmpQ = tQ.remove();
				log[tmpQ.a][tmpQ.b] = 0;
			}
		}		
	}
	
	static void findMin(int[][] log) {
		int cnt = 0;
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(log[i][j] == 0 && arr[i][j] == 0)
					cnt++;
			}
		}
		min = Math.min(cnt, min);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				 arr[i][j] = sc.nextInt();
				 if(arr[i][j] != 0 && arr[i][j] != 6) {
					 camera.add(new Pair(i,j,arr[i][j]));
				 }
			}
		}
		int[][] log = new int[N][M];

		DFS(0, log);
		System.out.println(min);
	}
}
