import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int minCount;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        minCount = Integer.MAX_VALUE;
        answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] dp = new int[1_000_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i = 1; i <= N; i++){
            if(i*3 <= N){
                dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
            }
            if(i*2 <= N){
                dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
            }
            if(i+1 <= N){
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            }
        }

        int nextIdx = N;
        int nextCount = dp[N]-1;
        answer.append(N).append(" ");
        while(nextIdx != 1){
            int select = Integer.MAX_VALUE;

            if(dp[nextIdx-1] == nextCount){ // 9 2
                select = nextIdx-1;
            }
            if(nextIdx%2 == 0 && dp[nextIdx/2] == nextCount){
                select = nextIdx/2;
            }
            if(nextIdx%3 == 0 && dp[nextIdx/3] == nextCount){
                select = nextIdx/3;
            }

            answer.append(select).append(" ");
            nextIdx = select;
            nextCount--;
        }

        System.out.println(dp[N]);
        System.out.println(answer);

    }
}