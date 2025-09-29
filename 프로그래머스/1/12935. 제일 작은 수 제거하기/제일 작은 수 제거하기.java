import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        if(length <= 1) return new int[]{-1};
        
        int min = Arrays.stream(arr).min().getAsInt();
        int[] newArr = new int[length-1];
        
        int idx = 0;
        for(int i : arr){
            if(i != min)
                newArr[idx++] = i;
        }
        
        
        return newArr;
    }
}