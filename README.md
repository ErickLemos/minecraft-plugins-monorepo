# Minecraft Plugins Monorepo

Este repositorio tem como finalidade agrupar diversos plugins para
facilitar o gerenciamento.

Este projeto é um monorepo multi-modulo, onde temos um arquivo gradle central
e os projetos/modulos herdam configurações deste arquivo central.

Para ajudar no desenvolvimento deste projeto é necessário ter:

- JDK 17
- Intellij
- Google Cloud Cli

Os passos para configurar este projetos são:

- baixar arquivo de credenciais do Google Cloud.
- declarar variavel de ambiente (GOOGLE_APPLICATION_CREDENTIALS) apontando para o Arquivo baixado.

O processo de desenvolvimento:

- você deve executar o script *boot.sh* que fica dentro da pasta server, isso fará
  o servidor iniciar.
- executando o comando "gradle build", os plugins serão buildados e seu arquivo jar
  será movido para a pasta /server/plugins. Isso fará seu servidor ter as modificações que
  realizou no desenvolvimento.
- dentro do console do servidor digite "reload confirm" para recarregar os plugins com as novas
  modificações que realizou.