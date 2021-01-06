CREATE TABLE shift (
        id varchar(3),
        nameList varchar(10),
        shiftName varchar(4),
        primary key (id)
        );

CREATE TABLE shiftpattern (
        number int(3),
        patternId varchar(5),
        shiftPattern varchar(4),
        primary key (number)
        );
CREATE TABLE schedule (
        date int(2),
        workId varchar(4),
        vacationCode varchar(28),
        primary key (date)
        );