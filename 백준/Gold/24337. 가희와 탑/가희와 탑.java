import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a+b > N+1){
            System.out.println(-1);
            return;
        }

        int[] buildings = new int[N];
        Arrays.fill(buildings, 1);

        int end = N-1;
        int max = Math.max(a, b);
        int maxIdx = end-b+1;

        int min = Math.min(a, b);

        StringBuilder answer = new StringBuilder();
        if(a == b){
            int v = 1;
            for(int i = end; i >= maxIdx; i--){
                buildings[i] = v++;
            }
            v = max;
            for(int i = maxIdx; i >= maxIdx-a+1; i--){
                buildings[i] = v--;
            }
        }else if(min == a){
            int v = 1;
            for(int i = end; i >= end-b+2; i--){
                buildings[i] = v++;
            }
            if(a == 1)
                buildings[a-1] = max;
            else {
                v = a-1;
                for(int i = maxIdx-1; i >= maxIdx-a+1; i--){
                    buildings[i] = v--;
                }
                buildings[maxIdx] = max;
            }
        }else{
            int v = 1;
            for(int i = end; i > end-b+1; i--){
                buildings[i] = v++;
            }
            v = max;
            for(int i = maxIdx; i >= maxIdx-a+1; i--){
                buildings[i] = v--;
            }
        }

        for (int building : buildings) {
            answer.append(building).append(" ");
        }
        System.out.println(answer);
    }
}