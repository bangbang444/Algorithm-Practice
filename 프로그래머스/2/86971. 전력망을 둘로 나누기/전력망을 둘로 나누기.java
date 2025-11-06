import java.util.*;
class Solution {
    
    Map<Integer, List<Integer>> tree;
    int min = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        
        visited = new boolean[n+1];
        
        // 트리 구축
        tree = new HashMap<>();
        for(int[] wire : wires){
            int node1 = wire[0];
            int node2 = wire[1];
            tree.putIfAbsent(node1, new ArrayList<>());
            tree.putIfAbsent(node2, new ArrayList<>());
            
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        
        // 전력망 탐색
        divNet(n, wires[0][0]);
        
        return min;
    }
    
    public int divNet(int n, int parent){
        
        if(visited[parent]) return 0;
        visited[parent] = true;
        
        List<Integer> edges = tree.get(parent);
        
        int totalChild = 0;
        for(Integer edge : edges){
            int child = divNet(n, edge);
            
            int nodeDiff = n-child;
            int localMin = Math.abs(nodeDiff-child);

            if(localMin < min){
                min = localMin;
            }
            
            totalChild += child;
        }
        
        return totalChild+1;
    }
}