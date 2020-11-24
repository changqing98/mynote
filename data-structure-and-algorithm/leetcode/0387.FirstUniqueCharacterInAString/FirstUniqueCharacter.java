public class FirstUniqueCharacter{
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a'] += 1;
        }
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(count[c - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}