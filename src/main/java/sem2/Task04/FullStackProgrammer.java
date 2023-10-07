package sem2.Task04;

public class FullStackProgrammer implements BackEndProgrammer, FrontEndProgrammer {
    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бек");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронт");
    }
}
