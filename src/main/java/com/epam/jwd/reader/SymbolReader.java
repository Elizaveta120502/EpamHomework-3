package com.epam.jwd.reader;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;
import com.epam.jwd.logger.LoggerProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SymbolReader extends BaseHandler {

    private static final String WORD_REGEX = "[^\\s+]";

    public SymbolReader(BaseHandler nextComponent) {
        super(nextComponent);
    }

    private TextComposite readParagraph(String path) throws IOException {
        List<TextComponent> symbolList = new ArrayList<>();
        TextComposite textComposite = null;
        TextLeaf symbolLeaf = null;

        TextComponent textComponent = new TextComposite();

        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String paragraph;

            while ((paragraph = bufferedReader.readLine()) != null) {
                if (paragraph.matches(WORD_REGEX) == true) {

                    textComposite = new TextComposite(symbolList);
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
