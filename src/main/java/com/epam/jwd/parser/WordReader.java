package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader extends SentenceReader {
    private static final String WORD_REGEX = "[a-zA-Z+]";
    private static final String SPLIT_WORD_REGEX = "\s";
    private static final String BINARY_EXPRESSION_REGEX = "[0-9~&>{2}<{2}(\\^\\|\\)]";

    private static WordReader wordReader;
    List<String> binaryOperations = new ArrayList<>();

    public WordReader() {
        super();
    }

    @Override
    protected List<TextComponent> processingNext(String text) throws IOException {

        if (wordReader == null) {
            wordReader = SymbolReader.getInstance();
        }
        return SymbolReader.getInstance().parse(text);
    }

    public static WordReader getInstance() {
        if (wordReader == null) {
            wordReader = new WordReader();
        }
        return wordReader;
    }

    @Override
    public List<TextComponent> parse(String text) throws IOException {
        LoggerProvider.getLOG().trace("Start parsing words");

        String[] words = text.split(SPLIT_WORD_REGEX);
        List<TextComponent> wordList = new ArrayList();

        for (int i = 0; i < words.length; i++) {
//            if (words[i].matches(WORD_REGEX)) {


             if ((words[i].matches(BINARY_EXPRESSION_REGEX))) {
                binaryOperations.add(words[i]);

            }else {
                 wordList.add(new TextComposite(processingNext(words[i])));
             }


            LoggerProvider.getLOG().trace("Stop parsing words");

        }
        return wordList;
    }


}
