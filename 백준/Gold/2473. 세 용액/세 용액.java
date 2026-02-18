import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //3~5000

        // -10억~10억 - 값 다 다름
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Math.abs(arr[0] + arr[1] + arr[2]);
        long[] answer = new long[]{arr[0], arr[1], arr[2]};
        for(int std = 0; std < N-2; std++){
            int left = std+1;
            int right = N-1;
            while(left < right){
                long sum = arr[std] + arr[left] + arr[right];

                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    answer = new long[]{arr[std], arr[left], arr[right]};
                }

                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    System.out.println(arr[std] + " " + arr[left] + " " + arr[right]);
                    return;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
