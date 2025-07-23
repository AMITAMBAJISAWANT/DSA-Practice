public class CountRangeSum {
    int count = 0;

    public void mergeSort(long[] preFix, int lower, int upper, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSort(preFix, lower, upper, left, mid);
        mergeSort(preFix, lower, upper, mid + 1, right);
        merge(preFix, lower, upper, left, mid, right);
    }

    public int merge(long[] preFix, int lower, int upper, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int start = mid + 1, end = mid + 1;

        while (i <= mid) {
            while (start <= right && preFix[start] < preFix[i] + lower) start++;
            while (end <= right && preFix[end] <= preFix[i] + upper) end++;
            count += end - start;
            i++;
        }

        long[] temp = new long[right - left + 1];
        i = left;
        j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (preFix[i] <= preFix[j]) {
                temp[k++] = preFix[i++];
            } else {
                temp[k++] = preFix[j++];
            }
        }

        while (i <= mid) temp[k++] = preFix[i++];
        while (j <= right) temp[k++] = preFix[j++];

        for (int t = 0; t < temp.length; t++) {
            preFix[left + t] = temp[t];
        }

        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preFix = new long[nums.length + 1];
        preFix[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preFix[i + 1] = preFix[i] + nums[i];
        }
        mergeSort(preFix, lower, upper,0, preFix.length - 1);
        return count;
    }

    
    public static void main(String[] args) {
        CountRangeSum sol = new CountRangeSum();
        int[] nums = {-2, 5, -1};  
        int lower = -2;
        int upper = 2;

        int result = sol.countRangeSum(nums, lower, upper);
        System.out.println("Count of range sums: " + result);
    }
}

