import java.util.HashSet;

public class IsStraight{

    public boolean isStraight(int[] nums) {
		var result = new HashSet<>();
		int min = 14;
		int max = 0;
		for (int num : nums) {
			if(num == 0){
				continue;
			}
			max = Math.max(num, max);
			min = Math.min(num, min);
			if(result.contains(num)){
				return false;
			}
			result.add(num);
		}
		return max - min < 5;
    }

	public static void main(String[] args) {
		var test = new IsStraight();
		System.out.println(test.isStraight(new int[]{1,2,3,4,5}));
	}
}
