import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for(int i = 0; i < N; i++){
            int sushi = Integer.parseInt(br.readLine());
            belt[i] = sushi;
        }

        int[] ate = new int[3001];
        int max = -1;
        int start = 0, end = 0;
        Set<Integer> types = new HashSet<>(); // sizeMax: d
        while(end < N+k){
            int sushi = belt[end%N];

            if(end-start >= k){
                int el = belt[start%N];
                if(ate[el] == 1) {
                    types.remove(el);
                }
                ate[el]--;

                start++;
                continue;
            }

            types.add(sushi);
            ate[sushi]++;

            if(!types.contains(c) && types.size()+1 <= d){
                max = Math.max(types.size() + 1, max);
            }else{
                max = Math.max(types.size(), max);
            }

            end++;
        }

        System.out.println(max);
    }
}