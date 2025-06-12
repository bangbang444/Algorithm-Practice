import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 수

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 간선 개수
            int c = Integer.parseInt(st.nextToken()); // 시작 노드

            // 그래프 초기화
            List<Node>[] graph = new ArrayList[n+1];
            for(int j = 0; j <= n; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 출발
                int b = Integer.parseInt(st.nextToken()); // 끝
                int s = Integer.parseInt(st.nextToken()); // 시간

                graph[b].add(new Node(a, s));
            }

            // 다익스트라
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] times = new int[n+1];
            Arrays.fill(times, Integer.MAX_VALUE);
            pq.add(new Node(c, 0));
            times[c] = 0;

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                int curTime = cur.time;

                if(times[cur.to] < curTime) continue;
                if(graph[cur.to].isEmpty()) continue;

                for(Node next : graph[cur.to]){
                    if(times[next.to] > times[cur.to] + next.time){
                        times[next.to] = times[cur.to] + next.time;
                        pq.add(new Node(next.to, times[next.to]));
                    }
                }
            }
            // 끝
            answer.append(Arrays.stream(times)
                    .filter(t -> t != Integer.MAX_VALUE).count()).append(" ");
            answer.append(Arrays.stream(times)
                            .filter(t -> t != Integer.MAX_VALUE)
                            .max().getAsInt()).append("\n");

        }

        System.out.print(answer);
    }

    static class Node implements Comparable<Node>{
        int to;
        int time;
        public Node(int to, int time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}