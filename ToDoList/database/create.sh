#!bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=to_do_list_db
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
-d $DATABASE -f "$BASEDIR/user.sql"