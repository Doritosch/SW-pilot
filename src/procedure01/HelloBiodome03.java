package procedure01;

public class HelloBiodome03 {
    private static final double BIONETTI_COEFFICIENT = 0.415;
    private static final double PIE = 3.14;
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.print("온도, 습도, 산소 농도 값을 입력해주세요.");
            return;
        }
        double temperature = 0.0;
        double humidity = 0.0;
        double oxygen = 0.0;

        try {
            temperature = Double.parseDouble(args[0]);
            humidity = Double.parseDouble(args[1]);
            oxygen = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.print("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요.");
            return;
        }

        double H = getTree(temperature, humidity, oxygen);
        String message = String.format("생명지수 = %.3f", H);
        System.out.println(message);
    }
    private static double getRoot(double h) {
        if (h == 0) {
            return 0;
        }
        return getRootHelper(h, h / 2.0);
    }
    private static double getRootHelper(double h, double guess) {
        double n = (guess + h / guess) / 2;
        double diff = n * n - h;
        if (diff < 0) {
            diff = -diff;
        }
        if (diff < 1e-10) {
            return n;
        }
        return getRootHelper(h, n);
    }
    private static double getAbs(double t) {
        if (t < 0) {
            return -t;
        }
        return t;
    }
    private static double getTree(double t, double h, double o) {
        return BIONETTI_COEFFICIENT *getAbs(getRoot(h) - t) + (o / (PIE*PIE));
    }
}
