import java.util.*;

class Pair{
	int num = 0;  //얼마인지
	int cnt = 0;  //연산 횟수
	Pair(int num,int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] number = {3,5};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] log = new int[5001];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(3,1)); q.add(new Pair(5,1));		
		log[3] = log[5] = 1;
		int x =0;
		while(x<=5000&&!q.isEmpty()) {
			Pair temp = q.remove();
			x = temp.num;
			if(x == N) {
				System.out.println(temp.cnt);
				return;
			}
			for(int i=0;i<2;i++) {
				int xx = x + number[i];
				if(xx>5000||log[xx]==1)continue;
				else {
					log[xx]=1;
					q.add(new Pair(xx,temp.cnt+1)); 
				}
			}		
		}
		System.out.println("-1");
	}
}
