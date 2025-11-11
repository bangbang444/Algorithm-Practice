import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(findBrother(N, K));
    }

    public static int findBrother(int N, int K){
        Queue<Sister> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.offer(new Sister(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Sister cur = queue.poll();
            int pos = cur.pos;
            int sec = cur.sec;

            if(pos == K){
                return sec;
            }

            if(pos+1 <= 100000 && !visited[pos+1]) {
                visited[pos+1] = true;
                queue.offer(new Sister(pos+1, sec+1));
            }
            if(pos-1 >= 0 && !visited[pos-1]){
                visited[pos-1] = true;
                queue.offer(new Sister(pos-1, sec+1));
            }
            if(pos*2 <= 100000 && !visited[pos*2]){
                visited[pos*2] = true;
                queue.offer(new Sister(pos * 2,sec+1));
            }

        }

        return -1;
    }

    static class Sister{
        int pos;
        int sec;
        public Sister(int pos, int sec){
            this.pos = pos;
            this.sec = sec;
        }
    }
}
