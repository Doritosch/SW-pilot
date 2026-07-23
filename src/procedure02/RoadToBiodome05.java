package procedure02;

public class RoadToBiodome05 {
    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("입력값이 없습니다. 입력해주세요.");
            return;
        }

        try {
            String[] splitedStr = parseAndSplit(args[0]);
            int[] nums1 = getIntegerArray(splitedStr);

            String[] splitedStr2 = parseAndSplit(args[1]);
            int[] nums2 = getIntegerArray(splitedStr2);

            int[] nums = new int[splitedStr.length + splitedStr2.length];
            for(int i=0; i<nums1.length; i++) {
                nums[i] = nums1[i];
            }
            for(int i=0; i<nums2.length; i++) {
                nums[nums1.length+i] = nums2[i];
            }

            quickSort(nums, 0, nums.length-1); // 분할 깊이 - log n, 각 단계에서 n번 비교 -> O(NlogN)
            //bubbleSort(nums); // O(N^2)

            for(int i=0; i<nums.length; i++) {
                if (i==0) System.out.print("[");
                System.out.print(nums[i]);
                if (i < nums.length-1) System.out.print(",");
                if (i == nums.length-1) System.out.println("]");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다. 확인 후 다시 입력해 주세요.");
            return;
        }
    }
    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for(int j=left; j<right; j++) {
            if (nums[j] <= pivot) {
                i += 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i+1];
        nums[i+1] = nums[right];
        nums[right] = temp;
        return i+1;
    }
    private static int[] bubbleSort(int[] nums) {
        for(int i=0; i<nums.length - 1; i++) {
            for(int j=0; j<nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
    private static String[] parseAndSplit(String str) {
        String replacedStr = str.replace("[", "")
                .replace(" ", "")
                .replace("]", "");
        return replacedStr.split(",");
    }
    private static int[] getIntegerArray(String[] arr) {
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }
}
