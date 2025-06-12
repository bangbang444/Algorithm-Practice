import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m,t;
    static List<Node>[] graph;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] destination = new ArrayList[T+1];
        for(int i = 0; i < T; i++)
            destination[i] = new ArrayList<>();

        for(int l = 0; l < T; l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 교차로 개수(노드)
            m = Integer.parseInt(st.nextToken()); // 도로 개수(간선)
            t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken()); // 꼭 지나는 노드1
            int h = Integer.parseInt(st.nextToken()); // 꼭 지나는 노드2

            // 그래프 초기화
            graph = new ArrayList[n+1];
            for(int i = 0; i <= n ; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); // 노드1
                int v = Integer.parseInt(st.nextToken()); // 노드2
                int d = Integer.parseInt(st.nextToken()); // 길이

                graph[u].add(new Node(v, d)); // 양방향
                graph[v].add(new Node(u, d));
            }

            int[] x = new int[t];
            for(int j = 0; j < t; j++){
                x[j] = Integer.parseInt(br.readLine());
            }


            // 원래 그래프 생성
            int[] normalTable = dijkstra(s, -1);

            int subStart = normalTable[g] < normalTable[h] ? g : h;
            int subEnd = normalTable[g] > normalTable[h] ? g : h;
            // 그럼 같을떈?
            
            // 특정 지점을 지났을 때 | 시작 => 특정 시작
            int[] subStartTable = dijkstra(s, subStart);

            // 특정 시작 -> 특정 끝
            int[] subEndTable = dijkstra(subStart, subEnd);

            // 특정 끝 -> 목적지
            int[] finalTable = dijkstra(subEnd, -1);

//            System.out.println(subStartTable[subStart]);
//            System.out.println(subEndTable[subEnd]);
//            System.out.println(finalTable[g] + " " + finalTable[s]);

            for(int j = 0; j < t; j++){
                if(subStartTable[subStart] + subEndTable[subEnd] +
                        finalTable[x[j]] == normalTable[x[j]])
                    destination[l].add(x[j]);
            }
        }

        for(int i = 0; i < T; i++){
            Collections.sort(destination[i]);
        }

        for(int i = 0; i < T; i++){
            ArrayList<Integer> integers = destination[i];
            for(int j = 0; j < integers.size(); j++){
                answer.append(integers.get(j)).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }

    private static int[] dijkstra(int s, int target) {
        boolean[] visited = new boolean[n+1];

        int[] table = new int[n+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        table[s] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(table[cur.to] < cur.length) continue;
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            if(cur.to == target){
                return table;
            }

            for(Node next : graph[cur.to]){
                if(table[next.to] > table[cur.to] + next.length){
                    table[next.to] = table[cur.to] + next.length;
                    pq.add(new Node(next.to, table[next.to]));
                }
            }
        }
        return table;
    }

    static class Node implements Comparable<Node>{
        int to;
        int length;
        public Node(int to, int length){
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
