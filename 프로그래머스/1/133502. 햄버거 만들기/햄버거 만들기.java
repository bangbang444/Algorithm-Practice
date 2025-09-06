import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        int[] arrStack = new int[ingredient.length+1];
        int top = 0;
        int count = 0;
        
        for(int i : ingredient){
            
            arrStack[top] = i;
            if(arrStack[top] == 1 && top >= 3){
                if(arrStack[top-1] == 3 &&
                  arrStack[top-2] == 2 &&
                  arrStack[top-3] == 1){
                    count++;
                    top-=4;
                }
            }
            top++;
            
            
        }
        
        return count;
    }
}