# 📌 Sistema Bancário em Java (Desktop)

**Sobre o projeto:**
Este projeto é um sistema bancário desktop desenvolvido em Java com Swing, que simula operações básicas de um banco digital, como criação de contas, login, depósito, saque e transferências via PIX.
O objetivo do projeto foi aplicar conceitos de:

*Programação Orientada a Objetos (POO);
Manipulação de arquivos;
Desenvolvimento de interfaces gráficas (GUI);
Organização em camadas (GUI + lógica).*
---
**Funcionalidades:**
*✔️ Cadastro de conta
✔️ Login de usuário
✔️ Depósito de valores
✔️ Saque com validação de saldo
✔️ Transferência via PIX entre contas
✔️ Exclusão de conta
✔️ Persistência de dados em arquivo (contas.txt)
✔️ Interface gráfica interativa com Java Swing

**Tecnologias utilizadas:**
Java;
Java Swing (GUI);
FileWriter / Scanner (persistência de dados);
Programação Orientada a Objetos.
---
📂 Estrutura do projeto:

executavel/
 └── Executar.java

interKaik/
 ├── contas/
 │    ├── ContaDoCliente.java
 │    └── ContasGerais.java
 │
 └── GUI/
      ├── login/
      ├── register/
      ├── inicial/
      └── servicos/
           ├── Deposito
           ├── Saque
           ├── Transferencia
           └── Configuracao
---
**Limitações atuais:**
Senhas ainda não são criptografadas;
Interface pode ser melhorada (layout e responsividade);
Não há sistema de extrato bancário;
Validações de entrada ainda podem ser aprimoradas;
Arquivo de dados simples (sem banco de dados).

**Possiveis melhorias futuras:**
Criptografia de senha (hash);
Implementação de extrato bancário;
Integração com banco de dados (MySQL ou SQLite);
Melhorias visuais na interface;
Possível migração para aplicação web ou mobile;
Validações mais robustas;
---
**Durante o desenvolvimento deste projeto, foram aplicados conceitos importantes como:**
Encapsulamento e organização de código;
Separação entre interface e lógica;
Manipulação de arquivos;
Tratamento de erros;
Experiência com construção de sistemas completos;
---

##**⭐ Considerações finais:**
*Este projeto foi um aprendizado feito praticamente as cegas, visto que não sabia bem de como o JavaSwing funcionava, a ideia central era adaptar o projeto anterior que era no terminal, de forma que ele tivesse uma interface, também apliquei conceitos de transferencias intercontas e outras coisas menores como atualização de saldo em tempo real. Esse projeto pode não ser o melhor projeto do mundo, ou o mais inovador, mas fiz com carinho e tenho certeza que saio com mais conhecimento do que quando comecei ele.*
