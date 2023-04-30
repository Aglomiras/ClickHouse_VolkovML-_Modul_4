create database measurement;

create table if not exists measurement.test
(
    Id INTEGER,
    Ia DOUBLE,
    Ib DOUBLE,
    Ic DOUBLE
)
engine = AggregatingMergeTree
order by (id);