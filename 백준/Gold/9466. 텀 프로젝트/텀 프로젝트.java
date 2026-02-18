import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] colors;
    static int color = 1;
    static int[] seq;
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            colors = new int[n+1];
            seq = new int[n+1];
            int[] choices = new int[n+1]; // 고른 사람
            for(int j = 1; j <= n; j++){
                choices[j] = Integer.parseInt(st.nextToken());
            }

            // 결국 링 구조에 해당되지 않는 학생 수 구하기
            // 1 <= n <= 100,000
            int people = 0;
            for(int j = 1; j <= n; j++){
                if(colors[j] != 0) continue;
                color++;
                people += checkMakeTeam(choices, j);
            }

            answer.append(n-people).append("\n");

        }

        System.out.println(answer);
    }

    private static int checkMakeTeam(int[] choices, int start){

        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        colors[start] = color;
        seq[start] = num++;

        while(!stack.isEmpty()){
            int cur = stack.pop();
            int next = choices[cur];

            if(colors[next] != 0 && colors[next] < color){
                break;
            }

            if(colors[cur] == colors[next]){
                return seq[cur] - seq[next] + 1;
            }
            seq[next] = seq[cur] + 1;
            colors[next] = color;

            stack.push(next);
        }

        return 0;
    }
}