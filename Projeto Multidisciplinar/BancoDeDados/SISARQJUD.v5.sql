CREATE TABLE Processo (
    nroProcesso SERIAL PRIMARY KEY,      
    varaOrigem VARCHAR(255),    
    tipoProcesso VARCHAR(100),           
    sigilo VARCHAR(50),                   
    sentenca VARCHAR(255),                
    volume INTEGER,
    nroProcesso INTEGER    
);

CREATE TABLE Funcionario (
    id SERIAL PRIMARY KEY,                
    nome VARCHAR(255) NOT NULL,           
    cargo VARCHAR(100) NOT NULL,
	codVerificacao INTEGER NOT NULL
);

CREATE TABLE Movimentacao (
    id SERIAL PRIMARY KEY,              
    processoId INTEGER NOT NULL,          
    funcionarioId INTEGER NOT NULL,       
    descricao TEXT,                        
    dataMovimentacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    FOREIGN KEY (processoId) REFERENCES Processo(nroProcesso) ON DELETE CASCADE,
    FOREIGN KEY (funcionarioId) REFERENCES Funcionario(id) ON DELETE CASCADE
);

CREATE TABLE TipoProcesso (
    id SERIAL PRIMARY KEY,                 
    classeProcessual VARCHAR(255) NOT NULL,        
    nome VARCHAR(255) NOT NULL                       
);

CREATE TABLE Parte (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE ParteProcesso (
    id SERIAL PRIMARY KEY,
    processoId INTEGER NOT NULL,
    parteId INTEGER NOT NULL,
    FOREIGN KEY (processoId) REFERENCES Processo(nroProcesso) ON DELETE CASCADE,
    FOREIGN KEY (parteId) REFERENCES Parte(id) ON DELETE CASCADE
);

CREATE TABLE Telefone (
    id SERIAL PRIMARY KEY,                 
    ddd VARCHAR(3) NOT NULL,               
    numero VARCHAR(15) NOT NULL,           
    funcionarioId INTEGER,                
    FOREIGN KEY (funcionarioId) REFERENCES Funcionario(id) ON DELETE SET NULL
);
