import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

// 0 빈칸, 1 벽
// 승객 태우면 연료 2배됨
// 한 칸 이동 시 연료 1 소모
// 거리, 행 번호, 열 번호 순으로 우선순위
public class Main {
    static int N, M, G;
    static int[][] map;
    static boolean[][] visited;
    static Map<Point, Point> works = new HashMap<>();

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵 N*N
        M = Integer.parseInt(st.nextToken()); // 승객 수
        G = Integer.parseInt(st.nextToken()); // 초기 연료

        // 맵
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 운전 시작 칸의 행, 열 번호
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;

        // 승객, 목적지
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken())-1;
            int startY = Integer.parseInt(st.nextToken())-1;
            int destX = Integer.parseInt(st.nextToken())-1;
            int destY = Integer.parseInt(st.nextToken())-1;

            works.put(new Point(startX, startY), new Point(destX, destY));
        }

        int success = 0;
        int startX = x, startY = y;
        int remainedFuel = G;
        while(success < M){

            //System.out.println(startX + " " + startY);
            int[] passenger = findPassenger(startX, startY, remainedFuel); // 승객 좌표가 반환
            if(passenger == null){
                System.out.println(-1);
                return;
            }

            int[] result = goToDestination(passenger[0], passenger[1], passenger[2]);

            if(result == null){
                System.out.println(-1);
                return;
            }
            //System.out.println(result[0] + " " + result[1]);
            startX = result[0];
            startY = result[1];
            remainedFuel = result[2];

            success++;
        }

        System.out.println(remainedFuel);
    }

    public static int[] findPassenger(int sx, int sy, int fuel){
        if(works.get(new Point(sx, sy)) != null) return new int[]{sx,sy,fuel};
        boolean[][] isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            isVisited[i] = Arrays.copyOf(visited[i], N);
        }

        List<int []> list = new ArrayList<>();
        int std = -1;
        Queue<Taxi> queue = new LinkedList<>();
        queue.offer(new Taxi(sx, sy, 0));
        isVisited[sx][sy] = true;

        while(!queue.isEmpty()){
            Taxi cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX >= 0 && newX < N && newY >=0 && newY < N
                    && !isVisited[newX][newY] && map[newX][newY] == 0){
                    isVisited[newX][newY] = true;

                    //if(fuel-1 <= 0) return null;

                    if(works.get(new Point(newX,newY)) != null && (std == -1 || cur.fuel == std)){ // std는 처음 승객 찾았을 때와 거리에 맞는 승객들만 찾으려고 할 때
                        std = cur.fuel;
                        //System.out.println("start: " + fuel + " " + (cur.fuel+1) + " = " + (fuel-cur.fuel-1));
                        if(fuel-cur.fuel-1 <= 0) continue;
                        list.add(new int[]{newX, newY, fuel-cur.fuel-1});
                    }

                    queue.offer(new Taxi(newX, newY, cur.fuel + 1));
                }
            }
        }

        list.sort((a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        //System.out.println(list.get(0)[0] + " " + list.get(0)[1] + " " + list.get(0)[2]);

        return list.isEmpty() ? null : list.get(0);
    }

    public static int[] goToDestination(int sx, int sy, int fuel){
        Point point = works.get(new Point(sx, sy));
        if(sx == point.x && sy == point.y) return new int[]{sx, sy, fuel};

        boolean[][] isVisited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            isVisited[i] = Arrays.copyOf(visited[i], N);
        }

        if(sx == point.x && sy == point.y){
            return new int[]{sx, sy, fuel};
        }

        Queue<Taxi> queue = new LinkedList<>();
        queue.offer(new Taxi(sx, sy, 0));
        isVisited[sx][sy] = true;

        while(!queue.isEmpty()){
            Taxi cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX >= 0 && newX < N && newY >=0 && newY < N
                        && !isVisited[newX][newY] && map[newX][newY] != 1){
                    isVisited[newX][newY] = true;

                    if(newX == point.x && newY == point.y && fuel-cur.fuel-1 >= 0){
                        cur.fuel++;
                        //System.out.println("des: " + " " + fuel + " " + (cur.fuel) + "= " + (fuel+cur.fuel));
                        works.remove(new Point(sx,sy));
                        return new int[]{newX, newY, (fuel+cur.fuel)};
                    }

                    queue.offer(new Taxi(newX, newY, cur.fuel + 1));
                }
            }
        }

        return null;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }

    static class Taxi{
        int x;
        int y;
        int fuel;
        public Taxi(int x, int y, int fuel){
            this.x = x;
            this.y = y;
            this.fuel = fuel;
        }
    }
}
