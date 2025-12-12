import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무 수(~100만)
        int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이(~20억)

        st = new StringTokenizer(br.readLine());
        long[] treeH = new long[N];
        for(int i = 0; i < N; i++){
            treeH[i] = Integer.parseInt(st.nextToken());
        }

        long left = 1;
        long right = Arrays.stream(treeH).max().getAsLong();
        long max = 0;
        while(left <= right){
            long mid = (left+right)/2; // 맞추려는 높이

            long sum = 0;
            for(int i = 0; i < treeH.length; i++){
                if(treeH[i] > mid){
                    sum += treeH[i]-mid;
                }
            }

            if(sum >= M){
                left = mid+1;
                max = mid;
            }else{
                right = mid-1;
            }

        }

        System.out.println(max);
    }
}
