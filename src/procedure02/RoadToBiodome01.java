package procedure02;

import java.util.ArrayList;
import java.util.List;

public class RoadToBiodome01  {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력값이 없습니다. 입력해주세요.");
            return;
        }

        String str = "";
        for(int i=0; i<args.length; i++) {
            str += args[i] + " ";
        }

        str = str.replace("[", "").replace("]", "").replace(",", "");
        String[] strings = str.split(" ");
        List<Integer> inputList = new ArrayList<>();
        for(int i=0; i< strings.length; i++) {
            int num;
            try {
                num = Integer.parseInt(strings[i]);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                return;
            }
            if (num < 0 || num > 1000) {
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }
            inputList.add(num);
        }

        int[] counted = countOccurrences(inputList);
        for(int i=0; i<counted.length; i++) {
            if (counted[i] == 1) {
                System.out.println(i);
            }
        }

        // bonus
        int k = 0;
        for(int i=0; i<counted.length; i++) {
            if (counted[i] > k) {
                k = counted[i];
            }
        }
        for(int i=0; i<counted.length; i++) {
            if (counted[i] != 0 && counted[i] % k != 0) {
                System.out.println(i);
            }
        }
    }
    private static int[] countOccurrences(List<Integer> inputs) {
        int[] counts = new int[1001];
        for(int i=0; i<inputs.size(); i++) {
            counts[inputs.get(i)] += 1;
        }
        return counts;
    }
}
