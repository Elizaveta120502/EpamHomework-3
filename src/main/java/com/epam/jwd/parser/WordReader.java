package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;

import java.util.ArrayList;
import java.util.List;

public class WordReader extends BaseHandler {
    private static final String WORD_REGEX = "\\w+";
    private static final String SPLIT_WORD_REGEX = "\\W+";

    private static WordReader wordReaderInstance;


    public WordReader getInstance(){
        if (wordReaderInstance == null){
            wordReaderInstance = new WordReader();
        }
        return wordReaderInstance;
    }

    @Override
    public List<TextComponent> parse(String text) {
        LoggerProvider.getLOG().trace("Start parsing words");
        String[] words = text.split(SPLIT_WORD_REGEX);
        List<TextComponent> wordList = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(WORD_REGEX)) {
                wordList.add(new TextComposite(processingNext(words[i])));
            }

            LoggerProvider.getLOG().trace("Stop parsing words");

        }
        return wordList;
    }



}
