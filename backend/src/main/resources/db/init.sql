-- Criação do usuário da aplicação
CREATE USER APP_USER IDENTIFIED BY changeit;

-- Concede permissões básicas
GRANT CONNECT, RESOURCE TO APP_USER;
GRANT CREATE SESSION TO APP_USER;
GRANT CREATE TABLE TO APP_USER;
GRANT CREATE SEQUENCE TO APP_USER;
GRANT CREATE TRIGGER TO APP_USER;
GRANT CREATE VIEW TO APP_USER;

-- (Opcional) Permissão para criar sinônimos públicos
GRANT CREATE PUBLIC SYNONYM TO APP_USER;

-- (Opcional) Criar tablespace dedicada (se quiser separar do SYSTEM)
-- CREATE TABLESPACE app_data DATAFILE 'app_data.dbf' SIZE 50M AUTOEXTEND ON;
-- ALTER USER APP_USER DEFAULT TABLESPACE app_data QUOTA UNLIMITED ON app_data;
