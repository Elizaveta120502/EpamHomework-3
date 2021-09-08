package com.epam.jwd.sort;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.parser.SentenceReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphsSortImpl implements ParagraphsSort {

    @Override
    public List<TextComponent> sortByNumberOfSentences(TextComposite textComposite,
                                                       String text,
                                                       List<TextComponent> paragraphReader) throws IOException {
        int counter = 0;
        int max = 0;


        List<TextComponent> sortedText = new ArrayList<>();

        for (int i = 0; i < textComposite.getAll().size(); i++) {
            sortedText.add(ParagraphReader.getInstance().parse(text).get(i));

        }
        for (int i = 0, j = i + 1; i < sortedText.size() - 1; i++, j++) {
            if (sortedText.get(i).getAll().size() < sortedText.get(j).getAll().size()) {
                TextComponent temp = sortedText.get(i);
                sortedText.set(i, sortedText.get(j));
                sortedText.set(j, temp);
            }
        }

        return sortedText;
    }

    @Override
    public int compare(SentenceReader o1, SentenceReader o2, int amountOne, int amountTwo) {
        return 0;
    }


}
