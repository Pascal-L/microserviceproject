drop table Algorythm if exists;

create table Algorythm (ID bigint identity primary key, 
                        NAME VARCHAR(30) not null, 
                        TYPE VARCHAR(20), 
                        BLOC VARCHAR (20),
                        KEY_LENGTH VARCHAR (20),
                        STRUCTURE VARCHAR(50),
                        KNOWN_ATTACKS VARCHAR(500), 
                        CREATIONYEAR INT,
                        CREATEDBY VARCHAR(50),
                        CreatedDate TIMESTAMP,
                        ModifiedDate TIMESTAMP,
                        UserCreation VARCHAR(50),
                        UserModification VARCHAR(50)
);