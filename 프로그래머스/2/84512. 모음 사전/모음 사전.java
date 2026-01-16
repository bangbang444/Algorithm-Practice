class Solution {
    public int solution(String word) {
        int[] target = new int[5];
        int idx = 0;
        for(char ch : word.toCharArray()){
            if(ch == 'A') target[idx] = 1;
            else if(ch == 'E') target[idx] = 2;
            else if(ch == 'I') target[idx] = 3;
            else if(ch == 'O') target[idx] = 4;
            else if(ch == 'U') target[idx] = 5;
            idx++;
        }
        
        int[] nums = new int[5];
        idx = 0;
        nums[0] = 1;
        int zero = 4;
        int count = 1;
        while(true){
            if(equalsArr(nums, target)){
                break;
            }
            
            if(nums[idx] != 0 && zero != 0){
                ++idx;
                nums[idx] = 1;
                zero--;
                count++;
                continue;
            }
            
            if(nums[idx] <= 5){
                nums[idx] += 1;
                count++;
            }
            
            while(nums[idx] > 5){
                nums[idx] = 0;
                zero++;
                if(idx - 1 >= 0){
                    idx--;
                    nums[idx]++;
                }
            }
        }
        
        return count;
    }
    
    private boolean equalsArr(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}