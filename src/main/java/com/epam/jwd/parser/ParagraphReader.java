package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphReader extends BaseHandler {

    private static final String PARAGRAPHE_REGEX = "\\t(.+)\\p{Punct}";
    private static ParagraphReader paragraphReader;


    private ParagraphReader() {
        super();
    }

    public static ParagraphReader getInstance() {
        if (paragraphReader == null) {
            paragraphReader = new ParagraphReader();
        }
        return paragraphReader;
    }


    @Override
    public List<TextComponent> parse(String text) throws IOException {
        LoggerProvider.getLOG().trace("Start parsing paragraph");
        ReadWriteFile.readFile(text);
        String[] paragraphs = text.split("\t");
        List<TextComponent> paragraphList = new ArrayList();
        for (int i = 0; i < paragraphs.length; i++) {
            if (paragraphs[i].matches(PARAGRAPHE_REGEX)) {
                paragraphs[i] = text.replaceAll("\t", "");
            }
            else {
                SentenceReader.getInstance().processingNext(text);
            }
        }

        for (String par : paragraphs) {

            paragraphList.add(new TextComposite(processingNext(par)));
        }
        LoggerProvider.getLOG().trace("Stop parsing paragraph");
        return paragraphList;
    }

    public int getAmountOfSentences(List<TextComponent> sentencesAmount) {
        int counter = 0;
        for (int i = 0; i < sentencesAmount.size(); i++) {
            counter++;
        }
        return counter;
    }


}
