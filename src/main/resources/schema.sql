CREATE TABLE IF NOT EXISTS person (
    id varchar(255) PRIMARY KEY,
    is_admin BOOLEAN NOT NULL,
    is_active BOOLEAN NOT NULL,
    name varchar(255) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS message (
    id varchar(255) PRIMARY KEY,
    person_id varchar(255) NOT NULL,
    content varchar(255),
    time_received timestamp,

       CONSTRAINT FK_PERSONID
            FOREIGN KEY (person_id)
            REFERENCES person(id)
);
