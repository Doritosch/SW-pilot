package procedure01;

public class HelloBiodome01 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.print("이름을 1글자 이상 입력해주세요.");
            return;
        }

        String name = String.join(" ", args);

        System.out.println(name + "님, 환영합니다!");

        // 보너스 과제
        //System.out.printf("\"%.10s\"님, 환영합니다!%n", name);

        //String message = String.format("\"%.10s\"님, 환영합니다!", name);
        //System.out.println(message);
    }
}
