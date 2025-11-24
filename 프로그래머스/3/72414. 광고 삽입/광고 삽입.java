class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int pt = strToSec(play_time);
        int at = strToSec(adv_time);
        
        long[] dp = new long[pt+1];
        for(String log : logs){
            String[] logTime = log.split("-");
            int start = strToSec(logTime[0]);
            int end = strToSec(logTime[1]);
            
            dp[start]+=1;
            dp[end]-=1;
        }
        
        for(int i = 1; i <= pt; i++){
            dp[i]+=dp[i-1];
        }
        for(int i = 1; i <= pt; i++){
            dp[i]+=dp[i-1];
        }
        
        int idxAtMax = 0;
        int s = 0;
        int e = at;
        long max = dp[e] - dp[s];
        while(e < dp.length){
            long sum = dp[e] - dp[s];;
            if(max < sum){
                max = sum;
                idxAtMax = s+1;
            }
            s++; e++;
        }
        
        return secToStr(idxAtMax);
    }
    
    public int strToSec(String play_time){
        String[] pt = play_time.split(":");
        int h = Integer.parseInt(pt[0]);
        int m = Integer.parseInt(pt[1]);
        int s = Integer.parseInt(pt[2]);
        
        return h*3600 + m*60 + s;
    }
    
    public String secToStr(int sec){
        String h = String.valueOf(sec/3600);
        sec %= 3600;
        String m = String.valueOf(sec/60);
        sec %= 60;
        String s = String.valueOf(sec);
        
        StringBuilder sb = new StringBuilder();
        if(h.length()==1){
            sb.append("0");
        }
        sb.append(h);
        sb.append(":");
        
        if(m.length()==1){
            sb.append("0");
        }
        sb.append(m);
        sb.append(":");
        
        if(s.length()==1){
            sb.append("0");
        }
        sb.append(s);
        
        return sb.toString();
    }
    
}