*************************************************************************************************************************************************************************************
Para la compilación del proyecto se deben seguir los siguientes pasos:

1. Configurar el puerto en el que se desea ejecutar la aplicación, ajustando la variable "server.port" en el archivo properties. El valor por defecto es 8080.
2. Abrir consola de comandos en la ruta donde se encuentra la aplicación.
3. Ejecutar el comando:  mvn clean install package

De está manera se habra generado un archivo .jar de la aplicación.

Para realizar la ejecución se deben seguir los siguientes pasos:

1. Ubicar la ruta ..SanitasTest\target dentro del proyecto.
2. Abrir una consola de comandos en esta ruta.
3. Ejecutar el comando: java -jar ..SanitasTest\target\sanitas-0.0.1-SNAPSHOT.jar 
	(asegurandose de tener el directorio de la carpeta target correctamente indicado)
4. Validar que se ha desplegado la aplicación correctamente en la url y puertos especificados, por defecto: http://localhost:8080
5. Una vez el servicio se encuentre en ejecución puede realizar peticiones a través de los servicios expuestos:
	* /test/calculator/add
	* /test/calculator/substract
	Los cuáles son de tipo POST y reciben como parametro un listado de números de tipo (Integer).

*************************************************************************************************************************************************************************************
Puede validar la documentación de la aplicación, una vez se encuentre desplegada, en el swagger del servidor:

(Por defecto) http://localhost:8080/test/swagger-ui.html

*************************************************************************************************************************************************************************************