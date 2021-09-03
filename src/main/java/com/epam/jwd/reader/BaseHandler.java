package com.epam.jwd.reader;

import com.epam.jwd.entity.TextComponent;

import java.util.List;

public abstract class BaseHandler implements Handler{
    private BaseHandler nextComponent;
//    public abstract List<TextComponent> parse (String text);

    public BaseHandler(BaseHandler nextComponent) {
        this.nextComponent = nextComponent;
    }



    @Override
    public BaseHandler processingNext(BaseHandler nextComponent){

        if (nextComponent != null) {
            this.nextComponent = nextComponent;
        }
        return nextComponent;
    }



}
