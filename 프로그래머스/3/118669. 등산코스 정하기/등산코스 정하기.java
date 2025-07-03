import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);
        Set<Integer> summitSet = IntStream.of(summits)
            .boxed().collect(Collectors.toSet());
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] path : paths){
            graph.putIfAbsent(path[0], new LinkedList<>());
            graph.putIfAbsent(path[1], new LinkedList<>());
            
            graph.get(path[0]).add(new Edge(path[1], path[2]));
            graph.get(path[1]).add(new Edge(path[0], path[2]));
        }
        
        // 모든 출입구를 우선순위큐에 삽입
        Queue<Entry> hq = new PriorityQueue<>();
        int[] visited = new int[n+1];
        Arrays.fill(visited, 10000001);
        for(int gate : gates){
            hq.add(new Entry(0, gate));
            visited[gate] = 0;
        }
        
        while(!hq.isEmpty()){
            Entry e = hq.remove();
            if(e.intensity > visited[e.node] || summitSet.contains(e.node)){
                continue;
            }
            
            for(Edge edge : graph.get(e.node)){
                int nextIntensity = Math.max(edge.weight, e.intensity);
                if(nextIntensity < visited[edge.node]){
                    visited[edge.node] = nextIntensity;
                    hq.add(new Entry(nextIntensity, edge.node));
                }
            }
        }
        
        int[] minIntensity = {0, 10000001};
        for(int summit : summits){
            if(minIntensity[1] > visited[summit]){
                minIntensity[0] = summit;
                minIntensity[1] = visited[summit];
            }
        }
        
        return minIntensity;
        
        
    }
    
    static class Entry implements Comparable<Entry>{
        int intensity;
        int node;
        
        public Entry(int intensity, int node){
            this.intensity = intensity;
            this.node = node;
        }
        
        @Override
        public int compareTo(Entry o){
            return this.intensity - o.intensity;
        }
    }
    
    static class Edge{
        int node;
        int weight;
        
        public Edge(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
        
        @Override
    public boolean equals(Object obj){
        if(obj instanceof Edge){
            Edge other = (Edge)obj;
            return other.node == this.node && other.weight == this.weight;
        }
        return false;
    }
    
        @Override
        public int hashCode(){
            return Objects.hash(this.node, this.weight);
        }
    }
    
    
}