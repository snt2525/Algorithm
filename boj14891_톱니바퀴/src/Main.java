import java.util.*;
public class Main {
	static int result = 0;
	static LinkedList<LinkedList<Integer>> g = new LinkedList<LinkedList<Integer>>();
	static int[] visit = new int[4];
	public static void MoveGear(int start, int move) {
		visit[start] = 1;	
		int tmpUP = g.get(start).get(2);
		int tmpDOWN = g.get(start).get(6);
		if(move == 1) { // 시계
			int tmp  = g.get(start).removeLast();
			g.get(start).addFirst(tmp);
		}else if(move == -1) { //반시계
			int tmp = g.get(start).removeFirst();
			g.get(start).addLast(tmp);
		}
		int tmpMove = move == 1 ? -1 : 1;	
		if(start + 1 < 4 && visit[start + 1] == 0) {  //위로
			if(tmpUP != g.get(start + 1).get(6))
				MoveGear(start + 1, tmpMove);
		}
		if(start - 1 >= 0 && visit[start - 1] == 0) {  //아래로
			if(tmpDOWN != g.get(start - 1).get(2))
				MoveGear(start - 1, tmpMove);
		}			
	} 	
	
	public static void Score() {
		if(g.get(0).get(0) == 1)
			result += 1;
		if(g.get(1).get(0) == 1)
			result += 2;
		if(g.get(2).get(0) == 1)
			result += 4;
		if(g.get(3).get(0) == 1)
			result += 8;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i =0;i<4;i++) {
			g.add(new LinkedList<Integer>());
			String[] tmp = sc.nextLine().trim().split("");
			for(int j =0;j<tmp.length;j++)
				g.get(i).add( j, Integer.parseInt(tmp[j]));
		}
				
		int loop = sc.nextInt();
		for(int i =0;i<loop;i++) {
			visit = new int[4];
			int start = sc.nextInt() - 1;
			int move = sc.nextInt();
			MoveGear(start, move);
		}
		
		Score();
		System.out.println(result);
	}
}
