/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json.types;

import java.lang.reflect.Type;
import java.util.Collection;

public class CollectionOfType extends AbstractWrappedType {

    public CollectionOfType(Class<?> wrapped) {
        super(wrapped);
    }

    @Override
    public Type getRawType() {
        return Collection.class;
    }

}
