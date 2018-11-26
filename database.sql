/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     20.11.2018. 18:31:05                         */
/*==============================================================*/




/*==============================================================*/
/* Table: PRODAVNICA                                            */
/*==============================================================*/
create table PRODAVNICA 
(
   ID_PRODAVNICA        integer                        not null  AUTO_INCREMENT,
   ID_USER              integer                       not null,
   NAZIV_PRODAVNICA     long varchar                  not null,
   DATUMMODIFIKACIJE    timestamp                    not null,
   STATUS               boolean                      not null,
   constraint PK_PRODAVNICA primary key (ID_PRODAVNICA)
);



/*==============================================================*/
/* Index: PRODAVNICA_PK                                         */
/*==============================================================*/
create unique index PRODAVNICA_PK on PRODAVNICA (
ID_PRODAVNICA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on PRODAVNICA (
ID_USER ASC
);

/*==============================================================*/
/* Table: PROIZVOD                                              */
/*==============================================================*/
create table PROIZVOD 
(
   ID_PROIZVOD          integer                        not null AUTO_INCREMENT,
   ID_PRODAVNICA        integer                       not null,
   ID_USER              integer                      not  null,
   NAZIV_PROIZVOD       long varchar                 not  null,
   ROKUPOTREBE          timestamp                    not  null,
   DATUMMODIFIKACIJE    timestamp                    not null,
   STATUS               boolean                      not null,
   STANJE               integer                      not  null,
   MINIMUM              integer                      not  null,
   constraint PK_PROIZVOD primary key (ID_PROIZVOD)
);


/*==============================================================*/
/* Index: PROIZVOD_PK                                           */
/*==============================================================*/
create unique index PROIZVOD_PK on PROIZVOD (
ID_PROIZVOD ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on PROIZVOD (
ID_USER ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on PROIZVOD (
ID_PRODAVNICA ASC
);

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table USER
(
   ID_USER              integer                        not null AUTO_INCREMENT,
   ID_ROLE              integer                       not null,
   USE_ID_USER          integer                        null,
   IME                  long varchar                  not null,
   PREZIME              long varchar                 not  null,
   USERNAME             long varchar                 not  null,
   PASSWORD             long varchar                 not  null,
   EMAIL                long varchar                 not  null,
   constraint PK_USER primary key (ID_USER)
);


/*==============================================================*/
/* Index: USER_PK                                               */
/*==============================================================*/
create unique index USER_PK on USER (
ID_USER ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on USER (
ID_ROLE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on USER (
USE_ID_USER ASC
);

/*==============================================================*/
/* Table: USERROLE                                              */
/*==============================================================*/
create table USERROLE 
(
   ID_ROLE              integer                        not null AUTO_INCREMENT,
   NAZIV                long varchar                   not null,
   constraint PK_USERROLE primary key (ID_ROLE)
);

/*==============================================================*/
/* Index: USERROLE_PK                                           */
/*==============================================================*/
create unique index USERROLE_PK on USERROLE (
ID_ROLE ASC
);


INSERT INTO USERROLE VALUES(1, 'KOMERCIJALISTA');
INSERT INTO USERROLE VALUES(2, 'RADNIK');

alter table PRODAVNICA
   add constraint FK_PRODAVNI_RELATIONS_USER foreign key (ID_USER)
      references USER (ID_USER)
      on update restrict
      on delete restrict;

alter table PROIZVOD
   add constraint FK_PROIZVOD_RELATIONS_USER foreign key (ID_USER)
      references USER (ID_USER)
      on update restrict
      on delete restrict;

alter table PROIZVOD
   add constraint FK_PROIZVOD_RELATIONS_PRODAVNI foreign key (ID_PRODAVNICA)
      references PRODAVNICA (ID_PRODAVNICA)
      on update restrict
      on delete restrict;

alter table USER
   add constraint FK_USER_RELATIONS_USERROLE foreign key (ID_ROLE)
      references USERROLE (ID_ROLE)
      on update restrict
      on delete restrict;


alter table USER
   add constraint FK_USER_RELATIONS_USER foreign key (USE_ID_USER)
      references USER (ID_USER)
      on update restrict
      on delete restrict;

