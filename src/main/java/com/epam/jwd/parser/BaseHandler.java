package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;


import java.util.Collections;
import java.util.List;

public abstract class BaseHandler  {
    private BaseHandler nextComponent;

    public abstract List<TextComponent> parse (String text);

    public BaseHandler(BaseHandler nextComponent) {
        this.nextComponent = nextComponent;
    }

    public BaseHandler() {
    }

    protected List<TextComponent> processingNext(String text){

        if (nextComponent == null) {
           Collections.emptyList();
        }
        return nextComponent.parse(text);
    }



}
