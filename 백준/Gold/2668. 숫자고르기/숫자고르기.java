import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[2][N]; // 가리키는 것, count
        for(int i = 0; i < N; i++){
            table[0][i] = Integer.parseInt(br.readLine());
        }
        // count는 이미 0으로 초기화 됨

        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++){

            if(set.contains(i+1)) continue;
            Arrays.fill(table[1], 0);

            int cur = i+1;
            // 그래프 탐색
            while(true){
                table[1][cur-1]++;
                if(table[1][cur-1] == 2){
                    set.add(cur);
                }

                if(table[1][cur-1]+1 >= 3){
                    // 2번이상 되어 있는 것들 저장
                    break;
                }

                cur = table[0][cur-1];
            }
        }

        StringBuilder answer = new StringBuilder();

        answer.append(set.size()).append("\n");
        for (Integer i : set) {
            answer.append(i).append(" ");
        }
        System.out.println(answer);
    }
}
