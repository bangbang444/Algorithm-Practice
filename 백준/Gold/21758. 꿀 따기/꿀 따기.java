import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] honey = new int[N+1];
        int maxE = -1;
        for(int i = 1; i <= N; i++){
            int input = Integer.parseInt(st.nextToken());
            honey[i] = honey[i-1] + input;
            if(maxE < input) maxE = input;
        }

        int sum1 = honey[N] - honey[1];
        int sum2;
        int max1 = -1;
        for(int i = 2; i <= N; i++){
            int std = honey[i]-honey[i-1]; // 기준점 원소
            sum2 = honey[N] - honey[i]; // 기준점부터 누적합
            max1 = Math.max(sum2 + (sum1-std), max1);
        }

        int max3 = honey[N-1] - honey[1] + maxE;

        int sum4 = honey[N-1];
        int sum5;
        int max2 = -1;
        for(int i = N-2; i >=1; i--){
            int std = honey[i+1]-honey[i]; // 기준점 원소
            sum5 = honey[i];
            max2 = Math.max(sum4-std + sum5, max2);
        }

        System.out.println(Math.max(Math.max(max1, max2), max3));

    }
}
