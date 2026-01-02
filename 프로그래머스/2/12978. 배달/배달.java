import java.util.*;

class Solution {
    Map<Integer, Node> tree = new HashMap<>();
    public int solution(int N, int[][] road, int K) {

        // Tree 생성
        for(int[] r : road){
            int s = r[0];
            int t = r[1];
            int w = r[2];
            
            tree.putIfAbsent(s, new Node(s));
            tree.putIfAbsent(t, new Node(t));
            
            tree.get(s).addEdge(t, w);
            tree.get(t).addEdge(s, w);
        }
        
        int[] table = dijstra(1, N);
        int sum = 0;
        for(int d : table){
            sum += d <= K ? 1 : 0;
        }
        return sum;
    }
    
    public int[] dijstra(int start, int N){
        
        int[] table = new int[N+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[start] = 0;
        
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curN = cur[0];
            int curW = cur[1];
            
            Node curNode = tree.get(curN);
            List<Edge> edges = curNode.edges;
            for(Edge edge : edges){
                int next = edge.n;
                int nextW = curW + edge.w;
                if(table[next] > nextW){
                    table[next] = nextW;
                    pq.add(new int[]{next, nextW});
                }
            }
        }
        
        return table;
    }
    
    class Node{
        int num;
        List<Edge> edges = new ArrayList<>();
        public Node(int num){
            this.num = num;
        }
        public void addEdge(int n, int w){
            this.edges.add(new Edge(n, w));
        }
    }
    
    class Edge{
        int n;
        int w;
        public Edge(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}