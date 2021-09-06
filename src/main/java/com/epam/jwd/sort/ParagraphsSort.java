package com.epam.jwd.sort;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.parser.SentenceReader;

import java.io.IOException;
import java.util.List;

public interface ParagraphsSort {
    List<TextComponent> sortByNumberOfSentences(SentenceReader sentenceReader,
                                                String text,
                                                ParagraphReader paragraphReader) throws IOException;
}
