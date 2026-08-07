package procedure02;

public class RoadToBiodome06 {
    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("배열 두개가 주어지지 않았습니다. 입력해주세요.");
            return;
        }

        try {
            String[] splitedStr = parseAndSplit(args[0]);
            double[] nums1 = getIntegerArray(splitedStr);

            String[] splitedStr2 = parseAndSplit(args[1]);
            double[] nums2 = getIntegerArray(splitedStr2);

            int n = nums1.length;
            int m = nums2.length;

            double[] nums = new double[n+m];
            for(int i=0; i<n; i++) {
                nums[i] = nums1[i];
            }
            for(int i=0; i<m; i++) {
                nums[n+i] = nums2[i];
            }

            quickSort(nums, 0, nums.length-1);
            double avg = getAverage(nums);
            double median = getMedian(nums);
            String message = String.format("평균값:%.1f, 중앙값:%.1f", avg, median);
            System.out.println(message);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다. 확인 후 다시 입력해 주세요.");
        }
    }
    private static void quickSort(double[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }
    private static int partition(double[] nums, int left, int right) {
        double pivot = nums[right];
        int i = left - 1;

        for(int j=left; j<right; j++) {
            if (nums[j] <= pivot) {
                i += 1;
                double temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        double temp = nums[i+1];
        nums[i+1] = nums[right];
        nums[right] = temp;
        return i+1;
    }
    private static double getAverage(double[] arr) {
        double sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
    private static double getMedian(double[] arr) {
        int n = arr.length;
        if (n%2 == 0) {
            return (arr[n/2-1] + arr[n/2]) / 2.0;
        }
        return arr[n/2];
    }
    private static String[] parseAndSplit(String str) {
        String replacedStr = str.replace("[", "")
                .replace(" ", "")
                .replace("]", "");
        return replacedStr.split(",");
    }
    private static double[] getIntegerArray(String[] arr) {
        double[] nums = new double[arr.length];
        for(int i=0; i<arr.length; i++) {
            nums[i] = Double.parseDouble(arr[i]);
        }
        return nums;
    }
}
