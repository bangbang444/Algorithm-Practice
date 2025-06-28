import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N, M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // map 초기화
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        // model 1
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M-3; j++){
                int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                max = Math.max(max, sum);
            }
        }
        for(int i = 0; i < N-3; i++){
            for(int j = 0; j < M; j++){
                int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                max = Math.max(max, sum);
            }
        }

        // model2
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-1; j++){
                int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                max = Math.max(max, sum);
            }
        }

        // model3
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                int sum1 = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                int sum2 = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                // 대칭
                int sum3 = map[i][j+1] + map[i+1][j+1] + map[i+2][j] + map[i+2][j+1];
                int sum4 = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];

                max = Math.max(max, Math.max(sum1, sum2));
                max = Math.max(max, Math.max(sum3, sum4));
            }
        }
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-2; j++){
                int sum1 = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2];
                int sum2 = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
                //대칭
                int sum3 = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                int sum4 = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];

                max = Math.max(max, Math.max(sum1, sum2));
                max = Math.max(max, Math.max(sum3, sum4));
            }
        }

        // model4
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                int sum1 = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                //대칭
                int sum2 = map[i][j+1] + map[i+1][j+1] + map[i+1][j] + map[i+2][j];
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-2; j++){
                int sum1 = map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1];
                // 대칭
                int sum2 = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        // model5
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-2; j++){
                int sum1 = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
                int sum2 = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2];
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < M-1; j++){
                int sum1 = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                int sum2 = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        System.out.println(max);

    }
}
