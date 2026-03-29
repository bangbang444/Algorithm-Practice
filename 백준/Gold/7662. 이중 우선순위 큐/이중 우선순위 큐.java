import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j = 0; j < k; j++){
                String[] cmd = br.readLine().split(" ");
                String op = cmd[0];
                int n = Integer.parseInt(cmd[1]);

                if(op.equals("I")){
                    insertCmd(n, map);
                }else if(op.equals("D")){
                    deleteCmd(map, n);
                }
            }

            // 후처리
            if(map.isEmpty()){
                answer.append("EMPTY").append("\n");
            }else if(map.size() == 1){
                answer.append(map.firstKey()).append(" ").append(map.firstKey()).append("\n");
            }else{
                answer.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(answer.toString().trim());
    }

    private static void insertCmd(Integer n, TreeMap<Integer, Integer> map) {
        map.put(n, map.getOrDefault(n, 0)+1);
    }

    private static void deleteCmd(TreeMap<Integer, Integer> map, int flag){
        if(map.isEmpty()) return;

        int min = map.firstKey();
        int max = map.lastKey();
        int value = flag == 1 ? max : min;

        int cnt = map.getOrDefault(value, 1);
        if(cnt <= 1){
            map.remove(value);
        }else{
            map.put(value, map.get(value)-1);
        }
    }
}
