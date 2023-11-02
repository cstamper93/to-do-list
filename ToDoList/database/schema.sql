BEGIN TRANSACTION;

DROP TABLE IF EXISTS item;

CREATE TABLE item (
    item_id SERIAL,
    item varchar(100) NOT NULL,
    CONSTRAINT PK_item PRIMARY KEY (item_id)
);

COMMIT;