package com.epam.jwd.sort;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.parser.SentenceReader;

import java.io.IOException;
import java.util.List;

public interface ParagraphsSort {
    List<TextComponent> sortByNumberOfSentences(TextComposite textComposite,
                                                String text,
                                                List<TextComponent> paragraphReader) throws IOException;

    int compare(SentenceReader o1, SentenceReader o2, int amountOne, int amountTwo);
}
