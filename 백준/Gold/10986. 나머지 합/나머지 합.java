import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] acc = new int[N+1];
        for(int i = 1; i <= N; i++){
            acc[i] = (Integer.parseInt(st.nextToken()) + acc[i-1])%M;
        }

        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for (int i = 1; i <= N; i++) {
            int a = acc[i];
            if(a == 0) {
                count++;
            }

            int cnt = map.getOrDefault(a, 0);
            if(cnt >= 1) {
                count += cnt;
            }
            map.put(a, cnt+1);


        }

        System.out.println(count);
    }
}