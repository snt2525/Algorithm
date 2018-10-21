import java.util.*;
public class Main {
	static int[][] arr; //사다리
	static int N,M,H;
	static int result = 0;
	static int resultCnt = Integer.MAX_VALUE; //최소 몇개 연결해서 답을 찾을 수 있는지?
	public static boolean DFS(int start,int a,int b,int cnt) {
		boolean flag = false;
		if(a == H) { //다 내려왔다.
			if(b == start) { //시작과 같은 결과
				resultCnt = Math.min(resultCnt, cnt);
				flag =  true;
			}
			return flag;
		}
		
		//다음길에 연결되어 있는 경우
		if(arr[a + 1][b] == 1) { //오른쪽으로 가는 길이 연결되어 있을 경우
			flag = DFS(start, a + 1, b + 1, cnt);
		}else if(b != 1 && arr[a + 1][b - 1] == 1) { //왼쪽으로 가는길 연결되어 있을 경우
			flag = DFS(start, a + 1, b - 1, cnt);
		}else {
			//다음 내려갈 방법을 선택하는건 3가지 방법이 있어!
			for(int i  = 0 ;i < 3;i++) {
				if(i == 0) { //그냥 쭉 내려가는거 
					flag = DFS(start, a + 1, b, cnt);
				}else if(i == 2) { //왼쪽으로 이동
					if(!check(0, a, b)) continue;
					arr[a + 1][b - 1] = 1;
					flag = DFS(start, a + 1, b - 1, cnt + 1);
					if(!flag) //갈 수 없었어
						arr[a + 1][b - 1] = 0;
				}else if(i == 1) { //오른쪽으로 이동
					if(!check(1, a, b)) continue;
					arr[a + 1][b] = 1;
					flag = DFS(start, a + 1, b + 1, cnt + 1);
					if(!flag)
						arr[a + 1][b] = 0;
				}				
				if(flag) //만약에 찾았으면 그냥 리턴
					return flag;
			}
		}
		return flag;
	}
	
	public static boolean check(int what, int a, int b) {  //사다리 놓을 수 있는지?, 0이면 왼쪽,		
		// b + 1이나 b - 1에 연결을 할 때 b + 2, b - 1에도 연결이 되어있는지 확인해 봐야한다.
		if(what == 0) { //왼쪽에 둘 수 있는지?
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
		
		for(int i = 1; i<= N; i++) { //N에서 내려간다.
			resultCnt = Integer.MAX_VALUE;
			boolean flag = DFS(i, 0, i, 0);  //int start,int a,int b,int cnt
			if(flag) { //찾았어!
				if(resultCnt != Integer.MAX_VALUE) { 
					//Integer.MAX_VALUE 이거라면 연결안해도 같음! 그게 아니면 연결한거임
					result += resultCnt;
				}
			}
			if(result > 3 || !flag) {  //못찾았어! 정답이 3을 넘거나, 연결하지 못하거나!
				result = -1;
				break;
			}
		}
		System.out.println(result);		
	}
}
