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
    
Example
-------

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
    
[![Build Status](https://drone.io/github.com/tonivade/json-fixtures/status.png)](https://drone.io/github.com/tonivade/json-fixtures/latest)
