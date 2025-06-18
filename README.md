
# Project Title

A brief description of what this project does and who it's for

## Stos Technologiczny 🛠️

* **Java 17**
* **Spring Boot 3.x**
* **Spring Security 6.x** - obsługa bezpieczeństwa i autoryzacji
* **Spring Data JPA / Hibernate** - warstwa dostępu do danych
* **MySQL** - relacyjna baza danych
* **JSON Web Token (JWT)** - autoryzacja za pomocą tokenów (biblioteka `jjwt`)
* **Maven** - narzędzie do budowy projektu i zarządzania zależnościami
* **Lombok** - redukcja kodu "boilerplate"

## Wymagania Wstępne 📋

Przed uruchomieniem aplikacji upewnij się, że masz zainstalowane następujące narzędzia:
* JDK w wersji 17 lub nowszej
* Apache Maven
* Aktywna instancja serwera bazy danych MySQL

## Konfiguracja ⚙️


1.  **Utwórz bazę danych** w swojej instancji MySQL:
    ```sql
    CREATE DATABASE your_database_name CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    ```

2.  **Utwórz tabele bazy danych**

    ```sql
    CREATE TABLE `users` (
      `id` varbinary(16) NOT NULL,
      `login` varchar(100) DEFAULT NULL,
      `password` varchar(100) DEFAULT NULL
    );
    CREATE TABLE `items` (
      `id` varbinary(16) NOT NULL,
      `owner_id` varbinary(16) NOT NULL,
      `name` varchar(100) DEFAULT NULL
    );
    ```

## Uruchomienie Aplikacji ▶️

1.  Sklonuj repozytorium na swój komputer.
2.  Upewnij się, że plik `application.properties` jest poprawnie skonfigurowany.
3.  Otwórz terminal w głównym katalogu projektu i uruchom aplikację za pomocą Mavena:

    ```bash
    mvn spring-boot:run
    ```
Aplikacja zostanie uruchomiona domyślnie na porcie `8080`.