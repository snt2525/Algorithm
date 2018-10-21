import java.util.*;

class heap{
	int[] arr = new int[200002];
	int size = 0;
	void push(int value) {
		arr[++size] = value;
		int last = size;
		if(arr[last/2]<value) {
			while(last > 1) {
				int tmp = arr[last];
				arr[last] = arr[last/2];
				arr[last/2] = tmp;
				last/=2;
				if(arr[last/2]>value)break;
			}		
		}
	}
	
	int pop() {
		int x = arr[1];
		arr[1] = arr[size];
		arr[size--] = 0;
		int rIndex = 1,left = 0, right = 0;
		int max = 0;
		while(right<=size&&left<=size&&size>0) {
			left = rIndex * 2;
			right = (rIndex * 2)+1;
			max = Math.max(arr[left], arr[right]);			
			if(arr[rIndex]<max&&max ==arr[left]) {
				int tmp = arr[left];
				arr[left] = arr[rIndex];
				arr[rIndex] = tmp;
				rIndex  = left;
				continue;
			}else if(arr[rIndex]<max&&max == arr[right]) {
				int tmp = arr[right];
				arr[right] = arr[rIndex];
				arr[rIndex] = tmp;
				rIndex  = right;
				continue;
			}
			break;
		}		
		return x;
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int testCase = 1;testCase<=tc;testCase++) {
			int loop = sc.nextInt();
			heap h = new heap();
			System.out.print("#"+testCase);
			for(int i=0;i<loop;i++) {
				int tmp = sc.nextInt();
				if(tmp == 1) {
					int x= sc.nextInt();
					h.push(x);
				}else if (tmp ==2) {
					if(h.size==1) {
						System.out.print(" -1");
						continue;
					}else 
						System.out.print(" "+h.pop());
				}
			}
			System.out.println();
		}
	}
}
