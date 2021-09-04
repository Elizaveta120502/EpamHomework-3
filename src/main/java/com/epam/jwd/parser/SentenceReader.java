package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;

import java.util.ArrayList;
import java.util.List;

public class SentenceReader extends BaseHandler {

    private static final String SENTENCE_REGEX = "([\\w+|\\w+\\,\\-]\\s?)+[\\.|\\?|\\!]";
    private static final String SPLIT_SENTENCE_REGEX = "[.?!]+\\\\s?";

    private static SentenceReader sentenceReader;


    public SentenceReader getInstance(){
        if (sentenceReader == null){
            sentenceReader = new SentenceReader();
        }
        return sentenceReader;
    }

    @Override
    public List<TextComponent> parse(String text) {
        LoggerProvider.getLOG().trace("Start parsing sentences");
        String[] sentences = text.split(SPLIT_SENTENCE_REGEX);
        List<TextComponent> sentenceList = new ArrayList();
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].matches(SENTENCE_REGEX)) {
                sentenceList.add(new TextComposite(processingNext(sentences[i])));
            }

            LoggerProvider.getLOG().trace("Stop parsing sentences");

        }
        return sentenceList;
    }
}
