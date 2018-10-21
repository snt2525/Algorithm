import java.util.*;
public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static LinkedList<LinkedList<String>> map = new LinkedList<LinkedList<String>>();
	static int[][] log;
	static int result = 0;
	static int tmpCheck = 0;
	static void CheckDFS(String num, int a, int b, int cnt) {
		tmpCheck = Math.max(tmpCheck, cnt);
		
		for(int i = 0; i < 4; i++) {
			int tmpA = a + dir[i][0];
			int tmpB = b + dir[i][1];
			if(tmpA < 0||tmpB < 0||tmpA >= 6||tmpB >= 12)continue;	
			if(log[tmpB][tmpA] == 0 && map.get(tmpA).get(tmpB).equals(num)) {
				cnt++;
				log[tmpB][tmpA] = 1;
				CheckDFS(num, tmpA, tmpB, cnt);				
			}
		}		
	}
	
	static void RemoveItem(int[][] visit) {
		for(int i = 0;i<6;i++) {
			for(int j=11;j>=0;j--) {
				if(visit[j][i] == 1) {
					map.get(i).remove(j);
					map.get(i).addLast(".");
				}
			}
		}
		result++;
	}
	
	static void SaveData(int[][] visit) {
		for(int i = 0;i<6;i++) {
			for(int j=11;j>=0;j--) {
				if(log[j][i] == 1) {
					visit[j][i] = 1;
				}
			}
		}
	}
	
	static void init(int i,int j) {
		tmpCheck = 0;
		log = new int[12][6];
		log[i][j] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<6;i++)
			map.add(new LinkedList<String>());
		
		for(int j = 0;j < 12;j++) {
			String[] tmp = sc.nextLine().trim().split("");
			for(int i = 0;i < 6;i++) 
				map.get(i).addFirst(tmp[i]);
		}
		while(true) {
			int[][] visit = new int[12][6];
			boolean flag = false;
			for(int j = 0;j < 6;j++) {
				for(int i = 11;i >= 0;i--) {
					String tmpW = map.get(j).get(i);
					if(tmpW.equals(".")) continue;
					init(i,j);
					CheckDFS(tmpW,j, i, 1);
					if(tmpCheck >= 4) { //4개 이상이면 save해둔다.
						flag = true;
						SaveData(visit);
					}
				}
			}
			if(!flag) break;
			RemoveItem(visit);
		}
		
		System.out.println(result);
	}
}
