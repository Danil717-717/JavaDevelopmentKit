package sem2.task04;

import sem2.task03.BackEndProgrammer;

public class BackEndDev extends Developer implements BackEndProgrammer {
    @Override
    void developerAction() {
        System.out.println("Write Back");
    }

    @Override
    public void writeBackEndCode() {

    }
}
