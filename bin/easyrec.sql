--
-- File generated with SQLiteStudio v3.4.3 on Sat Apr 8 16:00:19 2023
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Courses
CREATE TABLE IF NOT EXISTS Courses (
    [Dept ID] INTEGER NOT NULL,
    Course    TEXT    NOT NULL
                      PRIMARY KEY
);

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS49'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS166'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS47'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS147'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS149'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS151'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        2,
                        'PHYS49'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        2,
                        'PHYS50'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS152'
                    );

INSERT INTO Courses (
                        [Dept ID],
                        Course
                    )
                    VALUES (
                        1,
                        'CS154'
                    );


-- Table: Departments
CREATE TABLE IF NOT EXISTS Departments (
    ID   INTEGER NOT NULL
                 PRIMARY KEY,
    Name TEXT    NOT NULL
                 UNIQUE
);

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            1,
                            'Business'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            2,
                            'Science'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            3,
                            'Computer Science'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            4,
                            'Engineering'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            5,
                            'Math'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            6,
                            'Physic'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            7,
                            'Education'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            8,
                            'English'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            9,
                            'History'
                        );

INSERT INTO Departments (
                            ID,
                            Name
                        )
                        VALUES (
                            10,
                            'Political Science'
                        );


-- Table: Multi Data
CREATE TABLE IF NOT EXISTS [Multi Data] (
    [Item ID]  INTEGER NOT NULL,
    [Value ID] INTEGER NOT NULL,
    Value      TEXT    PRIMARY KEY
                       NOT NULL
);

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             1,
                             1,
                             'Summer'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             1,
                             2,
                             'Spring'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             1,
                             3,
                             'Fall'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             1,
                             4,
                             'Winter'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             2,
                             3,
                             'Your best friend''s last name'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             2,
                             2,
                             'Your favorite country'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             2,
                             1,
                             'Your mother''s maiden name'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             3,
                             1,
                             'Bachelors of Science(BS)'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             3,
                             2,
                             'Bachelors of Arts (BA)'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             3,
                             3,
                             'Masters of Science (MS)'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             3,
                             4,
                             'Doctor of Philosophy (PhD)'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             3,
                             5,
                             'Master of Business Administration (MBA)'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             4,
                             3,
                             'punctual'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             4,
                             2,
                             'enthusiastic'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             4,
                             1,
                             'passionate'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             4,
                             4,
                             'attentive'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             4,
                             5,
                             'polite'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             1,
                             'submitted well-written assignments'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             3,
                             'worked hard'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             2,
                             'participated in all of my class activities'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             6,
                             'excelled academically at the top of my class'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             5,
                             'picked up new skills quickly'
                         );

INSERT INTO [Multi Data] (
                             [Item ID],
                             [Value ID],
                             Value
                         )
                         VALUES (
                             5,
                             4,
                             'was well prepared for every exam'
                         );


-- Table: Password-Info
CREATE TABLE IF NOT EXISTS [Password-Info] (
    ID                     INTEGER PRIMARY KEY
                                   NOT NULL,
    password               TEXT    NOT NULL,
    [security qu id]       INTEGER NOT NULL,
    [security qu value id] INTEGER NOT NULL,
    [security ans]         TEXT    NOT NULL
);


-- Table: Prof-Signature
CREATE TABLE IF NOT EXISTS [Prof-Signature] (
    ID                   INTEGER PRIMARY KEY
                                 NOT NULL,
    [first name]         TEXT    NOT NULL,
    [last name]          TEXT    NOT NULL,
    title                TEXT    NOT NULL,
    [school name ID]     NUMERIC NOT NULL,
    [department name ID] NUMERIC NOT NULL,
    email                TEXT    NOT NULL,
    [phone num]          NUMERIC NOT NULL
);


-- Table: Schools
CREATE TABLE IF NOT EXISTS Schools (
    [School ID] INTEGER NOT NULL,
    [Name ID]   INTEGER NOT NULL,
    Name        TEXT    NOT NULL
                        PRIMARY KEY
);

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        1,
                        1,
                        'San Jose State University'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        1,
                        1,
                        'SJSU'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        2,
                        3,
                        'Berkeley'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        2,
                        2,
                        'Cal State'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        2,
                        1,
                        'UC Berkeley'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        3,
                        2,
                        'UC Santa Cruz'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        3,
                        1,
                        'UCSC'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        4,
                        2,
                        'Arizona State University'
                    );

INSERT INTO Schools (
                        [School ID],
                        [Name ID],
                        Name
                    )
                    VALUES (
                        4,
                        1,
                        'ASU'
                    );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;