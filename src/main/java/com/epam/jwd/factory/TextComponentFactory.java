package com.epam.jwd.factory;

import com.epam.jwd.entity.TextComponentPointer;
import com.epam.jwd.entity.textComponentInstance.*;
import com.epam.jwd.exception.InvalidComponentType;

public class TextComponentFactory {

    public TextComponentPointer getComponentType(ComponentType componentType) {
        TextComponentPointer toReturn;
        switch (componentType) {
            case SYMBOL:
                toReturn = new SymbolEntity();
                break;
            case SENTENCE:
                toReturn = new SentenceEntity();
                break;
            case PARAGRAPH:
                toReturn = new ParagraphEntity();
                break;
            case WORD:
                toReturn = new WordEntity();
                break;
            case TEXT:
                toReturn = new TextEntity();
                break;

            default:
                throw new InvalidComponentType("Unexpected value: " + componentType);
        }
        return toReturn;
    }
}
