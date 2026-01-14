import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Edge>> graph = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 그래프 생성
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.putIfAbsent(n1, new ArrayList<>());
            graph.putIfAbsent(n2, new ArrayList<>());

            graph.get(n1).add(new Edge(n2, w));
            graph.get(n2).add(new Edge(n1, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        boolean[] visited = new boolean[V+1];
        int start = 1;
        visited[start] = true;
        int mstW = 0;
        pq.addAll(graph.get(start));
        int cnt = 0;

        while(cnt < V-1){
            Edge edge = pq.poll();
            if(visited[edge.n]) continue;
            visited[edge.n] = true;

            mstW += edge.w;
            List<Edge> nexts = graph.get(edge.n);
            for(Edge next : nexts){
                if(!visited[next.n]){
                    pq.offer(new Edge(next.n, next.w));
                }
            }
            cnt++;
        }

        System.out.println(mstW);
    }

    static class Edge{
        int n;
        int w;
        public Edge(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}
