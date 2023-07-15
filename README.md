# RestApiSpring


# CONTENIDO

El Back  esta realizado en 

[Java](https://www.java.com/es/)

[Mongo DB](https://www.mongodb.com/es/)

## su estructura de archivos 
### Controllers
	UserController.java 

Se encarga de recibir las peticiones y ejecutar la lógica principal (llamado al servicio la mayoría de las veces)	

### Services
	UserService.java

Acciones permitidas en el sistema. Todo lo que se permite a quién lo solicita, por ejemplo: actualizar, buscar, operaciones de lógica, etc.

### Repositories
	UserRepository.java
Implica los métodos que llama el servicio. Tiene la lógica de conexión de persistencia, acciones de mapeo de objetos, métodos de operaciones de base de datos (consultas, etc).

### Models
	UserModel.java

Representación de una tabla/entidad/tipo/colección en una clase Java. Modelo de clase. 

________________________________________________________________________________________________________________________________________

## Framework

Spring boot 

Spring data

### Asistente de proyecto 

[intellij IDEA](https://www.jetbrains.com/idea/download/?section=windows)
__________________________________________________________________________________________________________________________________________
### Tener en cuenta 

1.	Recuerde tener instalado Java y en particular el JDK 8+.
2.	Puedes instalar IntelliJ IDEA directamente desde la web de Jetbrains, utilizando NNF (Next, Next, Finish), para cualquier SO (Windows, Linux, macOS). Recuerde que tiene dos opciones: versión community y ultimate (esta última se puede obtener en una licencia estudiantil). 
3.	En Windows también lo puedes hacer a través del gestor de paquetes chocolatey. En el powershell utilizando la línea de comando: choco install intellijidea-community. Para Linux, por ejemplo, dependiendo la distribución utilice su gestor de paquetes apt-get, yum, dnf, … Para macOS puede utilizar el gestor de paquetes Homebrew con la línea de comando: brew cask install intellij-idea-ce
______________________________________________________________________________________________________________________________________
### Programas Necesarios
Para poder utilizar el proyecto en localhost en necesario clonarlo y tener algunos programas necesarios:

IDE de desarrollo de tu comodidad Ej. [VS Code](https://code.visualstudio.com)

[POSMAN](https://www.postman.com) para puebas de APIS. (Opcional)

[git](https://github.com) para poder gestionar las versiones.


# Como Clonar

Comando para clonar:


git clone [LINK DEL REPOSITORIO]

### Como Ejecutar 

hacer  click sobre la clase principal y seleccione en la opción Run

![image](https://github.com/migueldj94/RestApiSpring/assets/125587415/9c26ff49-cad0-4d0b-9ab1-9ac02632f8df)


salida y  ejecución en la ventana inferior de IntelliJ IDEA:

![image](https://github.com/migueldj94/RestApiSpring/assets/125587415/c31da869-5353-4869-abff-5cef5fc38264)


_____________________________________________________________________________________________________________________________________

# Funcionalidad 

### personas  

crear personas 

obtener persona

obtener todas las personas  

si la persona ya existe no es posible crearlo de nuevo 

todos los campos del formulario tienen validaciones que reciben letras o numeros 


### doctores 

crear doctor 

obtener doctor 

obtener doctores 

No se puede crear más de un médico por especialidad

No es posible crear un nuevo médico cuya cédula ya existe en la base de datos

___________________________________________________________________________________________________________________________________

# Endpoints

### obtener cita medica 

GET  http://localhost:9000/citas/especialidad/1

### agregar cita medica 

POST http://localhost:9000/api/citasMedicas

### obtener citas medicas 

GET http://localhost:9000/api/citasMedicas


### obtener personas  

GET http://localhost:9000/api/personas

### agregar peronas 

POST http://localhost:9000/api/personas

### obtener doctor 

GET http://localhost:9000/api/doctores

### agregar doctor 

POST http://localhost:9000/api/doctores

###  obtener especialidad  

GET http://localhost:9000/api/especialidades

### agregar especialidad

POST http://localhost:9000/api/especialidades


# Video y pruebas Unitarias

[video y pruebas](https://drive.google.com/drive/folders/1rbU0pGnbTdbVSz4TvZS61-MhUckZQde7)
