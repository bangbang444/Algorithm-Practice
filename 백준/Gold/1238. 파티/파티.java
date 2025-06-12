import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 마을 개수
        X = Integer.parseInt(st.nextToken()); // 집결지

        // 그래프 초기화
        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        // 그래프 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, t));
        }

        int[] total = new int[N+1];

        int[] lastToStart = dijkstra(X); // INF 1 0 3 7

        for(int i = 1; i <= N; i++){
            int[] startToLast = dijkstra(i);

            total[i] = Math.max(total[i], startToLast[X] + lastToStart[i]);
        }

        System.out.println(Arrays.stream(total).max().getAsInt());

    }

    private static int[] dijkstra(int start) {
        int[] table1 = new int[N+1];
        Arrays.fill(table1, INF);
        table1[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(table1[cur.to] < cur.time) continue;
            if(graph[cur.to].isEmpty()) continue;
            
            for(Node next : graph[cur.to]){
                if(table1[next.to] > table1[cur.to] + next.time){
                    table1[next.to] = table1[cur.to] + next.time;
                    pq.add(new Node(next.to, table1[next.to]));
                }
            }
        }

        return table1;
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
