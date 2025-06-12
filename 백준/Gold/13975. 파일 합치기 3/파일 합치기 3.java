import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 0;t < T; t++){
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            long total = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < K; k++){
                pq.add(Long.parseLong(st.nextToken()));
            }

            while(pq.size() > 1){
                Long poll1 = pq.poll();
                Long poll2 = pq.poll();
                long sum = poll1 + poll2;
                total += sum;
                pq.add(sum);
            }
            answer.append(total).append("\n");

        }
        System.out.print(answer);
    }
}
