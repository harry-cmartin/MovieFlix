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



Projeto Final – MovieFlix Analytics
 Vocês foram contratados como equipe de tecnologia da MovieFlix, uma startup fictícia de streaming de filmes.
  A empresa deseja lançar uma plataforma simples de cadastro e avaliação de filmes, mas também precisa analisar os dados gerados pelos usuários para entender preferências, tendências e apoiar decisões de negócio.
O desafio da equipe é construir:
Uma aplicação web com docker e publicada via pipeline de CI/CD. 
Um fluxo de dados que simula Data Lake, Data Warehouse e Data Mart, com consultas que geram insights para a empresa. 

Objetivos do Projeto
Compreender como funciona o ciclo de vida de uma aplicação em containers. 
Aplicar conceitos de servidores, proxies e DNS. 
Implementar um pipeline de CI/CD para build, teste e publicação de imagens Docker. 
Simular um ecossistema de dados (Data Lake, DW e Data Mart). 
Realizar consultas analíticas para apoiar decisões de negócio. 

Aplicação Web
Criar uma aplicação simples (pode ser em qualquer linguagem) que permita cadastrar filmes e avaliar com notas. 
A aplicação deve rodar no Docker. 
Configurar o Nginx como proxy reverso para a aplicação. 
Opcional: utilizar um domínio ou subdomínio (mesmo gratuito, ex: DuckDNS). 

Pipeline (CI/CD)
Configurar no GitHub Actions um workflow com as etapas:
Build da imagem Docker. 
Teste simples (ex.: verificar se a aplicação sobe e responde na porta correta). 
Push da imagem para o Docker Hub. 

Dados (DW, Data Lake e Data Mart)
Vocês vão simular o fluxo de dados da MovieFlix, recomendo utilizar uma API para buscar os dados (ex:.omdbapi.com)
Data Lake (dados brutos)
Armazenar arquivos CSV com dados brutos, exemplo:
movies.csv (informações sobre os filmes) 
users.csv (informações sobre usuários) 
ratings.csv (avaliações dos usuários nos filmes) 
Esses arquivos podem ficar em um diretório.

Data Warehouse (dados tratados)
Criar tabelas no PostgreSQL (ou outro banco) e carregar os CSVs do Data Lake nessas tabelas.
Data Mart (visões de negócio)
Criar visões/tabelas resumidas a partir do DW, por exemplo:
Top 10 filmes mais bem avaliados por gênero 
Nota média por faixa etária dos usuários 
Número de avaliações por país 
Consultas Analíticas
Escrever queries SQL que respondam perguntas como:
Quais os 5 filmes mais populares? 
Qual gênero tem a melhor avaliação média? 
Qual país assiste mais filmes? 

Entregáveis
Repositório GitHub com: 
Código da aplicação 
Dockerfile 
Workflow do GitHub Actions 
Scripts de carga de dados (ETL simples CSV → Postgres (ou outro banco) 
README com explicação da arquitetura 
Demonstração prática: 
Pipeline rodando no GitHub Actions. 
Imagem publicada no Docker Hub. 
Aplicação acessível via Nginx/DNS. 
Consultas SQL ou dashboards mostrando resultados do Data Mart.


Prazo:

Os projetos serão aceitos até o dia 22 de abril de 2026 às 23:59.

O envio precisa ser feito via e-mail: raoni@srelabs.cloud

Título: Seu nome completo + Projeto final

