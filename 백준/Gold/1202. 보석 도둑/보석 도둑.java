import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 보석 개수
        K = Integer.parseInt(st.nextToken()); // 가방 개수

        List<int []> infos = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치

            infos.add(new int[]{M,V});
        }
        infos.sort((a,b) -> a[0]-b[0]);

        List<Integer> bags = new ArrayList<>(); // 가방
        for(int i = 0; i < K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bags);

        // 보석 가격의 최댓값
        long max = 0;
        int idx = 0;
        // 현재 들어갈 수 있는 가치
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int bag : bags){
            while(idx < N && infos.get(idx)[0] <= bag){
                pq.offer(infos.get(idx)[1]);
                idx++;
            }

            if(!pq.isEmpty()){
                max+=pq.poll();
            }
        }

        System.out.println(max);

    }
}
