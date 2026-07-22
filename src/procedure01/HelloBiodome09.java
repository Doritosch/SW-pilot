package procedure01;

public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("나무의 높이를 입력해주세요.");
            return;
        }

        int len;
        char ch;
        try {
            len = Integer.parseInt(args[0]);
            ch = args[1].charAt(0);
        } catch (NumberFormatException e) {
            System.out.println("높이는 숫자를 입력해주세요.");
            return;
        }

        if (len < 3 || len > 100) {
            System.out.println("나무의 높이는 최소 3, 최대 100입니다.");
            return;
        }

        drawTree(len, ch);
    }
    private static void drawTree(int n, char ch) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }
            for(int j=0; j<i*2+1; j++) {
                if (j == (i*2+1)/2) {
                    System.out.print(ch);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for(int i=0; i<n-1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
}
