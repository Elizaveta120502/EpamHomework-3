package com.epam.jwd.reader;

public interface Handler {

    BaseHandler processingNext(BaseHandler nextComponent);

}
