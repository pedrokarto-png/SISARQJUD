   CREATE TABLE IF NOT EXISTS Parte (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        telefone VARCHAR(15),
        CPF_CNPJ VARCHAR(14) UNIQUE,
        numero VARCHAR(10),
        complemento VARCHAR(50),
        rua VARCHAR(100),
        endereco VARCHAR(200),
        naturalidade VARCHAR(100)
    );

    CREATE TABLE IF NOT EXISTS Processo (
        id INT AUTO_INCREMENT PRIMARY KEY,
        numeroProcesso VARCHAR(20) UNIQUE NOT NULL,
        dataCriacao DATE NOT NULL,
        descricao TEXT
    );
    
    CREATE TABLE IF NOT EXISTS Funcionario (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        cargo VARCHAR(50) NOT NULL
    );

    CREATE TABLE IF NOT EXISTS Movimentacao( 
        id INT AUTO_INCREMENT PRIMARY KEY,
        tipoMov VARCHAR(100) NOT NULL,
        dataMov DATE NOT NULL,
    )

    CREATE TABLE IF NOT EXISTS Caixa (
        id INT AUTO_INCREMENT PRIMARY KEY,
        numeroCaixa VARCHAR(10) NOT NULL,
        complementoCaixa VARCHAR(50),
        rua VARCHAR(100),
        endereco VARCHAR(200),
        processo_id INT NOT NULL,
        FOREIGN KEY (processo_id) REFERENCES Processo (id) ON DELETE CASCADE
    );

    CREATE TABLE IF NOT EXISTS ParteProcesso (
        id INT AUTO_INCREMENT PRIMARY KEY,
        parte_id INT NOT NULL,
        processo_id INT NOT NULL,
        FOREIGN KEY (parte_id) REFERENCES Parte (id) ON DELETE CASCADE,
        FOREIGN KEY (processo_id) REFERENCES Processo (id) ON DELETE CASCADE
    );

    CREATE TABLE IF NOT EXISTS FuncionarioProcesso (
        id INT AUTO_INCREMENT PRIMARY KEY,
        funcionario_id INT NOT NULL,
        processo_id INT NOT NULL,
        FOREIGN KEY (funcionario_id) REFERENCES Funcionario (id) ON DELETE CASCADE,
        FOREIGN KEY (processo_id) REFERENCES Processo (id) ON DELETE CASCADE
    );


    INSERT INTO Parte (nome, numero, complemento, rua, endereco, naturalidade, classe, genero, CPF_CNPJ, dataNascimento, nomeDaMae, nomeDoPai, telefone, ddd, classeProcessual)
    VALUES
    ('João Silva', '123', 'Apto 1', 'Rua das Flores', 'Bairro Centro', 'Brasileira', 'Requerente', 'Masculino', '12345678901', '1980-01-01', 'Maria Silva', 'José Silva', '11999999999', '11', 'Cível'),
    ('Maria Oliveira', '456', 'Casa', 'Avenida Paulista', 'Bairro Jardins', 'Brasileira', 'Ré', 'Feminino', '98765432100', '1990-02-02', 'Ana Oliveira', 'Pedro Oliveira', '21988888888', '21', 'Trabalhista'),
    ('Carlos Souza', '789', 'Apto 10', 'Rua das Acácias', 'Bairro Vila Nova', 'Brasileira', 'Testemunha', 'Masculino', '12312312312', '1985-03-03', 'Clara Souza', 'João Souza', '31977777777', '31', 'Penal'),
    ('Ana Costa', '012', 'Apto 5', 'Rua do Sol', 'Bairro Jardim', 'Brasileira', 'Requerente', 'Feminino', '98798798798', '1995-04-04', 'Beatriz Costa', 'Antonio Costa', '21988888888', '21', 'Cível'),
    ('José Santos', '345', 'Casa', 'Avenida Brasil', 'Bairro Centro', 'Brasileira', 'Réu', 'Masculino', '45645645645', '1988-05-05', 'Sandra Santos', 'Paulo Santos', '11966666666', '11', 'Trabalhista'),
    ('Luciana Mendes', '678', 'Cobertura', 'Rua das Orquídeas', 'Bairro Bela Vista', 'Brasileira', 'Requerente', 'Feminino', '78978978978', '1992-06-06', 'Rita Mendes', 'Carlos Mendes', '81955555555', '81', 'Cível'),
    ('Pedro Lima', '901', 'Loja 1', 'Rua Principal', 'Bairro Comércio', 'Brasileira', 'Réu', 'Masculino', '33333333333', '1981-07-07', 'Helena Lima', 'Ricardo Lima', '71944444444', '71', 'Penal'),
    ('Fernanda Alves', '234', 'Casa', 'Rua Nova', 'Bairro Antigo', 'Brasileira', 'Testemunha', 'Feminino', '55555555555', '1996-08-08', 'Carla Alves', 'Marcos Alves', '62933333333', '62', 'Cível'),
    ('Bruno Costa', '567', 'Apto 2', 'Avenida Boa Vista', 'Bairro Alto', 'Brasileira', 'Requerente', 'Masculino', '66666666666', '1990-09-09', 'Ana Costa', 'João Costa', '85922222222', '85', 'Trabalhista'),
    ('Juliana Rocha', '890', 'Apto 8', 'Rua Santa Luzia', 'Bairro Santo Antônio', 'Brasileira', 'Réu', 'Feminino', '77777777777', '1987-10-10', 'Lucia Rocha', 'Carlos Rocha', '42911111111', '42', 'Penal'),
    ('Rodrigo Silva', '135', 'Apto 3', 'Rua Verde', 'Bairro Floresta', 'Brasileira', 'Testemunha', 'Masculino', '88888888888', '1984-11-11', 'Clara Silva', 'José Silva', '13900000000', '13', 'Cível'),
    ('Paula Freitas', '468', 'Casa', 'Avenida Central', 'Bairro Novo', 'Brasileira', 'Requerente', 'Feminino', '99999999999', '1993-12-12', 'Sonia Freitas', 'Roberto Freitas', '51999999999', '51', 'Trabalhista'),
    ('Marcos Lima', '579', 'Casa', 'Rua Pequi', 'Bairro Nova Era', 'Brasileira', 'Réu', 'Masculino', '22222222222', '1998-01-13', 'Helena Lima', 'Ricardo Lima', '65988888888', '65', 'Penal'),
    ('Sandra Melo', '902', 'Apto 7', 'Rua das Palmeiras', 'Bairro Alegria', 'Brasileira', 'Requerente', 'Feminino', '44444444444', '1991-02-14', 'Rita Melo', 'Carlos Melo', '81955555555', '81', 'Cível'),
    ('Thiago Santos', '334', 'Loja 2', 'Rua do Comércio', 'Bairro Antigo', 'Brasileira', 'Testemunha', 'Masculino', '55555555555', '1989-03-15', 'Carla Santos', 'Marcos Santos', '85933333333', '85', 'Cível');

    INSERT INTO Funcionario (nome, cargo, codVerificacao, dataNascimento)
    VALUES
    ('Bruno Lima', 'Juiz', 'DEF789', '1980-01-01'),
    ('Fernanda Souza', 'Analista Jurídico', 'GHI012', '1990-02-15'),
    ('Pedro Santos', 'Advogado', 'JKL345', '1985-07-10'),
    ('Mariana Silva', 'Secretária', 'MNO678', '1995-03-20'),
    ('Roberto Alves', 'Procurador', 'PQR901', '1978-05-05'),
    ('Juliana Costa', 'Estagiária', 'STU234', '1997-06-30'),
    ('Rodrigo Mendes', 'Analista', 'VWX567', '1988-08-25'),
    ('Paula Rocha', 'Juíza', 'YZA890', '1983-09-15'),
    ('Thiago Freitas', 'Técnico Jurídico', 'BCD123', '1987-04-10'),
    ('Sandra Melo', 'Secretária', 'EFG456', '1990-11-20'),
    ('Luciano Santos', 'Advogado', 'HIJ789', '1985-12-25'),
    ('Clara Oliveira', 'Procuradora', 'KLM012', '1982-02-18'),
    ('Fabiano Lima', 'Analista Jurídico', 'NOP345', '1993-10-12'),
    ('Ana Paula', 'Estagiária', 'QRS678', '2000-07-22');

    INSERT INTO Processo (nome, tipoProcesso, sigilo, sentenca, nroVolume, nroProcesso)
    VALUES
    ('Processo A', 'Cível', 'Confidencial', 'Sentença favorável', 1, '1001/2025'),
    ('Processo B', 'Trabalhista', 'Público', 'Sentença desfavorável', 2, '1002/2025'),
    ('Processo C', 'Penal', 'Confidencial', 'Aguardando julgamento', 1, '1003/2025'),
    ('Processo D', 'Cível', 'Público', 'Sentença favorável', 3, '1004/2025'),
    ('Processo E', 'Trabalhista', 'Confidencial', 'Aguardando recurso', 2, '1005/2025'),
    ('Processo F', 'Penal', 'Público', 'Absolvição', 1, '1006/2025'),
    ('Processo G', 'Cível', 'Confidencial', 'Condenação', 2, '1007/2025'),
    ('Processo H', 'Trabalhista', 'Público', 'Arquivado', 1, '1008/2025'),
    ('Processo I', 'Penal', 'Confidencial', 'Sentença desfavorável', 3, '1009/2025'),
    ('Processo J', 'Cível', 'Público', 'Aguardando audiência', 2, '1010/2025'),
    ('Processo K', 'Trabalhista', 'Confidencial', 'Sentença favorável', 1, '1011/2025'),
    ('Processo L', 'Penal', 'Público', 'Arquivado', 2, '1012/2025'),
    ('Processo M', 'Cível', 'Confidencial', 'Condenação', 3, '1013/2025'),
    ('Processo N', 'Trabalhista', 'Público', 'Aguardando julgamento', 1, '1014/2025'),
    ('Processo O', 'Penal', 'Confidencial', 'Aguardando recurso', 2, '1015/2025');

    INSERT INTO Movimentacao (nroMovimentacao, dataMovimentacao, tipoMovimentacao)
    VALUES
    ('M1001', '2025-01-01', 'Despacho'),
    ('M1002', '2025-01-02', 'Decisão'),
    ('M1003', '2025-01-03', 'Audiência'),
    ('M1004', '2025-01-04', 'Despacho'),
    ('M1005', '2025-01-05', 'Decisão'),
    ('M1006', '2025-01-06', 'Audiência'),
    ('M1007', '2025-01-07', 'Arquivamento'),
    ('M1008', '2025-01-08', 'Despacho'),
    ('M1009', '2025-01-09', 'Decisão'),
    ('M1010', '2025-01-10', 'Audiência'),
    ('M1011', '2025-01-11', 'Despacho'),
    ('M1012', '2025-01-12', 'Decisão'),
    ('M1013', '2025-01-13', 'Audiência'),
    ('M1014', '2025-01-14', 'Arquivamento'),
    ('M1015', '2025-01-15', 'Despacho');

    INSERT INTO Caixa (nroCaixa, localizacao, numero, complemento, nroProcesso)
    VALUES
    ('CX001', 'Prédio A - Sala 1', '123', 'Prateleira 1', '1001/2025'),
    ('CX002', 'Prédio A - Sala 2', '124', 'Prateleira 2', '1002/2025'),
    ('CX003', 'Prédio B - Sala 1', '125', 'Prateleira 3', '1003/2025'),
    ('CX004', 'Prédio B - Sala 2', '126', 'Prateleira 4', '1004/2025'),
    ('CX005', 'Prédio C - Sala 1', '127', 'Prateleira 5', '1005/2025'),
    ('CX006', 'Prédio C - Sala 2', '128', 'Prateleira 6', '1006/2025'),
    ('CX007', 'Prédio A - Sala 3', '129', 'Prateleira 7', '1007/2025'),
    ('CX008', 'Prédio B - Sala 3', '130', 'Prateleira 8', '1008/2025'),
    ('CX009', 'Prédio C - Sala 3', '131', 'Prateleira 9', '1009/2025'),
    ('CX010', 'Prédio D - Sala 1', '132', 'Prateleira 10', '1010/2025'),
    ('CX011', 'Prédio D - Sala 2', '133', 'Prateleira 11', '1011/2025'),
    ('CX012', 'Prédio D - Sala 3', '134', 'Prateleira 12', '1012/2025'),
    ('CX013', 'Prédio E - Sala 1', '135', 'Prateleira 13', '1013/2025'),
    ('CX014', 'Prédio E - Sala 2', '136', 'Prateleira 14', '1014/2025'),
    ('CX015', 'Prédio E - Sala 3', '137', 'Prateleira 15', '1015/2025');

