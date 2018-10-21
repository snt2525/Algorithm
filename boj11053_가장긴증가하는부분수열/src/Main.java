import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException{
    	Scanner sc = new Scanner(System.in);
        int n, i, j, max = 0;
    	n = sc.nextInt();;
        int[] dp = new int[n];
        int[] arr = new int[n];
        for(i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.fill(dp, 1); // �ڽŸ� ������ �κм����� �������������̶�� �� �� �����Ƿ� '1'�� �ʱ�ȭ
        for(i = 0; i < n; i++){
        	for(j = 0; j < i; j++){
        		if(arr[i] <= arr[j]) continue; // 'j'���� ���Ұ� 'i'���� ���Һ��� ũ�� j���� ���Ҵ� �������������� ���Ե��� �ʴ´�.
        		dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        	max = Math.max(max, dp[i]); // ������������ �߿����� ���̰� ���� �� ���� ã�´�.
        }
        System.out.print(b);(max+"");
        bw.close();
}
}
