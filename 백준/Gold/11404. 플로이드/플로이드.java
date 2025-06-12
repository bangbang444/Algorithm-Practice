import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] infos;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 버스 개수

        infos = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                infos[i][j] = INF;

            }
            infos[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;
            int cost = Integer.parseInt(st.nextToken());

            infos[start][end] = Math.min(infos[start][end], cost);

        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if (infos[i][k] == INF || infos[k][j] == INF)
                        continue; // i -> k 또는 k -> j가 연결되지 않은 경우, 무시
                    infos[i][j] = Math.min(infos[i][j], infos[i][k] + infos[k][j]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++){
            int[] rows = infos[i];
            for(int j = 0; j < N; j++){
                int element = rows[j];
                if(element == INF) {
                    answer.append(0).append(" ");
                    continue;
                }
                answer.append(infos[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

}
