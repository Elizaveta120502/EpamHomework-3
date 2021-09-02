package com.epam.jwd.entity;

import java.util.Iterator;

public interface TextComponent {
    void addElement(TextComponent textComponent);

    void removeElement(TextComponent textComponent);

    TextComponent getElement(int id);

    void parse();

    Iterator<TextComponent> getIterator();
}
