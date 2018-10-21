import java.util.*;
public class Main {
	static int[][] arr; //��ٸ�
	static int N,M,H;
	static int result = 0;
	static int resultCnt = Integer.MAX_VALUE; //�ּ� � �����ؼ� ���� ã�� �� �ִ���?
	public static boolean DFS(int start,int a,int b,int cnt) {
		boolean flag = false;
		if(a == H) { //�� �����Դ�.
			if(b == start) { //���۰� ���� ���
				resultCnt = Math.min(resultCnt, cnt);
				flag =  true;
			}
			return flag;
		}
		
		//�����濡 ����Ǿ� �ִ� ���
		if(arr[a + 1][b] == 1) { //���������� ���� ���� ����Ǿ� ���� ���
			flag = DFS(start, a + 1, b + 1, cnt);
		}else if(b != 1 && arr[a + 1][b - 1] == 1) { //�������� ���±� ����Ǿ� ���� ���
			flag = DFS(start, a + 1, b - 1, cnt);
		}else {
			//���� ������ ����� �����ϴ°� 3���� ����� �־�!
			for(int i  = 0 ;i < 3;i++) {
				if(i == 0) { //�׳� �� �������°� 
					flag = DFS(start, a + 1, b, cnt);
				}else if(i == 2) { //�������� �̵�
					if(!check(0, a, b)) continue;
					arr[a + 1][b - 1] = 1;
					flag = DFS(start, a + 1, b - 1, cnt + 1);
					if(!flag) //�� �� ������
						arr[a + 1][b - 1] = 0;
				}else if(i == 1) { //���������� �̵�
					if(!check(1, a, b)) continue;
					arr[a + 1][b] = 1;
					flag = DFS(start, a + 1, b + 1, cnt + 1);
					if(!flag)
						arr[a + 1][b] = 0;
				}				
				if(flag) //���࿡ ã������ �׳� ����
					return flag;
			}
		}
		return flag;
	}
	
	public static boolean check(int what, int a, int b) {  //��ٸ� ���� �� �ִ���?, 0�̸� ����,		
		// b + 1�̳� b - 1�� ������ �� �� b + 2, b - 1���� ������ �Ǿ��ִ��� Ȯ���� �����Ѵ�.
		if(what == 0) { //���ʿ� �� �� �ִ���?
			if(b == 1||(b - 2 > 0  && arr[a + 1][b - 2] == 1))
				return false;			
		}else if(what == 1) {
			if(b == N || ( b + 1 < N&&arr[a + 1][b + 1] == 1))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H + 2][N + 2];
		
		for(int i = 0 ;i < M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
		}
		
		for(int i = 1; i<= N; i++) { //N���� ��������.
			resultCnt = Integer.MAX_VALUE;
			boolean flag = DFS(i, 0, i, 0);  //int start,int a,int b,int cnt
			if(flag) { //ã�Ҿ�!
				if(resultCnt != Integer.MAX_VALUE) { 
					//Integer.MAX_VALUE �̰Ŷ�� ������ص� ����! �װ� �ƴϸ� �����Ѱ���
					result += resultCnt;
				}
			}
			if(result > 3 || !flag) {  //��ã�Ҿ�! ������ 3�� �Ѱų�, �������� ���ϰų�!
				result = -1;
				break;
			}
		}
		System.out.println(result);		
	}
}
