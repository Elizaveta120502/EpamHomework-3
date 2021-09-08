import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.parser.SymbolReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SymbolReaderTest {
    @Test
    public void parse() throws IOException {
        Assert.assertEquals(SymbolReader.getInstance().parse("3>>5").size(),4);
    }
}
