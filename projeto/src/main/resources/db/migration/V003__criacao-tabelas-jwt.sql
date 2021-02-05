create table tb_permissao  (
   id  bigint(20) not null auto_increment,
   description  varchar(255) null default null,
   data_criacao  datetime null default null,
   data_alteracao  datetime null default null,
  primary key ( id ))
engine = innodb default character set = utf8;

create table tb_usuario  (
   id  bigint(20) not null auto_increment,
   user_name  varchar(255) null default null,
   full_name  varchar(255) null default null,
   password  varchar(255) null default null,
   account_non_expired  bit(1) null default null,
   account_non_locked  bit(1) null default null,
   credentials_non_expired  bit(1) null default null,
   enabled  bit(1) null default null,
   data_criacao  datetime null default null,
   data_alteracao  datetime null default null,
  primary key ( id ),
  unique index  uk_user_name  ( user_name  asc) )
engine = innodb default character set = utf8;

create table tb_usuario_permissao  (
   id_usuario  bigint(20) not null,
   id_permissao  bigint(20) not null,
  primary key ( id_usuario ,  id_permissao ),
  index  fk_usuario_permissao_permissao  ( id_permissao  asc) ,
  constraint  fk_usuario_permissao
    foreign key ( id_usuario )
    references  tb_usuario( id ),
  constraint  fk_usuario_permissao_permissao
    foreign key ( id_permissao )
    references tb_permissao ( id ))
engine = innodb default character set = utf8;