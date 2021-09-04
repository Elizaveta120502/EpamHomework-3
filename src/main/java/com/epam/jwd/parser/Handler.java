package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;


import java.util.List;

public interface Handler {

    List<TextComponent> processingNext(String text);

}
