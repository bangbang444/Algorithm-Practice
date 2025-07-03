import java.util.*;
class Solution {
    static Set<Integer> primes;
    public int solution(String numbers) {
        primes = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        backTracking(0, numbers, visited, "");
        
        return primes.size();
    }
    
    public void backTracking(int stage, String numbers, boolean[] visited, String cur){
        
        if(cur.length() != 0 && stage <= numbers.length()){
            int num = Integer.parseInt(cur);
            if(isPrime(num)){
                System.out.println(num);
                primes.add(num);
            }
        }
        if(stage == numbers.length()) return;
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                backTracking(stage+1, numbers, visited, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i < num/2 + 1; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}