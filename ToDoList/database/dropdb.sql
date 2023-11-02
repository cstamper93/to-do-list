-- This script destroys database

SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'to_do_list_db';

DROP DATABASE to_do_list_db;