
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[][] table = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(table[i], Integer.MAX_VALUE);
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            table[u][v] = 1;
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(table[i][k] != Integer.MAX_VALUE && table[k][j] != Integer.MAX_VALUE) {
                        table[i][j] = Math.min(table[i][j] ,table[i][k] + table[k][j]);
                    }
                }
            }
        }

        int count = 0;
        for(int i=1;i<=n;i++) {
            int subCount = 0;
            for(int j=1;j<=n;j++) {
                if(table[i][j] != Integer.MAX_VALUE) {
                    subCount++;
                }
            }

            for(int j=1;j<=n;j++) {
                if(table[j][i] != Integer.MAX_VALUE) {
                    subCount++;
                }
            }

            if(subCount == n-1){
                count++;
            }
        }

        System.out.println(count);

    }

}
