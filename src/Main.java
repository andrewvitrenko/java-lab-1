public class Main {
    public static void main(String[] args) throws Exception {
        Main.checkArguments(args);

        short a = Short.parseShort(args[0]);
        short b = Short.parseShort(args[1]);
        short n = Short.parseShort(args[2]);
        short m = Short.parseShort(args[3]);

        Main.checkLimits(a, b, n, m);

        float result = Main.calculate(a, b, n, m);

        System.out.printf("result %f", result);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Short.parseShort(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void checkArguments(String[] args) throws Exception {
        if (args.length != 4) {
            throw new Exception("Invalid number of arguments. Need 4 arguments");
        }

        for (String argument : args) {
            if (!Main.isNumeric(argument)) {
                throw new Exception(String.format("Value %s cannot be parsed to number", argument));
            }
        }
    }

    public static void checkLimits(short a, short b, short n, short m) throws Exception {
        if (a > n) {
            throw new Exception("[Wrong limits] a cannot be bigger than n");
        }

        if (b > m) {
            throw new Exception("[Wrong limits] b cannot be bigger than m");
        }
    }

    public static float calculate(short a, short b, short n, short m) throws Exception {
        float sum = 0;

        for (short i = a; i <= n; i++) {
            for (short j = b; j <= m; j++) {
                if (j == 0 || i == 0) {
                    throw new Exception(String.format("Division by zero, i - %d, j - %d", i, j));
                }

                sum += (float) (i % j) / i;
            }
        }

        return sum;
    }
}