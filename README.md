json-fixtures
=============

Json-Fixtures is a library to simplify tests. You can define fixtures using json and load
inside your tests using annotations.

Supported types:
- Pojos
- Arrays of pojos
- Collections of Pojos
    - List
    - Set
    - Collection
- Maps of Pojos

Example
-------

    @Rule
    public JsonFixturesTestRule rule = new JsonFixturesTestRule(this);

    @JsonFixture("/files/data.json")
    public Data data;

    @JsonFixture("/files/list.json")
    public List<Data> dataList;

    @JsonFixture("/files/list.json")
    public Set<Data> dataSet;

    @JsonFixture("/files/list.json")
    public Collection<Data> dataCollection;

    @JsonFixture("/files/list.json")
    public Data[] dataArray;

    @JsonFixture("/files/map.json")
    public Map<String, Data> dataMap;

[![Build Status](https://drone.io/github.com/tonivade/json-fixtures/status.png)](https://drone.io/github.com/tonivade/json-fixtures/latest)
