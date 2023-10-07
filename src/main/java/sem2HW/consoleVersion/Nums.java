package sem2HW.consoleVersion;

import sem2HW.common.NumsConcot;
import sem2HW.common.NumsSum;

import javax.swing.*;

import static java.lang.Integer.sum;

public class Nums implements NumsSum, NumsConcot {
    @Override
    public String sumNums(int num1, int num2){
        return (num1
                + " + " + num2 + " = " + sum(num1,num2));
    }

    @Override
    public String concotNums(int num1, int num2) {
        return (String.valueOf(num1) + String.valueOf(num2));
    }
}
