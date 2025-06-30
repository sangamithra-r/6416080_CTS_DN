CREATE DATABASE IF NOT EXISTS ExerciseControlStructures;
USE ExerciseControlStructures;

SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Customers;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance DECIMAL(10,2),
    LoanInterestRate DECIMAL(5,2),
    IsVIP VARCHAR(3) DEFAULT 'NO'
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount DECIMAL(10,2),
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES
(1, 'Ravi', '1960-06-01', 15000, 9.5, 'NO'),
(2, 'Meena', '1980-08-20', 5000, 10.0, 'NO'),
(3, 'John', '1950-01-15', 12000, 11.0, 'NO'),
(4, 'Sara', '1995-03-10', 9500, 8.5, 'NO');

INSERT INTO Loans VALUES
(101, 1, 10000, DATE_ADD(CURDATE(), INTERVAL 10 DAY)),
(102, 2, 8000, DATE_ADD(CURDATE(), INTERVAL 40 DAY)),
(103, 3, 6000, DATE_ADD(CURDATE(), INTERVAL 5 DAY)),
(104, 4, 9000, DATE_ADD(CURDATE(), INTERVAL 20 DAY));

UPDATE Customers
SET LoanInterestRate = LoanInterestRate - 1
WHERE CustomerID IN (
  SELECT CustomerID FROM (
    SELECT CustomerID
    FROM Customers
    WHERE TIMESTAMPDIFF(YEAR, DOB, CURDATE()) > 60
  ) AS Sub
);

UPDATE Customers
SET IsVIP = 'YES'
WHERE Balance > 10000;

SELECT 
  CustomerID,
  Name,
  DATE_FORMAT(DOB, '%Y-%m-%d') AS DOB,
  Balance,
  LoanInterestRate,
  IsVIP
FROM Customers;

SELECT 
  c.Name AS CustomerName,
  l.LoanID,
  DATE_FORMAT(l.EndDate, '%d-%b-%Y') AS DueDate,
  CONCAT('Reminder: Dear ', c.Name, ', your loan is due on ', DATE_FORMAT(l.EndDate, '%d-%b-%Y')) AS ReminderMessage
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

/*
 Note:
 - If you are using an online SQL compiler (like OneCompiler),
   comment out or remove these lines at the top:
   -- CREATE DATABASE IF NOT EXISTS ExerciseControlStructures;
   -- USE ExerciseControlStructures;
*/
