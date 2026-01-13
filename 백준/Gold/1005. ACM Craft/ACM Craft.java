import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,K,W;
    static Map<Integer, Node> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 0; t < T; t++) {
            graph = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 건물 수
            K = Integer.parseInt(st.nextToken()); // 건설 순서 규칙

            // 최소 걸리는 시간
            int[] leastTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                leastTime[i] = Integer.parseInt(st.nextToken());
                graph.put(i, new Node(i,leastTime[i]));
            }

            // 건설 순서
            int[] indegree = new int[N+1];
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph.get(first).connectNode(end);
                graph.get(end).addPreNode(first);
                indegree[end]++;
            }


            // 건설해야 할 건물 번호
            W = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            for(int i = 1; i <= N; i++){
                if(indegree[i] == 0) queue.offer(i);
            }

            // 위상 정렬
            List<Integer> seq = new ArrayList<>();
            while(!queue.isEmpty()){
                int cur = queue.poll();
                seq.add(cur);

                Node node = graph.get(cur);
                for(int next : node.next){
                    if(--indegree[next] == 0){
                        queue.offer(next);
                    }
                }
            }

            // 시작
            for(int n : seq){
                Node node = graph.get(n);
                List<Integer> pre = node.pre;
                if(pre.isEmpty()){
                    node.time = leastTime[node.num];
                    continue;
                }

                int max = 0;
                for (Integer i : pre) {
                    Node preNode = graph.get(i);
                    max = Math.max(preNode.time, max);
                }
                node.time = max + leastTime[node.num];
            }

            answer.append(graph.get(W).time).append("\n");
        }

        System.out.println(answer);
    }

    static class Node{
        int num;
        int time;
        List<Integer> next = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
        public void connectNode(int num){
            next.add(num);
        }
        public void addPreNode(int num){
            pre.add(num);
        }
    }
}
