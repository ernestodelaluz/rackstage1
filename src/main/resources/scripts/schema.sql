 

drop table VEHICLE if exists;
create table VEHICLE (ID bigint identity primary key
						, BRAND varchar(20)not null
						, MODEL varchar(50) not null
                        , YEAR integer not null
                        , TYPE_VEHICLE varchar(30)not null
                        );
                        
                                      