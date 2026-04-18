CREATE VIEW v_filmes_mais_populares AS
SELECT m.title, COUNT(r.ratingid) AS quantidade_avaliacoes
FROM movies m
JOIN ratings r ON m.movieid = r.movieid
GROUP BY m.title
ORDER BY quantidade_avaliacoes DESC
LIMIT 5;

CREATE VIEW v_melhor_avaliacao_media AS
SELECT m.genre, AVG(r.rating) as media_avaliacoes
FROM movies m 
JOIN ratings r ON m.movieid = r.movieid
GROUP BY m.genre
ORDER BY media_avaliacoes DESC
LIMIT 50;


DROP VIEW v_melhor_avaliacao_media;

SELECT * FROM v_melhor_avaliacao_media;



SELECT * FROM v_filmes_mais_populares;