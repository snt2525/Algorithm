import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<ArrayList<Integer>> Q =  new ArrayList<ArrayList<Integer>>();
		int[][] arr = new int[10002][10002];
		int[] parent = new int[10002];  //부모가 누구니
		int[] level = new int[10002];  //레벨이 뭐니
		for(int i=0;i<=N;i++) {
			Q.add(new ArrayList<Integer>());
		}
				
		for(int i=0;i<N-1;i++) { 
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			Q.get(a).add(b);
			Q.get(b).add(a);
			arr[a][b] = arr[b][a] = c;
		}
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int log[]= new int[10002]; //방문 햇엇니
		int cnt=0; //레벨 나누기
		
		tmp.add(1);
		level[1] = cnt++; parent[1]=0; log[1]=1;
		
		while(!tmp.isEmpty()) {
			int size = tmp.size();
			for(int i=0;i<size;i++) {
				int x = tmp.remove(0);
				log[x]=1;
				for(int j=0;j<Q.get(x).size();j++) {
					int xx = Q.get(x).get(j);
					if(log[xx]==0) {
						tmp.add(xx);
						level[xx] = cnt;
						parent[xx]=x;
					}
				}				
			}
			cnt++;
		}
		
		int M = sc.nextInt();
		
		for(int i=0;i<M;i++) {
			int value = 0;
			int a = sc.nextInt();
			int b = sc.nextInt();
			int levelA = level[a];
			int levelB = level[b];
			
			if(levelA != levelB){
				while(levelA>levelB&&a!=b) {
					int p = parent[a];
					levelA = level[p];				
					if(p==b) {
						value += arr[a][b];
						a = p;
						break;
					}
					value +=  arr[a][p];
					if(levelB == levelA) break;	
					a = p;
				}	
				
				while(levelA<levelB&&a!=b) {
					int p = parent[b];
					levelB = level[p];
					if(p==b) {
						value += arr[a][b];
						b = p;
						break;
					}
					value +=  arr[b][p];
					if(levelB == levelA) break;				
					b = p;
				}				
			}  //레벨을 맞줬지
			
			if(a!=b) {			
				while(a!=b) {
					int pa = parent[a];
					int pb = parent[b];
					value += (arr[a][pa] + arr[b][pb]);					
					a = pa; b = pb;
					if(a==b) break;
				}							
			}
			System.out.println(value);
		}						
	}
}
