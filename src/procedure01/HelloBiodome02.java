package procedure01;

public class HelloBiodome02 {
    private static final int MIN_PRODUCTION = 0;
    private static final int MAX_PRODUCTION = 30000;
    public static void main(String[] args) {
        int solar = 0;
        int wind = 0;
        int earth = 0;
        if (args.length == 0) {
            System.out.print("에너지 생산량을 입력해주세요.");
            return;
        }

        try {
            solar = Integer.parseInt(args[0]);
            wind = Integer.parseInt(args[1]);
            earth = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.print("숫자를 입력해주세요.");
            return;
        }

        if (!isValid(solar) || !isValid(wind) || !isValid(earth)) {
            System.out.print("에너지 생산량은 0 이상 30,000 이하로 입력해주세요.");
            return;
        }

        int sum = solar + wind + earth;
        String message = String.format("총 에너지 사용량은 " + sum + "입니다.");
        System.out.println(message);

        double solarPercent = (double) solar / sum * 100;
        double windPercent = (double) wind / sum * 100;
        double earthPercent = (double) earth / sum * 100;
        String message2 = String.format("태양광 %.9f%%, 풍력 %.9f%%, 지열 %.9f%%", solarPercent, windPercent, earthPercent);
        System.out.print(message2);
    }
    private static boolean isValid(int p) {
        if (MIN_PRODUCTION > p || p > MAX_PRODUCTION) {
            return false;
        }
        return true;
    }
}
