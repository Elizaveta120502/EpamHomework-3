package com.epam.jwd.reader;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;
import com.epam.jwd.logger.LoggerProvider;
import org.w3c.dom.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParagraphReader extends BaseHandler {

    private static final String PARAGRAPHE_REGEX = "\\t(.+)\\p{Punct}";


    public ParagraphReader(BaseHandler nextComponent) {
        super(nextComponent);
    }


    private TextComposite readParagraph(String path) throws IOException {
        List<TextComponent> paragraphList = new ArrayList<>();
        TextComposite textComposite = null;
        TextLeaf paragraphLeaf = null;

        TextComponent textComponent = new TextComposite();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String paragraph;

            while ((paragraph = bufferedReader.readLine()) != null) {
                if (paragraph.matches(PARAGRAPHE_REGEX) == true) {

                    textComposite = new TextComposite(paragraphList);
                    textComposite.addElement(textComponent);
                }
            }
        } catch (FileNotFoundException e) {
            LoggerProvider.getLOG().error("The file to parse is not found");
        } catch (IOException e) {
            LoggerProvider.getLOG().error("An exception is thrown when trying to enter");
        }
        return textComposite;
    }

}
