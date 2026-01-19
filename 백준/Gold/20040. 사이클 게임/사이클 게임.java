import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 점 개수
        int M = Integer.parseInt(st.nextToken()); // 어디까지 할건지
        // 모든 점은 일직선 상에 놓이지 않음
        tree = new int[N];
        for(int i = 0; i < N; i++) tree[i] = i;

        int answer = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int f1 = find(s);
            int f2 = find(e);
            if(f1 == f2){
                answer = i+1;
                break;
            }
            union(f1, f2);
        }

        System.out.println(answer);

    }

    private static int find(int target){

        List<Integer> list = new ArrayList<>();
        while(tree[target] != target){
            list.add(target);
            target = tree[target];
        }

        for(int e : list){
            tree[e] = target;
        }

        return target;
    }

    private static void union(int r1, int r2){
        tree[r1] = r2;
    }
}
