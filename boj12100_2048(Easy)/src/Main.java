import java.util.*;
public class Main {
	static int[][] map;
	static int n;
	static int max = Integer.MIN_VALUE;
	static void dfs(int cnt) {
		if(cnt == 5) {
			for(int i =0;i<n;i++) 
				for(int j=0;j<n;j++) 
					max = Math.max(max,map[i][j]);		
			return;
		}
		int[][] bu = new int[n][n];
		backUp(bu,map); //����صд�.
		for(int i =0;i<=3;i++) {		
			if(i == 0 ) Up();//���� �б�
			else if(i == 1 ) Down(); //�Ʒ��� ������
			else if(i == 2) Right();//���������� �б�
			else Left(); //�������� �б�		
		    print();
			dfs(cnt+1);
			backUp(map,bu); //�ǵ��� ����
		}
	}
	
	static void backUp(int[][] a,int[][] b) {
		for(int i =0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = b[i][j];
	}
	
	static void print() {
		System.out.println();
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void Up() {
		int[][] log = new int[n][n];
		for(int y =0; y<n;y++) { //y�� //x���� n-1�̿����Ѵ�.
			for(int x=n-1;x>0;x--) {
				if(log[x][y] == 1||map[x][y]==0)continue;
				int now = map[x][y];
				int xx = x;
				while(xx>0) {//�տ� ���� ã�´� 0�̸� ����ϰ� �ٸ��� �׸�
					xx--;
					if(now == map[xx][y]) {
						map[x][y] = 0;
						map[xx][y] *= 2;
						log[xx][y] = 1;
						break;
					}else if(map[xx][y] != 0 && map[xx][y] != now) {
						break;
					}
				}
			}
			//0�� ���� �����ش�.
			for(int x =0;x<n-1;x++) {
				if(map[x][y] == 0) {
					int xx = x+1;
					while(xx<n-1 && map[xx][y] == 0) xx++;
					swap(map,x,y,xx,y);
				}
			}
		}	
	}
	
	static void swap(int[][] arr,int a1,int b1,int a2,int b2) {
		int tmp = arr[a1][b1];
		arr[a1][b1] = arr[a2][b2];
		arr[a2][b2] = tmp;
	}
	
	static void Down() {
		int[][] log = new int[n][n];
		for(int y = 0; y < n;y++) { //y�� //x���� n-1�̿����Ѵ�.
			for(int x=0;x<n-1;x++) {
				if(log[x][y] == 1||map[x][y]==0)continue;
				int now = map[x][y];
				int xx = x;
				while(xx<n-1) {//�տ� ���� ã�´� 0�̸� ����ϰ� �ٸ��� �׸�
					xx++;
					if(now == map[xx][y]) {
						map[x][y] = 0;
						map[xx][y] *= 2;
						log[xx][y] = 1;
						break;
					}else if(map[xx][y] != 0 && map[xx][y] != now) {
						break;
					}
				}
			}
			//0�� ���� �����ش�.
			for(int x =n-1;x>0;x--) {
				if(map[x][y] == 0) {
					int xx = x-1;
					while(xx>0 && map[xx][y] == 0) xx--;
					swap(map,x,y,xx,y);
				}
			}
		}	
	}
	
	static void Right() {
		int[][] log = new int[n][n];
		for(int x = 0; x < n;x++) { //y�� //x���� n-1�̿����Ѵ�.
			for(int y = n-1;y > 0;y--) {
				if(log[x][y] == 1||map[x][y]==0)continue;
				int now = map[x][y];
				int yy = y;
				while(yy>0) {//�տ� ���� ã�´� 0�̸� ����ϰ� �ٸ��� �׸�
					yy--;
					if(now == map[x][yy]) {
						map[x][y] = 0;
						map[x][yy] *= 2;
						log[x][yy] = 1;
						break;
					}else if(map[x][yy] != 0 && map[x][yy] != now) {
						break;
					}
				}
			}
			
			//0�� ���� �����ش�.
			for(int y =0;y<n-1;y++) {
				if(map[x][y] == 0) {
					int yy = y+1;
					while(yy<n-1 && map[x][yy] == 0) yy++;
					swap(map,x,y,x,yy);
				}
			}
			
		}	
	}
	
	static void Left() {
		int[][] log = new int[n][n];
		for(int x = 0; x < n;x++) { //y�� //x���� n-1�̿����Ѵ�.
			for(int y = 0;y < n-1;y++) {
				if(log[x][y] == 1||map[x][y]==0)continue;
				int now = map[x][y];
				int yy = y;
				while(yy<n-1) {//�տ� ���� ã�´� 0�̸� ����ϰ� �ٸ��� �׸�
					yy++;
					if(now == map[x][yy]) {
						map[x][y] = 0;
						map[x][yy] *= 2;
						log[x][yy] = 1;
						break;
					}else if(map[x][yy] != 0 && map[x][yy] != now) {
						break;
					}
				}
			}
			
			//0�� ���� �����ش�.
			for(int y =n-1;y>0;y--) {
				if(map[x][y] == 0) {
					int yy = y-1;
					while(yy>0 && map[x][yy] == 0) yy--;
					swap(map,x,y,x,yy);
				}
			}		
		}	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(0);
		System.out.println(max);
	}
}
