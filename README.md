# 💳 Sistema Bancário em Java

Projeto desenvolvido com o objetivo de praticar conceitos de Programação Orientada a Objetos (POO) e manipulação de arquivos em Java.

---

## 📌 Sobre o Projeto

Este é um sistema bancário simples executado no console, onde é possível:

- Criar conta
- Realizar login
- Depositar valores
- Sacar valores
- Excluir conta
- Salvar e carregar dados automaticamente através de arquivo (.txt)

O sistema mantém os dados das contas mesmo após o encerramento do programa, utilizando persistência em arquivo.

---

## Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- ArrayList
- Estruturas de repetição e decisão
- Manipulação de arquivos (FileWriter e Scanner)
- Conversão de dados (String para double)

---

## 🗂 Estrutura do Projeto

```
ContaDoCliente.java
ContasGerais.java
Sistema.java
Executar.java
```

- `ContaDoCliente` → Representa a conta do usuário  
- `ContasGerais` → Gerencia todas as contas do sistema  
- `Sistema` → Controla menus e fluxo do programa  
- `Executar` → Classe principal (main)

---

## 💾 Persistência de Dados

As contas são salvas em um arquivo `contas.txt` no seguinte formato:

```
login;senha;saldo
```

Ao iniciar o sistema, o arquivo é lido e os objetos são reconstruídos automaticamente.

---

## 👨‍💻 Objetivo

Este projeto faz parte da minha evolução prática em Java, com foco na construção de sistemas organizados e estruturados.
