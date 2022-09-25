create table dbtesttable(
tid number primary key,
tname varchar2(20) not null
);

insert into dbtesttable
values(2, 'won');

select * from dbtesttable;

commit;

--TABLE_NAME				
DROP TABLE	#NAME	;		
CREATE TABLE	#NAME	(		
		);		
--SEQUENCE_NAME				
DROP SEQUENCE	#NAME	;		
CREATE SEQUENCE	#NAME	;		
				
--INSERT USER				
INSERT INTO 	PROLINGO_USER	(		
USER_ID	,			
USER_PW	,			
DEFAULAT_EMAIL	,			
EMAIL	,			
USER_NAME	,			
NICKNAME	)			
VALUES	(			
1	,			
123	,			
'aaa@aaa.aaa'	,			
'aaa@aaa.aaa'	,			
'aaa'	,			
'aaa'	);			
				
INSERT INTO 	PROLINGO_USER	(		
USER_ID	,			
USER_PW 	,			
DEFAULAT_EMAIL	,			
EMAIL	,			
USER_NAME	,			
NICKNAME	)			
VALUES	(			
2	,			
123	,			
'bbb@bbb.bbb'	,			
'bbb@bbb.bbb'	,			
'bbb'	,			
'bbb'	);			
				
INSERT INTO	FOLLOW	(USER_ID, TARGET_ID)		
VALUES 	(1, 2);			
				
INSERT INTO 	WEEKLY_EXP	(USER_ID)		
VALUES	(2);			
				
SELECT	*	FROM	PROLINGO_USER;	
SELECT	*	FROM	FOLLOW;	
SELECT	*	FROM	WEEKLY_EXP;	
				
DELETE	FROM	PROLINGO_USER		
WHERE	user_id = 2;			
