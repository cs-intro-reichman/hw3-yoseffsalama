public class Algebra {
    public static void main(String[] args) {
    }

    public static int plus(int number1, int number2) {
        if (number2 > 0) {
            for (int i = 0; i < number2; i++) {
                number1++;
            }
        } else if (number2 < 0) {
            for (int i = 0; i > number2; i--) {
                number1--;
            }
        }
        return number1;
    }

    public static int minus(int number1, int number2) {
        if (number2 > 0) {
            for (int i = 0; i < number2; i++) {
                number1--;
            }
        } else if (number2 < 0) {
            for (int i = 0; i > number2; i--) {
                number1++;
            }
        }
        return number1;
    }

    public static int times(int number1, int number2) {
        int product = 0;
        if (number2 >= 0) {
            for (int i = 0; i < number2; i++) {
                product = plus(product, number1);
            }
        } else {
            for (int i = number2; i < 0; i++) {
                product = minus(product, number1);
            }
        }
        return product;
    }

    public static int pow(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = times(result, base);
        }
        return result;
    }

    public static int div(int dividend, int divisor) {
        int quotient = 0;
        if (dividend > 0) {
            while (dividend >= divisor) {
                dividend = minus(dividend, divisor);
                quotient++;
            }
        }
        if (dividend < 0) {
            while (dividend != 0) {
                dividend = plus(dividend, divisor);
                quotient--;
            }
        }
        return quotient;
    }

    public static int mod(int dividend, int divisor) {
        int remainder = minus(dividend, times(div(dividend, divisor), divisor));
        return remainder;
    }

    public static int sqrt(int number) {
        int root = 0;
        while (times(root, root) < number) {
            root++;
        }
        return root;
    }
}
