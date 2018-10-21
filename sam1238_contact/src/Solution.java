import java.util.*;
public class Solution {
	ArrayList<ArrayList<Integer>> q = new ArrayList<ArrayList<Integer>>();
	int[] log = new int[101];
	int start;
	int max=0;
	void bfs() {
		ArrayList<Integer> qx = new ArrayList<Integer>();
		qx.add(start);
		log[start]=1;
		while(!qx.isEmpty()) {
			int size = qx.size();
			max=0;
			for(int i =0;i<size;i++) {
				int x= qx.remove(0);
				int qsize = q.get(x).size();
				max = Math.max(max,x);			
				for(int j=0;j<qsize;j++) {
					int xx = q.get(x).get(j);
					if(log[xx]==0) {
						qx.add(xx);
						log[xx]=1;
					}
				}
			}
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		for(int tc = 1;tc<=10;tc++) {
			Solution s = new Solution();
			int n= sc.nextInt();
			s.start =sc.nextInt();
			for(int i=0;i<=100;i++)
				s.q.add(new ArrayList<Integer>());
			for(int i=0;i<n/2;i++) {
				int temp=sc.nextInt();
				int temp2=sc.nextInt();
				s.q.get(temp).add(temp2);
			}
			s.bfs();
			System.out.println("#"+tc+" "+s.max);
		}
	}
}
