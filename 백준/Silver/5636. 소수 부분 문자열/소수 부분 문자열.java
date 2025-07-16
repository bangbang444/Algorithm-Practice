import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answers = new StringBuilder();


        while(true){
            long maxPrime = 0;
            String numString = br.readLine();
            if(numString.equals("0")) break;

            for(int i = 1; i <= 6; i++){
                for(int j = 0; i + j <= numString.length(); j++){
                    String substring = numString.substring(j, j + i);
                    long num = Long.parseLong(substring);
                    if(num <= 100000 && isPrime(num))
                        maxPrime = Math.max(num, maxPrime);
                }
            }
            answers.append(maxPrime).append('\n');
        }

        System.out.print(answers);
    }

    private static boolean isPrime(long num){
        if(num < 2) return false;
        for(long i = 2; i * i <= num; i++){
            if(num%i == 0){return false;}
        }

        return true;
    }
}
