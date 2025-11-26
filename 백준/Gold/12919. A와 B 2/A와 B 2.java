import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        System.out.println(SToT(new StringBuilder(T)));
    }

    public static int SToT(StringBuilder s){

        Queue<StringBuilder> queue = new LinkedList<>();
        queue.offer(new StringBuilder(s));

        while(!queue.isEmpty()){
            StringBuilder p = queue.poll();

            if(p.length() < S.length()) continue;

            if(p.toString().equals(S)){
                return 1;
            }

            if(p.charAt(p.length()-1) == 'A'){
                p.setLength(p.length()-1);
                queue.offer(new StringBuilder(p));
                p.append('A');
            }
            if(p.charAt(0) == 'B'){
                p.reverse().setLength(p.length()-1);
                queue.offer(new StringBuilder(p));
            }
        }
        return 0;
    }
}
