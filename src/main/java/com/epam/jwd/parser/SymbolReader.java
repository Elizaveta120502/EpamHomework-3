package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;
import com.epam.jwd.interpreter.ExpressionsStack;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymbolReader extends WordReader {

    private static final String SYMBOL_REGEX = "[^\\s+]";


    private static SymbolReader symbolReader;



    private SymbolReader() {
    }

    public static SymbolReader getInstance() {
        if (symbolReader == null) {
            symbolReader = new SymbolReader();
        }
        return symbolReader;
    }

    @Override
    public List<TextComponent> parse(String text) throws IOException {
        LoggerProvider.getLOG().trace("Start parsing symbols");

        String[] symbols = text.split("");
        List<TextComponent> symbolList = new ArrayList();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].matches(SYMBOL_REGEX)) {
//                if (symbols[i].matches(BINARY_EXPRESSION_REGEX)) {
//                    ExpressionsStack.getResultOfBitOperation(text, Integer.parseInt(symbols[i]), Integer.parseInt(symbols[i + 1]));
//                }
                symbolList.add(new TextLeaf(symbols[i]));
            }


            LoggerProvider.getLOG().trace("Stop parsing symbols");


        }
        for (TextComponent s : symbolList) {
            LoggerProvider.getLOG().info(s);
        }
        return symbolList;
    }
}
