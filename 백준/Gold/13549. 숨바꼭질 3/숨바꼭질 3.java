import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[100001];

        Deque<Position> queue = new ArrayDeque<>();
        queue.add(new Position(N, 0));
        isVisited[N] = true;
        int answer = -1;
        while(!queue.isEmpty()){
            Position cur = queue.poll();
            if(cur.pos == K){
                answer = cur.second;
                break;
            }



            if(cur.pos-1 >= 0 && !isVisited[cur.pos-1]){
                isVisited[cur.pos+-1] = true;
                queue.add(new Position(cur.pos-1, cur.second+1));
            }
            if(cur.pos*2 <= 100000 && !isVisited[cur.pos*2]){
                isVisited[cur.pos*2] = true;
                queue.add(new Position(cur.pos*2, cur.second));
            }
            if(cur.pos + 1 <= 100000 && !isVisited[cur.pos+1]){
                isVisited[cur.pos+1] = true;
                queue.add(new Position(cur.pos+1, cur.second+1));
            }


        }
        System.out.println(answer);

    }

    static class Position{
        int pos;
        int second;
        public Position(int pos, int second){
            this.pos = pos;
            this.second = second;
        }
    }
}