package procedure01;

public class HelloBiodome04 {
    private double temperature;
    private double humidity;
    private double oxygen;
    private static final double BIONETTI_COEFFICIENT = 0.415;
    private static final double PIE = 3.14;
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("온도, 습도, 산소 농도를 입력해주세요.");
            return;
        }
        if (args.length != 3) {
            System.out.println("온도, 습도, 산소 농도 3개의 입력값이 필요합니다.");
            return;
        }

        HelloBiodome04 biodome = new HelloBiodome04();
        try {
            biodome.temperature = Double.parseDouble(args[0]);
            biodome.humidity = Double.parseDouble(args[1]);
            biodome.oxygen = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력값을 입력하셨습니다.");
            return;
        }

        if (!isValidTemperature(biodome.temperature)) {
            System.out.println("온도값이 정상 범위를 벗어났습니다.");
            return;
        }
        if (!isValidHumidity(biodome.humidity)) {
            System.out.println("습도값이 정상 범위를 벗어났습니다.");
            return;
        }
        if (!isValidOxygen(biodome.oxygen)) {
            System.out.println("산소 농도값이 정상 범위를 벗어났습니다.");
            return;
        }

        System.out.println("생명의 나무는 안정적인 상태입니다.");

        double H = getTree(biodome.temperature, biodome.humidity, biodome.oxygen);
        String message = String.format("건강지수는 %.2f입니다.", H);
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
    private static boolean isValidTemperature(double t) {
        if (t >= 10 && t < 27.5) {
            return true;
        }
        return false;
    }
    private static boolean isValidHumidity(double h) {
        if (h > 40 && h < 60) {
            return true;
        }
        return false;
    }
    private static boolean isValidOxygen(double o) {
        if (o >= 19.5 && o <= 23.5) {
            return true;
        }
        return false;
    }
}