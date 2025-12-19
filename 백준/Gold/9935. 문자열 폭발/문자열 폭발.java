import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();

        Stack<char []> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);

            if(boom.length() == 1 && boom.charAt(0) == cur) continue;

            if(stack.isEmpty()){
                stack.push(new char[]{cur, 0});
                continue;
            }

            char[] top = stack.peek();
            char el = top[0];
            char seq = top[1];

            if(el == boom.charAt(seq) && seq+1 < boom.length() && boom.charAt(seq+1) == cur){
                stack.push(new char[]{cur, (char)(seq+1)});
            }else{
                stack.push(new char[]{cur, 0});
            }

            if(boom.length() != 1 && stack.peek()[1] == boom.length()-1){
                for(int j = 0; j < boom.length(); j++){
                    stack.pop();
                }
            }
        }

        
        StringBuilder answer = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        }else{
            while(!stack.isEmpty()){
                answer.append(stack.pop()[0]);
            }
            System.out.println(answer.reverse().toString());
        }
    }
}
