import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,K,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 건물 수
            K = Integer.parseInt(st.nextToken()); // 건설 순서 규칙

            // 최소 걸리는 시간
            int[] leastTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                leastTime[i] = Integer.parseInt(st.nextToken());
            }

            // 그래프
            List<Integer>[] graph = new ArrayList[N+1];
            for(int i = 1; i <= N; i++){
                graph[i] = new ArrayList<>();
            }

            // 건설 순서
            int[] indegree = new int[N+1];
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                indegree[end]++;
            }

            // 건설해야 할 건물 번호
            W = Integer.parseInt(br.readLine());

            int[] dp = new int[N+1];
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 1; i <= N; i++){
                if(indegree[i] == 0) {
                    dp[i] = leastTime[i];
                    queue.offer(i);
                }
            }

            // 위상 정렬
            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int next : graph[cur]){
                    dp[next] = Math.max(dp[next], dp[cur] + leastTime[next]);
                    if(--indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }

            // 시작
            answer.append(dp[W]).append("\n");
        }
        System.out.println(answer);
    }
}
