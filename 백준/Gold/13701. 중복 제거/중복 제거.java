import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main { // 768MB, N <= 500만
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BitSet bitset = new BitSet(33554433);
        StringBuilder answer = new StringBuilder();
        while(st.hasMoreElements()){
            int v = Integer.parseInt(st.nextToken());
            if(!bitset.get(v)){
                bitset.set(v);
                answer.append(v).append(" ");
            }
        }
        System.out.println(answer);
    }
}