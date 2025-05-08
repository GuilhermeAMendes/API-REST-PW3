create table consertos
(

    id              bigint not null auto_increment,
    data_entrada     varchar(20),
    data_saida       varchar(20),
    marca           varchar(100),
    modelo          varchar(100),
    ano             varchar(100),
    nome            varchar(100),
    anos_experiencia int,

    primary key (id)
);