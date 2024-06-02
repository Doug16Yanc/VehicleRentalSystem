<h1 align="center" width="100%">RESTful Java API project for vehicle rental system</h1>

<p align="center" width="100%">
    <img width="50%" src="https://github.com/Doug16Yanc/VehicleRentalSystem/assets/129301271/1787a58c-b203-4de1-b30f-530af45639e7"> 
</p>


<h3 align="center">
  Spring Security 6 + Jwt Token
</h3>

<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">

</p>

<h1 align="center" width="100%"> Description </h1>

<p>
  Vehicle rental system with two interaction entities, system administrators and basic users, administrators have maximum access privileges within the system, being able to register, list, remove as many other users as vehicles.
  Ordinary users are restricted to searching and listing vehicles and performing rentals and returns. A return can only be made after a rental, which is obvious, and each rental has its own value. Each entity can perform access 
  and requests through credential validations. Security is guaranteed through the encryption of the RSA algorithm and asymmetric keys (which justifies the absence of the private key in the repository, as it cannot be generally known).
</p>

<h1 align="center" width="100%"> Used technologies </h1>


* Java 21
* Spring Boot
* Spring Security 6
* OAuth2 Resource Server
* Docker Compose
* MySQL 

<h1 align="center" width="100%"> How to clone the project locally? </h1>

<p>
  Clone the project using the command line :

  
```bash
    git clone git@github.com:Doug16Yanc/VehicleRentalSystem.git
```
  
</p>
<h1 align="center" width="100%"> How to generate a private key for decryption? </h1>

<p>
Using Linux-based terminals, Git Bash or WSL (if you are on Windows), use the following command, after entering a file directory.

```bash
  openssl genrsa > app.key
```
</p>


<h1 align="center" width="100%"> How to interate with the database? </h1>

<p>
  We use MySQL in a Docker Compose container. Make sure you have Docker and Docker Compose installed and properly configured on your device and follow these commands:


Enter the "docker" directory with the MySQL image code.
  
```bash
  cd docker
```

Generate the database image.

```bash
 docker compose up --build
```

Open a new local terminal tab and type:

```bash
  docker compose exec mysql bash
```
After entering MySQL bash, log in as the operating system's root user, enter the database password and from there you can interact through traditional SQL commands.

```bash
  mysql -u root -p
```

Remembering that you can use [Beekeeper Community](https://github.com/beekeeper-studio/beekeeper-studio/releases/tag/v4.1.13) or [MySQL Workbench](https://www.mysql.com/products/workbench/).

</p>

<h1 align="center" width="100%"> How to interate with the API? </h1>

<p>
  
  We use the [Postman](https://www.postman.com/), but you can also use [Insomnia](https://insomnia.rest/download) or another one of your choice.
  
</p>

