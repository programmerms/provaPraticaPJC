create table tb_artista (
  art_id bigint(20) not null auto_increment,
  art_nome varchar(100) null default null,
  data_criacao datetime(6) null default null,
  data_alteracao datetime(6) null default null,
  primary key ( art_id ))
engine = innodb default character set = utf8;

create table tb_album (
  alb_id bigint(20) not null auto_increment,
  art_id bigint(20) not null,
   alb_nome  varchar(100) null default null,
   alb_tipo  varchar(1) not null,
   data_criacao  datetime(6) not null,
   data_alteracao  datetime(6) null default null,
  primary key ( alb_id ),
  index  fkvd7d30vr0l0m7hm99fgc2o8q  ( art_id  asc) ,
  constraint  fkvd7d30vr0l0m7hm99fgc2o8q
    foreign key ( art_id )
    references  tb_artista ( art_id ))
engine = innodb default character set = utf8;

create table tb_capa_album  (
   cpa_id  bigint(20) not null auto_increment,
   alb_id  bigint(20) not null,
   cpa_descricao  varchar(100) null default null,
   cpa_content_type  varchar(80) not null,
   cpa_nome_arquivo  varchar(150) not null,
   cpa_tamanho  int not null,
   data_criacao  datetime null,
   data_alteracao  datetime null,
  primary key ( cpa_id ),
  index  fkcjmyx074lbo6a8dhvf1mrti5e  ( alb_id  asc) ,
  constraint  fkcjmyx074lbo6a8dhvf1mrti5e
    foreign key ( alb_id )
    references  tb_album( alb_id )
    on delete restrict
    on update restrict)
engine = innodb default character set = utf8;