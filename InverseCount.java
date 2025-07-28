public class InverseCount {
       
        public static int mergeSort(int[] arr, int left, int right) {
            if (left >= right) return 0;;
    
            int mid = left + (right - left) / 2;
            int count  = 0;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
             return count ;
        }
    
        public static int merge(int[] arr, int left, int mid, int right) {
            int i = left;
            int j = mid + 1;
            int k = 0;
            int[] temp = new int[right - left + 1];
            int count = 0;
    
            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                    count += (mid - i + 1); 
                
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
        return count ;
    }
    public static void main(String[] args) {
        int [] nums1 = {3, 1, 2, 4};
        int count ;
        count = mergeSort(nums1, 0, nums1.length - 1);
        System.out.println(count);
        
     
}
}