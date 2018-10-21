import java.util.*;
public class Solution {
    static int[][] arr;
    static int n,m;
    static int result;

    public static void check() {
        for(int i = 0; i< n;i++) {
            //세로
            dfs(0, i, 1, 0);
            //가로
            dfs(0 , i, 1, 1);
        }
    }
    public static void dfs(int cur, int index, int pos,int i) {
        if( cur == n - 1) {
            result++;
            return;
        }

        if(i == 0) { //세로
            if(cur + 1 < n && arr[cur + 1][index] == arr[cur][index]) { // 같을 때,
                dfs(cur + 1, index, pos + 1, i);
            }else if(cur + 1 < n &&(pos >= m && arr[cur + 1][index] == arr[cur][index] + 1)) { // +1 일 때,
                dfs(cur + 1, index, 1, i);
            }else if(cur + 1 < n &&  arr[cur + 1][index] == arr[cur][index] - 1) { //-1 일때
                for(int j= 2; j <= m;j++) {
                    if(cur + j < n && arr[cur + j][index] == arr[cur + 1][index] ) {
                        continue;
                    }
                    return; 
                }   
                dfs(cur + m, index, 0, i);
            }
                return;
        }

        if(i == 1) {
            if(cur + 1 < n && arr[index][cur + 1] == arr[index][cur]) { // 같을 때,
                dfs(cur + 1, index, pos + 1, i);
            }else if(cur + 1 < n &&(pos >= m && arr[index][cur + 1] == arr[index][cur] + 1)) { // +1 일 때,
                dfs(cur + 1, index, 1, i);
            }else if(cur + 1 < n &&  arr[index][cur + 1] == arr[index][cur] - 1) { //-1 일때
                for(int j= 2; j <= m;j++) {
                    if(cur + j < n && arr[index][cur + j] == arr[index][cur + 1]) {
                        continue;
                    }
                    return; 
                }   
                dfs(cur + m, index, 0, i);
            }
                return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 1;t <= test;t++) {
	        result = 0;
	        n = sc.nextInt();
	        m = sc.nextInt();
	        arr = new int[n][n];
	        for(int i =0;i<n;i++) 
	            for(int j =0;j<n;j++) 
	                arr[i][j] = sc.nextInt();           
	        check();        
	        System.out.println("#"+t+" "+result);
        }
    }
}