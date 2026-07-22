package procedure01;

import java.util.Arrays;

public class HelloBiodome08 {
    private static final String[] ENG_DICTIONARY = {"hello", "where", "this", "biodome", "help", "tree", "new", "is", "problem", "please", "need",
                                                    "we", "isn’t", "there", "a", "your", "any", "thanks", "the", "for", "solution", "can", "?"};
    private static final String[] KOR_DICTIONARY = {"안녕하세요", "새로운", "나무를", "발견했습니다", "신속한" ,"지원", "감사합니다",
                                                    "당신의", "도움이", "필요합니다"};
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("문장을 입력해주세요.");
            return;
        }
        if (args[0].length() > 100) {
            System.out.println("최대 길이는 100자 입니다.");
            return;
        }
        String message = args[0];

        char firstChar = message.charAt(0);
        String result;
        if (firstChar >= '가' && firstChar <= '힣') {
            result = getSentence(message, KOR_DICTIONARY);
        } else {
            result = getSentence(message, ENG_DICTIONARY);
        }
        System.out.println(result);
    }
    private static String getSentence(String message, String[] dictionary) {
        Arrays.sort(dictionary, (a,b) -> b.length() - a.length());
        StringBuilder sb = new StringBuilder(message);
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < message.length()) {
            boolean matched = false;
            for(int j=0; j<dictionary.length; j++) {
                if (sb.indexOf(dictionary[j], i) == i) {
                    if (dictionary[j].equals("?") && result.charAt(result.length()-1) == ' ') {
                        result.deleteCharAt(result.length() - 1);
                    }
                    result.append(dictionary[j]).append(" ");
                    i += dictionary[j].length();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                result.append(message.charAt(i));
                i += 1;
            }
        }

        if (result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length()-1);
        }
        if (result.charAt(result.length() - 1) != '?') {
            result.append(".");
        }
        return result.toString();
    }
}
