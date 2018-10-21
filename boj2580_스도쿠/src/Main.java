import java.util.*;

class Pair{
	int x = 0;
	int y = 0; 
	int includeX = 0;
	int includeY = 0;
	Pair(int a,int b,int c,int d){
		this.x = a;
		this.y = b;
		this.includeX = c;
		this.includeY = d;
	}
}

public class Main {
	final static int MAX = 9;
	static LinkedList<Pair> q = new LinkedList<Pair>();
	static int[][] map = new int[MAX][MAX];
	static int cnt = 0;
	static boolean findMap = false;
	
	static void dfs(int find) {
		if(cnt == find) { // ���ڸ� ��� �� ä���� ��,
			findMap = true;
			print();
			return;
		}
		
		Pair tmp = q.get(find);
		//int[] log = new int[MAX + 1];
		for(int i=1;i<=9;i++) {
			if(check(tmp.x,tmp.y,i,tmp.includeX,tmp.includeY)) {
				map[tmp.x][tmp.y] = i;
				dfs(find+1);
				if(findMap) return;
			}
		}
		map[tmp.x][tmp.y] = 0;
	}
	
	static boolean check(int x,int y,int num,int includeX,int includeY) { 
		//System.out.println("ȣ��");
		for(int i =0;i<9;i++)   // + �˻��ϴ� �κ�
			if(map[x][i] == num || map[i][y] == num) return false; //���ش�.	

		for(int i =includeX;i<includeX+3;i++) {
			for(int j=includeY;j<includeY+3;j++) {
				if(map[i][j] == num) return false;
			}
		}		
		return true;
	}
	
	static void findPosition(int i,int j) { //�����ġ���� ã�Ƽ� q�� �־��ش�
		int x =0, y = 0;
		//x�� ã��
		if(i>=3 && i<6) x = 3;
		else if(i>=6 && i<9) x=6;
		else x = 0;
		//y��ã��
		if(j>=3 && j<6) y = 3;
		else if(j>=6 && j<9) y = 6;
		else y = 0;
	
		q.add(new Pair(i,j,x,y));
		cnt++;
	}
	
	static void print() {
		for(int i=0;i<MAX;i++) { 
			for(int j=0;j<MAX;j++) 
				System.out.print(map[i][j]+" ");		
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int i=0;i<MAX;i++) {  //map �Է� �ޱ�
 			for(int j=0;j<MAX;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0)  //q�� ��ġ�� ã�Ƽ� �־��ش�.
					findPosition(i,j);
			}
		}
		dfs(0);		
	}
}
