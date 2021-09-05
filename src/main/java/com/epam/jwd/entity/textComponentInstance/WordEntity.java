package com.epam.jwd.entity.textComponentInstance;

import com.epam.jwd.entity.TextComponentPointer;
import com.epam.jwd.entity.textComponentImpl.TextComposite;


public class WordEntity extends TextComposite implements TextComponentPointer {
    @Override
    public ComponentType getType() {
        return ComponentType.WORD;
    }
}
