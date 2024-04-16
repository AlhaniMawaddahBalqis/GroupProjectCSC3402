CREATE TABLE MEDICATIONS
(medID VARCHAR2(100),
 name VARCHAR2(100),
 brand VARCHAR2(100),
 dosage VARCHAR2(100),
 quantity NUMBER,
 expdate DATE,
 supplierID VARCHAR2(100),
 price VARCHAR2(100));
  
CREATE TABLE SUPPLIER
(supplierID VARCHAR2(100),
 name VARCHAR2(100),
 contactnum VARCHAR2(100),
 email VARCHAR2(100),
 address VARCHAR2(100));
 
 CREATE TABLE PRESCRIPTIONS
(prescID VARCHAR2(100),
 patientID VARCHAR2(100),
 medID VARCHAR2(100),
 physicianID VARCHAR2(100),
 prescdate DATE,
 dosage VARCHAR2(100));
 
CREATE TABLE PATIENT
(patientID VARCHAR2(100),
 name VARCHAR2(100),
 contactno VARCHAR2(100),
 DOB DATE,
 IC VARCHAR2(100),
 gender CHAR(1));
 
CREATE TABLE PHARMACIST
(pharmacistID VARCHAR2(100),
 name VARCHAR2(100),
 contactno VARCHAR2(100),
 email VARCHAR2(100),
 hiredate DATE,
 credentials VARCHAR2(100));
 
CREATE TABLE PHYSICIAN
(physicianID VARCHAR2(100),
 name VARCHAR2(100),
 contactno VARCHAR2(100),
 email VARCHAR2(100),
 prescdate DATE);
 
CREATE TABLE INVENTORY
(inventoryID VARCHAR2(100),
 medID VARCHAR2(100),
 quantity NUMBER);
 
CREATE TABLE TRANSACTION
(transactionID NUMBER PRIMARY KEY,
prescID NUMBER,
inventoryID VARCHAR2(100),
transactiontype VARCHAR2(100),
transactiondate DATE,
quantity NUMBER,
unitprice NUMBER,
totalprice NUMBER);
 
