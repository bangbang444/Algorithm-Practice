import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        StringBuilder answer = new StringBuilder();
        // 닉네임, 인원들
        Map<String, List<String[]>> map = new LinkedHashMap<>();
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            boolean enter = false;
            for(String host : map.keySet()){
                List<String[]> list = map.get(host);
                if(list.size() >= m) continue;

                int hostLv = Integer.parseInt(list.get(0)[0]);
                if(hostLv-10 <= l && hostLv+10 >= l){
                    map.get(host).add(new String[]{String.valueOf(l), n});
                    enter = true;
                }

                if(enter) break;
            }

            if(!enter){
                map.put(n, new ArrayList<>());
                map.get(n).add(new String[]{String.valueOf(l), n});
            }
        }

        for (List<String[]> list : map.values()) {
            Collections.sort(list, (a, b) -> a[1].compareTo(b[1]));
            if(list.size() == m){
                answer.append("Started!\n");
            }else{
                answer.append("Waiting!\n");
            }
            for (String[] e : list) {
                answer.append(e[0]).append(" ").append(e[1]).append("\n");
            }
        }

        answer.setLength(answer.length()-1);
        System.out.println(answer);
    }
}
