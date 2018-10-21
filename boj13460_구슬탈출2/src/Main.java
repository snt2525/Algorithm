import java.util.*;
class Pair{
	int a;
	int b;
	Pair(int a,int b){
		this.a = a;
		this.b = b;
	}
}

public class Main {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //����, �Ʒ�, ����, ��
	static int n,m;
	static String[][] arr;
	static int[][] ball = new int[2][2];
	
	static void BFS() {
		int move = 1;
		Queue<Pair> R = new LinkedList<Pair>();
		Queue<Pair> B = new LinkedList<Pair>();
		R.add(new Pair(ball[0][0],ball[0][1]));
		B.add(new Pair(ball[1][0],ball[1][1]));
		
		while(!R.isEmpty() && move <= 10) {
			int size = R.size();
			for(int i =0;i<size;i++) {
				Pair tmpR = R.remove();
				Pair tmpB = B.remove();
				for(int j=0;j<4;j++) {
					int aR = tmpR.a;
					int bR = tmpR.b;
					int aB = tmpB.a;
					int bB = tmpB.b;
					boolean backR = false; //���� ���¹��⿡ ���տ� �ִ���
					boolean backB = false;
					boolean flagR = false;
					boolean flagB = false;
					//if(arr[aR + dir[j][0]][bR + dir[j][1]].equals("#"))continue;
					/* ������ */												
					//�ٸ� ���� ������
					while(true) {
						if(aR == tmpB.a && bR == tmpB.b) //���� ���� ���⿡ �ִ���
							backR = true;
						if(arr[aR][bR].equals("O")) {
							flagR = true;
							break;
						}
						if(arr[aR + dir[j][0]][bR + dir[j][1]].equals("#")) break;
						aR += dir[j][0]; bR += dir[j][1];					
					}
					/* �Ķ��� */		
					while(true) {
						if(aB == tmpR.a && bB == tmpR.b) //������ ���� ������ 
							backB = true;
						if(arr[aB][bB].equals("O")) { //���ۿ� ������							
							flagB = true;
							break;
						}
						if(arr[aB + dir[j][0]][bB+ dir[j][1]].equals("#"))break;
						aB += dir[j][0]; bB += dir[j][1];
					}
					
					if(flagB) continue; //B�� ����
					else if(flagR) {
						System.out.println(move);
						return;
					}
					if(aR == tmpR.a && bR == tmpR.b && aB == tmpB.a && bB == tmpB.b) continue;
					if(backB)
						B.add(new Pair(aB - dir[j][0],bB - dir[j][1]));
					else
						B.add(new Pair(aB,bB));	
					
					if(backR)
						R.add(new Pair(aR - dir[j][0],bR - dir[j][1]));
					else
						R.add(new Pair(aR,bR));	
					
				}									
			}
			move++;
		}		
		System.out.println("-1");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new String[n][m];
		
		String[] tmp = sc.nextLine().trim().split("");
		for(int i = 0;i<n;i++) {
			tmp = sc.nextLine().trim().split("");
			for(int j=0;j<m;j++) { 
				arr[i][j] = tmp[j];
				if(arr[i][j].equals("B")) {
					ball[1][0] = i;
					ball[1][1] = j;
				}else if(arr[i][j].equals("R")) {
					ball[0][0] = i;
					ball[0][1] = j;					
				}				
			}
		}
		BFS();
	}
}
