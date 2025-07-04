import java.util.*;
class Solution {
    Set<Integer> primes;
    public int solution(String numbers) {
        primes = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        
        backTracking(numbers, visited, "");
        
        return primes.size();
    }
    
    public void backTracking(String numbers, boolean[] visited, String cur){
        
        if(cur.length() != 0){
            if(isPrime(Integer.parseInt(cur))) 
                primes.add(Integer.parseInt(cur));
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                backTracking(numbers, visited, cur+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i < num/2+1; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
    
}