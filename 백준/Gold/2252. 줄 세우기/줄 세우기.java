import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[] in = new int[N];
        Map<Integer, Node> graph = new HashMap<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            graph.putIfAbsent(s, new Node(s));
            graph.putIfAbsent(e, new Node(e));

            in[e] += 1;

            graph.get(s).addEdge(e);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < in.length; i++){
            if(in[i] == 0)
                q.offer(i);
        }

        StringBuilder answer = new StringBuilder();
        while(!q.isEmpty()){
            Integer cur = q.poll();
            answer.append(cur+1).append(" ");

            Node node = graph.get(cur);
            if(node == null) continue;
            List<Integer> edges = node.edges;
            if(edges.isEmpty()) continue;

            for (Integer edge : edges) {
                in[edge] -= 1;
                if(in[edge] == 0){
                    q.offer(edge);
                }
            }

        }

        System.out.println(answer);
    }

    static class Node{
        int num;
        List<Integer> edges = new ArrayList<>();
        public Node(int num){
            this.num = num;
        }

        public void addEdge(int num){
            edges.add(num);
        }
    }
}