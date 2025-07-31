import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String target = br.readLine();

        char[] origin = new char[N];
        for(int i = 0; i < N; i++){
            origin[i] = line.charAt(i);
        }

        // 처음 안 바꿈
        int count = 0;
        char[] copy = Arrays.copyOf(origin, origin.length);
        for(int i = 1; i < N-1; i++){
            if(copy[i-1] != target.charAt(i-1)){
                copy[i-1] = copy[i-1] == '1' ? '0' : '1';
                copy[i] = copy[i] == '1' ? '0' : '1';
                copy[i+1] = copy[i+1] == '1' ? '0' : '1';
                count++;
            }
        }

        if(copy[N-2] != target.charAt(N-2) && copy[N-1] != target.charAt(N-1)){
            copy[N-2] = copy[N-2] == '1' ? '0' : '1';
            copy[N-1] = copy[N-1] == '1' ? '0' : '1';
            count++;
        }

        for(int i = 0 ; i < N; i++){
            if(copy[i] != target.charAt(i)) count = -1;
        }

        if(count != -1){
            System.out.println(count);
            return;
        }

        // 처음 바꿈
        count = 1;
        origin[0] = origin[0] == '1' ? '0' : '1';
        origin[1] = origin[1] == '1' ? '0' : '1';
        for(int i = 1; i < N-1; i++){
            if(origin[i-1] != target.charAt(i-1)){
                origin[i-1] = origin[i-1] == '1' ? '0' : '1';
                origin[i] = origin[i] == '1' ? '0' : '1';
                origin[i+1] = origin[i+1] == '1' ? '0' : '1';
                count++;
            }
        }

        if(origin[N-2] != target.charAt(N-2) && origin[N-1] != target.charAt(N-1)){
            origin[N-2] = origin[N-2] == '1' ? '0' : '1';
            origin[N-1] = origin[N-1] == '1' ? '0' : '1';
            count++;
        }

        for(int i = 0; i < N; i++){
            if(origin[i] != target.charAt(i)) count = -1;
        }

        System.out.println(count);
    }
}
