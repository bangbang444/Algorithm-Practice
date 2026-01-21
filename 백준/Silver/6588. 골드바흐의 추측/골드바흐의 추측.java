import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] eratos = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeEratos();

        StringBuilder answer = new StringBuilder();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            boolean find = false;
            for(int i = 3; i <= N/2; i+=2){
                if(eratos[i] != 0 && eratos[N-i] != 0){
                    answer.append(N).append(" = ").append(i).append(" + ").append(N-i).append("\n");
                    find = true;
                    break;
                }
            }
            if(!find){
                answer.append("Goldbach's conjecture is wrong.\n");
            }
        }
        System.out.println(answer);

    }

    public static void makeEratos(){
        for(int i = 2; i <= 1000000; i++){
            eratos[i] = i;
        }

        for(int i = 2; i <= 1000000; i++){
            if(eratos[i]==0) continue;

            for(int j = 2*i; j<= 1000000; j+=i){ // 2i~(i-1)i 구간은 이미 처리됨
                eratos[j] = 0;
            }
        }
    }
}