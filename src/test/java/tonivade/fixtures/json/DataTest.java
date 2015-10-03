/*
 * Copyright (c) 2015, Antonio Gabriel Muñoz Conejo <antoniogmc at gmail dot com>
 * Distributed under the terms of the MIT License
 */
package tonivade.fixtures.json;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

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

    @JsonFixture(value = "/files/map.json", type = { String.class, Data.class })
    public Map<String, Data> dataMap;

    private List<Data> expectedList = IntStream.range(1, 4).mapToObj((i) -> new Data(i, "value-" + i)).collect(toList());
    private Set<Data> expectedSet = expectedList.stream().collect(toSet());
    private Map<String, Data> expectedMap = expectedList.stream().collect(toMap((data) -> "data" + data.getId(), (data) -> data));
    private Data[] expectedArray = expectedList.stream().toArray((size) -> new Data[size]);

    @Test
    public void testData() {
        assertThat(data, is(new Data(1, "value")));
    }

    @Test
    public void testList() {
        assertThat(dataList, is(expectedList));
    }

    @Test
    public void testSet() {
        assertThat(dataSet, is(expectedSet));
    }

    @Test
    public void testCollection() {
        assertThat(dataCollection, is(expectedList));
    }

    @Test
    public void testArray() {
        assertThat(dataArray, is(expectedArray));
    }

    @Test
    public void testMap() {
        assertThat(dataMap, is(expectedMap));
    }
}
