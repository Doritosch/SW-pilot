package procedure01;

public class HelloBiodome06 {
    private static String c1;
    private static String c2;
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("두 개의 유전자 코드를 입력해주세요.");
            return;
        }

        c1 = args[0];
        c2 = args[1];
        if (!isValidCode(c1) ||
                !isValidCode(c2)) {
            System.out.println("유전자 코드는 5자 이상 20자 이하로 입력해주세요.");
            return;
        }

        if (isMatchLength(c1, c2) &&
                isMatchCode(c1, c2)) {
            System.out.println("동일한 유전자 코드입니다.");
        } else {
            System.out.println("일치하지 않습니다.");

            if (isContained(c1, c2)) {
                System.out.println("부분적으로 포함됩니다.");
            } else {
                System.out.println("포함되지 않습니다.");
            }
        }
    }
    private static boolean isValidCode(String c) {
        int len = c.length();
        if (len >= 5 && len <= 20) {
            return true;
        }
        return false;
    }
    private static boolean isMatchLength(String c1, String c2) {
        if (c1.length() == c2.length()) {
            return true;
        }
        return false;
    }
    private static boolean isMatchCode(String c1, String c2) {
        int i = 0;
        while(true) {
            if (i >= c1.length()) {
                break;
            }
            char nuc1 = c1.charAt(i);
            char nuc2 = c2.charAt(i);

            if (nuc1 != nuc2) {
                return false;
            }
            i += 1;
        }
        return true;
    }
    private static boolean isContained(String c1, String c2) {
        if (c1.length() < c2.length()) {
            int i = 0;
            while(i <= c2.length() - c1.length()) {
                boolean contain = true;
                int j = 0;
                while(j < c1.length()) {
                    if (c1.charAt(j) != c2.charAt(j+i)) {
                        contain = false;
                        break;
                    }
                    j += 1;
                }
                if (contain) {
                    return true;
                }
                i += 1;
            }
        }
        return false;
    }
}
