import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] std = br.readLine().toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        Set<Character> set = new HashSet<>();
        for(char c : std) set.add(c);
        for (char c : std) map.put(c, map.getOrDefault(c, 0) + 1);

        int similar = 0;
        for(int i = 0; i < N-1; i++){
            char[] comp = br.readLine().toCharArray();
            if(Math.abs(comp.length - std.length) > 1) continue;

            Map<Character, Integer> compMap = new TreeMap<>();
            for(char ch : comp) compMap.put(ch, compMap.getOrDefault(ch,0)+1);

            int diff = 0;
            for (Character c : map.keySet()) {
                diff += Math.abs(map.get(c) - compMap.getOrDefault(c, 0));
            }

            for (Character c : compMap.keySet()) {
                if(!set.contains(c)){
                    diff += compMap.get(c);
                }
            }

            if(diff <= 2){
                similar++;
            }
        }

        System.out.println(similar);
    }
}