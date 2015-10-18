/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import java.util.Objects;

public class Data {
    private final int id;
    private final String value;

    public Data(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Data other = (Data) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return "Data [id=" + id + ", value=" + value + "]";
    }
}
