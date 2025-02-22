# 🌟 Event Subscription API 🌟

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

## 📖 Sobre o Projeto

O **Event Subscription API** é uma aplicação desenvolvida em Java com Spring Boot que permite a criação e gerenciamento de inscrições para eventos. Além disso, oferece funcionalidades como geração de rankings de usuários inscritos em eventos específicos.

A API utiliza um banco de dados MySQL para armazenar informações sobre eventos, usuários e suas respectivas inscrições. Com uma arquitetura robusta e bem estruturada, o projeto é ideal para quem deseja aprender ou implementar um sistema de inscrição para eventos.

---

## 🚀 Funcionalidades Principais

### 1. **Criação de Inscrições**
   - Crie inscrições para eventos utilizando os endpoints da API.
   - Suporte para inscrições com ou sem `userId` específico.
   - Tratamento de exceções para conflitos de inscrição e eventos não encontrados.

### 2. **Geração de Rankings**
   - Gere rankings dos melhores usuários inscritos em um evento específico.
   - Obtenha rankings personalizados para um usuário específico dentro de um evento.

### 3. **Tratamento de Erros**
   - Mensagens de erro claras e bem definidas para facilitar a depuração e uso da API.

---

## 🛠️ Tecnologias Utilizadas

- **Backend**: Java 17, Spring Boot, Spring Web, Spring Data JPA
- **Banco de Dados**: MySQL
- **API RESTful**: Endpoints HTTP (GET, POST) com tratamento de exceções
- **DTOs e Exceções Personalizadas**: Para garantir uma comunicação clara entre cliente e servidor
- **Testes**: Cobertura de testes unitários e de integração (em desenvolvimento)

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/flaviodev/events/
│   │   ├── controller/          # Controladores REST
│   │   ├── dto/                 # DTOs e Exceções Personalizadas
│   │   ├── exception/           # Classes de Exceção
│   │   ├── model/               # Entidades do Banco de Dados
│   │   ├── repository/          # Interfaces de Repositório
│   │   ├── service/             # Lógica de Negócio
│   │   └── EventsApplication.java # Classe Principal da Aplicação
│   └── resources/
│       ├── application.properties # Configurações do Projeto
│       └── data.sql              # Scripts SQL Iniciais
└── test/
    └── java/com/flaviodev/events/ # Testes Unitários e de Integração
```

---

## 🌐 Endpoints da API

### 1. **Criar Inscrição**
   - **POST** `/subscription/{prettyName}`
   - **POST** `/subscription/{prettyName}/{userId}`
   - **Corpo da Requisição**:
     ```json
     {
       "name": "Flávio",
       "email": "flavio@example.com"
     }
     ```
   - **Respostas**:
     - **200 OK**: Inscrição criada com sucesso.
     - **404 Not Found**: Evento ou usuário indicador não encontrado.
     - **409 Conflict**: Conflito de inscrição.

### 2. **Gerar Ranking por Evento**
   - **GET** `/subscription/{prettyName}/ranking`
   - **Resposta**:
     ```json
     [
       { "userId": 1, "score": 100 },
       { "userId": 2, "score": 90 },
       { "userId": 3, "score": 80 }
     ]
     ```

### 3. **Gerar Ranking por Usuário**
   - **GET** `/subscription/{prettyName}/ranking/{userId}`
   - **Resposta**:
     ```json
     { "userId": 1, "score": 100 }
     ```

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos

- **JDK 17** instalado
- **Maven** instalado
- **MySQL** configurado e rodando localmente ou em um servidor remoto

### Passos para Execução

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/seu-usuario/event-subscription-api.git
   cd event-subscription-api
   ```

2. **Configure o Banco de Dados**
   - Abra o arquivo `src/main/resources/application.properties` e configure as credenciais do MySQL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/event_db
     spring.datasource.username=root
     spring.datasource.password=your_password
     ```

3. **Execute o Projeto**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API**
   - A API estará disponível em: `http://localhost:8080`



## 🤝 Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature: `git checkout -b feature/nova-funcionalidade`.
3. Commit suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`.
4. Envie para a branch: `git push origin feature/nova-funcionalidade`.
5. Abra um Pull Request.

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📧 Contato

- **Autor**: Flávio Dev
- **E-mail**: flavioleandrovasco@gmail.com
- **LinkedIn**: [linkedin.com/in/flavio-felix](https://www.linkedin.com/in/flavio-felix/)
- **GitHub**: [github.com/fau-33](https://github.com/fau-33)

---

✨ **Obrigado por visitar este projeto!** ✨
