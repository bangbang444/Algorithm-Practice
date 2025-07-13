import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // 1. 공백을 기준으로 단어 분리
        // 2. <> 있으면 그대로, 아니면 반전
        StringBuilder answer = new StringBuilder();
        String[] split = line.split(" ");
        Stack<Character> stack = new Stack<>();

        boolean notChange = false;
        for (String s : split) {
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '<') {
                    while (!stack.isEmpty()) answer.append(stack.pop());
                    notChange = true;
                }
                if (c == '>') {
                    answer.append(c);
                    notChange = false;
                    continue;
                }

                if(notChange) answer.append(c);
                else stack.push(c);
            }
            while (!stack.isEmpty()) answer.append(stack.pop());
            answer.append(" ");
        }


        System.out.println(answer);

    }
}