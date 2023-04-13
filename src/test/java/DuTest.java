import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuTest {

    @Test
    void test1() throws Exception {
        assertEquals("Sum of files = 2\r\n", actual("du -c src/test/resources/file2.txt src/test/resources/file4.txt"));
    }
    @Test
    void test2() throws Exception {
        assertEquals("""
                src/test/resources/file1.txt = 749B\r
                src/test/resources/file2.txt = 42B\r
                src/test/resources/file4.txt = 2KB\r
                """, actual("du -h --si src/test/resources/file1.txt src/test/resources/file2.txt src/test/resources/file4.txt"));
    }
    @Test
    void test3() throws Exception {
        assertEquals("Sum of files = 4KB\r\n", actual("du -h --si -c src/test/resources"));
    }
    @Test
    void test4() throws Exception {
        assertEquals("src/test/resources = 4KB\r\n", actual("du -h src/test/resources"));
    }

    public String actual(String cmd) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(output);
        System.setOut(print);
        Parser.main(cmd.split(" "));
        return output.toString();
    }
}