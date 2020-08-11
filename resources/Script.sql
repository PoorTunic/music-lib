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
    FOREIGN KEY (ID_band) REFERENCES band(ID_band) ON DELETE CASCADE
);

CREATE TABLE album(
    ID_album SERIAL PRIMARY KEY,
    ID_band INTEGER,
    name VARCHAR(30),
    departure DATE,
    comment VARCHAR(50),
    ID_genre INTEGER,
    FOREIGN KEY (ID_band) REFERENCES band(ID_band) ON DELETE CASCADE,
    FOREIGN KEY (ID_genre) REFERENCES genre(ID_genre)
);

CREATE TABLE song(
    ID_song SERIAL PRIMARY KEY,
    ID_album INTEGER,
    name VARCHAR(30),
    release DATE,
    comment VARCHAR(50),
    publisher VARCHAR(50),
    FOREIGN KEY (ID_album) REFERENCES  album(ID_album) ON DELETE CASCADE
);

INSERT INTO "genre" (ID_genre,name) VALUES (0,'GAME'),(1,'MEDITATIVE'),(2,'BLUEGRASS'),(3,'PSYCHEDELIC ROCK'),(4,'OLDIES'),(5,'SYMPHONY'),(6,'SOUL'),(7,'BEBOB'),(8,'FAST FUSION'),(9,'POP');
INSERT INTO "genre" (ID_genre,name) VALUES (10,'ACID'),(11,'POLKA'),(12,'VOCAL'),(13,'SONATA'),(14,'RAVE'),(15,'TRAILER'),(16,'OLDIES'),(17,'JUNGLE'),(18,'CELTIC'),(19,'PSYCHEDELIC ROCK');
INSERT INTO "genre" (ID_genre,name) VALUES (20,'OTHER'),(21,'FUNK'),(22,'POP'),(23,'PORN GROOVE'),(24,'ROCK & ROLL'),(25,'GOTHIC'),(26,'NOISE'),(27,'HUMOUR'),(28,'PUNK'),(29,'DRUM SOLO');
INSERT INTO "genre" (ID_genre,name) VALUES (30,'TECHNO-INDUSTRIAL'),(31,'FOLKLORE'),(32,'NEW WAVE'),(33,'SYMPHONY'),(34,'DANCE'),(35,'ELECTRONIC'),(36,'MEDITATIVE'),(37,'MUSICAL'),(38,'CLASSIC ROCK'),(39,'AMBIENT');
INSERT INTO "genre" (ID_genre,name) VALUES (40,'TECHNO'),(41,'MUSICAL'),(42,'GRUNGE'),(43,'TRIBAL'),(44,'BASS'),(45,'TANGO'),(46,'BLUEGRASS'),(47,'CHANSON'),(48,'ACAPELLA'),(49,'POP/FUNK');
INSERT INTO "genre" (ID_genre,name) VALUES (50,'CLUB'),(51,'BEBOB'),(52,'CHANSON'),(53,'OPERA'),(54,'DREAM'),(55,'GRUNGE'),(56,'POP-FOLK'),(57,'METAL'),(58,'SONATA'),(59,'TRANCE');
INSERT INTO "genre" (ID_genre,name) VALUES (60,'VOCAL'),(61,'GOTHIC ROCK'),(62,'RAVE'),(63,'SOUL'),(64,'CELTIC'),(65,'PUNK ROCK'),(66,'ACID PUNK'),(67,'POP'),(68,'AVANTGARDE'),(69,'ACID');
INSERT INTO "genre" (ID_genre,name) VALUES (70,'TANGO'),(71,'FOLKLORE'),(72,'TRIBAL'),(73,'SOUND CLIP'),(74,'RAVE'),(75,'DREAM'),(76,'RHYTHMIC SOUL'),(77,'BIG BAND'),(78,'GAME'),(79,'PUNK');
INSERT INTO "genre" (ID_genre,name) VALUES (80,'ELECTRONIC'),(81,'DISCO'),(82,'INSTRUMENTAL ROCK'),(83,'EASY LISTENING'),(84,'GOSPEL'),(85,'HIP-HOP'),(86,'ELECTRONIC'),(87,'SKA'),(88,'TRAILER'),(89,'ALTERNATIVE');
INSERT INTO "genre" (ID_genre,name) VALUES (90,'CLASSICAL'),(91,'INSTRUMENTAL ROCK'),(92,'DREAM'),(93,'BEBOB'),(94,'AMBIENT'),(95,'GOTHIC'),(96,'REVIVAL'),(97,'LO-FI'),(98,'RAP'),(99,'INDUSTRIAL');

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
