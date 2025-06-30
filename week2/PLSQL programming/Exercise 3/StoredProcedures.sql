CREATE DATABASE IF NOT EXISTS ExerciseStoredProcedures;
USE ExerciseStoredProcedures;

SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Employees;

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(10,2),
    LastModified DATE
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary DECIMAL(10,2),
    Department VARCHAR(50),
    HireDate DATE
);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES
(1, 1, 'Savings', 5000.00, CURDATE()),
(2, 1, 'Checking', 3000.00, CURDATE()),
(3, 2, 'Savings', 12000.00, CURDATE()),
(4, 3, 'Checking', 1500.00, CURDATE());

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES
(1, 'Alice Johnson', 'Manager', 70000.00, 'HR', '2015-06-15'),
(2, 'Bob Brown', 'Developer', 60000.00, 'IT', '2017-03-20'),
(3, 'Chris Lee', 'Analyst', 55000.00, 'Finance', '2019-09-01'),
(4, 'Diana Smith', 'Developer', 62000.00, 'IT', '2020-11-10');

DELIMITER $$
DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01),
      LastModified = CURDATE()
  WHERE AccountType = 'Savings';
END $$

DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS UpdateEmployeeBonus;

CREATE PROCEDURE UpdateEmployeeBonus(
  IN deptName VARCHAR(50),
  IN bonusPercent DECIMAL(5,2)
)
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonusPercent / 100)
  WHERE Department = deptName;
END $$

DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS TransferFunds;
CREATE PROCEDURE TransferFunds(
  IN fromAccount INT,
  IN toAccount INT,
  IN amount DECIMAL(10,2)
)
BEGIN
  DECLARE fromBalance DECIMAL(10,2);

  SELECT Balance INTO fromBalance
  FROM Accounts
  WHERE AccountID = fromAccount;

  IF fromBalance >= amount THEN
    UPDATE Accounts
    SET Balance = Balance - amount,
        LastModified = CURDATE()
    WHERE AccountID = fromAccount;

    UPDATE Accounts
    SET Balance = Balance + amount,
        LastModified = CURDATE()
    WHERE AccountID = toAccount;
  ELSE
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Insufficient funds for transfer.';
  END IF;
END $$

DELIMITER ;

CALL ProcessMonthlyInterest();
CALL UpdateEmployeeBonus('IT', 10);
CALL TransferFunds(1, 2, 1000);

SELECT * FROM Accounts;
SELECT * FROM Employees;

/*
 Note:
 - If you are using an online SQL compiler (like OneCompiler),
   comment out or remove these lines at the top:
   -- CREATE DATABASE IF NOT EXISTS ExerciseControlStructures;
   -- USE ExerciseControlStructures;
*/
