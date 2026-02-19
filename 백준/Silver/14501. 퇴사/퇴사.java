import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] consult = new int[2][N+2];
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            consult[0][i] = Integer.parseInt(st.nextToken());
            consult[1][i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];
        for(int i = 1; i <= N; i++){
            int take = consult[0][i];
            int money = consult[1][i];
            dp[i] = Math.max(dp[i-1], dp[i]);
            if(i+take <= N+1){
                dp[i+take] = Math.max(dp[i]+money, dp[i+take]);
            }

        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
