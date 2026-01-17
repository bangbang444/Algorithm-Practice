import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken()); // 세로 ~500
        int W = Integer.parseInt(st.nextToken()); // 가로 ~500

        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[W];
        for(int i = 0; i < W; i++){
            blocks[i] = Integer.parseInt(st.nextToken());
        }


        int idx = 0;
        int total = 0;
        int[] waters = new int[W];
        int localMax = 0;
        int localMaxIdx = 0;
        while(idx < blocks.length){
            int curH = blocks[idx];
            waters[idx] = curH;

            if(localMax < curH) {
                for(int i = idx-1; i >= localMaxIdx; i--){
                    total += localMax - waters[i];
                }

                localMax = curH;
                localMaxIdx = idx;
                continue;
            }

            for(int i = idx-1; i >= 0; i--){ // 현재보다 큰거 찾기
                if(blocks[i] >= curH){
                    for(int j = i+1; j <= idx-1; j++){ // 물 채우기
                        total += curH - waters[j];
                        waters[j] = curH;
                    }
                    break;
                }
            }
            idx++;
        }
        
        System.out.println(total);

    }
}