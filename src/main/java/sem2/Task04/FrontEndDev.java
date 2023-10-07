package sem2.Task04;

public class FrontEndDev extends Developer implements FrontEndProgrammer{
    @Override
    void developerAction() {
        System.out.println("Write Front");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Write FrontCode");
    }
}
