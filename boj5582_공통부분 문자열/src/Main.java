import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] find = new char[1001];
		String tmp = sc.next();
		String tmp2 = sc.next();
		char[] a1 = tmp.toCharArray();
		char[] a2 = tmp2.toCharArray();
		int[][] arr = new int[a1.length + 1][a2.length + 1];
		int maxLen = 0 ;
		
		for(int i=0;i<a1.length;i++) {
			for(int j=0;j<a2.length;j++) {
				if(a1[i]==a2[j]) {					
					arr[i+1][j+1] = arr[i][j] + 1;
				}else
					arr[i+1][j+1] = Math.max(arr[i+1][j], arr[i][j+1]);				
				maxLen = Math.max(arr[i+1][j+1],maxLen);				
			}
		}
		
		int tmpCnt = maxLen;
		Stack<Character> st = new Stack<Character>();
		for(int j=a2.length;j>0;j--) {
			for(int i=a1.length;i>0;i--) {
					if(tmpCnt == arr[i][j] && a2[j-1] == a1[i-1]) {
						st.add(a1[i-1]);
						tmpCnt--;
						if(tmpCnt == 0) {
							System.out.println(maxLen);
							while(!st.isEmpty())
								System.out.print(st.pop());
						}else 
							break;
					}
			}
		}
		
	}
}