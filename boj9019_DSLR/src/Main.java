import java.util.*;

class Pair{
	int a = 0;
	String b = "";
	Pair(int a,String b){ 
		this.a = a;
		this.b = b;
	}
}

public class Main {
	static String[] dslr = {"D","S","L","R"};
	
	static String bfs(int a,int b) {
		Queue<Pair> num = new LinkedList<Pair>();
		int[] visit= new int[10001];
		visit[a]=1;
		num.add(new Pair(a,""));
		while(!num.isEmpty()) {
			Pair temp  = num.remove();
			int tmpNum = temp.a;
			String tmpQ = temp.b;
			if(tmpNum==b)
				return tmpQ;
			
			int tmpDSLR = tmpNum;
				//D
				tmpDSLR = (tmpNum * 2) % 10000; 
				if(visit[tmpDSLR] != 1){
					visit[tmpDSLR]=1;
					num.add(new Pair(tmpDSLR,tmpQ+dslr[0]));
				}
				
				//S
				tmpDSLR = tmpNum - 1;
				if(tmpDSLR < 0) tmpDSLR = 9999;
				if(visit[tmpDSLR] != 1){ 
					visit[tmpDSLR]=1;
					num.add(new Pair(tmpDSLR,tmpQ+dslr[1]));
				}
				
				//L
				tmpDSLR =(tmpNum % 1000) * 10 + (tmpNum / 1000); 
				if(visit[tmpDSLR] != 1){ 
					visit[tmpDSLR]=1;
					num.add(new Pair(tmpDSLR,tmpQ+dslr[2]));
				}
				
				//R
				tmpDSLR = (tmpNum / 10) + ((tmpNum % 10) * 1000);
				if(visit[tmpDSLR] != 1){
					visit[tmpDSLR]=1;
					num.add(new Pair(tmpDSLR,tmpQ+dslr[3]));
				}			
			} 				
		return "";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();		
			System.out.println(bfs(a, b));			
		}	
	}
}
