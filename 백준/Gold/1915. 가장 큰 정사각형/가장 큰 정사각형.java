import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j-1) - 48;
            }
        }

        int maxSize = -1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(map[i][j] == 1){
                    map[i][j] = Math.min(Math.min(map[i-1][j-1], map[i-1][j]), map[i][j-1]) + 1;
                }
                maxSize = Math.max(maxSize, map[i][j]);
            }
        }

        System.out.println(maxSize*maxSize);

    }
}