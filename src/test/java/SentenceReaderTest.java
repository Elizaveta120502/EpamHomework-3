import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.parser.SentenceReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SentenceReaderTest {

    @Test
    public void parse() throws IOException {
        Assert.assertEquals(SentenceReader.getInstance().parse("My name is Liz.I learn Java.").size(),2);
    }
}
