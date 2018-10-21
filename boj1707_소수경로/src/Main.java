import java.util.*;

class NUM{ 
	int num = 0;
	int cnt = 0 ;
	NUM(int a,int b){
		num = a;
		cnt = b;
	}
}
public class Main {
	static int[] check = new int[10000];
	static int min =Integer.MAX_VALUE;
	static boolean checkNumber(int num) { //소수인지 판별
		for(int i = 2;i<num;i++) {
			if(num%i==0)return false;
		}
		return true;
	}
	
	static void bfs(int start,int find) {
		Queue<NUM> q = new LinkedList<NUM>();
		check[start] = 1;
		q.add(new NUM(start,0));
		
		while(!q.isEmpty()) {
			NUM tmp = q.remove();
			if(tmp.num == find) {
				min = Math.min(min, tmp.cnt); 
			}
			for(int i = 0;i<10;i++) {
				int[] now = {tmp.num / 1000,((tmp.num/100)-(tmp.num/1000)*10),
						(tmp.num/10)-(tmp.num/100)*10,tmp.num%10};   
				
				int next = (i*1000) + (now[1]*100) + (now[2]*10) + now[3];
				if(check[next]==0&&next>1000&&checkNumber(next)) {
					check[next] = 1;
					q.add(new NUM(next,tmp.cnt+1));
				}
				
				next = (now[0]*1000) + (i*100) + (now[2]*10) + now[3];
				if(check[next]==0&&next>1000&&checkNumber(next)) {
					check[next] = 1;
					q.add(new NUM(next,tmp.cnt+1));
				}
				
				next = (now[0]*1000) + (now[1]*100) + (i*10) + now[3];
				if(check[next]==0&&next>1000&&checkNumber(next)) {
					check[next] = 1;
					q.add(new NUM(next,tmp.cnt+1));
				}
				
				next = (now[0]*1000) + (now[1]*100) + (now[2]*10) + i;
				if(check[next]==0&&next>1000&&checkNumber(next)) {
					check[next] = 1;
					q.add(new NUM(next,tmp.cnt+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 0; testCase<T;testCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			check = new int[10000];
			min = Integer.MAX_VALUE;
			bfs(n,m);
			
			if(min == Integer.MAX_VALUE) 
				System.out.println("Impossible");
			else
				System.out.println(min);
		}
	}
}
