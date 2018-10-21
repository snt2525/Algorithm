import java.util.*;

public class Solution {

	public static void main(String[] args) {
		final int ten = 1000000;
		int[] num = new int[ten+1];
		int start=2;
			
		while(start<ten) {
			for(int i = start*2;i<=ten;i+=start) 
				num[i]=1;			
			start++;
		}
		for(int i=2;i<=ten;i++) {
			if(num[i]==0) System.out.print(i+" ");
		}
		
	}
}
