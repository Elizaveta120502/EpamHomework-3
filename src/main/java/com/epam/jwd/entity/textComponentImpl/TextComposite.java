package com.epam.jwd.entity.textComponentImpl;

import com.epam.jwd.entity.TextComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> compositeChildren = new ArrayList<>();

    public TextComposite() {
    }

    public TextComposite(List<TextComponent> compositeChildren) {
        this.compositeChildren = compositeChildren;
    }

    @Override
    public void addElement(TextComponent textComponent) {
       compositeChildren.add(textComponent);
    }

    @Override
    public void removeElement(TextComponent textComponent) {
        compositeChildren.remove(textComponent);
    }

    @Override
    public TextComponent getElement(int id) {
        return compositeChildren.get(id);
    }



    @Override
    public Iterator<TextComponent> getIterator() {
        return compositeChildren.iterator();
    }
}
