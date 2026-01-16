import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> line = new ArrayList<>();
        for(int i = 0; i < N; i++){
            line.add(Integer.parseInt(br.readLine()));
        }

        int[] lis = new int[N];
        Arrays.fill(lis,1);
        for(int i = 0; i < N; i++){
            Integer num = line.get(i);
            for(int j = 0; j < i; j++){
                if(num > line.get(j))
                    lis[i] = Math.max(lis[i], lis[j]+1);
            }
        }

        System.out.println(N-Arrays.stream(lis).max().getAsInt());
    }
}