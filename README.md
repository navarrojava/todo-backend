# todo-backend

Para clonar o projeto execute o seguinte comando em seu prompt de comando
  "git clone https://github.com/navarrojava/todo-backend.git "
  
  Caso enfrente problemas em clonar siga as instruçoes neste link --> https://help.github.com/articles/importing-a-git-repository-using-the-command-line/


##O que preciso instalar?


O projeto utiliza os seguintes recursos:

* [JDK 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html).
* [Maven](https://maven.apache.org/download.cgi).
* [Mysql 9.4](http://dev.mysql.com/downloads/).
* [Git](https://git-scm.com/downloads).
* IDE de sua escolha, este projeto foi criado utilizando: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Informações

O banco de dados utilizado é o MySql.
O projeto utiliza Spring boot.

Para rodar o projeto utilizando Maven rodar o seguinte comando:

 * mvn spring-boot:run


##Maven JVM Args
* ```-Ddatasource.username``` - usuário para o banco de dados - default root
* ```-Ddatasource.password``` - senha para o banco de dados - default root
* ```-Dserver.port``` - porta para rodar o tomcat (embedded/ Springboot) - default 8081
Exemplo:

    -Dserver.port-8082


<b>Atencão:</b> 
Neste projeto o Cors esta habilitado para aceitar requisiçoes de "qualquer" dominio. <p/>
Caso queira alterar esta configuração por segurança va até a classe CORSFilter,
no pacote filter e modifique : <br/>
response.addHeader("Access-Control-Allow-Origin", "*"); <br/>
para: <br/>
response.addHeader("Access-Control-Allow-Origin", "seudominio.foo.bar"); <p/>

 
                                                                                Navarro Ferreira
