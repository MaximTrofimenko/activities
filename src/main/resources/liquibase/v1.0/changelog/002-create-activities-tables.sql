create table if not exists activities
(
    id            uuid default uuid_generate_v4() not null
        constraint activities_id_pkey primary key,
    distance      int                             not null,
    total_time    int                             not null,
    activity_date timestamptz                     not null,
    activity_type varchar(50)                     not null
);

comment on table activities is 'Физическая активность';
comment on column activities.id is 'Первичный ключ';
comment on column activities.distance is 'Дистанция';
comment on column activities.total_time is 'Общее время';
comment on column activities.activity_date is 'Дата';
comment on column activities.activity_type is 'Тип активности';