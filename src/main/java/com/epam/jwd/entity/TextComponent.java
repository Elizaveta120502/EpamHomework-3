package com.epam.jwd.entity;

import java.util.Iterator;
import java.util.List;

public interface TextComponent {
    void addElement(TextComponent textComponent);

    void removeElement(TextComponent textComponent);

    TextComponent getElement(int id);

    Iterator<TextComponent> getIterator();

    List<TextComponent> getAll();

    int getId();

}
