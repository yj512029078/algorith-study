import java.util.Arrays;

public class Interview1_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {3, 2, 1, 5, 6, 4};
//		int k = 2;
		
		int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;
		int result = findKthElement(nums, k);
		System.out.println("result: " + result);
	}
	
	private static int findKthElement(int[] nums, int k) {
		if(nums == null) {
			throw new RuntimeException("invalid input, nums");
		}
		
		int length = nums.length;
		if(k >= length) {
			throw new RuntimeException("invalid input, k");
		}
		
		nums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		
//		Integer[] nums2;
//		Arrays.sort(nums2, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2 - o1;
//			}
//		});
		
//		Collections.sort(list, new Comparator<T>() {
//			
//		});
		
//		for(int i = 0; i < nums.length; i++) {
//			if(i == (length - k)) {
//				result = nums[i];
//				break;
//			}
//		}
		
		return nums[length - k];
	}

}
