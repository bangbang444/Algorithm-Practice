import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        boolean isSmall = true;
        for(int i = 1; i <= N; i++){
            if(!isSmallNetwork(graph, i)){
                isSmall = false;
                break;
            }
        }

        System.out.println(isSmall ? "Small World!" : "Big World!");
    }

    private static boolean isSmallNetwork(List<List<Integer>> graph, int start){
        boolean[] visited = new boolean[graph.size()];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int num = node[0];
            int dep = node[1];

            if(dep > 6) return false;

            if(!visited[num]){
                visited[num] = true;
                List<Integer> edges = graph.get(num);

                for (Integer edge : edges) {
                    if(!visited[edge]) {
                        queue.offer(new int[]{edge, dep+1});
                    }
                }

            }
        }

        int count = 0;
        for (int i = 1; i < graph.size(); i++) {
            if(visited[i]) count++;
        }

        return count == graph.size() - 1;
    }
}
