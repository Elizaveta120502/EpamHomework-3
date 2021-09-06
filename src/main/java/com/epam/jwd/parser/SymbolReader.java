package com.epam.jwd.parser;


import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;
import com.epam.jwd.interpreter.ExpressionsStack;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.reader.ReadWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymbolReader extends BaseHandler {

    private static final String SYMBOL_REGEX = "[^\\s+]";
    private static final String BINARY_EXPRESSION_REGEX = "[0-9~&>{2}<{2}(\\^\\|]";

    private static SymbolReader symbolReader;

   private SymbolReader(BaseHandler nextComponent) {
        super(nextComponent);
    }

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
        ReadWriteFile.readFile(text);
        String[] symbols = text.split("");
        List<TextComponent> symbolList = new ArrayList();
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].matches(SYMBOL_REGEX)) {
                if (symbols[i].matches(BINARY_EXPRESSION_REGEX)) {
                    ExpressionsStack.getResultOfBitOperation(text, Integer.parseInt(symbols[i]), Integer.parseInt(symbols[i + 1]));
                }
                symbolList.add(new TextLeaf(text));
            }

            LoggerProvider.getLOG().trace("Stop parsing symbols");

        }
        return symbolList;
    }
}
