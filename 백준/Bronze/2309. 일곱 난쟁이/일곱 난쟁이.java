import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] h = new int[9];
        for(int i = 0; i < 9; i++){
            h[i] = Integer.parseInt(br.readLine());
        }

        int total = Arrays.stream(h).sum();
        int[] idxs = findIdx(h, total-100);
        h[idxs[0]] = Integer.MAX_VALUE;
        h[idxs[1]] = Integer.MAX_VALUE;
        Arrays.sort(h);

        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < 7; i++){
            answer.append(h[i]).append("\n");
        }

        System.out.println(answer);
    }

    public static int[] findIdx(int[] arr, int sum){
        for(int i = 0; i < arr.length; i++){
            int el1 = arr[i];
            for(int j = i+1; j < arr.length; j++){
                if(el1 + arr[j] == sum){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}