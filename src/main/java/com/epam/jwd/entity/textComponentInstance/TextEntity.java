package com.epam.jwd.entity.textComponentInstance;

import com.epam.jwd.entity.TextComponentPointer;
import com.epam.jwd.entity.textComponentImpl.TextComposite;

public class TextEntity extends TextComposite implements TextComponentPointer {
    public TextEntity() {
    }

    @Override
    public ComponentType getType() {
        return ComponentType.TEXT;
    }

}
