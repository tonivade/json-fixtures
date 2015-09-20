/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;

public class DataTest {

    @Rule
    public JsonFixturesTestRule rule = new JsonFixturesTestRule(this);

    @JsonFixture("/files/data.json")
    public Data data;

    @JsonFixture(value = "/files/list.json", type = Data.class)
    public List<Data> dataList;

    @JsonFixture(value = "/files/list.json", type = Data.class)
    public Set<Data> dataSet;

    @JsonFixture(value = "/files/list.json", type = Data.class)
    public Collection<Data> dataCollection;

    @JsonFixture("/files/list.json")
    public Data[] dataArray;

    private Data[] expectedArray = new Data[] { new Data(1, "value-1"), new Data(2, "value-2"), new Data(3, "value-3") };

    @Test
    public void testData() {
        assertThat(data, is(new Data(1, "value")));
    }

    @Test
    public void testList() {
        assertThat(dataList, is(asList(expectedArray)));
    }

    @Test
    public void testSet() {
        assertThat(dataSet, is(new HashSet<Data>(asList(expectedArray))));
    }

    @Test
    public void testCollection() {
        assertThat(dataCollection, is(asList(expectedArray)));
    }

    @Test
    public void testArray() {
        assertThat(dataArray, is(expectedArray));
    }
}
