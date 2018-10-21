import java.util.*;
class Pair{
	int x;
	int time;
	Pair(int a,int b){
		this.x = a;
		this.time = b;
	}
}
public class Main {
	static int[] dir = {1,-1};
	static int[] arr = new int[100001];
	static int n;
	static int k;
	static int result = 0;
	static void bfs(){
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(n,0));
		arr[n] = 1;
		while(!q.isEmpty()) {
			Pair tmp = q.remove();
			for(int j = 0;j<3;j++ ) {
				int x = tmp.x;
				if(j == 2)
					x *= 2;
				else 
					x += dir[j];
				if(x<0||x>=100001)continue;
				if(arr[x]==0) {
					if(x == k) {
						result = tmp.time + 1;
						break;
					}
					arr[x] = 1;
					q.add(new Pair(x,tmp.time+1));
				}						
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		bfs();
		System.out.println(result);
	}
}
