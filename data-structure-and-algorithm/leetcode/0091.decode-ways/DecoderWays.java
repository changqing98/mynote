public class DecoderWays {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int[] result = new int[s.length()];
        result[0] = 1;
        int fst = s.charAt(0) - '0';
        int sec = s.charAt(1) - '0';
        int sum = fst * 10 + sec;
        if(sum >= 10 && sum <= 26){
            result[1] = 2;
        } else if(sum % 10 == 0){
            return 0;
        } else {
            result[1] = 1;
        }
        
        for(int i = 2; i < s.length(); i++){
            fst = s.charAt(i-1) - '0';
            sec = s.charAt(i) - '0';
            sum = fst * 10 + sec;
            if(sum >= 10 && sum <= 26){
                result[i] = result[i-1] + result[i-2];
            } else if(sum % 10 == 0){
                return 0;
            } else {
                result[i] = result[i - 1];
            }
        }
        return result[s.length()-1];
    }
}
