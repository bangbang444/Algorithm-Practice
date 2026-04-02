import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 완제품 번호
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer, Node> graph = new HashMap<>();

        //중간 부품이나 완제품 X를 만드는데 중간 부품 혹은 기본 부품 Y가 K개 필요하다
        int[] unit = new int[N+1];
        int[] seq = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph.putIfAbsent(X, new Node(X));
            graph.putIfAbsent(Y, new Node(Y));
            graph.get(X).addEdge(Y, K);

            unit[X] += 1;
            seq[Y] += 1;
        }

        List<Integer> base = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(unit[i] == 0){
                base.add(i);
            }
        }

        int[] dp = new int[N+1];
        dp[N] = 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < seq.length; i++) {
            if(seq[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            Node node = graph.get(cur);
            if(node == null) continue;
            List<Edge> edges = node.edges;
            if(edges.isEmpty()) continue;

            for (Edge edge : edges) {
                seq[edge.target]--;
                if(seq[edge.target] == 0) {
                    q.offer(edge.target);
                }
                dp[edge.target] += edge.w * dp[cur];

            }
        }

        StringBuilder answer = new StringBuilder();
        for (Integer i : base) {
            answer.append(i).append(" ").append(dp[i]).append("\n");
        }

        System.out.println(answer);
    }

    static class Node{
        int num;
        List<Edge> edges = new ArrayList<>();
        public Node(int num){
            this.num = num;
        }

        public void addEdge(int num, int w){
            edges.add(new Edge(num, w));
        }
    }

    static class Edge{
        int target;
        int w;
        public Edge(int target, int w){
            this.target = target;
            this.w = w;
        }
    }
}