import java.util.*;

public class Main {
	final static int SIZE = 100001;
	static int[] map = new int[SIZE];
	static int[] log = new int[SIZE];
	static int[] time = new int[SIZE];
	static int min = Integer.MAX_VALUE;
	
	static void bfs(int start, int find) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		int cnt = -1;
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int j = 0;j<size;j++) {
				int xx = q.remove();
				log[xx] = 1;
				
				if(xx == find){
					time[cnt]++;	
					min = Math.min(min,cnt);					
				}				

				if(xx + 1 >= 0 && xx + 1 <= 100000 && log[xx + 1] == 0)  //1ĭ ������
					q.add(xx + 1);		
				if(xx - 1 >= 0 && xx - 1 <= 100000 && log[xx - 1] == 0)  //1ĭ �ڷ�
					q.add(xx - 1);	
				if(xx * 2 >= 0 && xx * 2 <= 100000 && log[xx * 2] == 0)  //*2ĭ ������
					q.add(xx * 2);									
			}		
        }
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //�������� ��ġ
		int m = sc.nextInt();  //������ �ִ� ��ġ
		bfs(n,m);
		System.out.println(min);
		System.out.println(time[min]);
	}
}
