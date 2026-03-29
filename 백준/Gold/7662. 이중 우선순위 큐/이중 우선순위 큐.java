import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> minMap = new TreeMap<>();
            TreeMap<Integer, Integer> maxMap = new TreeMap<>(Collections.reverseOrder());
            for(int j = 0; j < k; j++){
                String[] cmd = br.readLine().split(" ");
                String op = cmd[0];
                int n = Integer.parseInt(cmd[1]);

                if(op.equals("I")){
                    insertCmd(n, minMap, maxMap);
                }else if(op.equals("D")){
                    if(n == 1 && !maxMap.isEmpty()){
                        deleteCmd(maxMap, minMap);
                    }else if(n == -1 && !minMap.isEmpty()){
                        deleteCmd(minMap, maxMap);
                    }
                }
            }

            // 후처리
            if(maxMap.isEmpty()){
                answer.append("EMPTY").append("\n");
            }else if(maxMap.size() == 1){
                answer.append(maxMap.firstKey()).append(" ").append(maxMap.firstKey()).append("\n");
            }else{
                answer.append(maxMap.firstKey()).append(" ").append(minMap.firstKey()).append("\n");
            }
        }

        System.out.println(answer.toString().trim());
    }

    private static void insertCmd(Integer n, TreeMap<Integer, Integer> minMap, TreeMap<Integer, Integer> maxMap) {
        minMap.put(n, minMap.getOrDefault(n, 0)+1);
        maxMap.put(n, maxMap.getOrDefault(n, 0)+1);
    }

    private static void deleteCmd(TreeMap<Integer, Integer> stdMap, TreeMap<Integer, Integer> sideMap){
        int value = stdMap.firstKey();

        int cnt = stdMap.getOrDefault(value, 1);
        if(cnt <= 1){
            stdMap.remove(value);
            sideMap.remove(value);
        }else{
            stdMap.put(value, stdMap.get(value)-1);
            sideMap.put(value, sideMap.get(value)-1);
        }
    }
}