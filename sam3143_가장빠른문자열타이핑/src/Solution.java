import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);	
		int tc = Integer.parseInt(sc.next());
		for(int testCase =1;testCase <= tc;testCase++) {
			String a = sc.next();
			String[] aSplit = a.split("");			
			String b = sc.next();
			String[] bSplit = b.split("");
			int num=0,size = bSplit.length;			
			for(int i=0;i<aSplit.length;i++) {
				if(aSplit[i].equals(bSplit[0])&&(i+size<=aSplit.length)) {
					String temp= a.substring(i,i+size); 
					if(temp.equals(b)) i+=(size-1);
				}
				num++;
			}						
			System.out.println("#"+testCase+" "+num);
		}
	}
}
