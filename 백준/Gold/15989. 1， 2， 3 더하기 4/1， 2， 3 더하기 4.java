import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= 10000; i++){
            dp[i] = 1 + i/2 + dp[i-3];
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            answer.append(dp[n]).append("\n");
        }

        System.out.print(answer);
    }
}
