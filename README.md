Integrantes del grupo:

José Enrique García Arévalo 0009361
Rodrigo Anibal Hernández García 00050519
Andrea María Rodríguez Amaya 00366519
Gerson Javier Quintanilla Sánchez 00254719
Luis Gustavo Escobar Hernández 00091318

Requerimientos para correr de froma local

Pre requsitos
Java SDK 11 o superior https://www.oracle.com/java/technologies/downloads/
Node JS 20 o superior https://nodejs.org/es
Spring tools suite 4 o ide de IntelliJ IDEA https://spring.io/tools/
Maven https://maven.apache.org/

Instrucciones para ejecución local

Instrucciones para backend

1. Con las tecnologías previamente mecionadas, abrir la carpeta backend con el ide seleccionado compatiblec on spring boot
2. Ejecutar Mediante le ide el código de spring boot
3. El enlace por defecto para consumir la api localmente será http://localhost:8080

Instruciones para front end
1. Con las tecnologías previamente mecinoadas, abrir en un editor de código como visual studio code la carpeta proyecto-ARI-react o navegar hasta esta mediante la consola
2. Ejecutar el comando npm install
3. Modificar dentro del archivo proyecto-ARI-react/src/api/axios.js la variable llamada baseURL y reemplazarla por http://localhost:8080 si se desea usar el backend local
4. Ejecutar el comando npm run dev
5. En la barra de navegación colocar en enlace http://localhost:5173/

Enlace de aplicación funcional:
https://proyecto-ari.vercel.app/


