INSERT INTO uwork.Usuario
VALUES ('viniciusouza7@gmail.com', '1234#teste', 'VINICIUS O. SOUZA', 'AV. PARAMIRIM, 2517 - BRASIL', 77920001321 );

INSERT INTO uwork.Usuario
VALUES ('wesley@gmail.com', '1234#teste', 'WESLEY FERREIRA', 'AV. OLIVIA FLORES, 25 - CANDEIAS', 77999999999 );

INSERT INTO uwork.Usuario
VALUES ('uzel@gmail.com', '1234#teste', 'GABRIEL UZEL', 'AV. GOES CALMON, 410 - CENTRO', 77922224444 );

INSERT INTO uwork.Usuario
VALUES ('uzel@gmail.com', '1234#teste', 'JOSE JUNIO', 'AV. YOLANDO FONSECA, 110 - JUREMA', 77911223344 );

INSERT INTO uwork.Usuario
VALUES ('google@gmail.com', '1234#teste', 'GOOGLE SA', 'FRINS, 110 - BEVERLY', 77900012233 );

INSERT INTO uwork.PF
VALUES (11122233344,'viniciusouza7@gmail.com');

INSERT INTO uwork.PF
VALUES (22233344455,'uzel@gmail.com');

INSERT INTO uwork.PF
VALUES (12345678900,'viniciusouza7@gmail.com');

INSERT INTO uwork.PJ
VALUES (12345678900000, 'V7TECH', 'viniciusouza7@gmail.com');

INSERT INTO uwork.PJ
VALUES (09876568900000, 'GOOGLE SA', 'google@gmail.com');

INSERT INTO uwork.Formacao (f_curso, f_instituicao, f_tipo_registro, f_n_registro, f_registro, f_fk_pf_fk_usuario_email)
VALUES ('CIENCIA DA COMPUTACAO', 'UESB', null, null, false, 'viniciusouza7@gmail.com');

INSERT INTO uwork.Formacao (f_curso, f_instituicao, f_tipo_registro, f_n_registro, f_registro, f_fk_pf_fk_usuario_email)
VALUES ('CIENCIA DA COMPUTACAO', 'UESB', null, null, false, 'uzel@gmail.com');

INSERT INTO uwork.Vaga (v_nome, v_area_atuacao, v_regime, v_descricao, v_salario, v_data_criacao, v_data_limite, v_status, v_registro, v_tipo_registro, v_fk_usuario_email)
VALUES ('DESENVOLVEDOR JAVA BACKEND JR.', 'COMPUTACAO', 'CLT', null, 4000, '01-11-2022', '30-11-2022', null, false, null, 'google@gmail.com');

DELETE FROM uwork.Usuario;
