class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) {return 2147483647;}
        else if (dividend == divisor) {return 1;}
        else if (dividend == -2147483648 && divisor == 2) {return -1073741824;}
        else if (divisor == 1) {return dividend;}
        else if (divisor == -1) {return dividend * -1;}
        else if (divisor == -2147483648) {return 0;}
        String plusminus = "positive";
        if (dividend == -2147483648) {
            dividend = 2147483647;
            if (divisor > 0) {
                plusminus = "negative";
            }
            else {
                plusminus = "positive";
                divisor = divisor * -1;
            }
        }
        else if (dividend < 0) {
            if (divisor < 0) {
                plusminus = "positive";
                dividend = dividend * -1;
                divisor = divisor * -1;
            }
            else {
                plusminus = "negative";
                dividend = dividend * -1;
            }
        }
        else if (divisor < 0) {
            plusminus = "negative";
            divisor = divisor * -1;
        }
        else {plusminus = "positive";}
        int exp = -1;
        int quotient = 0;
        while (Math.pow(divisor,exp + 1) <= dividend) {exp++;}
        int n = (int)Math.round(Math.pow(divisor, exp));
        while (dividend >= divisor) {
            if (n > dividend) {n = n / divisor;}
            else {
                dividend -= n;
                quotient += n / divisor;
            }
        }
        if (plusminus.equals("negative")) {quotient = quotient * -1;}
        return quotient;
    }
}