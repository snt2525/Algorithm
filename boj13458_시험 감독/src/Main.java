import java.util.*;
public class Main {
	static int[] arr; //각 시험장의 응시자의 수
	static int n; 
	static int[] person = new int[2];
	static int[] log = new int[1000001]; //찾으면 저장
	static long minPerson = 0;
	
	static void findMin(int start,int classNum) { //b만 사용
		int num = start; //클래스에 있는 사람 수
		int sum = log[num-1] * person[0];
		while(num<=classNum) {
			log[num] = log[num-1]; //감독관이 감시할수 있는 사람의 수, 필요한 감독관수
			while(sum<num) {
				sum += person[1];
				log[num]++;
			}
			num++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		int maxNum = 0;
		
		for(int i =0;i<n;i++) { 
			arr[i] = sc.nextInt();
			maxNum = Math.max(maxNum, arr[i]);
		}
	
		for(int i =0;i<2;i++)
			person[i] = sc.nextInt();
	
		int start = person[0] +1;
		for(int i=1;i<=person[0];i++) log[i] = 1;		
		findMin(start,maxNum);
		
		for(int i =0;i<n;i++) {
			minPerson += log[arr[i]];
		}
		System.out.println(minPerson);
	}
}
