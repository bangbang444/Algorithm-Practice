import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] vistors = new int[N+1];
        // 누적합 테이블
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            vistors[i] = vistors[i-1] + Integer.parseInt(st.nextToken());
        }
        // ㄹㄹㄹ
        int maxVisitor = 0;
        int count = 0;
        for(int i = 1; i + X <= N+1; i++){
            if(maxVisitor < vistors[i+X-1] - vistors[i-1]){
                maxVisitor = vistors[i+X-1] - vistors[i-1];
                count = 1;
            }else if (maxVisitor == vistors[i+X-1] - vistors[i-1]){
                count++;
            }
        }

        if(maxVisitor == 0){
            System.out.println("SAD");
            return;
        }
        System.out.println(maxVisitor);
        System.out.println(count);


    }
}
