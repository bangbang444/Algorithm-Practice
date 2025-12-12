import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] origin = br.readLine().toCharArray();
        Arrays.sort(origin);

        Map<Character, Integer> map = new HashMap<>();
        for (char c : origin) {
            map.merge(c, 1, Integer::sum);
        }

        int isOdd = 0;
        char rest = ' ';
        int restCount = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();

            if(value%2 == 1){
                isOdd++;
                rest = entry.getKey();
                restCount = value;
            }

            if(isOdd > 1){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        int start = 0, end = origin.length-1;
        int count = 0;
        char[] preAns = new char[origin.length];
        while(count < origin.length){
            char input = origin[count];
            if(rest == input && restCount == 1){
                count++;
                continue;
            }

            if(rest == input){
                restCount--;
            }


            if(count%2 == 0){
                preAns[start++] = input;
            }else{
                preAns[end--] = input;
            }
            count++;
        }

        if(rest != ' '){
            preAns[origin.length/2] = rest;
        }


        StringBuilder answer = new StringBuilder();
        for (char c : preAns) {
            answer.append(c);
        }
        System.out.println(answer);

    }
}
