public class Algebra {
    public static void main(String[] args) {

    }

    public static int plus(int a, int b) {
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a++;
            }
        } else if (b < 0) {
            for (int i = 0; i > b; i--) {
                a--;
            }
        }
        return a;
    }

    public static int minus(int a, int b) {
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a--;
            }
        } else if (b < 0) {
            for (int i = 0; i > b; i--) {
                a++;
            }
        }
        return a;
    }

    public static int times(int a, int b) {
        int multiplication = 0;
        if (b >= 0) {
            for (int i = 0; i < b; i++) {
                multiplication = plus(multiplication, a);
            }
        }
        else {
            for (int i = b; i < 0; i++) {
                multiplication = minus(multiplication, a);
            }
        }
        return multiplication;
    }

    public static int pow(int a, int b) {
        int power = 1;
        for (int i = 0; i < b; i++) {
            power = times(power, a);
        }
        return power;
    }

    public static int div(int a, int b) {
        int division = 0;
        if (a > 0) {
            while (a >= b) {
                a = minus(a, b);
                division++;
            }
        }
        if (a < 0) {
            while (a != 0) {
                a = plus(a, b);
                division--;
            }
        }
        return division;
    }

    public static int mod(int a, int b) {
        int modulo = minus(a, times(div(a, b), b));
        return modulo;
    }

    public static int sqrt(int a) {
            int root = 0;
            while (times(root, root) <= a) {
                root++;
            }
            return (--root);
    }
}
