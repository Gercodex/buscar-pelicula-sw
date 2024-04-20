# buscar-pelicula-sw

Aplicación que consume un OpenAPI (swapi.dev) de búsqueda de películas para la actividad del curso de java para el programa ONE y Alura Latam.

Dependencias: gson-2.10.1

Para compilar desde carpeta que contiene a /src con 'gson' en la misma carpeta:

..$ javac -d classes src/com/cursoalura/cuarto/modulos/ *.java src/com/cursoalura/cuarto/principal/ *.java -classpath gson-2.10.1.jar

Para ejecutar la aplicación dentro de la carpeta classes:

--$ java -classpath "/home/.../.../.../.../buscar-pelicula-sw/gson-2.10.1.jar": com.cursoalura.cuarto.principal.Principal

Nota: la ruta para el classpath es ficticia solo para fines ilustrativos, reemplazar por la ruta completa donde se encuentre el paquete gson.
