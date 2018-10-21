import java.util.*;
class Pair implements Comparable<Pair>{
	int x;
	int y;
	int cost;
	Pair(int a,int b,int c){
		this.x = a;
		this.y = b;
		this.cost = c;
	}
	@Override
	public int compareTo(Pair p) {
		if(this.cost > p.cost) {
			return 1;
		}else if(this.cost < p.cost) {
			return -1;
		}else {
			return 0;
		}
	}
}

public class Main {
	static int[][] map;
	static int[] visit;
	static ArrayList<Pair> num = new ArrayList<Pair>();
	static int min = 0;
	static void print() {
		for(int i =0;i<6;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt() + 1;
		int connect = sc.nextInt();
		int visitCnt = 0; //몇개의 컴ㅍ퓨터를 연결하였는지
		int value = Integer.MAX_VALUE; //가중치
		map = new int[computer][computer];
		visit = new int[computer];
		
		for(int i =0;i<connect;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			num.add(new Pair(a,b,c)); //최소비용을 기준으로 x와 y값을 저장
		}
		Collections.sort(num);	
		
		while(visitCnt<computer&&!num.isEmpty()) { //최소 간선으로 방문 한다.
			Pair tmp = num.remove(0);	
			value = tmp.cost;
			map[tmp.x][tmp.y] = map[tmp.y][tmp.x] = 1;
			
			//사이클이생기는지 
			int[][] log = new int[computer][computer]; //방문 했는지?
			int[] visitTmp = new int[computer];
			Queue<Integer> q = new LinkedList<Integer>();
			boolean flag = true;
			q.add(tmp.x);
			int x = 0;
			
			while(flag&&!q.isEmpty()) {
				x = q.remove();
				visitTmp[x] = 1;
				for(int i = 0;i < computer;i++) {
					if(map[x][i] == 1) {
						if(log[x][i] == 1) { //사이클이 생김
							flag = false;
							break;
						}
						log[x][i] = 1;
						if(visitTmp[i]==1)continue;
						q.add(i);
					}
				}	
			}
			if(!flag) {//사이클을 이룬다면 continue;
				map[tmp.x][tmp.y] = map[tmp.y][tmp.x] = 0;
				continue; 
			}
			//print();
			visitCnt = visit[tmp.x] == 1? visitCnt + 1 : visit[tmp.x]++ ;
			visitCnt = visit[tmp.y] == 1? visitCnt + 1 : visit[tmp.y]++ ;
			min = min + value;
		}		
		System.out.println(min);
	}
}
