import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();

        try {
            int result = eval(expression.substring(0, expression.length() - 1));
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("WRONG");
        }

    }

    static int pos = -1, ch;

    static void nextChar(final String str) {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    static boolean eat(int charToEat, final String str) {
        if (ch == charToEat) {
            nextChar(str);
            return true;
        }
        return false;
    }

    static int parse(final String str) {
        nextChar(str);
        int x = parseExpression(str);
        if (pos < str.length()) throw new RuntimeException("Ошибка");
        return x;
    }

    static int parseExpression(final String str) {
        int x = parseTerm(str);
        for (; ; ) {
            if (eat('+', str)) x += parseTerm(str);
            else if (eat('-', str)) x -= parseTerm(str);
            else return x;
        }
    }

    static int parseTerm(final String str) {
        int x = parseFactor(str);
        for (; ; ) {
            if (eat('*', str)) x *= parseFactor(str);
            else if (eat('/', str)) x /= parseFactor(str);
            else return x;
        }
    }

    static int parseFactor(final String str) {
        int x;
        int startPos = pos;
        if (eat('(', str)) {
            x = parseExpression(str);
            if (!eat(')', str)) throw new RuntimeException("Ошибка");
        } else if ((ch >= '0' && ch <= '9')) {
            while ((ch >= '0' && ch <= '9')) nextChar(str);
            x = Integer.parseInt(str.substring(startPos, pos));
        } else {
            throw new RuntimeException("Ошибка");
        }
        return x;
    }

    static int eval(final String str) {
        return parse(str);
    }

}
