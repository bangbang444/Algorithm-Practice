import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문제 수
        int M = Integer.parseInt(st.nextToken()); // 정보 개수

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] in = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.putIfAbsent(front, new ArrayList<>());
            map.get(front).add(end);
            in[end]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            if(in[i] == 0){
                pq.offer(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            answer.append(cur).append(" ");
            List<Integer> edges = map.get(cur);
            if(edges == null) continue;

            for(Integer edge : edges){
                in[edge]--;
                if(in[edge] == 0){
                    pq.offer(edge);
                }
            }
        }

        System.out.println(answer);
    }
}