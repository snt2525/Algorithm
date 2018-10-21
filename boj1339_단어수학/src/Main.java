import java.util.*;
public class Main {
	static HashMap<String,Integer> h = new HashMap<String,Integer>();
	static int n;
	static String[] word;
	static String[][] wordOriginal;
	static int[] wordSize;
	static int[] log = new int[10];
	static int num = 0;
	static int max = 0;
	
	static void dfs(int cnt,int now) {
		if(cnt == num) {
			int number = 0;
			for(int i=0;i<n;i++) {
				int tmp = 0;
				for(int j=wordSize[i]-1;j>=0;j--) {
					number += ((int)Math.pow(10, j) * h.get(wordOriginal[i][tmp++])); 
				}
			}
			max = Math.max(max, number);
			return;
		}
		
		for(int i = 9;i > 9 - num; i--) {
			if(log[i] == 0) {
				log[i] = 1;
				h.put(word[now],i);
				dfs(cnt+1,now+1);
				log[i] = 0;
			}		
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		word = new String[11];
		wordOriginal = new String[n][8];
		wordSize = new int[n];
		
		String[] s= sc.nextLine().trim().split("");
		for(int i = 0;i<n;i++) {
			s = sc.nextLine().trim().split("");
			int size = s.length;			
			wordSize[i] = size;
			for(int j =0 ;j<size;j++) {
				wordOriginal[i][j] = s[j];
				if(!h.containsKey(s[j])) {
					h.put(s[j], 0);
					word[num++] = s[j];
				}
			}
		}
		dfs(0,0);	
		System.out.println(max);		
	}
}
