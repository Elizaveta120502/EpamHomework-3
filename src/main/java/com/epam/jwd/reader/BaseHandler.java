package com.epam.jwd.reader;

public abstract class BaseHandler implements Handler{
    private BaseHandler nextComponent;

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
