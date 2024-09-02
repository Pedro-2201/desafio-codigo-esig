# Gerenciador de Tarefas

Este projeto é um Gerenciador de Tarefas desenvolvido utilizando JSF, PrimeFaces, Hibernate, JPA, CDI e PostgreSQL. Ele permite o gerenciamento de tarefas, incluindo a criação, edição, e conclusão de tarefas.

## Funcionalidades Implementadas

O projeto inclui as seguintes funcionalidades:

### a) Cadastro de Tarefas
- Interface para cadastro de novas tarefas com os campos de título, descrição, responsável, prioridade e data limite.

### b) Edição de Tarefas
- Botão de edição disponível na tabela de listagem de tarefas, permitindo a modificação de tarefas existentes.

### c) Exclusão de Tarefas
- Botão de excluir uma tarefa existente.

### d) Marcar Tarefa como Concluída
- Botão para mudar o status da tarefa para concluída.

### e) Persistência de Dados
- Integração com PostgreSQL para persistência das entidades, utilizando JPA e Hibernate.
 
## Instruções para Execução em Ambiente Local

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- Java 8 (JDK 1.8)
- Maven
- PostgreSQL 16.4
- IntelliJ IDEA ou outra IDE compatível
- Servidor de Aplicação Tomcat

### Passo a Passo

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
2. **Abra o projeto na IDE de sua preferencia**
3. **Atualize o arquivo de persistência:**
    Caminho: src/main/resources/META-INF/persistence.xml
    Dentro do arquivo encontre as propriedades "user" e "password" para adicionar o seu usuário e senha do PostgreSQL. 
4. **Inicie o servidor do Tomcat**
6. **Acesse a página "http://localhost:8080/gerenciador_tarefas_war_exploded/"**