import java.util.*;
public class Main {
	static HashMap<String,Integer> h = new HashMap<String,Integer>();
	static String[] s;
	static int[] log;
	static int length = 0;
	static int result = 0;
	
	static void dfs(int cnt,String word,String next) {
		if(cnt == length ) {
			if(!h.containsKey(word)) 
				h.put(word, result++);
			return;
		}
		
		for(int i = 0;i<length;i++) {
			if(next.equals(s[i])) continue;
			if(log[i]==0) {
				log[i] = 1;
				dfs(cnt+1,word+s[i],s[i]);
				log[i] = 0;
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine().trim().split("");
		length = s.length;
		log = new int[length];
		
		Arrays.sort(s);
		dfs(0,"","");
		System.out.println(result);
	}
}
