CREATE USER epam_user WITH PASSWORD 'epam' CREATEDB;
CREATE DATABASE user_db
    WITH
    OWNER = epam_user
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE USER epam_post WITH PASSWORD 'epam' CREATEDB;
CREATE DATABASE post_db
    WITH
    OWNER = epam_post
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;