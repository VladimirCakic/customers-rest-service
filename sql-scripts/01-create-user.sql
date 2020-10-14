CREATE USER 'vlade'@'localhost' IDENTIFIED BY 'somePassw00rd';
GRANT ALL PRIVILEGES ON * . * TO 'vlade'@'localhost';
ALTER USER 'vlade'@'localhost' IDENTIFIED WITH mysql_native_password BY 'somePassw00rd';
