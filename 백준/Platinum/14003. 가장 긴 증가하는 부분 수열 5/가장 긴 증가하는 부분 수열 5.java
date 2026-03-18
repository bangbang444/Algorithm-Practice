import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1~1,000,000
        int N = Integer.parseInt(br.readLine());

        // -1,000,000,000 ~ 1,000,000,000
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> lis = new ArrayList<>();
        lis.add(A[0]);
        int[] idxs = new int[N];
        idxs[0] = 0;

        for(int i = 1; i < A.length; i++){
            int cur = A[i];
            int lastIdx = lis.size()-1;

            if(cur > lis.get(lastIdx)){
                lis.add(cur);
                idxs[i] = lis.size()-1;
            }else{
                int left = 0;
                int right = lastIdx;
                int pos = 0;
                while(left <= right){
                    int mid = (left+right)/2;

                    if(cur <= lis.get(mid)){
                        right = mid-1;
                        pos = mid;
                    }else{
                        left = mid+1;
                    }
                }
                lis.set(pos, cur);
                idxs[i] = pos;
            }
        }
        // LIS 길이
        System.out.println(lis.size());

        // LIS 수열 출력
        Stack<Integer> stack = new Stack<>();
        int next = lis.size()-1;

        for(int i = idxs.length-1; i >= 0; i--){
            int cur = idxs[i];
            if(next == cur){
                stack.push(A[i]);
                next--;
            }
            if(next < 0) break;
        }

        StringBuilder seq = new StringBuilder();
        while(!stack.isEmpty()) {
            seq.append(stack.pop()).append(" ");
        }
        System.out.println(seq);

    }
}