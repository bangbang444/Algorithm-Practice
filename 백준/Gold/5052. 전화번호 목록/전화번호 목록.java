import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            String[] phone_numbers = new String[N];
            for(int j = 0; j < N; j++){
                phone_numbers[j] = br.readLine();
            }

            Arrays.sort(phone_numbers);

            boolean isConsistent = true;
            for(int j = 0; j < N-1; j++){
                String str1 = phone_numbers[j];
                String str2 = phone_numbers[j+1];
                if(str1.startsWith(str2) || str2.startsWith(str1)) {
                    answer.append("NO").append("\n");
                    isConsistent = false;
                    break;
                }
            }
            if(isConsistent){
                answer.append("YES").append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.println(answer);
    }
}