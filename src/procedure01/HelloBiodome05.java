package procedure01;

public class HelloBiodome05 {
    private int g;
    private int h;
    public static void main(String[] args) {
        HelloBiodome05 biodome = new HelloBiodome05();

        biodome.findGAndH();
        System.out.println("찾은 g, h 값: " + biodome.g + " " + biodome.h);

        int result = biodome.calculate();
        System.out.println("세번째 수식 결과값: " + result);

        int bonusResult = biodome.bonus();
        System.out.println("보너스 수식 결과값: " + bonusResult);
    }
    private void findGAndH() {
        for(int i=0; i<16; i++) {
            for(int j=0; j<16; j++) {
                if (isValid(i, j)) {
                    this.g = i;
                    this.h = j;
                    return;
                }
            }
        }
    }
    private boolean isValid(int i, int j) {
        if (((i&1) >> (i<<2)|((j+i)^j)) != 1) {
            return false;
        }
        if (((i%2) << (j>>i) | (1 & 0 ^ 0)) != 2) {
            return false;
        }
        return true;
    }
    private int calculate() {
        return (h*h*g)*(h<<h)+(g<<g);
    }
    private int bonus() { // g - 1, h - 2
        return (((h << g) | h) << h) + ((h << h) ^ h);
    }
}
