
CREATE TABLE MOVIE (
    ID bigint AUTO_INCREMENT NOT NULL,
    PRIMARY_TITLE varchar(255) UNIQUE,
    ORIGINAL_TITLE varchar(255) NOT NULL,
    START_YEAR year,
    END_YEAR year,
    RUNTIME_MINUTES int,
    MODIFIED_AT timestamp,
    CREATED_AT timestamp DEFAULT (CURRENT_TIMESTAMP),
    MOVIE_GENRE int,
    MOVIE_TYPE int,
    IMDB_RATING double,
    IMDB_RATING_COUNT int,
    IS_ADULT boolean,
    RATING double,
    RATING_COUNT int DEFAULT 0,
    PRIMARY KEY (ID)
);