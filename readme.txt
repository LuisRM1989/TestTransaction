1-Descargar proyecto
2-Abrir con IntelliJ con la opcion Importar
3-Selecciona el archivo pom.xml
4-Al abrir el proyecto corremos el proyecto.
si no esta  configurado el modo de ejecucion 
5-Seleccionamos en la configuracion la plantilla Maven
6-En la configuracion de parametros
Seleccionamos el directorio donde este el pom.xml
Command line: spring-boot:run -f pom-xml
Profiles: -text
7- Al ejecutar vamos a un navegador e ingresamos a la url: http://localhost:8080/swagger-ui.html
8- Tenemos las opciones de Owners, Account y Transacction
9- Ingresamos un Owner para obtener su clave.
10-Ingresamos un Account con la clave de usuario obtenida anteriormente.
Nota: necesitamos dos Account para realizar la tranferencia
11-Ingresamos una trasferencia con las dos claves de Account para generarla.
12-En transferencias podemos obtener las transferencias realizadas por clave de Account
12-En transferencias podemos obtener las transferencias obtenidas por clave de Account