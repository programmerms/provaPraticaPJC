# usuario: admin e senha admin123
INSERT INTO tb_usuario (id, user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, data_alteracao, data_criacao) VALUES (1, 'admin', 'Usuario Admin', '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', true, true, true, true, null, null);
INSERT INTO tb_permissao (id, description, data_alteracao, data_criacao) VALUES (1, 'ADMIN', null, null);
INSERT INTO tb_permissao (id, description, data_alteracao, data_criacao) VALUES (2, 'MANAGER', null, null);
INSERT INTO provapjc.tb_usuario_permissao (id_usuario, id_permissao) VALUES (1, 1);