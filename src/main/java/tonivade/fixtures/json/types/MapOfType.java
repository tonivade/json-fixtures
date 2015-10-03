/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json.types;

import java.lang.reflect.Type;
import java.util.Map;

public class MapOfType extends AbstractWrappedType {

    public MapOfType(Class<?> key, Class<?> value) {
        super(key, value);
    }

    @Override
    public Type getRawType() {
        return Map.class;
    }
}
