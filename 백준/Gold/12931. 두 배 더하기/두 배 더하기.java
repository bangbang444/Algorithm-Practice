import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] goal = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        int operations = 0;

        while (true) {
            boolean allZero = true;

            // 먼저 홀수면 -1 (→ +1 연산 했다는 뜻)
            for (int i = 0; i < N; i++) {
                if (goal[i] % 2 == 1) {
                    goal[i]--;
                    operations++;
                }
                if (goal[i] != 0) {
                    allZero = false;
                }
            }

            if (allZero) break;

            // 모두 짝수일 때만 /2 (→ 전체 *2 연산 했다는 뜻)
            for (int i = 0; i < N; i++) {
                goal[i] /= 2;
            }
            operations++; // *2 연산 1회
        }

        System.out.println(operations);
    }
}
