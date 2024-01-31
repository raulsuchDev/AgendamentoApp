# Agendamento App
Aplicação que cria e lista agendamentos.

## 1 - Versões
Java: v11.0.19 <br />
Maven: v3.9.6 <br />
Spring-boot: v2.7.18 <br />
Node.js: v20.11.0 <br />
NPM: v10.2.4

## 1.1 - Decisões Arquiteturais e ferramentas
- O App foi separado entre front-end (Agendamento-Ui), e backend (Agendamento-api);
- A comunicação entre os dois é feita por meio de REST API;

### 1.1.1 - No backend
- O backend foi concebido utilizando o Padrão Arquitetural MVC (Model, View, Controller);
- Para o desenvolvimento no backend foi utilizado a ferramenta Lombok, para deixar menos código boilerplate;
- Para facilitar a utilização do H2, inseri variáveis que permitem que o script rode toda vez que aplicação é executada;
- Foi criada uma classe na API, para lidar com os erros que venham a acontecer na própria API, sem a necessidade de criar IF's adicionais;
- Adicionei múltiplas validações que são feitas no corpo da requisição, e na classe de Service, de agendamento, para verificar: Se há taxa aplicável,
os valores enviados pelo front-end, se não há agendamentos repetidos, se a conta de origem é diferente da conta de destino, no ato da criação do agendamento;
- Criadas classes exceptions específicas para alguns erros nas operações de criação e listagem de agendamentos;

### 1.1.2 - No front-end
- Utilizado o pacote angular-material e tailwind, para facilitar na criação das telas,
aspectos do formulário de criação de agendamento com validações, e respostas de validação da criação de agendamentos;
- Utilizado o pacote "Luxon", para lidar com as Datas;
- O pacote ngx-currency, que aplica uma máscara no valor da transferência, no campo de mesmo nome no formulário de criação de agendamento,
para que o usuário veja apenas o valor em reais;
- Feita a configuração proxy, para que o consumo dos recursos da API, seja feita sem erro de CORS.

## 1.2 - Passos para instalação

### 1.2.1 - Passo 1
Verificar se as versões de Java, Maven, Node.js, NPM e Angular(caso haja a instalação global), estão conforme o _Item 1_ desse documento.
As ferramentas JVMS e NVM, podem ser de ajuda, caso tenha mais de uma versão de Java e Node.js instaladas.

### 1.2.2 - Passo 2
Fazer o checkout desse repositório.

### 1.2.3 - Passo 3
Vá para o diretório _agendamento-api_, abra um terminal nesse diretório, e digite o comando `mvn install -DskipTests`.

### 1.2.4 - Passo 4
No sucesso da execução do "Passo 3", execute o comando `mvn spring-boot:run`.
Aqui, a sua aplicação deve estar rodando sem erros para o próximo passo.

### 1.2.5 - Passo 5
Abra um terminal de comando no diretório _agendamento-ui_ e execute o comando `npm install`.

### 1.2.6 - Passo 6
Ainda no terminal, após sucesso do passo anterior, execute o comando `ng serve`.
Caso o terminal não reconheça o comando desse passo, instale o Angular CLI, 
com o seguinte comando `npm install --global @angular/cli@17.0.10`. Após isso tente rodar novamente o comando `ng serve`.

### 1.2.7 - Passo 7
Após sucesso da execução do "Passo 6", abra o navegador e vá na URL: _http://localhost:4200/_.
Agora é só testar a aplicação :)

## 1.3 - Observações
No teste da aplicação, não houve erro na instalação ou execução da mesma.
Caso haja problema em algum dos passos de instalação, me contate pelo e-mail: raulsuch@outlook.com.



