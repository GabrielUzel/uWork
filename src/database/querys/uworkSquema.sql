/* uWork Squema/Tables */
CREATE TABLE uwork.Usuario (
    u_email VARCHAR(50) PRIMARY KEY,
    u_senha VARCHAR(20) NOT NULL,
    u_nome VARCHAR(50) NOT NULL,
    u_logradouro VARCHAR(50),
    u_numero NUMERIC(5),
    u_bairro VARCHAR(20),
    u_complemento VARCHAR(20)
    u_cidade VARCHAR(20),
    u_estado VARCHAR(20),
    u_pais VARCHAR(20),
    u_cep NUMERIC(8),
    u_telefone NUMERIC(11)
);


CREATE TABLE uwork.PJ (
    pj_CNPJ NUMERIC(14) UNIQUE NOT NULL,
    pj_razao_social VARCHAR(50) NOT NULL,
    pj_FK_Usuario_email VARCHAR(50) PRIMARY KEY
);


CREATE TABLE uwork.PF (
    pf_CPF NUMERIC(11) UNIQUE NOT NULL,
    pf_FK_Usuario_email VARCHAR(50) PRIMARY KEY
);


CREATE TABLE uwork.Experiencia (
    e_id SERIAL PRIMARY KEY,
    e_cargo VARCHAR(50) NOT NULL,
    e_data_inicio DATE NOT NULL,
    e_data_fim DATE NOT NULL,
    e_descricao VARCHAR(200),
    e_nome_empresa VARCHAR(50) NOT NULL,
    e_fk_PF_FK_Usuario_email VARCHAR(50)
);


CREATE TABLE uwork.Formacao (
    f_id SERIAL PRIMARY KEY,
    f_curso VARCHAR(50) NOT NULL,
    f_instituicao VARCHAR(50) NOT NULL,
    f_tipo_registro VARCHAR(10),
    f_n_registro NUMERIC(10),
    f_registro BOOLEAN NOT NULL,
    f_fk_PF_FK_Usuario_email VARCHAR(50)
);


CREATE TABLE uwork.Vaga (
    v_id SERIAL PRIMARY KEY,
    v_nome VARCHAR(50) NOT NULL,
    v_area_atuacao VARCHAR(50) NOT NULL,
    v_regime VARCHAR(50) NOT NULL,
    v_descricao VARCHAR(200),
    v_salario DECIMAL(10,2) CHECK (v_salario>0), 
    v_data_criacao DATE NOT NULL,
    v_data_limite DATE NOT NULL,
    v_status VARCHAR(50),
    v_registro BOOLEAN NOT NULL,
    v_tipo_registro VARCHAR(10) NOT NULL,
    v_fk_Usuario_email VARCHAR(50)
);


CREATE TABLE uwork.Requisito (
    r_id SERIAL PRIMARY KEY,
    r_nome VARCHAR(50) NOT NULL,
    r_descricao VARCHAR(200),
    r_fk_Vaga_id SERIAL
);


CREATE TABLE uwork.Candidatura (
    c_id SERIAL PRIMARY KEY,
    c_status VARCHAR(50),
    c_data_candidatura DATE NOT NULL,
    c_fk_Vaga_id SERIAL, c_fk_PF_FK_Usuario_email VARCHAR(50)
);


CREATE TABLE uwork.Beneficio (
    b_id SERIAL PRIMARY KEY,
    b_nome VARCHAR(50) NOT NULL,
    b_fk_Vaga_id SERIAL
);


ALTER TABLE uwork.PJ ADD CONSTRAINT FK_PJ_2
FOREIGN KEY (pj_FK_Usuario_email) REFERENCES uwork.Usuario (u_email);


ALTER TABLE uwork.PF ADD CONSTRAINT FK_PF_2
FOREIGN KEY (pf_FK_Usuario_email) REFERENCES uwork.Usuario (u_email);


ALTER TABLE uwork.Experiencia ADD CONSTRAINT FK_Experiencia_2
FOREIGN KEY (e_fk_PF_FK_Usuario_email) REFERENCES uwork.PF (pf_FK_Usuario_email);


ALTER TABLE uwork.Formacao ADD CONSTRAINT FK_Formacao_2
FOREIGN KEY (f_fk_PF_FK_Usuario_email) REFERENCES uwork.PF (pf_FK_Usuario_email);


ALTER TABLE uwork.Vaga ADD CONSTRAINT FK_Vaga_2
FOREIGN KEY (v_fk_Usuario_email) REFERENCES uwork.Usuario (u_email);


ALTER TABLE uwork.Requisito ADD CONSTRAINT FK_Requisito_2
FOREIGN KEY (b_fk_Vaga_id) REFERENCES uwork.Vaga (v_id);


ALTER TABLE uwork.Candidatura ADD CONSTRAINT FK_Candidatura_2
FOREIGN KEY (c_fk_Vaga_id) REFERENCES uwork.Vaga (v_id);


ALTER TABLE uwork.Candidatura ADD CONSTRAINT FK_Candidatura_3
FOREIGN KEY (c_fk_PF_FK_Usuario_email) REFERENCES uwork.PF (pf_FK_Usuario_email);


ALTER TABLE uwork.Beneficio ADD CONSTRAINT FK_Beneficio_2
FOREIGN KEY (b_fk_Vaga_id) REFERENCES uwork.Vaga (v_id);