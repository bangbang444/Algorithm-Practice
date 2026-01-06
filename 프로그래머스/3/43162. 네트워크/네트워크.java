import java.util.*;
class Solution {
    boolean[] visited;
    Map<Integer, Node> map = new HashMap<>();
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        // tree를 통한 그래프 생성
        for(int i = 0; i < n; i++){
            int[] computer = computers[i];
            map.putIfAbsent(i, new Node(i));
            for(int j = 0; j < computer.length; j++){
                int c = computer[j];
                if(c == 1 && i != j){
                    map.get(i).addEdge(j);
                }
            }
        }
        
        // 순회
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    List<Integer> edges = map.get(node).edges;
                    for(int edge : edges){
                        if(!visited[edge]){
                            visited[edge] = true;
                            queue.offer(edge);
                        }
                    } 
                }
            }
        }
        
        return count;
    }
    
    class Node{
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