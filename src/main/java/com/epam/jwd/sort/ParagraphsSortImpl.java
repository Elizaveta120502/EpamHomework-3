package com.epam.jwd.sort;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.parser.SentenceReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphsSortImpl implements ParagraphsSort {

    @Override
    public List<TextComponent> sortByNumberOfSentences(SentenceReader sentenceReader,
                                                       String text,
                                                       ParagraphReader paragraphReader) throws IOException {
        int counter = 0;
        int max = 0;
        int temp = 0;

        List<TextComponent> sortedText = new ArrayList<>();

        for (int i = 0; i < ParagraphReader.getInstance().parse(text).size(); i++) {

            counter = ParagraphReader.getInstance().getAmountOfSentences((List<TextComponent>) sentenceReader.parse(text).get(i));
            if (counter > max) {
                temp = max;
                max = counter;
            }
            sortedText.add(ParagraphReader.getInstance().parse(text).get(i));

        }
        return null;
    }

}
