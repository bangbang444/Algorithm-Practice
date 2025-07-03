class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 문자열 시간 -> 정수형 시간
        final int playSec = strToInt(play_time);
        final int advSec = strToInt(adv_time);
        
        long[] delta = new long[playSec+1];
        for(String log : logs){
            String[] split = log.split("-");
            final int startSec = strToInt(split[0]);
            final int endSec = strToInt(split[1]);
            // 시작/종료 시간에 +1 기록
            delta[startSec]++;
            delta[endSec]--;
        }
        
        for(int i = 1; i < delta.length; i++){
            delta[i] = delta[i-1] + delta[i];
        }
        
        for(int i = 1; i < delta.length; i++){
            delta[i] = delta[i-1] + delta[i];
        }
        
        //✅ DP테이블을 순회하며 광고 시간동안 누적 시청자 수가 가장 많은 구간을 구한다.
        int startTime = 0;
        long maxTime = delta[advSec-1];
        for (int i = 0; i < playSec-advSec+1; i++) {
            if (maxTime < delta[i+advSec] - delta[i]) {
                maxTime = delta[i+advSec] - delta[i];
                startTime = i + 1;
            }
        }
        return intToStr(startTime);
        
    }
    
    int strToInt(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2]);
        return 3600*hour + 60*minute + second;
    }
    
    String intToStr(int s){
        String sec = String.valueOf(s % 60);
        if(sec.length() == 1) sec = "0" + sec;
        s /= 60;
        String minute = String.valueOf(s % 60);
        if(minute.length() == 1) minute = "0" + minute;
        s /= 60;
        String hour = String.valueOf(s);
        if(hour.length() == 1) hour = "0" + hour;
        return hour + ":" + minute + ":" + sec;
    }
}