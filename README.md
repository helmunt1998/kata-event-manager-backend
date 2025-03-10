# Kata Event Manager Backend
 
Este es el proyecto para el gestor de eventos temporales, desarrollado con Spring Boot. Hace parte del módulo Backend que, a su vez, complementa el Front en: [Event Manager Frontend](https://github.com/helmunt1998/temp-event-manager)
 
 
## Instalación
 
1. Clone el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/kata-event-manager-backend.git
    cd kata-event-manager-backend
    ```
 
2. Configure la base de datos en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/event_manager
    spring.datasource.username=-usuario
    spring.datasource.password=contraseña
    ```
    Nota: Por defecto ya está configurada y precargada por Script una Base de datos en memoria H2.
 
3. Compile y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
 
## Depuración en Local
 
1. Abra el proyecto en su IDE de preferencia (IntelliJ IDEA, Eclipse, etc.).
2. Configure un entorno de ejecución para Spring Boot.
3. Ejecute la aplicación en modo depuración.
 
## Ficha Técnica
 
* **Framework**: Spring Boot 3.4.3 y Spring Framework 6.2.3
* **Base de Datos**: H2
* **Compilación**: Maven 3.9.1
* **Lenguaje**: Java 23
* **Puerto por Defecto**: 8081
 
### Requisitos
 
 - Java 23 o superior
 - Maven 3.6.0 o superior
 - SpringBoot 3.0.x o superior
 - Spring Framework 6.x o superior
 
## Endpoints Principales
 
- `GET /api/events` - Lista todos los eventos
- `POST /api/events` - Crea un nuevo evento
- `GET /api/events/{id}` - Obtiene un evento por ID
- `PUT /api/events/{id}` - Actualiza un evento por ID
- `DELETE /api/events/{id}` - Elimina un evento por ID
 
## Contribuciones
 
Si desea contribuir a este proyecto, por favor siga estos pasos:
 
1. Haga un fork del repositorio.
2. Cree una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realice sus cambios y haga commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Haga push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Cree un Pull Request.
 
## Licencia
 
Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo `LICENSE` para más detalles.