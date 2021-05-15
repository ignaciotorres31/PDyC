# PDyC- 
#TP2 

HTTP
 ¿Qué es el protocolo HTTP? 

HTTP es el Protocolo de transferencia de hipertexto (Hypertext Transfer Protocol), es decir es el protocolo de comunicación que permite las transferencias de información a través de archivos (XHML, HTML . . .) en la World Wide Web. 

 Mencionar los distintos métodos y verbos de HTTP 

Los distintos métodos de HTTP son : GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
 ¿Los request de tipo POST tienen un body? ¿Y los de tipo GET? 

Los request de tipo POST tienen body, esto quiere decir que envían datos al servidor. 
En cambio los de tipo GET, no tienen body y no tienen acción sobre el servidor

 Códigos de estado de response HTTP: Describa los código: 200, 201, 400, 401, 403 y 500. 

Código 200: Ok. El request es correcto. Esta es la respuesta estándar para respuestas correctas.
Código 201: Created.  El request se ha completado y se ha creado un nuevo recurso.
Código 400: Bad Request. El servidor no puede o no va a procesar el request por un error de sintaxis del cliente.
Código 403: Forbidden. El request fue válido pero el servidor se niega a responder.
Código 500: Internal Server Error. Error genérico, cuando se ha dado una condición no esperada y no se puede concretar el mensaje.

 ¿Qué posibles valores de Media Type puede tomar el header Content Type de HTML?
Todos los tipos de posibles valores de Media Type estan aca: http://www.iana.org/assignments/media-types/media-types.xhtml

Los tipos más comunes son:
Tipo de aplicación:
application/java-archive
application/javascript   
application/pdf  
application/json  
application/xml   
application/zip  

Escribe audio
audio/mpeg   
audio/x-wav   

Escribe imagen
image/gif   
image/jpeg   
image/png   

Tipo multiparte
multipart/mixed    
multipart/alternative   
multipart/form-data  

Teclee el texto
text/css    
text/csv    
text/html    
text/javascript (obsolete)    
text/plain    
text/xml    
 
Escribe vídeo
video/mpeg    
video/mp4    
video/quicktime    
video/x-ms-wmv    
video/x-msvideo    

JSON 

 Defina brevemente JavaScript Object Notation

Es un estándar basado en texto plano para el intercambio de información, por lo que se usa en muchos sistemas que requieren mostrar o enviar información para ser interpretada por otros sistemas, la ventaja de JSON al ser un formato que es independiente de cualquier lenguaje de programación, es que los servicios que comparten información por éste método, no necesitan hablar el mismo idioma.

Ejemplo : El emisor puede ser JAVA y el receptor podría ser PHP.

Spring.io 

 Realice un investigación y describa brevemente el framework Spring: https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html 

Es una de las tecnologías dentro del mundo de Spring de las que más se está hablando últimamente. Ofrece como elemento clave el soporte de infraestructura a nivel de aplicación, brindando un completo modelo tanto para la configuración como para la programación de aplicaciones empresariales desarrolladas bajo Java, sin discriminación en cuanto al despliegue de la plataforma. Permite que los equipos de desarrollo puedan enfocarse directamente en la lógica empresarial que requiere la aplicación, haciendo el proceso más corto, rápido y eficaz, ahorrando líneas de código evitando tareas repetitivas.


 Spring Web: ○ ¿Cuál es el propósito de la anotación @Service?

Los componentes de servicio son el archivo de clase que contiene la anotación @Service. Estos archivos de clase se utilizan para escribir lógica empresarial (lógica de negocio) en una capa diferente, separada del archivo de clase @RestController.

 Para que se usa la anotación @Autowired 

Spring @Autowired es una de las anotaciones más habituales cuando trabajamos  con Spring Framework ya que se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring.

 Spring-boot: Explique brevemente el propósito de este proyecto de Spring

El objetivo de Spring Boot es proporcionar un conjunto de herramientas para construir rápidamente aplicaciones de Spring que sean fáciles de configurar.
 
 Spring Data JPA ○ ¿Para qué se usa la anotación @Repository y qué es la interface JPARepository?

@Repository se usa para anotar clases en la capa de persistencia, que actuará como un repositorio de la base de datos.

JPARepository

Su objetivo es simplificar al desarrollador la persistencia de datos contra distintos repositorios de información.

JAXRS - Jersey 
 ¿Con qué anotaciones se declaran los distintos métodos HTTP? 
