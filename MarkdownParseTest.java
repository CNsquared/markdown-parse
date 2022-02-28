/*
import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest{
    String file1;
    String file2;
    String file3;
    @Before
    public void setUp() throws IOException{
        file1 = Files.readString(Path.of("test-file.md"));
        file2 = Files.readString(Path.of("test-file2.md"));
        file3 = Files.readString(Path.of("test-file3.md"));
    }
    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }
    @Test
    public void testGetLinks(){
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(file1));
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(file2));
        assertEquals(List.of(), MarkdownParse.getLinks(file3));

    }
}
*/




import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
public class MarkdownParseTest {
    
    /*
    @Test
    public void improvmentTest() throws IOException{
        Path fileName = Path.of("test-file-l5.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("something.com()"), MarkdownParse.getLinks(contents));
    }
    */

    @Test
    public void testBackticks1() throws IOException{
        Path fileName = Path.of("test-backtick1.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("`google.com");
        list.add("google.com");
        list.add("ucsd.edu");

        assertEquals(list, links);
    }

    @Test
    public void testBackticks2() throws IOException{
        Path fileName = Path.of("test-backtick2.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("a.com");
        list.add("a.com(())");
        list.add("example.com");

        assertEquals(list, links);
    }

    @Test
    public void testBackticks3() throws IOException{
        Path fileName = Path.of("test-backtick3.md");
        String contents = Files.readString(fileName);
        ArrayList <String> links = MarkdownParse.getLinks(contents);
        ArrayList <String> list = new ArrayList<String>();
        list.add("https://www.twitter.com");
        list.add("https://ucsd-cse15l-w22.github.io/");
        list.add("https://cse.ucsd.edu/");

        assertEquals(list, links);
    }

    


}
