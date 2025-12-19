import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,C;
    static int[] share;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        share = new int[N];
        for(int i = 0; i < N; i++){
            share[i] = Integer.parseInt(br.readLine());
        }

        // 1 2 4 8 9
        Arrays.sort(share);

        // 거리
        int first = 1;
        int last = share[share.length-1] - share[0];

        int answer = 1;
        while(first <= last){
            int mid = (first + last) / 2;

            if(check(mid)){
                answer = mid;
                first = mid + 1;
            }else{
                last = mid - 1;
            }

        }

        System.out.println(answer);
    }

    public static boolean check(int distance){
        int count = 1;
        int start = share[0];
        for(int i = 1; i < N; i++){
            if(share[i] - start >= distance){
                count++;
                start = share[i];
            }
        }

        return count >= C;
    }
}

