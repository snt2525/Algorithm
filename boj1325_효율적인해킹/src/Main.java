import java.util.*;
public class Main {
	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	int[] count;
	int[] visited;
	int computer=0;
	int temp=0;
	int maxCount=0;
	Main(int computer){
		this.count = new int[computer+1];
		this.computer = computer;
	}
	void dfs(int start){
		visited[start]=1;
			for(int i=0;i<list.get(start).size();i++){
				if(visited[list.get(start).get(i)]==0){
					temp++;
					dfs(list.get(start).get(i));
				}
			}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer =sc.nextInt();
		int line =sc.nextInt();
		Main m =new Main(computer);
		for(int i = 0;i <= computer;i++) 
			m.list.add(new ArrayList<Integer>());
		
		for(int i = 0;i < line;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			m.list.get(b).add(a);
		}
		
		for(int i = 1;i <= computer;i++){
			m.temp=0;
			m.visited=new int[computer+1];
			m.dfs(i);
			m.count[i] = m.temp;
			if(m.maxCount < m.count[i])
				m.maxCount = m.count[i];
		}
		
		for(int i=1;i<=computer;i++) {
			if(m.count[i]==m.maxCount)
				System.out.print(i+" ");
		}
	}
}