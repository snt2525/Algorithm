import java.util.*;
class Pair{
	int x,y,bio,d;
	Pair(int x, int y, int bio,int d){
		this.x = x;
		this.y = y;
		this.bio = bio;
		this.d = d;
	}
}
class Pair2{
	int x,y;
	Pair2(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
	LinkedList<Pair> q = new LinkedList<Pair>();
	int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
	int n;
	int result;
	Solution(int n){
		this.n = n;
	}
	void move(int time) {
		for(int t = 0;t < time;t++) {
			Queue<Pair2> q2 = new LinkedList<Pair2>();
			int[][][] arr = new int[n][n][3]; //0은 미생물 수, 방향, 큰 애를 저장해 두기
			int size = q.size();
			for(int i = 0;i < size;i++) {
				Pair tmp = q.remove();
				int x = tmp.x + dir[tmp.d][0];
				int y = tmp.y + dir[tmp.d][1];
				
				if(x == 0 || y == 0 || x == (n - 1) || y == (n - 1)) { //시약선에 왔을 때
				if((int)tmp.bio / 2 == 0) continue; //절반으로 감소했을 때 0이 되면 안돌아두 됨
					arr[x][y][0] = tmp.bio / 2; //절반으로 감소
					arr[x][y][1] = changeDIR(tmp.d); //방향 바뀜	
					arr[x][y][2] = arr[x][y][0];
					q2.add(new Pair2(x, y));
				}else if(arr[x][y][0] == 0) { //다음 칸이 비어있을 때 한칸 이동
					arr[x][y][0] = tmp.bio; //미생물 수
					arr[x][y][1] = tmp.d; //방향
					arr[x][y][2] = tmp.bio; //저장해두기
					q2.add(new Pair2(x, y));
				}else if(arr[x][y][0] != 0){ //충돌
					arr[x][y][0] += tmp.bio;
					if(arr[x][y][2] < tmp.bio) {
						arr[x][y][1] = tmp.d;
						arr[x][y][2] = tmp.bio;
					}					
				}
			}
			int size2 = q2.size();
			for(int i = 0;i < size2;i++) {
				Pair2 tmp = q2.remove();
				q.add(new Pair(tmp.x, tmp.y, arr[tmp.x][tmp.y][0], arr[tmp.x][tmp.y][1]));
			}
		}
		int size = q.size(); //총 남은 미생물 수
		for(int i = 0;i < size;i++) {
			Pair tmp = q.remove();
			result += tmp.bio;
		}
	}
	int changeDIR(int index) {
		if(index == 0) return 1;
		else if(index == 1) return 0;
		else if(index == 2) return 3;
		else return 2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1; t <= test;t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			Solution s = new Solution(n);
			for(int i = 0;i < k;i++) 
				s.q.add(new Pair(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt() - 1));			
			s.move(m);			
			System.out.println("#"+t+" "+s.result);
		}
	}
}
