package procedure02;

public class RoadToBiodome04 {
    public static void main(String[] args) {
        if (args == null || args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("올바른 값을 입력해주세요.");
            return;
        }

        double[][] result = new double[args.length][2];
        try {
            for(int i=0; i<args.length; i++) {
                String replacesStr = args[i].replace("[", "")
                        .replace(" ", "")
                        .replace("]", "");

                String[] splitedStr = replacesStr.split(",");

                double[] nums = new double[splitedStr.length];
                for(int j=0; j<nums.length; j++) {
                    nums[j] = Double.parseDouble(splitedStr[j]);
                }

                double[] sortedNums = selectionSort(nums);
                result[i][0] = getAvg(sortedNums);
                result[i][1] = getMedian(sortedNums);
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 올바르지 않습니다. 확인 후 다시 입력해 주세요.");
            return;
        }

        // bonus
        if (args.length == 1) {
            String message = String.format("평균값:%s, 중앙값:%s", getNum(result[0][0]), getNum(result[0][1]));
            System.out.println(message);
        } else {
            for(int i=0; i<args.length; i++) {
                System.out.print(result[i][1]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
    private static double[] selectionSort(double[] nums) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    double temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    private static double getAvg(double[] nums) {
        double sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        return sum / nums.length;
    }
    private static double getMedian(double[] nums) {
        int len = nums.length;
        if (len%2 == 0) {
            return (nums[len/2-1] + nums[len/2]) / 2.0;
        }
        return nums[len/2];
    }
    private static String getNum(double num) {
        String str = String.valueOf(num);
        if (str.endsWith(".0")) {
            str = str.replace(".0", "");
        }
        return str;
    }
}
