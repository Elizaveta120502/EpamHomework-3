import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.reader.ReadWriteFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReadWriteFileTest {

    String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/text-app/src/main/resources/BasicText.txt";

    String expected = "/It has survived — not only five centuries, but also the leap into 13<<2 " +
            "electronictypesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged." +
            " It was popularized in the5(1&2&(3|(4&(^5|6&47)|3)|2)|1) with the release" +
            " of Letraset sheets containing Lorem Ipsumpassages, and more recently with" +
            " desktop publishing software like Aldus PageMaker includingversions of Lorem" +
            " Ipsum./It is a long-established fact that a reader will be distracted by the " +
            "readable content of apage when looking at its layout. The point of using" +
            " (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78Ipsum is that it has a more-or-less normal " +
            "distribution of letters, as opposed to using Contenthere, content here', making it " +
            "look like readable English./It is a (^5|1&2<<(2|5>>2&71))|1200 established fact that" +
            " a reader will be of a page whenlooking at its layout.../Bye.";
    @Test
    public void readFile() throws IOException {


        Assert.assertEquals(ReadWriteFile.readFile(FILE_NAME),expected);
    }
}
