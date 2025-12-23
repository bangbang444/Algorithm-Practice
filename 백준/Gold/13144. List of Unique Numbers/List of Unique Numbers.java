import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] reg = new boolean[100001];
        int left = 0, right = 0;
        long count = 0;
        while(left < N && right < N){
            int cur = arr[right];
            if(!reg[cur]){
                reg[cur] = true;
                right++;
                continue;
            }


            long count2 = 0;
            int num = right-left;
            while(reg[cur]){
                int e = arr[left];
                reg[e] = false;
                left++;
                count2++;
            }

            for(int i = 0; i < count2; i++){
                count += num--;
            }
        }

        long m = N-(left);
        count += m*(1+m)/2;
        System.out.println(count);

    }
}
