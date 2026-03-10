import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = A[0];
        int idx = 0;
        for(int i = 1; i < N; i++){
            int cur = A[i];
            if(lis[idx] < cur){ // 뒤에 추가
                idx++;
                lis[idx] = cur;
            }else{ // 이전 것 중 교체
                int left = 0;
                int right = idx;
                int pos = (left+right)/2;

                while(left <= right){
                    int mid = (left+right) / 2;
                    if(lis[mid] >= cur){
                        right = mid - 1;
                        pos = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                lis[pos] = cur;
            }
        }

        int count = 0;
        for (int li : lis) {
            if(li != 0) count++;
            else break;
        }
        System.out.println(count);
    }
}
