import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        int L = A.length;
        for(int i = 0; i < L; i++){
            sum += A[i] * B[L-i-1];
        }
        
        return sum;
    }
}