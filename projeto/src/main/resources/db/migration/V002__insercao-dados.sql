INSERT INTO tb_artista ( art_nome ,  data_alteracao, data_criacao)  VALUES ("Serj Tankian" , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Harakiri" , "C" ,(select art_id from tb_artista where art_nome ="Serj Tankian" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Black Bloms" , "C" ,(select art_id from tb_artista where art_nome ="Serj Tankian" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("The Rough Dog" , "C" ,(select art_id from tb_artista where art_nome ="Serj Tankian" limit 1) , now() , now());

INSERT INTO tb_artista ( art_nome ,  data_alteracao, data_criacao)  VALUES ("Mike Shinoda" , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("The Rising Tied" , "C" ,(select art_id from tb_artista where art_nome ="Mike Shinoda" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Post Traumatic" , "C" ,(select art_id from tb_artista where art_nome ="Mike Shinoda" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Post Traumatic EP" , "C" ,(select art_id from tb_artista where art_nome ="Mike Shinoda" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Where'd You Go" , "B" ,(select art_id from tb_artista where art_nome ="Mike Shinoda" limit 1) , now() , now());

INSERT INTO tb_artista ( art_nome ,  data_alteracao, data_criacao)  VALUES ("Michel Teló" , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Bem Sertanejo" , "C" ,(select art_id from tb_artista where art_nome ="Michel Teló" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Bem Sertanejo - O Show (Ao Vivo)" , "C" ,(select art_id from tb_artista where art_nome ="Michel Teló" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Bem Sertanejo - (1a Temporada) - EP" , "C" ,(select art_id from tb_artista where art_nome ="Michel Teló" limit 1) , now() , now());


INSERT INTO tb_artista ( art_nome ,  data_alteracao, data_criacao)  VALUES ("Guns N' Roses" , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Use Your IIIlusion I" , "C" ,(select art_id from tb_artista where art_nome ="Guns N' Roses" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Use Your IIIlusion II" , "B" ,(select art_id from tb_artista where art_nome ="Guns N' Roses" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Use Your IIIlusion III" , "B" ,(select art_id from tb_artista where art_nome ="Guns N' Roses" limit 1) , now() , now());

INSERT INTO tb_album ( alb_nome , alb_tipo , art_id , data_alteracao , data_criacao) value
("Greatest Hits" , "B" ,(select art_id from tb_artista where art_nome ="Guns N' Roses" limit 1) , now() , now());