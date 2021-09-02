package com.epam.jwd.entity.textComponentImpl;

import com.epam.jwd.entity.TextComponent;

import java.util.Iterator;
import java.util.Objects;

public class TextLeaf implements TextComponent {
    String str;

    public TextLeaf(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextLeaf)) return false;
        TextLeaf textLeaf = (TextLeaf) o;
        return Objects.equals(str, textLeaf.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return  str;
    }

    @Override
    public void addElement(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getElement(int id) {
        return this;
    }

    @Override
    public void parse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<TextComponent> getIterator() {
        throw new UnsupportedOperationException();
    }
}
