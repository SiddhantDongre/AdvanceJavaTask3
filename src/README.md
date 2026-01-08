# Student Management JDBC Project

## Project Overview
This is a simple Java program to **insert student details** into a MySQL database using **JDBC**.  
It demonstrates basic database operations like connecting to MySQL and adding new records.

---

## Table Used
**Table Name:** `studentaddinto`

| Column Name | Data Type |
|-------------|-----------|
| id          | INT       |
| name        | VARCHAR(50) |
| age         | INT       |

**SQL to create table:**

```sql
CREATE TABLE studentaddinto (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
