-- Logic for returning bank account details for a user when username and password are entered. 

-- trial procedure -- 
CREATE OR REPLACE PROCEDURE SP_USR_VIEW_ACCOUNT(UNAME IN USR.USERNAME%TYPE, PWORD IN USR.PASSWORD%TYPE, S OUT SYS_REFCURSOR) IS
BEGIN 
    OPEN S FOR
    SELECT B.BANK_ACCOUNT_ID, B.USR_ID, B.ACCOUNT_TYPE_ID, B.BALANCE
    FROM BANK_ACCOUNT B
    INNER JOIN USR 
    ON 
        USR.USR_ID = B.USR_ID
    WHERE 
        (USR.USERNAME=UNAME) AND (USR.PASSWORD=PWORD); 
END; 

--test for USR_VIEW_ACCOUNT --
DECLARE 
S SYS_REFCURSOR; 
ACC_ID BANK_ACCOUNT.BANK_ACCOUNT_ID%TYPE; 
USR_ID BANK_ACCOUNT.USR_ID%TYPE; 
ACC_TYPE BANK_ACCOUNT.ACCOUNT_TYPE_ID%TYPE; 
BAL BANK_ACCOUNT.BALANCE%TYPE; 
BEGIN 
SP_USR_VIEW_ACCOUNT('BJones', 'p@ssword', S); 
LOOP
FETCH S INTO ACC_ID, USR_ID, ACC_TYPE, BAL; 
EXIT WHEN S%NOTFOUND; 
DBMS_OUTPUT.PUT_LINE('Account ID: '||ACC_ID||' User ID: '||USR_ID||' Account Type: '||ACC_TYPE||' Balance: '||BAL); 
END LOOP; 
CLOSE S; 
END; 

-- pull bank acccount balance by user id --  
SELECT BALANCE 
FROM BANK_ACCOUNT 
WHERE USR_ID = 2; 


--This logic works
SELECT *
FROM BANK_ACCOUNT B
WHERE 
    B.USR_ID = 2; 


-- logic for a user to create an account --- 
 
INSERT INTO BANK_ACCOUNT(USR_ID, ACCOUNT_TYPE_ID, BALANCE)
VALUES (5, 2, 100);



-- logic for a user to delete an account if it is empty --
-- NOTE, there are not checks here to see if the account is empty. This is simply the logic to delete. 

-- first empty an account --- 
UPDATE BANK_ACCOUNT
SET BALANCE = 0
WHERE 
    BANK_ACCOUNT_ID = 2; 
/ 

-- next delete ----
DELETE FROM 
    BANK_ACCOUNT 
WHERE 
    BANK_ACCOUNT_ID = 2; 
/ 



--- logic for deposits and withdrawals ----
-- * * * will write this in java * * *  



-- logic for superusers 

-- view all acounts 

SELECT B.BANK_ACCOUNT_ID, B.ACCOUNT_TYPE_ID, B.BALANCE, U.USR_ID, U.FIRSTNAME, U.LASTNAME, U.USERNAME, U.PASSWORD, U.USR_TYPE_ID
FROM BANK_ACCOUNT B
LEFT JOIN USR U
ON 
    U.USR_ID = B.USR_ID; 

-- view all accounts simpler versioin -- 

SELECT * 
FROM BANK_ACCOUNT; 

-- logic to build transation table -- 
CREATE OR REPLACE PROCEDURE  SP_GET_MAX_ACTIVITY(INDX OUT INTEGER) AS 
BEGIN 
SELECT MAX(ACTIVITY_ID) INTO INDX
FROM ACTIVITY; 
END;
/ 

-- test of stored procudure -- 
DECLARE 
INDX INTEGER; 
BEGIN 
    SP_GET_MAX_ACTIVITY(INDX); 
    DBMS_OUTPUT.PUT_LINE('Max Index is : '||INDX); 
END; 

-- update activity fields --- 
/*
UPDATE ACTIVITY A
SET 
A.BANK_ACCOUNT_ID = ?
A.ACTIVITY_TYPE_ID = ?, 
A.TX_DESCRIPTION = ? 
WHERE 
A.ACTIVITY_ID = ? "; 
*/

--- add balance column to activity table -- 
ALTER TABLE ACTIVITY
ADD  CURRENT_BALANCE DOUBLE PRECISION;
/ 

--test -- 

UPDATE BANK_ACCOUNT  
SET BALANCE = 10   
WHERE BANK_ACCOUNT_ID = 5; 
COMMIT; 
/ 

--pull up a user's transaction history -- 
SELECT *
FROM ACTIVITY 
WHERE BANK_ACCOUNT_ID = 5; 

-- logic to update an account -- 

