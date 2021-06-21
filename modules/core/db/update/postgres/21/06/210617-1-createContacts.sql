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
);