import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시 수

        int[][] mat = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int con = Integer.parseInt(st.nextToken());
                if(con == 1){
                    mat[i][j] = con;
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE)
                        mat[i][j] = Math.min(mat[i][k] + mat[k][j], mat[i][j]);
                }
            }
        }

        int[] plan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            plan[i] = Integer.parseInt(st.nextToken())-1;
        }

        int count = 0;
        for (int i = 0; i < M-1; i++) {
            int x = plan[i];
            int y = plan[i+1];
            if(x == y){
                count++;
                continue;
            }
            if(mat[x][y] != Integer.MAX_VALUE){
                count++;
            }
        }

        if(count+1 == M){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
