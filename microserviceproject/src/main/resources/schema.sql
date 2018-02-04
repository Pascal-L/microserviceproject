drop table Algorythm if exists;

create table Algorythm (ID bigint identity primary key, 
                        NAME varchar(50) not null, 
                        DESCRIPTION varchar(500), 
                        CREATIONYEAR int,
                        CREATEDBY varchar(50),
                        ISCRACKED boolean,
                        DC timestamp,
                        DM timestamp,
                        USERC varchar(50),
                        USERM varchar(50)
);