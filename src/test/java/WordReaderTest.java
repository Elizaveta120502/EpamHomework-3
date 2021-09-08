import com.epam.jwd.parser.WordReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WordReaderTest {

    @Test
    public void parse() throws IOException {
        Assert.assertEquals(WordReader.getInstance().parse("My name is Liz.I learn Java.").size(),6);
    }
}
