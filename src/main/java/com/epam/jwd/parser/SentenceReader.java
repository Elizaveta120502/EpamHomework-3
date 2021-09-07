package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentenceReader extends ParagraphReader {

    private static final String SENTENCE_REGEX = "([A-Z][^\\.!?]*[\\.!?])";
    private static final String SPLIT_SENTENCE_REGEX = "[.?!]+\s?";
    private static String str;

    private static SentenceReader sentenceReader;

    @Override
    protected List<TextComponent> processingNext(String text) throws IOException {

        if (sentenceReader == null) {
            sentenceReader = WordReader.getInstance();
        }
        return  WordReader.getInstance().parse(text);
    }



    protected SentenceReader() {
        super();

    }

    public static SentenceReader getInstance() {
        if (sentenceReader == null) {
            sentenceReader = new SentenceReader();
        }
        return sentenceReader;
    }

    @Override
    public List<TextComponent> parse(String text) throws IOException {
        LoggerProvider.getLOG().trace("Start parsing sentences");

        String[] sentences = text.split(SPLIT_SENTENCE_REGEX);
        List<TextComponent> sentenceList = new ArrayList();
        for (int i = 0; i < sentences.length; i++) {
          // if (sentences[i].matches(SENTENCE_REGEX) == true) {
                sentenceList.add(new TextComposite(processingNext(sentences[i])));
         //  }




        }
        LoggerProvider.getLOG().trace("Stop parsing sentences");
        return sentenceList;
    }


}
