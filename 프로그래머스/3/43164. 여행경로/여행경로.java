import java.util.*;
class Solution {
    Map<String, Node> graph = new HashMap<>();
    public String[] solution(String[][] tickets) {
        Set<String> cities = new HashSet<>();
        int num = 1;
        for(String[] ticket : tickets){
            String depart = ticket[0];
            String arrive = ticket[1];
            graph.putIfAbsent(depart, new Node(depart));
            graph.putIfAbsent(arrive, new Node(arrive));
            
            graph.get(depart).addEdge(arrive);
            cities.add(depart); cities.add(arrive);
        }
        
        String[] answer = new String[tickets.length+1];
        int idx = tickets.length;
        Stack<String> stack = new Stack<>();
        stack.push("ICN");
        while(!stack.isEmpty()){
            String cur = stack.pop();
            List<String> nexts = graph.get(cur).edges;
            if(nexts.isEmpty()){
                answer[idx--] = cur;
                continue;
            }
            stack.push(cur);
            stack.push(nexts.get(0));
            nexts.remove(0);
        }
        
        return answer;
    }

    
    class Node{
        String name;
        List<String> edges = new ArrayList<>();
        public Node(String name){
            this.name = name;
        }
        public void addEdge(String name){
            edges.add(name);
            Collections.sort(edges);
        }
    }
}