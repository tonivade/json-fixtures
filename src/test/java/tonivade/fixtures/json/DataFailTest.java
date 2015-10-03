/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class DataFailTest {

    @JsonFixture("/files/data.json")
    private Data data;

    private JsonFixturesTestRule rule = new JsonFixturesTestRule(this);

    @Test(expected = JsonFixtureException.class)
    public void accessException() throws Throwable {
        rule.apply(mock(Statement.class), mock(Description.class)).evaluate();
    }
}
