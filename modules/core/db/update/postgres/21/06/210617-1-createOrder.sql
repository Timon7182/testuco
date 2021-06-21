create table TESTWORK_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    PRODUCT_ID uuid,
    PRICE double precision,
    QUANTITY integer,
    ORDERS_ID uuid,
    --
    primary key (ID)
);