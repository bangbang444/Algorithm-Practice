import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] heights = new int[N];
        for(int i = 0; i < N; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 한 빌딩을 기준으로 '왼/오' 본다.
        // 한 빌딩을 목표로 잡는다.
        // 그 둘을 선으로 잇고 그 사이에 선에 접하거나 건드는게 있는지 확인한다.
        // 건드는게 없으면 +1
        // 그렇게 보이는 빌딩들을 구한다.
        // 최댓값을 구한다.
        int max = -1;
        for(int i = 0; i < N; i++){ // 기준
            int count = 0;
            double std = heights[i];
            for(int j = i-1; j >= 0; j--){ // 타겟
                int target = heights[j];
                double gradient = (std-target)/(i-j);
                double yIntercept = std-gradient*i;
                boolean success = true;
                for(int k = j+1; k < i; k++){ // 사이 애들
                    if(gradient*k+yIntercept <= heights[k]){
                        success = false;
                        break;
                    }
                }
                if(success) {
                    count++;
                }
            }

            for(int j = i+1; j < N; j++){
                int target = heights[j];
                double gradient = (std-target)/(i-j);
                double yIntercept = std-gradient*i;
                boolean success = true;
                for(int k = i+1; k < j; k++){
                    if(gradient*k+yIntercept <= heights[k]){
                        success = false;
                        break;
                    }
                }
                if(success) count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
