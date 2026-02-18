import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move(map, 0);
        System.out.println(max);
    }

    private static void move(int[][] map, int count){
        if(count >= 5){
            for(int i = 0; i < N; i++){
                int localMax = Arrays.stream(map[i]).max().getAsInt();
                max = Math.max(localMax, max);
            }
            return;
        }

        // 움직임 4번
        move(moveU(map), count+1);
        move(moveD(map), count+1);
        move(moveL(map), count+1);
        move(moveR(map), count+1);
    }

    private static int[][] moveU(int[][] m){
        int[][] map = copyArr(m);
        for(int i = 0; i < N; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            int row = 0;
            while(row < N){
                if(map[row][i] != 0) deque.add(map[row][i]);
                row++;
            }

            int idx = 0;
            while(deque.size() >= 2){
                int e1 = deque.poll();
                int e2 = deque.poll();
                if(e1 == e2){
                    map[idx++][i] = e1*2;
                }else{
                    map[idx++][i] = e1;
                    deque.addFirst(e2);
                }
            }

            if(deque.size() == 1){
                map[idx++][i] = deque.poll();
            }

            while(idx < N){
                map[idx++][i] = 0;
            }
        }
        return map;
    }

    private static int[][] moveD(int[][] m){
        int[][] map = copyArr(m);
        for(int i = 0; i < N; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            int row = N-1;
            while(row >= 0){
                if(map[row][i] != 0) deque.add(map[row][i]);
                row--;
            }
            
            int idx = N-1;
            while(deque.size() >= 2){
                int e1 = deque.poll();
                int e2 = deque.poll();
                if(e1 == e2){
                    map[idx--][i] = e1*2;
                }else{
                    map[idx--][i] = e1;
                    deque.addFirst(e2);
                }
            }

            if(deque.size() == 1){
                map[idx--][i] = deque.poll();
            }

            while(idx >= 0){
                map[idx--][i] = 0;
            }
        }
        return map;
    }

    private static int[][] moveL(int[][] m){
        int[][] map = copyArr(m);
        for(int i = 0; i < N; i++){
            Deque<Integer> deque = new ArrayDeque<>();
            for(int e : map[i]){
                if(e != 0) deque.add(e);
            }

            int idx = 0;
            while(deque.size() >= 2){
                int e1 = deque.poll();
                int e2 = deque.poll();
                if(e1 == e2){
                    map[i][idx++] = e1*2;
                }else{
                    map[i][idx++] = e1;
                    deque.addFirst(e2);
                }
            }

            if(deque.size() == 1){
                map[i][idx++] = deque.poll();
            }

            while(idx < N){
                map[i][idx++] = 0;
            }
        }
        return map;
    }

    private static int[][] moveR(int[][] m){
        int[][] map = copyArr(m);
        for(int i = 0; i < N; i++){

            Deque<Integer> deque = new ArrayDeque<>();
            for(int j = N-1; j >= 0; j--){
                if(map[i][j] != 0) deque.add(map[i][j]);
            }

            int idx = N-1;
            while(deque.size() >= 2){
                int e1 = deque.poll();
                int e2 = deque.poll();
                if(e1 == e2){
                    map[i][idx--] = e1*2;
                }else{
                    map[i][idx--] = e1;
                    deque.addFirst(e2);
                }
            }

            if(deque.size() == 1){
                map[i][idx--] = deque.poll();
            }

            while(idx >= 0){
                map[i][idx--] = 0;
            }
        }
        return map;
    }

    private static int[][] copyArr(int[][] arr){
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return map;
    }
}
