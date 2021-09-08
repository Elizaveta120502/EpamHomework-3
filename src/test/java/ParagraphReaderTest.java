import com.epam.jwd.parser.ParagraphReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ParagraphReaderTest {


    String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/text-app/src/main/resources/BasicText.txt";



    @Test
    public void parse() throws IOException {
        Assert.assertEquals(ParagraphReader.getInstance().parse(FILE_NAME).size(),4);
    }

    @Test
    public void getInstance() throws IOException {
        Assert.assertNotNull(ParagraphReader.getInstance());
    }


}
