package sem2HW.consoleVersion;


import sem2HW.common.InpUser;
import sem2HW.common.InputVibor;

public class Main {
    public static void main(String[] args) {
        InpUser ip = new InpUser();
        Nums nums = new Nums();
        InputVibor iv = new InputVibor();

        ip.inputNum();
        iv.UserVibor();
        if(iv.getNum()==1){
            String res = nums.sumNums(ip.getNum1(), ip.getNum2());
            System.out.println(res);
        } else if (iv.getNum()==2) {
            String res = nums.concotNums(ip.getNum1(), ip.getNum2());
            System.out.println(res);
        }else {
            System.out.println("Попробуйте еще раз");
        }
    }
}
