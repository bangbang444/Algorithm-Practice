class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] arr = new int[(int)right-(int)left+1];
        long idx = left;
        int seq = 0;
        
        while(idx <= right){
            long row = idx/n;
            long col = idx%n;
            
            arr[seq++] = (int)Math.max(row+1, col+1);
            idx++;
        }
        
        return arr;
    }
    
    
    
}