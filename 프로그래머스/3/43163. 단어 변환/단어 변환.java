import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        
        
        // BFS
        int answer = 0;
        Queue<WordInfo> queue = new LinkedList<>();
        queue.offer(new WordInfo(begin, 0));
        while(!queue.isEmpty()){
            WordInfo cur = queue.poll();
            String std = cur.word;
            int minCount = cur.changeCount;
            
            if(cur.word.equals(target)){
                answer = minCount;
                break;
            }
            
            if(minCount > std.length()) {
                continue;
            }
            
            
            for(int i = 0; i < words.length; i++){
                String cmpWord = words[i];
                int count = 0;
 
                // 단어 비교
                for(int j = 0; j < std.length(); j++){
                    if(std.charAt(j) == cmpWord.charAt(j)) 
                        count++;
                }
                
                if(count == std.length()-1){
                    queue.offer(new WordInfo(cmpWord, minCount+1));
                }         
            }
        }
        
        return answer;
    }
    
    public class WordInfo{
        String word;
        int changeCount;
        
        public WordInfo(String word, int changeCount){
            this.word = word;
            this.changeCount = changeCount;
        }
    }
    
}