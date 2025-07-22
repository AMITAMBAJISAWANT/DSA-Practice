import java.util.*;

class CountSmaller {

    public static Map<Integer, Integer> mergeSort(int[] nums, int left, int right, Map<Integer, Integer> map) {
        if (left >= right) return map;
        int mid = left + (right - left) / 2;
        map = mergeSort(nums, left, mid, map);
        map = mergeSort(nums, mid + 1, right, map);
        map = merge(nums, left, mid, right, map);
        return map;
    }

    public static Map<Integer, Integer> merge(int nums[], int left, int mid, int right, Map<Integer, Integer> map) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + (right - j + 1));
                i++;
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int t = 0; t < temp.length; t++) {
            nums[left + t] = temp[t];
        }

        return map;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>(n);
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add(0);
            return list;
        }
        map = mergeSort(nums, 0, n - 1, map);
        for (int i = 0; i < n; i++) {
            list.add(map.getOrDefault(nums[i], 0));
        }
        return list;
    }

    public static void main(String[] args) {
        CountSmaller sol = new CountSmaller();
        int[] nums = {8, 5, 2, 7};  
        List<Integer> result = sol.countSmaller(nums);
        System.out.println(result);  
    }
}
