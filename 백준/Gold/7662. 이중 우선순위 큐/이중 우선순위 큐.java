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
                Integer n = Integer.parseInt(cmd[1]);

                if(op.equals("I")){
                    minMap.put(n, minMap.getOrDefault(n, 0)+1);
                    maxMap.put(n, maxMap.getOrDefault(n, 0)+1);
                }else if(op.equals("D")){
                    if(n == 1 && !maxMap.isEmpty()){
                        int max = maxMap.firstKey();

                        int cnt = maxMap.getOrDefault(max, 1);
                        if(cnt <= 1){
                            maxMap.remove(max);
                            minMap.remove(max);
                        }else{
                            maxMap.put(max, maxMap.get(max)-1);
                            minMap.put(max, minMap.get(max)-1);
                        }

                    }else if(n == -1 && !minMap.isEmpty()){
                        int min = minMap.firstKey();

                        int cnt = minMap.getOrDefault(min, 1);
                        if(cnt <= 1){
                            maxMap.remove(min);
                            minMap.remove(min);
                        }else{
                            maxMap.put(min, maxMap.get(min)-1);
                            minMap.put(min, minMap.get(min)-1);
                        }
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
        answer.setLength(answer.length()-1);
        System.out.println(answer);
    }
}