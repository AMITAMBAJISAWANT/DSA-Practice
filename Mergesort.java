public class Mergesort {

    public static void mergeSort(int[] nums) {
        
        int n = nums.length;
        if(n<2) return ;
        int mid = n/2;
        
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        
        for(int i = 0; i < mid; i++ )left[i] = nums[i];
        for(int j = mid; j < n; j++)right[j-mid] = nums[j];
        mergeSort(left);
        mergeSort(right);

        merge(nums, left, right);


    }

    public static void merge(int[] nums, int[] left, int[] right) {
        int i =0, j=0, k=0;
         while(i<left.length && j<right.length){
            if(left[i] <= right[j] ){
                nums[k++] = left[i++];
            }
            else{
                nums[k++] = right[j++];

            }
         }
         while(i<left.length)nums[k++] = left[i++];
         while(j<right.length)nums[k++] = right[j++];


    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 6, 3};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
