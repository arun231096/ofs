//Print the following values of a particular BigDecimal number:
//        - absolute value
//        - ceiling
//        - floor
//        - rint
//        - max
//        - min
package com.objectfrontier.training.java.pack;

import java.math.BigDecimal;

public class RoundingOff {

    public static void main(String[] args) {

        RoundingOff decimalOperation = new RoundingOff();
        decimalOperation.bigDecimalToSpecifiedDecimals();
        decimalOperation.roundOff();
    }

    private void bigDecimalToSpecifiedDecimals() {
        // TODO Auto-generated method stub
        BigDecimal roundingOff = new BigDecimal("99.7986");
        BigDecimal result1 = roundingOff.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal result2 = roundingOff.setScale(2, BigDecimal.ROUND_UP);
        BigDecimal result3 = roundingOff.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal result4 = roundingOff.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal result5 = roundingOff.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(result1 + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n" + result5);
    }

    private void roundOff() {
        // TODO Auto-generated method stub
        BigDecimal number = new BigDecimal("167.8769");
        BigDecimal ceiling = number.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal floor = number.setScale(2, BigDecimal.ROUND_FLOOR);
        BigDecimal comaparablenumber = new BigDecimal("100.01");
        BigDecimal maximum = number.max(comaparablenumber);
        BigDecimal minimum = number.min(comaparablenumber);
        Double roundOfresult = Math.rint(maximum.doubleValue());
        Double abs = Math.abs(minimum.doubleValue());
        System.out.println(ceiling);
        System.out.println(floor);
        System.out.println(maximum);
        System.out.println(minimum);
        System.out.println(roundOfresult);
        System.out.println(abs);
    }
}
