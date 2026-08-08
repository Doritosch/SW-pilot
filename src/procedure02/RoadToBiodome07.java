package procedure02;

public class RoadToBiodome07 {

    private static String[] uniqueAnimals;
    private static int[] counts;
    public static void main(String[] args) {
        if (args == null || args[0].trim().isEmpty()) {
            System.out.println("배열을 입력해주세요.");
            return;
        }

        String str = args[0];
        String replacedStr = str.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String[] animals = replacedStr.split(",");
        counts = new int[animals.length];
        uniqueAnimals = new String[animals.length];

        if (containDigits(animals)) {
            System.out.println("입력값에 숫자가 포함되어 있습니다. 확인 후 다시 입력해 주세요.");
            return;
        }

        int idx = 0;
        for(int i=0; i<animals.length; i++) {
            if (!isContain(uniqueAnimals, animals[i])) {
                uniqueAnimals[idx] = animals[i];
                counts[idx] = getCounts(animals, animals[i]);
                idx += 1;
            }
        }

        bubbleSort(uniqueAnimals, counts, idx);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            if (i > 0) sb.append(", ");
            sb.append(uniqueAnimals[i]);
        }
        System.out.println(sb.toString());
    }
    private static void bubbleSort(String[] arr, int[] freqs, int size) {
        for(int i=0; i<size-1; i++) {
            for(int j=0; j<size-1-i; j++) {
                boolean swap;
                if (freqs[j] == freqs[j+1]) {
                    swap = arr[j].compareTo(arr[j+1]) > 0;
                } else {
                    swap = freqs[j] < freqs[j+1];
                }

                if (swap) {
                    String tempName = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tempName;

                    int tempFreq = freqs[j];
                    freqs[j] = freqs[j+1];
                    freqs[j+1] = tempFreq;
                }
            }
        }
    }
    private static boolean containDigits(String[] arr) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i].matches(".*\\d.*")) {
                return true;
            }
        }
        return false;
    }
    private static boolean isContain(String[] arr, String target) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == null) {
                return false;
            }
            if (arr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }
    private static int getCounts(String[] arr, String target) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if (target.equals(arr[i])) {
                count += 1;
            }
        }
        return count;
    }
}
