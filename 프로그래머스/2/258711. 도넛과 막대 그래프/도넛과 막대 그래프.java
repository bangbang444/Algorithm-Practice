// 구해야 할 것: [생성한 정점, 도넛 수, 막대 수, 8자 수]
import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int donut = 0;
    int stick = 0;
    int eight = 0;
    int RANGE = 1000000;
    boolean[] visited = new boolean[RANGE+1];
    public int[] solution(int[][] edges) {
        
        // 그래프 초기화
        for(int i = 0; i <= RANGE+1; i++){
            graph.add(new ArrayList<>());
        }
        
        boolean[] inputs = new boolean[RANGE+1];
        int[] outs = new int[RANGE+1];
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            inputs[end] = true;
            outs[start]++;
        }
        // 시작 찾기
        int start = -1;
        for(int i = 1; i <= inputs.length; i++){
            if(!inputs[i] && outs[i] > 1){
                start = i;
                break;
            } 
        }
        
        List<Integer> starts = graph.get(start);
        for(int s : starts){
            int type = judgeType(s, edges.length);
            if(type == 1) donut += 1;
            else if(type == 2) stick += 1;
            else eight += 1;
        }
        
        return new int[]{start, donut, stick, eight};
    }
    
    public int judgeType(int start, int size){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;
        int n = 0;
        int v = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            
            List<Integer> edges = graph.get(cur);
            n+=1;
            v += edges.size();
            for(int edge : edges){
                if(!visited[edge]){
                    visited[edge] = true;
                    stack.push(edge);
                }
            }
            
        }
        
        if(n == v) return 1; // 도넛
        else if(n == v+1) return 2; // 막대
        else return 3; // 8자
    }
}