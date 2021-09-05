package com.epam.jwd.entity.textComponentInstance;

import com.epam.jwd.entity.TextComponentPointer;
import com.epam.jwd.entity.textComponentImpl.TextLeaf;


public class SymbolEntity extends TextLeaf implements TextComponentPointer {

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    public SymbolEntity() {
        super();
    }
}
