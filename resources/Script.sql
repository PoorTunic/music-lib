DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE genre(
    ID_genre SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE band(
    ID_band SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE artist(
    ID_artist SERIAL PRIMARY KEY,
    ID_band INTEGER,
    nickname VARCHAR(30),
    name VARCHAR(30),
    debut DATE,
    bio VARCHAR(500),
    FOREIGN KEY (ID_band) REFERENCES band(ID_band)
);

CREATE TABLE album(
    ID_album SERIAL PRIMARY KEY,
    ID_band INTEGER,
    name VARCHAR(30),
    departure DATE,
    comment VARCHAR(50),
    ID_genre INTEGER,
    FOREIGN KEY (ID_band) REFERENCES band(ID_band),
    FOREIGN KEY (ID_genre) REFERENCES genre(ID_genre)
);

CREATE TABLE song(
    ID_song SERIAL PRIMARY KEY,
    ID_album INTEGER,
    name VARCHAR(30),
    release DATE,
    comment VARCHAR(50),
    publisher VARCHAR(50),
    FOREIGN KEY (ID_album) REFERENCES  album(ID_album)
);

INSERT INTO genre VALUES(DEFAULT, 'ROCK');
INSERT INTO genre VALUES(DEFAULT, 'POP');
INSERT INTO genre VALUES(DEFAULT, 'ELECTRONIC');
INSERT INTO genre VALUES(DEFAULT, 'EDM');
INSERT INTO genre VALUES(DEFAULT, 'BLUES');
INSERT INTO genre VALUES(DEFAULT, 'JAZZ');

INSERT INTO band VALUES(DEFAULT, 'METALLICA');
INSERT INTO artist VALUES(DEFAULT, 1, '', 'LARS ULRICH', '1981-01-01', 'Lars Ulrich (Gentofte, 26 de diciembre de 1963) es un músico danés conocido principalmente por ser el baterista, compositor, fundador y líder (junto a James Hetfield) de la banda de Thrash metal estadounidense Metallica.');
INSERT INTO artist VALUES(DEFAULT, 1, '', 'JAMES ALAN HETFIELD', '1978-01-01', 'James Alan Hetfield (Downey, California; 3 de agosto de 1963) es un músico estadounidense conocido por ser el vocalista, guitarrista rítmico y principal compositor de la banda de thrash metal Metallica, además de ser cofundador de la misma junto con Lars Ulrich.');

INSERT INTO band VALUES(DEFAULT, 'LUIS MIGUEL');
INSERT INTO artist VALUES(DEFAULT, 2, 'LUIS MIGUEL', 'SOL DE MEXICO', '1980-01-01', 'Luis Miguel Gallego Basteri (San Juan, Puerto Rico; 19 de abril de 1970),​ apodado a veces como el Sol de México,​ es un cantante y productor musical mexicano​ nacido en Puerto Rico.');

INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1);

INSERT INTO song VALUES(DEFAULT, 1, 'NOTHING ELSE MATTERS', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 1, 'BATTERY', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 1, 'SEEK AND DESTROY', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 1, 'ONE', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 1, 'THE UNFORGIVEN', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
