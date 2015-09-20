/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json.types;

import java.lang.reflect.Type;
import java.util.Set;

public class SetOfType extends AbstractWrappedType {

    public SetOfType(Class<?> wrapped) {
        super(wrapped);
    }

    @Override
    public Type getRawType() {
        return Set.class;
    }

}
