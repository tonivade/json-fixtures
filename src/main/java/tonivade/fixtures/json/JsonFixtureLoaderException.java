/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import static java.lang.String.format;

public class JsonFixtureLoaderException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JsonFixtureLoaderException(String field) {
        super(format("field %s is not accesible", field));
    }
}
