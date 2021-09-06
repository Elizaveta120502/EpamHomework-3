package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

public abstract class BaseHandler {
    private BaseHandler nextComponent;

    public abstract List<TextComponent> parse(String text) throws IOException;

    public BaseHandler(BaseHandler nextComponent) {

        this.nextComponent = nextComponent;
    }

    public BaseHandler() {
    }

    protected List<TextComponent> processingNext(String text) throws IOException {

        if (nextComponent == null) {
            nextComponent = ParagraphReader.getInstance();
        }
        return nextComponent.parse(text);
    }


}
