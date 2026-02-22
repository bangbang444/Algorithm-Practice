class Solution {
    public int[] solution(int n, int m) {
        int n1 = Math.min(n, m);
        int n2 = Math.max(n, m);
        
        return new int[]{GCD(n1,n2), LCM(n1,n2)};
    }
    
    private int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a%b);
    }
    
    private int LCM(int a, int b){
        return a*b/ GCD(a, b);
    }
}