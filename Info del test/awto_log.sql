CREATE DATABASE awto_log;

USE awto_log;

CREATE TABLE aw_log(
	id INTEGER AUTO_INCREMENT,
	creation_date TIMESTAMP,
	host TEXT,
	details TEXT,
	PRIMARY KEY(id)
);

INSERT INTO aw_log VALUES 
(NULL, NOW(), 'host1', 'details1'),
(NULL, NOW(), 'host1', 'details2'),
(NULL, NOW(), 'host1', 'details3');

CREATE TABLE aw_hashtag(
	id INTEGER AUTO_INCREMENT,
	description VARCHAR(50),
	PRIMARY KEY(id)
);

INSERT INTO aw_hashtag VALUES
(NULL, 'vehicle'), 
(NULL, 'purchaseorder'), 
(NULL, 'trip');

CREATE TABLE aw_hashtag_log(
	id INTEGER AUTO_INCREMENT,
	log_id INTEGER,
	hashtag_id INTEGER,	
	PRIMARY KEY(id),
	FOREIGN KEY(log_id) REFERENCES aw_log(id),
	FOREIGN KEY(hashtag_id) REFERENCES aw_hashtag(id)
);


INSERT INTO aw_hashtag_log VALUES
(NULL, 1, 1),
(NULL, 2, 1), (NULL, 2, 2), 
(NULL, 3, 1), (NULL, 3, 2), (NULL, 3, 3) ;

SELECT * FROM aw_log;
SELECT * FROM aw_hashtag;
SELECT * FROM aw_hashtag_log;