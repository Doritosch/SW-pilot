package procedure01;

public class HelloBiodome07 {
    private static final char[] NUCLEOTIDE = {'C', 'Y', 'J', 'E', 'H'};
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("염기서열이 입력되지 않았습니다.");
            return;
        }

        String dna = getDna(args);
        dna = getUpperCase(dna);
        if (!isNucleotide(dna)) {
            System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요.");
            return;
        }
        dna = getCode(dna);
        System.out.println(dna);

        // bonus
        String bonusCode = getBonusCode(args);
        System.out.println(bonusCode);
    }
    private static boolean isNucleotide(String dna) {
        for(int i=0; i<dna.length(); i++) {
            boolean isFound = false;
            for(int j=0; j<NUCLEOTIDE.length; j++) {
                if (dna.charAt(i) == NUCLEOTIDE[j]) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return false;
            }
        }
        return true;
    }
    private static String getDna(String[] args) {
        String str = "";
        for(int i=0; i<args.length; i++) {
            str += args[i];
        }
        return str;
    }
    private static String getUpperCase(String str) {
        String result = "";
        for(int i=0; i<str.length(); i++) {
            result += Character.toUpperCase(str.charAt(i));
        }
        return result;
    }
    private static String getCode(String dna) {
        String result = "";
        int count = 1;
        for(int i=0; i<dna.length(); i++) {
            if (i+1 < dna.length() && dna.charAt(i+1) == dna.charAt(i)) {
                count += 1;
            } else {
                result += String.valueOf(dna.charAt(i)) + count;
                count = 1;
            }
        }
        return result;
    }
    private static String getBonusCode(String[] args) {
        String result = "";
        for(int i=0; i<args.length; i++) {
            if (i > 0) {
                result += " ";
            }
            String upperCase = getUpperCase(args[i]);
            result += getCode(upperCase);
        }
        return result;
    }
}
