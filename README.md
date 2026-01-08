📅 API de Agendamento de Comunicação

API REST desenvolvida para gerenciar agendamentos de comunicação, permitindo criar, listar, atualizar e cancelar agendamentos.
O projeto foi construído utilizando Java com Spring Boot, banco de dados PostgreSQL e testado via Postman.


🚀 Funcionalidades

Criar agendamentos

Listar agendamentos

Buscar agendamento por ID

Atualizar agendamentos

Cancelar / remover agendamentos

Validação de dados

Persistência em banco de dados relacional


🛠 Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

PostgreSQL

Maven

Postman

Hibernate



🧱 Arquitetura

O projeto segue uma arquitetura em camadas:

Controller → Camada de entrada (endpoints REST)

Service → Regras de negócio

Repository → Acesso ao banco de dados

Entity → Mapeamento das tabelas


📡 Endpoints Principais
➕ Criar agendamento
POST /api/agendamento/create


📄 Listar todos os agendamentos
GET /api/agendamento/all


🔍 Buscar agendamento por ID
GET /api/agendamento/{id}

✏️ Atualizar agendamento
PUT /api/agendamento/update/{id}


❌ Excluir agendamento
DELETE /api/agendamento/delete/{id}


📦 Exemplo de Request (JSON)
{
  "mensagem": "Reunião de alinhamento do projeto",
  "destinatario": "cliente@email.com",
  "dataHoraEnvio": "2026-01-15T14:30:00",
  "tipoComunicacao": "EMAIL"
}



✅ Validações Aplicadas

O DTO AgendamentoRequestDTO possui validações automáticas:

mensagem → não pode ser nula ou vazia

destinatario → não pode ser nulo ou vazio

dataHoraEnvio → obrigatória e deve ser uma data futura

tipoComunicacao → não pode ser nulo ou vazio

Exemplo de anotações usadas:

@NotBlank

@NotNull

@Future


🗄 Banco de Dados

Banco de dados utilizado: PostgreSQL

Exemplo de configuração (application.properties)
spring.datasource.url=jdbc:postgresql://localhost:5432/agendamentos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


▶️ Como Executar o Projeto
Pré-requisitos

Java 17+ (ou versão utilizada no projeto)

Maven

PostgreSQL

Postman


# Clonar o repositório
git clone https://github.com/java-rique/agendar_api.git
# Acessar a pasta
cd agendar_api

# Executar o projeto
mvn spring-boot:run



A aplicação ficará disponível em:

http://localhost:8080


🧪 Testes

Todos os endpoints foram testados utilizando o Postman, validando:

Corpo das requisições

Respostas JSON

Códigos HTTP

Validações de erro



bservações

API construída seguindo boas práticas REST

Código organizado e escalável

Projeto voltado para backend

Pronto para integração com front-end ou aplicações mobile



👤 Autor

Fábio Henrique
🔗 GitHub: https://github.com/java-rique
