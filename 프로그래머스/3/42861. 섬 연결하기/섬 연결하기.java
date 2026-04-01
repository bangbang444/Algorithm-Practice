import java.util.*;
class Solution {
    Map<Integer, Node> graph = new HashMap<>();
    public int solution(int n, int[][] costs) {
        for(int[] cost : costs){
            int s = cost[0];
            int t = cost[1];
            int w = cost[2];
            
            graph.putIfAbsent(s, new Node(s));
            graph.putIfAbsent(t, new Node(t));
            
            graph.get(s).addEdge(t, w);
            graph.get(t).addEdge(s, w);
        }
        
        int minCost = findMinCost(n, graph);
        
        
        return minCost;
    }
    
    public int findMinCost(int n, Map<Integer, Node> graph){
        int start = 0;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNum = cur[0];
            int curW = cur[1];
            
            if(set.contains(curNum)) continue;
            set.add(curNum);
            count++;
            sum+=curW;
            
            if(count == n) break;
            
            Node curNode = graph.get(curNum);
            List<Edge> edges = curNode.edges;
            
            int min = Integer.MAX_VALUE;
            for(Edge edge : edges){
                int next = edge.target;
                int w = edge.w;
                
                pq.add(new int[]{next, w});
            }
        }
        
        return sum;
    }
    
    
    
    class Node{
        int num;
        List<Edge> edges = new ArrayList<>();
        public Node(int num){
            this.num = num;
        }
        
        public void addEdge(int node, int w){
            edges.add(new Edge(node, w));
        }
    }
    
    class Edge{
        int target;
        int w;
        public Edge(int target, int w){
            this.target = target;
            this.w = w;
        }
    }
    
}