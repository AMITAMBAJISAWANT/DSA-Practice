public class ReversePair  {

    public int mergeSort(int[] nums, int left, int right){
        if(left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);
        count += countReversePair(nums, left, mid, right);
        merge(nums, left, mid, right);
        return count;
    }

    public int countReversePair(int[] nums, int left, int mid, int right) {
        int count = 0;
        for (int i = left; i <= mid; i++) {
            int j = mid + 1;
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        return count;
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int t = 0; t < temp.length; t++) {
            nums[left + t] = temp[t];
        }
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    
    public static void main(String[] args) {
        ReversePair sol = new ReversePair();
        int[] nums = {1, 3, 2, 3, 1};
        int result = sol.reversePairs(nums);
        System.out.println("Number of reverse pairs: " + result);
    }
}
