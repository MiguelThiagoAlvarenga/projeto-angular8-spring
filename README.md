# projeto-angular8-spring
Projeto, contendo um cadastro simples na tecnologia Angular8 e Spring Boot

1. entre no diretório da aplicação
2. no diretório "backend" execute o seguinte comando:
   ./mvnw spring-boot:run
3. no diretório "frontend" :

	Instale o node.js ->> https://nodejs.org/en/
4. Execut os seguinetes comandos:
	npm install
	
	e -- npm start --- para rodar a aplicação
5. Após executar o backend, deve-se parar e ir na pasta:

		\backend\src\main\resources\db\migration
	
	e executa o script sql: V1_PreenchendoTabelas
	
	Obs.: para não ter que instalar uma base, foi utilizada a base H2. seu arquivo se encontra no
	diretório do /data/ na pasta do usuário.
	
6. Usar a seguinte configuração para inicializar a base e rodar os scripts:
   Com o backend rodando vai no Browser e acessa o seguinte diretório.

   http://localhost:8080/h2-console/login.jsp

	*Na opção "JDBC URL" substitua seu conteúdo por: jdbc:h2:file:~/data/cadPropDb
	
		user name: sa 
		Password: sa
		
	Clique no botão connect
	
7. Após executar os scripts e preencher as tabelas indicadas, pode-e executar o software
com os comando já citados: npm start - para frontend e ./mvnw spring-boot:run - backend



	
