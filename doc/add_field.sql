



DROP PROCEDURE IF EXISTS addField;
CREATE PROCEDURE addField ( IN dbName VARCHAR ( 20 ),IN fieldName VARCHAR ( 50 ), IN fieldProp VARCHAR ( 200 )) BEGIN
	DECLARE
s_tablename VARCHAR ( 200 );
	DECLARE
cur_table_structure1 CURSOR FOR (
		SELECT
			table_name
		FROM
			INFORMATION_SCHEMA.TABLES
		WHERE
			table_schema = dbName
			AND table_name NOT IN (
			SELECT
				t.table_name
			FROM
				( SELECT table_name, column_name FROM information_schema.COLUMNS WHERE table_name IN ( SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = dbName ) ) t
			WHERE
				t.column_name = fieldName
			)
		);
	DECLARE
CONTINUE HANDLER FOR SQLSTATE '02000'
		SET s_tablename = NULL;
OPEN cur_table_structure1;
FETCH cur_table_structure1 INTO s_tablename;
WHILE
( s_tablename IS NOT NULL ) DO
			SET @MyQuery = CONCAT( "alter table ",dbName,".", s_tablename, " add COLUMN ", fieldName, " ", fieldProp );
PREPARE MSQL
    FROM
    @MyQuery;
EXECUTE MSQL;
FETCH cur_table_structure1 INTO s_tablename;

END WHILE;
CLOSE cur_table_structure1;
END;











# 添加公共字段字段
set @g_dbName="g_sys";

CALL addField(@g_dbName,"deleted","tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标识：0-未删除；1-已删除'");
CALL addField(@g_dbName,"version","bigint(20) NOT NULL DEFAULT 0 COMMENT '乐观行锁控制字段' AFTER deleted");
CALL addField(@g_dbName,"create_time","datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间' AFTER version");
CALL addField(@g_dbName,"create_by","bigint(20) NOT NULL DEFAULT 0 COMMENT '创建人ID' AFTER create_time");
CALL addField(@g_dbName,"create_user","varchar(64) NOT NULL DEFAULT '-' COMMENT '创建人' AFTER create_by");
CALL addField(@g_dbName,"update_time","datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间' AFTER create_user");
CALL addField(@g_dbName,"update_by","bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人ID' AFTER update_time");
CALL addField(@g_dbName,"update_user","varchar(64) NOT NULL DEFAULT '-' COMMENT '修改人' AFTER update_by");

