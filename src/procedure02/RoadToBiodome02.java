package procedure02;

public class RoadToBiodome02 {
    private static final int MAX_LENGTH = 1000000;
    private char[] stack = new char[MAX_LENGTH];
    private int top = -1;
    public static void main(String[] args) {
        if (args == null || args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("올바른 문장을 입력해주세요.");
            return;
        }

        RoadToBiodome02 biodome = new RoadToBiodome02();
        String str = args[0];
        for(int i=0; i<str.length(); i++) {
            biodome.push(str.charAt(i));
        }

        String result = "";
        while(!biodome.isEmpty()) {
            result += biodome.pop();
        }

        // bonus
        RoadToBiodome02 stack = new RoadToBiodome02();
        if (stack.isPalindrome(str)) {
            System.out.print("회문입니다: ");
            System.out.println(str);
        } else {
            System.out.println(result);
        }
    }
    private boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
    private void push(char ch) {
        stack[++top] = ch;
    }
    private char pop() {
        return stack[top--];
    }
    private boolean isPalindrome(String str) {
        RoadToBiodome02 compareStack = new RoadToBiodome02();

        for(int i=0; i<str.length(); i++) {
            this.push(str.charAt(i));
        }
        for(int i=0; i<str.length()/2; i++) {
            compareStack.push(this.pop());
        }
        if (str.length()%2 != 0) {
            this.pop();
        }

        while(!this.isEmpty() && !compareStack.isEmpty()) {
            char ch1 = this.pop();
            char ch2 = compareStack.pop();
            if (ch1 != ch2) {
                return false;
            }
        }
        return true;
    }
}
