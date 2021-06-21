-- begin TESTWORK_ORDER
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
    DATE_ timestamp,
    AMOUNT double precision,
    ACCOUNT_ID uuid,
    --
    primary key (ID)
)^
-- end TESTWORK_ORDER

-- begin TESTWORK_CONTACTS
create table TESTWORK_CONTACTS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ACCOUNT_ID uuid,
    CONTACT varchar(50),
    VALUE_ varchar(255),
    --
    primary key (ID)
)^
-- end TESTWORK_CONTACTS
-- begin TESTWORK_PRODUCT
create table TESTWORK_PRODUCT (
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
    QUANTITY integer,
    PRICE double precision,
    ORDER_ID uuid,
    --
    primary key (ID)
)^
-- end TESTWORK_PRODUCT
-- begin TESTWORK_ACCOUNT
create table TESTWORK_ACCOUNT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    MIDDLE_NAME varchar(255),
    PHOTO_ID uuid,
    --
    primary key (ID)
)^
-- end TESTWORK_ACCOUNT
