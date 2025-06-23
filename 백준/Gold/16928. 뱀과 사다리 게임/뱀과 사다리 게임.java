import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { 
    static int N, M;
    static boolean[] visited;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new boolean[101];
        map = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 사다리
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        // 뱀
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.put(u, v);
        }

        // 사다리 타기 시작
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            int num = cur.number;
            if(num == 100){
                answer = cur.count;
                break;
            }

            for(int i = 1; i <= 6; i++) {

                for (Integer key : map.keySet()) {
                    Integer des = num + i == key ? map.get(key) : num + i;
                    if(map.containsKey(des)) continue;
                    if(des <= 100 && !visited[des]) {
                        visited[des] = true;
                        queue.add(new Node(des, cur.count + 1));
                    }
                }

            }
        }

        System.out.println(answer);


    }

    static class Node{
        int number;
        int count;
        public Node(int number, int count){
            this.number = number;
            this.count = count;
        }
    }

}
