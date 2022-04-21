import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    // To tell the program this is a test
    @Test
    public void addition() {
        //Evaluate the expectation value 
        //to the real value
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testfile() throws IOException {
        MarkdownParse m = new MarkdownParse();
        Path path = Path.of("test-file.md");
        String content = Files.readString(path);
        List<String> links = m.getLinks(content);
        List<String>linkList = List.of("https://something.com, some-thing.html");
        assertEquals(linkList.toString(), links.toString());
        
    }
}
