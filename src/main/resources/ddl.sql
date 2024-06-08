CREATE SСНЕМА MUSICDB;
GRANT ALL PRIVILEGES ON MUSICDB . *
то 'prospringS'@'localhost';
FLUSH PRIVILEGES;
/* На тот случай, если возникнет исключение
типа java.sql.SQLException: значение 'UTC'
часового пояса не распознано или представляет
не один часовой пояс. */
SET GLOBAL time zone = '+3:00';