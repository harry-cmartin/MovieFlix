CREATE table if not exists users (

    userId int not null,
    email varchar(100) not null,

    constraint PK_user PRIMARY KEY (userId)


);


CREATE table if not exists movies (

    movieId int not null ,
    title varchar(100) not null,
    genre varchar(100) not null ,

    constraint PK_movie PRIMARY KEY (movieId)
);

CREATE table if not exists ratings(

    ratingId int not null,
    userId int not null,
    movieId int not null ,
    rating float not null,
    timestamp timestamp not null,

    constraint FK_ratings_user FOREIGN KEY (userId) REFERENCES users(userId),
    constraint FK_ratings_movie FOREIGN KEY (movieId) REFERENCES movies(movieId)


);