Los métodos HTTP se anotan de la siguiente manera: 
@GET
@POST
@PUT
@DELETE
@HEAD
@OPTION


 Describa el propósito de las anotaciones ○ @Path ○ @Produces ○ @Consumes ○ @PathParam ○ @QueryParam ○ @HeaderParam 

@Path: Es una URI de un path relativo que indica dónde se mapeará el servicio. 
@Produces: Se utiliza para especificar el tipo MIME de las representaciones que un recurso puede proporcionar y enviar al cliente.
@Consumes: Se utiliza para especificar el tipo MIME de las representaciones que un recurso puede consumir cuando ésta es enviada desde el cliente.
@PathParam: Es un tipo de parámetro que puede extraerse para utilizarse en la clase del recurso. Estos parámetros se extraen de la URI de la petición. En la plantilla de la ruta especificada mediante @Path se pueden incluir segmentos variables, y mediante @PathParam podemos hacer referencia a estas variables para obtener su valor y utilizarlo en nuestro código
@QueryParam: Es un tipo de parámetro que puede extraerse para utilizarse en la clase del recurso. Los parámetros de la query de la URI se extraen de los parámetros de query de la URI de la petición
@HeaderParam: se usa para inyectar valores de encabezado de solicitud HTTP

Explique el uso de la clase javax.ws.rs.core.Response y sus métodos estáticos ok y status. ¿Qué patrón de diseño implementa? 

Define el contrato entre una instancia devuelta y el tiempo de ejecución cuando una aplicación necesita proporcionar metadatos al tiempo de ejecución.
Una clase de aplicación no debe extender esta clase directamente. La clase de respuesta está reservada para una extensión por los proveedores de implementación JAX-RS. Una aplicación debe usar uno de los métodos estáticos para crear una instancia de Respuesta usando un ResponseBuilder.


DTO 

Explique brevemente el patrón de diseño Data Transfer Object.

Es un objeto que transporta datos entre procesos. La motivación de su uso tiene relación con el hecho que la comunicación entre procesos se realiza generalmente mediante interfaces remotas (por ejemplo, servicios web), donde cada llamada es una operación costosa.

Investigue el uso de la librería ModelMapper
http://modelmapper.org/getting-started/

Es una librería Java para copiar o mapear propiedades de un tipo de objeto a otro tipo de objeto, permitiendo copiar también los datos de las referencias a los objetos que contengan. 


Inicialización de un nuevo proyecto Spring

● Identifique y analice el contenido del archivo pom.xml

En el archivo pom.xml estan todas las dependencias que vamos a necesitar para el proyecto. Cuando compilamos el proyecto, maven descarga las dependencia declaradas en el pom.xml

● ¿Cuál es el propósito de la clase generada por el asistente que tiene la notacion @SpringBootApplication?

La notación @SpringBootApplication. Esto internamente es una combinación de las siguientes 3 anotaciones. Y en forma de resumen más simplificado realiza: @Configuración: Necesaria para configuraciones de resorte manual. La adición de esta anotación garantiza que la configuración se puede realizar en una clase Java en lugar de usar un archivo xml separado. @EnableAutoConfiguration: Spring necesita mucha configuración por hacer. Esta anotación asegura que gran parte de la configuración se realiza automáticamente. @ComponentScan: Esto le dice a Spring, donde todos deben buscar componentes. Los siguientes son los parámetros aceptados en la anotación @SpringBootApplication: excluir: excluye la lista de clases de la configuración automática. excludeNames: excluye la lista de nombres de clase totalmente calificados de la configuración automática. Este parámetro agregado desde Spring Boot 1.3.0. scanBasePackageClasses: proporcione la lista de clases que se deben aplicar para @ComponentScan. scanBasePackages: Proporciona la lista de paquetes que se deben aplicar para @ComponentScan. Este parámetro agregado desde el arranque de primavera 1.3.0.

● ¿Para qué se utiliza el archivo src/main/resources/application.properties

Se utiliza para definir las properties del proyecto. Las properties son un modo conveniente de proporcionar pares clave-valor que podremos utilizar desde nuestra propia aplicación. De hecho, lo que podemos definir mediante una property es una clave, a la que le asignaremos un valor, y en nuestra aplicación podemos usar esa clave

● Ejecute el proyecto y determine cuál es la causa por la cual falla el deploy.

Falla debido a que no está configurado la base de datos en application.properties

● Defina ahora la clase JerseyConfig que extienda de ResourceConfig para poder registrar los distintos resources para que puedan ser accedidos. 
Tenga en cuenta la anotación @Component.

● Realice un nuevo commit para versionar los cambios

● Cambie nuevamente a la rama master y realice un merge con la rama develop

