alter table TESTWORK_ORDER add constraint FK_TESTWORK_ORDER_ON_ORDERS foreign key (ORDERS_ID) references TESTWORK_ORDERS(ID);
create index IDX_TESTWORK_ORDER_ON_ORDERS on TESTWORK_ORDER (ORDERS_ID);