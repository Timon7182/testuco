-- begin TESTWORK_ORDER
alter table TESTWORK_ORDER add constraint FK_TESTWORK_ORDER_ON_ACCOUNT foreign key (ACCOUNT_ID) references TESTWORK_ACCOUNT(ID)^
create index IDX_TESTWORK_ORDER_ON_ACCOUNT on TESTWORK_ORDER (ACCOUNT_ID)^
-- end TESTWORK_ORDER

-- begin TESTWORK_CONTACTS
alter table TESTWORK_CONTACTS add constraint FK_TESTWORK_CONTACTS_ON_ACCOUNT foreign key (ACCOUNT_ID) references TESTWORK_ACCOUNT(ID)^
create index IDX_TESTWORK_CONTACTS_ON_ACCOUNT on TESTWORK_CONTACTS (ACCOUNT_ID)^
-- end TESTWORK_CONTACTS
-- begin TESTWORK_PRODUCT
alter table TESTWORK_PRODUCT add constraint FK_TESTWORK_PRODUCT_ON_ORDER foreign key (ORDER_ID) references TESTWORK_ORDER(ID)^
create index IDX_TESTWORK_PRODUCT_ON_ORDER on TESTWORK_PRODUCT (ORDER_ID)^
-- end TESTWORK_PRODUCT
-- begin TESTWORK_ACCOUNT
alter table TESTWORK_ACCOUNT add constraint FK_TESTWORK_ACCOUNT_ON_PHOTO foreign key (PHOTO_ID) references SYS_FILE(ID)^
create index IDX_TESTWORK_ACCOUNT_ON_PHOTO on TESTWORK_ACCOUNT (PHOTO_ID)^
-- end TESTWORK_ACCOUNT
