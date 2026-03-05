import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // A 배열 입력
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        int[] acc1 = new int[n+1];
        int[] acc2 = new int[m+1];
        for(int i = 0; i < n; i++){
            acc1[i+1] = A[i] + acc1[i];
        }
        for(int i = 0; i < m; i++){
            acc2[i+1] = B[i] + acc2[i];
        }

        Map<Integer, Integer> mapA = new HashMap<>(); // [합, 개수]
        Map<Integer, Integer> mapB = new HashMap<>(); // [합, 개수]

        for(int i = 1; i < n+1; i++){
            for(int j= i-1; j >= 0; j--){
                int sum = acc1[i] - acc1[j];
                mapA.putIfAbsent(sum, 0);
                mapA.put(sum, mapA.get(sum)+1);
            }
        }

        for(int i = 1; i < m+1; i++){
            for(int j= i-1; j >= 0; j--){
                int sum = acc2[i] - acc2[j];
                mapB.putIfAbsent(sum, 0);
                mapB.put(sum, mapB.get(sum)+1);
            }
        }

        long answer = 0;
        for(Map.Entry<Integer, Integer> entry : mapA.entrySet()){
            int std = entry.getKey();
            int countA =entry.getValue();

            int need = T-std;

            if(mapB.containsKey(need)){
                answer += ((long)countA * mapB.get(need));
            }
        }

        System.out.println(answer);
    }
}
