# MovieFlix
Projeto Final dedicado a disciplina de Arquitetura de Software do Curso ADA

A empresa deseja lançar uma plataforma simples de cadastro e avaliação de filmes, mas também precisa analisar os dados gerados pelos usuários para entender preferências, tendências e apoiar decisões de negócio.
O desafio é construir:
Uma aplicação web com docker e publicada via pipeline de CI/CD. 
Um fluxo de dados que simula Data Lake, Data Warehouse e Data Mart, com consultas que geram insights para a empresa. 


# Arquitetura definida

```
movieflix-backend/
├── docker/                             # Infraestrutura do projeto
│   ├── docker-compose.yml              # Sobe o Postgres, Nginx e a Aplicação
│   ├── nginx.conf                      # Configuração do Proxy Reverso
│   └── data/                      
│       └── dataLake                    # CSVs propostos para o projeto
├── src/main/java/br/com/movieflix/
│   │
│   ├── shared/                         # Tudo que é comum e transversal
│   │   ├── exceptions/                 # Tratamento global de erros
│   │   └── config/                     # Configurações do Quarkus (ex: Jackson, OpenAPI)
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
│   ├── application.properties          # Configurações de banco, porta, etc.
│   └── import.sql                      # (Opcional) Script para Quarkus rodar e ler os CSVs no startup
│
└──pom.xml                             # Dependências (Panache, Resteasy, JDBC PG)


```




