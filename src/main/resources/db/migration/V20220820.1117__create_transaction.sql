CREATE TABLE IF NOT EXISTS rest_test_transaction
  (
     id           INT PRIMARY KEY auto_increment,
     company_name VARCHAR(255) NOT NULL,
     ledger       VARCHAR(255) NOT NULL,
     amount       DECIMAL(5, 2) NOT NULL,
     create_date  DATE NOT NULL DEFAULT CURRENT_DATE
  )