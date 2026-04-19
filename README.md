# MovieFlix
Projeto Final dedicado a disciplina de Arquitetura de Software do Curso ADA

A empresa deseja lançar uma plataforma simples de cadastro e avaliação de filmes, mas também precisa analisar os dados gerados pelos usuários para entender preferências, tendências e apoiar decisões de negócio.


Uma aplicação web com docker e publicada via pipeline de CI/CD. 
Um fluxo de dados que simula Data Lake, Data Warehouse e Data Mart, com consultas que geram insights para a empresa. 


## Sobre a Aplicação

MovieFlix é um sistema (sem interface) desenvolvido em **Java 21 com Quarkus**, projetado sob a arquitetura de **Monolito Modular**. Ele oferece o gerenciamento de filmes e avaliações (Ratings) com uma infraestrutura acoplada por contêineres Docker (PostgreSQL para dados e NGINX para roteamento reverso).
Faz parte de uma esteira completa de engenharia, onde possui regras para simulação de Data Lake/Data Warehouse, além de pipeline em GitHub Actions.


# Arquitetura definida


Monolito Modular 

```
movieflix-backend/

├── github/workflows       
│   ├── ci-cd.yml                       # Pipelines
│                    
├── docker/                             # Infraestrutura do projeto

│   └── data/                      
│       └── dataLake                    # CSVs propostos para o projeto
├── src/main/java/br/com/movieflix/
│   │
│   ├── movies/                         #  MÓDULO: FILMES
│   │   ├── domain/                     # Entidade (Movie)
│   │   ├── repository/                 # Acesso a dados (MovieRepository via Panache)
│   │   ├── service/                    # Regras de negócio (MovieService)
│   │   └── resource/                   # Endpoints REST (MovieResource)
│   │
│   ├── users/                          #  MÓDULO: USUÁRIOS
│   │   ├── domain/                     # Entidade (User)
│   │   ├── repository/                 # UserRepository
│   │   ├── service/                    # UserService
│   │   └── resource/                   # UserResource
│   │
│   └── ratings/                        #  MÓDULO: AVALIAÇÕES (O Coração)
│       ├── domain/                     # Entidade (Rating)
│       ├── repository/                 # RatingRepository
│       ├── service/                    # RatingService
│       ├── resource/                   # RatingResource
│       └── dto/                        # Objetos de transferência de dados
│
├── src/main/resources/
│   └──application.properties          # Configurações de banco, porta, etc.
│  
├── docker-compose.yml              # Sobe o Postgres, Nginx e a Aplicação
├── nginx.conf                      # Configuração do Proxy Reverso
└── pom.xml                             # Dependências do Quarkus (Panache, Resteasy, JDBC PG)
```


##  Como Executar o Projeto com Docker Compose

Como o projeto está no ecossistema do Quarkus usando um build `.jvm`, você precisará compilar o pacote Java em sua máquina antes de "buildar" o contêiner Docker.

**1. Gere a compilação do `.jar` local:**
Na pasta padrão do terminal, navegue pro backend e rode o empacotador do Maven:
```bash
cd movieflix-backend
./mvnw clean package
```

**2. Configure as Variáveis de Ambiente:**
Crie um arquivo `.env` dentro do diretório `movieflix-backend` para que o Compose aplique ao banco. Exemplo:

```env
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
POSTGRES_DB=movieflix
POSTGRES_PORT=5432
```

**3. Levante os Contêineres:**
Ainda dentro de `movieflix-backend`, inicie o Docker Compose:
```bash
docker compose --env-file .env up -d --build
```
Os três serviços subirão juntos. **A API responderá por trás do NGINX pela porta 80 do seu localhost (`http://localhost`).**

## Endpoints Disponíveis

###  Filmes (`/movies`)
*   `GET /movies` - Retorna a lista de todos os filmes.
*   `POST /movies` - Cadastra um novo filme na plataforma. Corpo esperado: Entidade Movie.
*   `DELETE /movies/{id}` - Deleta um filme dado o ID especificado.

###  Avaliações (`/ratings`)
*   `POST /ratings` - Cria uma nova avaliação atrelando um Usuário e um Filme com um formato numérico.
*   `DELETE /ratings/{id}` - Exclui uma avaliação dado o seu respectivo ID.




