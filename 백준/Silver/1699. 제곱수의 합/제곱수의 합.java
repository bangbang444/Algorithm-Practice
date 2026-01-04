import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer stdN = Integer.parseInt(br.readLine());
        int std = (int) Math.sqrt(stdN);

        back(stdN, std, 0);

        System.out.println(min);
    }

    public static void back(int N, int num, int count){
        //System.out.println(N + " " + num + " " + count);
        if(N < 0 || count >= min) return;
        if(N == 0){
            min = count;
            return;
        }

        int end = (int)(num*0.7);
        for(int i = num; i >= end; i--){
            int pow = i*i;
            int next = N - pow;

            back(next, (int)Math.sqrt(next),count+1);
        }
    }
}