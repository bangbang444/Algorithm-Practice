import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        // 초기화
        int a = map[0][0];
        int idx = a;
        if(a != 0) {
            while (idx < N && map[0][idx] != 0) { // 가로
                dp[0][idx] = 1;
                idx += map[0][idx];
            }
            idx = a;
            while (idx < N && map[idx][0] != 0) {
                dp[idx][0] = 1;
                idx += map[idx][0];
            }
        }else{
            System.out.println(0);
            return;
        }

        // 시작
        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){

                int num = 1;
                while(num <= 9 && i - num >= 0){
                    if(num == map[i-num][j]){
                        dp[i][j] += dp[i-num][j];
                    }
                    num++;
                }
                num = 1;
                while(num <= 9 && j - num >= 0){
                    if(num == map[i][j-num]){
                        dp[i][j] += dp[i][j-num];
                    }
                    num++;
                }
            }
        }

        System.out.println(dp[N-1][N-1]);

    }
}
