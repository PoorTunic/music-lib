DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE genre(
    ID_genre SERIAL PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE song(
    ID_song SERIAL PRIMARY KEY,
    name VARCHAR(30),
    release DATE,
    comment VARCHAR(50),
    publisher VARCHAR(50)
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
    ID_song INTEGER,
    FOREIGN KEY (ID_band) REFERENCES band(ID_band),
    FOREIGN KEY (ID_genre) REFERENCES genre(ID_genre),
    FOREIGN KEY (ID_song) REFERENCES song(ID_song)
);

CREATE OR REPLACE FUNCTION persistGenre(vIDGenre INTEGER, vName VARCHAR(30)) RETURNS TABLE(ID_genre INTEGER) AS $TER$
BEGIN
    IF vIDGenre > 0 THEN
        INSERT INTO genre VALUES(DEFAULT, vName) RETURNING genre.ID_genre;
    ELSE 
        UPDATE genre SET name=vName WHERE genre.ID_genre=vIDGenre RETURNING genre.ID_genre;
    END IF;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION deleteGenre(vIDGenre INTEGER) RETURNS VOID AS $TER$
BEGIN
    DELETE FROM genre WHERE genre.ID_genre=vIDGenre;
END;
$TER$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION persistBand(vName VARCHAR(30)) RETURNS TABLE(ID_Band INT) AS $TER$
BEGIN
    INSERT INTO band VALUES(DEFAULT, vName);    
    RETURN QUERY SELECT band.ID_band FROM band WHERE band.name=vName; 
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION deleteBand(vIDBand INTEGER) RETURNS VOID AS $TER$
BEGIN
    DELETE FROM band WHERE band.ID_band=vIDBand;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION persistArtist(vIDArtist INTEGER, vIDBand INTEGER, vArtisticName VARCHAR(30), vName VARCHAR(30), vLastName VARCHAR(30), vDebut DATE, vBio VARCHAR(200)) RETURNS VOID AS $TER$
BEGIN
    IF vIDArtist IS NULL THEN
        INSERT INTO artist VALUES(DEFAULT, vIDBand, vArtisticName, vName, vLastName, vDebut, vBio);
    ELSE
        UPDATE artist SET ID_band=vIDBand, artistic_name=vArtisticName, name=vName, last_name=vLastName, debut=vDebut, bio=vBio WHERE ID_artist=vIDArtist;
    END IF;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION deleteArtist(vIDArtist INTEGER) RETURNS VOID AS $TER$
BEGIN
    DELETE FROM artist WHERE artist.ID_artist=vIDArtist;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION persistAlbum(vIDAlbum INTEGER, vIDBand INTEGER, vName VARCHAR(30), vDeparture DATE, vComment VARCHAR(50), vIDGenre INTEGER, vIDSong INTEGER) RETURNS VOID AS $TER$
BEGIN
    IF vIDAlbum IS NULL THEN
        INSERT INTO album VALUES(DEFAULT, vIDBand, vName, vDeparture, vComment, vIDGenre, vIDSong);
    ELSE
        UPDATE album SET ID_band=vIDBand, name=vName, departure=vDeparture, comment=vComment, ID_genre=vIDGenre, ID_song=vIDSong WHERE album.ID_album=vIDAlbum;
    END IF;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION deleteAlbum(vIDAlbum INTEGER) RETURNS VOID AS $TER$
BEGIN
    DELETE FROM album WHERE album.ID_album=vIDAlbum;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION getSongsByAlbumName(vQuery VARCHAR(50)) RETURNS TABLE(id_song INTEGER, song_name VARCHAR(30)) AS $TER$
DECLARE
    recRow RECORD;
BEGIN
    FOR recRow IN SELECT song.id_song, song.name FROM song INNER JOIN album ON song.id_song = album.id_song WHERE album.name LIKE CONCAT('%', vQuery, '%') LOOP
        id_song := recRow.id_song;
        song_name := recRow.name;
        RETURN NEXT;
    END LOOP;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION getSongsByBandSolistName(vQuery VARCHAR(50)) RETURNS TABLE(id_song INTEGER, song_name VARCHAR(30)) AS $TER$
DECLARE
    recRow RECORD;
BEGIN
    FOR recRow IN 
    SELECT song.id_song, song.name FROM song INNER JOIN album ON song.id_song = album.id_song INNER JOIN band ON album.id_band=band.id_band WHERE band.name LIKE CONCAT('%', vQuery, '%') LOOP
        id_song := recRow.id_song;
        song_name := recRow.name;
        RETURN NEXT;
    END LOOP;
END;
$TER$ LANGUAGE PLPGSQL;

CREATE OR REPLACE FUNCTION getSongsByArtistName(vQuery VARCHAR(50)) RETURNS TABLE(id_song INTEGER, song_name VARCHAR(30)) AS $TER$
DECLARE
    recRow RECORD;
BEGIN
    FOR recRow IN SELECT song.id_song, song.name FROM song INNER JOIN album ON song.id_song = album.id_song INNER JOIN band ON album.id_band=band.id_band INNER JOIN artist ON band.id_band=artist.id_band  WHERE artist.name LIKE CONCAT('%', vQuery, '%') LOOP
        id_song := recRow.id_song;
        song_name := recRow.name;
        RETURN NEXT;
    END LOOP;
END;
$TER$ LANGUAGE PLPGSQL;

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

INSERT INTO song VALUES(DEFAULT, 'NOTHING ELSE MATTERS', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 'BATTERY', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 'SEEK AND DESTROY', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 'ONE', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');
INSERT INTO song VALUES(DEFAULT, 'THE UNFORGIVEN', '2000-01-01', 'THIS IS A SUICIDAL SONG', 'ELEKTRA');

INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1, 1);
INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1, 2);
INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1, 3);
INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1, 4);
INSERT INTO album VALUES(DEFAULT, 1, 'GARAGE INC.', '2000-01-01', 'COOL ALBUM', 1, 5);


SELECT getSongsByAlbumName('INC');

SELECT getSongsByArtistName('JAMES');

SELECT getSongsByBandSolistName('METALLICA');
