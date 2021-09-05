package com.epam.jwd.entity;

import com.epam.jwd.entity.textComponentInstance.ComponentType;

import java.util.Iterator;

public interface TextComponent {
    void addElement(TextComponent textComponent);

    void removeElement(TextComponent textComponent);

    TextComponent getElement(int id);

    Iterator<TextComponent> getIterator();

}
