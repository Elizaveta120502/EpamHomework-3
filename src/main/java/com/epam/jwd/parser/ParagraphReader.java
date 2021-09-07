package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphReader extends BaseHandler {

    private static final String PARAGRAPHE_REGEX = "(.+)\\p{Punct}";
    private static ParagraphReader paragraphReader;
    String str;


    protected ParagraphReader() {
        super();
    }

    @Override
    protected List<TextComponent> processingNext(String str) throws IOException {

        if (paragraphReader == null) {
            paragraphReader = SentenceReader.getInstance();
        }
        return SentenceReader.getInstance().parse(str);
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

        str = ReadWriteFile.readFile(text);
        String[] paragraphs = str.split("/");
        List<TextComponent> paragraphList = new ArrayList();
        for (int i = 1; i < paragraphs.length; i++) {
           // paragraphs[i].replaceAll(" ","");
                paragraphList.add(new TextComposite(processingNext(paragraphs[i])));


        }
        LoggerProvider.getLOG().trace("Stop parsing paragraph");
        //paragraphReader.processingNext(str);
        return paragraphList;
    }

    public int getAmountOfSentences(int sentencesAmount) {
        int counter = 0;


                counter = sentencesAmount;

        return counter;
    }

}
