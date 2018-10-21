import java.util.*;
public class Main {
	int edgeNum=0;
	boolean flag = false;
	int[] log;
	Main(int edgeNum){
		this.log = new int[edgeNum];
		this.edgeNum = edgeNum;
	}
	
	boolean FindCycle(int[][] map,int x,int y) {  //사이클이 생기면 true, 생기지 않으면 false;
		for(int i = 1;i<=edgeNum;i++) {
			if(i == y)continue;
			if(map[x][i]==1&&log[i]==1) {
				flag = true;
				return flag;
			}
			if(map[x][i]==1) {
				log[x] = 1;
				FindCycle(map,i,x);
				return flag;
			}
		}	
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int edge = sc.nextInt();
		int loop = sc.nextInt();
		int[][] link = new int[loop][4];
		int[][] map = new int[edge+1][edge+1];
		ArrayList<Integer> q = new ArrayList<Integer>();
		Main m = new Main(edge);
		for(int i=0;i<loop;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			link[i][0] = a; link[i][1] = b; link[i][2] = c;
			q.add(c);
		}
		Collections.sort(q);
		int result = 0,linkEdge = 0;
		for(int i=0;i<loop;i++) {
			int tmp = q.remove(0);
			int a = 0,b = 0;
			//누구랑 연결 되어있는 애인지 찾는다 .
			for(int j=0;j<loop;j++) {
				if(link[j][2]== tmp&&link[j][3]==0) {
					a = link[j][0];
					b = link[j][1];
					link[j][3]=1;
					break;
				}
			}
			map[a][b] = map[b][a] = 1;
			//우선 연결해보고 사이클이 생기는지 검사한다
			m.flag = false;
			m.log = new int[edge];  
			boolean find = false;
			for(int j=0;j<edge;j++) {
				for(int k=0;k<edge;k++) {
					if(map[j][k]==1) {
						find = m.FindCycle(map, j,k);
						j = edge;
						break;
					}
				}
			}
			if(find) { //사이클이 생긴거야 
				map[b][a] = map[a][b] =0;
				continue;
			}
			result += tmp;
			if(linkEdge == (edge-1)) break; //만약에 모든 선들이 연결이 되어있으면?
		}
		
		System.out.println(result);
		
		
	}
}
