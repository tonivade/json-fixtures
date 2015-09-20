/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import static java.util.Objects.requireNonNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import tonivade.fixtures.json.types.CollectionOfType;
import tonivade.fixtures.json.types.ListOfType;
import tonivade.fixtures.json.types.SetOfType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonFixturesTestRule implements TestRule {

    private Object underTest;

    private Gson gson = new GsonBuilder().create();

    public JsonFixturesTestRule(Object underTest) {
        this.underTest = requireNonNull(underTest);
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                loadFixtures();
                base.evaluate();
            }
        };
    }

    protected void loadFixtures() throws IllegalAccessException {
        for (Field field : underTest.getClass().getDeclaredFields()) {
            JsonFixture annontation = field.getAnnotation(JsonFixture.class);
            if (annontation != null) {
                InputStream input = loadJsonFile(annontation.value());
                Object value = loadValue(input, field.getType(), annontation.type());
                setValue(field, value);
            }
        }
    }

    private InputStream loadJsonFile(String name) {
        return underTest.getClass().getResourceAsStream(requireNonNull(name));
    }

    private Object loadValue(InputStream input, Class<?> type, Class<?> parametizedType) {
        return gson.fromJson(new InputStreamReader(requireNonNull(input)), getType(type, parametizedType));
    }

    private Type getType(Class<?> type, Class<?> parametizedType) {
        Type realType = type;
        if (List.class.isAssignableFrom(type)) {
            realType = new ListOfType(parametizedType);
        } else if (Set.class.isAssignableFrom(type)) {
            realType = new SetOfType(parametizedType);
        } else if (Collection.class.isAssignableFrom(type)) {
            realType = new CollectionOfType(parametizedType);
        }
        return TypeToken.get(realType).getType();
    }

    private void setValue(Field field, Object value) throws IllegalAccessException {
        field.set(underTest, value);
    }
}
