package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;
import com.epam.jwd.logger.LoggerProvider;

import java.util.ArrayList;
import java.util.List;

public class SymbolReader extends BaseHandler {

    private static final String SYMBOL_REGEX = "[^\\s+]";




    @Override
    public List<TextComponent> parse(String text) {
        LoggerProvider.getLOG().trace("Start parsing symbols");
        String[] symbols = text.split("");
        List<TextComponent> symbolList = new ArrayList();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].matches(SYMBOL_REGEX)) {
                symbolList.add(new TextLeaf(text));
            }

            LoggerProvider.getLOG().trace("Stop parsing symbols");

        }
        return symbolList;
    }
}
