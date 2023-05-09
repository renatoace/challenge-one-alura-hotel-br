# Challenge ONE | Java | Back-end | Hotel Alura

<p align="center" >
     <img width="400" heigth="400" src="https://user-images.githubusercontent.com/101413385/173164615-192ca98a-1a44-480e-9229-9f82f456eec8.png">

</p>

---
##  Meu projeto de sistema do Hotel Alura:

#### 🔹 O sistema de reservas do hotel Alura tem autenticação de usuario, somente usuários pertencentes ao hotel possam acessar;
#### 🔹 Nele podemos criar uma reserva e ditar e excluir para o cliente;
#### 🔹 Pesquisar na base de dados toda a informação de clientes e reservas;
#### 🔹 Registra, editar e excluir os dados dos hópedes;
#### 🔹 Ele calcula o valor da reserva de dias da reserva com a taxa da diária atribuida em reais;
#### 🔹 Para utilizar tem que usar o banco de dados MySql;

</br>

## 🖥️ Tecnologias Utilizadas:

- Java
- Eclipse
- MySql
- Biblioteca JCalendar
- Plugin WindowBuilder </br>

---
## ⚠️ Importante! ⚠️

☕ Use o Java na versão 8 ou superior para ter compatibilidade. 
</br></br>
📝 Recomendamos utilizar o editor Eclipse para compatibilidade da interface gráfica. </br></br>
🎨 A interface contém dois importantes métodos:
- setResizable(false): determina o tamanho da janela, e através do parâmetro <strong>false</strong>, a tela não poderá ser maximizada;
- setLocationRelativeTo(null): determina a localização da janela, e através do parâmetro <strong>null</strong> ele a mantém centralizada na tela.

#### 🔹 Para poder utilizar o projeto:
#### 🔹 Tem que criar o banco de dados com o nome "alura_hotel";
#### 🔹 As tabelas usuarios, valor_diaria, reservas, hospedes;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `valor_diaria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor_diaria` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `reservas` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `DataEntrada` datetime NOT NULL,
  `DataSaida` datetime NOT NULL,
  `Valor` double NOT NULL,
  `FormaPagamento` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `hospedes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) DEFAULT NULL,
  `Sobrenome` varchar(50) DEFAULT NULL,
  `DataNascimento` datetime DEFAULT NULL,
  `Nacionalidade` varchar(50) DEFAULT NULL,
  `Telefone` varchar(45) DEFAULT NULL,
  `Id_Reserva` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_Reserva_idx` (`Id_Reserva`),
  CONSTRAINT `id_Reserva` FOREIGN KEY (`Id_Reserva`) REFERENCES `reservas` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

---



🧡 <strong>Oracle</strong></br>
<a href="https://www.linkedin.com/company/oracle/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

💙 <strong>Alura Latam</strong></br>
<a href="https://www.linkedin.com/company/alura-latam/mycompany/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
