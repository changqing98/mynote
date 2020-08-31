public class FirstUniqChar {

    public static char firstUniqChar(String s) {
        if(s==null || s.length() ==0){
            return ' ';
        }
        int[] count = new int[256];
        var array = s.toCharArray();
        int flag = 0;
        for(int i=0; i<array.length;i++){
            count[array[i]] = ++count[array[i]];
            if(count[array[i]]>=2 && array[i] == array[flag]){
                while(flag < array.length && count[array[flag]] >= 2){
                    flag++;
                }
                if(flag == array.length){
                    return ' ';
                }
            }
        }
        return array[flag];
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
    }
}
