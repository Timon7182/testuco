alter table TESTWORK_ACCOUNT add constraint FK_TESTWORK_ACCOUNT_ON_PHOTO foreign key (PHOTO_ID) references SYS_FILE(ID);
create index IDX_TESTWORK_ACCOUNT_ON_PHOTO on TESTWORK_ACCOUNT (PHOTO_ID);
