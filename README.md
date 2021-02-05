# provaPraticaPJC
PROJETO PRÁTICO IMPLEMENTAÇÃO BACK END 

Acesso api :

	username: Admin
	password: admin123 

Documentação api:

http://localhost:8080/swagger-ui.html#

iniciar aplicação no docker :

start.sh

Parar aplicação no docker :

stop.sh


Situação das tarefas :

a) A solução deverá conter a segurança necessária de forma a não permitir
acesso ao endpoint a partir de domínios diversos do qual estará hospedado o
serviço;

       Situação :  Implementada

b) A solução deverá conter controle de acesso por meio de autenticação JWT
com expiração a cada 5 minutos e possibilidade de renovação;

       Situação :  Implementada

c) A solução deverá implementar pelo menos os verbos post, put, get;

       Situação :  Implementada

d) A solução deverá conter recursos de paginação na consulta dos álbuns;

        Situação :  Implementada

e) A solução deverá expor quais álbuns são/tem os cantores e/ou bandas
possibilitando consultas parametrizadas;

        Situação :  Implementada

f) Deverá ser possível realizar consultas por nome do artista, permitindo ordenar
por ordem alfabética (asc e desc);

           Situação :  Implementada

g) Deverá ser possível fazer o upload de uma ou mais imagens da capa do
álbum;
    Situação :  Não implementada *

h) As imagens deverão ser armazenadas no ​Object Store MinIO utilizando API
S3;
    Situação :  Não implementada *

i) Preferencialmente, a recuperação das imagens deverá ser através links
apontando para o Min.IO Play com tempo de expiração.

    Situação :  Não implementada *

j) Por fim, a solução deverá ser “dockerizada” de forma que a solução execute
em docker.

           Situação :  implementada

*  Inicialmente foram implementas os metodos para tratamento de upload de imagens mas por não conhecer a tecnologia de armazenamento em Store  Store MinIO não foram incluidas. Sendo priorizadas as demais tarefas.

