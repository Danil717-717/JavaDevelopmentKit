package less6;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class Main {

    public void printFile() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("hello.txt");

        System.out.println(new String(resourceAsStream.readAllBytes()));

    }
    public static void main(String[] args) throws IOException {
        new Main().printFile();

        //CollectionUtils.subtract();
    }
}
