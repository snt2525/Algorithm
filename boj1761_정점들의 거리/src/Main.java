import java.util.*;
public class Main {
	int price[][];
	int N;
	Main(int N){
		this.N = N;
		price = new int[N+1][N+1];
	}
	void dfs(int x,int y,int price) {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Main m = new Main(N);
		
		for(int i=0;i<N-1;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			m.price[a][b] = m.price[b][a] = c;
		}
		
		int M=sc.nextInt();
		for(int i=0;i<M;i++) {
			
			
			
			System.out.println();
		}
	}
}
