\c movieflix;


CREATE TABLE IF NOT EXISTS users (
    userId INT NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS movies (
    movieId INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    CONSTRAINT PK_movie PRIMARY KEY (movieId)
);

CREATE TABLE IF NOT EXISTS ratings (
    -- ratingId gerado automaticamente (SERIAL)
    ratingId SERIAL PRIMARY KEY,
    userId INT NOT NULL,
    movieId INT NOT NULL,
    rating FLOAT NOT NULL,
    timestamp BIGINT NOT NULL,
    CONSTRAINT FK_ratings_user FOREIGN KEY (userId) REFERENCES users(userId),
    CONSTRAINT FK_ratings_movie FOREIGN KEY (movieId) REFERENCES movies(movieId)
);


TRUNCATE TABLE ratings, users, movies CASCADE;



COPY users(userId, email)
FROM '/data/dataLake/users.csv' DELIMITER ',' CSV HEADER;

COPY movies(movieId, title, genre)
FROM '/data/dataLake/movies.csv' DELIMITER ',' CSV HEADER;

COPY ratings(userId, movieId, rating, timestamp)
FROM '/data/dataLake/ratings.csv' DELIMITER ',' CSV HEADER;
