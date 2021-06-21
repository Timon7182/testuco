alter table TESTWORK_ORDER rename column orders_id to orders_id__u44375 ;
drop index IDX_TESTWORK_ORDER_ON_ORDERS ;
alter table TESTWORK_ORDER rename column quantity to quantity__u23586 ;
alter table TESTWORK_ORDER rename column product_id to product_id__u26705 ;
alter table TESTWORK_ORDER drop constraint FK_TESTWORK_ORDER_ON_PRODUCT ;
drop index IDX_TESTWORK_ORDER_ON_PRODUCT ;
alter table TESTWORK_ORDER add column AMOUNT double precision ;
alter table TESTWORK_ORDER add column ACCOUNT_ID uuid ;
