# TP 1 - Algoritmos y Estructuras de Datos 1 - Año 2025

## Este TP debe realizarse en forma grupal, en grupos de mínimo 2 y máximo 3 integrantes. NO SE ACEPTARÁN ENTREGAS INDIVIDUALES.

La integridad académica es un principio esencial en todos los aspectos de la educación. En el contexto de los exámenes esto es `fundamental`.
El plagio y el pasar el trabajo de otros como propio representan una grave violación de este valor. El plagio implica copiar o parafrasear el trabajo de alguien más sin atribuir adecuadamente la autoría. Pasar el trabajo de otros como propio es aún mas grave, ya que no refleja el conocimiento adquirido.
La integridad académica demanda `originalidad`, `honestidad` y `respeto` hacia el trabajo `propio` y de `otros`. Promover y mantener altos estándares de integridad académica es esencial para preservar la calidad y el valor de la educación.

En caso de detectarse un posible caso de plagio o copia, la entrega será puesta bajo observación, se informará a las autoridades departamentales y se evaluarán los pasos a seguir. Asimismo, algunos estudiantes podrán ser seleccionados, en caso de que el equipo docente lo considere necesario, para explicar oralmente la resolución de los ejercicios. Si no logran responder adecuadamente a la solicitud del docente, se descontarán puntos a ambos integrantes del grupo. Esto implica que `TODOS` los miembros deben participar activamente en la resolución de cada ejercicio.

Se recomienda utilizar herramientas de inteligencia artificial de manera responsable y como herramienta de apoyo. Lo más valioso para su proceso de aprendizaje es que intenten resolverlos por su cuenta, pensando la solución. Recuerden que en caso de encontrarse con dificultades, pueden recurrir a la ayuda de los profesores.

## **\*\*\*\***\*\***\*\*\*\***\***\*\*\*\***\*\***\*\*\*\***

## FECHA DE ENTREGA: Jueves 25 de Septiembre hasta las 23:59:59 hs

## **\*\*\*\***\*\***\*\*\*\***\***\*\*\*\***\*\***\*\*\*\***

## Situación Problemática

En el desarrollo de software se utilizan continuamente expresiones lógicas, ya sea en condicionales, ciclos o para especificar de forma precisa el comportamiento esperado de un método o función(invariantes, precondiciones, postcondiciones). Detrás de estas operaciones existen estructuras de datos y mecanismos que permiten representar, manipular y evaluar expresiones booleanas de manera eficiente y extensible.

En Particular, la forma en que representamos las expresiones no es un detalle menor, ya que influye en cómo se almacenan, procesan y evalúan. La notación prefija (también llamada Polaca) tiene la ventaja de eliminar la ambigüedad propia de la notación infija, ya que no requiere paréntesis para indicar el orden de evaluación. Esto, si bien es más compleja de entender para el ojo humano, resulta especialmente útil y práctico en el diseño de intérpretes, compiladores y calculadoras, donde las expresiones deben analizarse y evaluarse de manera automática.
Por ejemplo, en notación infija escribiríamos:

- p AND q
- (p OR q) AND r
- NOT (p OR q)

Las mismas expresiones en notación prefija se expresan sin necesidad de paréntesis, de la siguiente manera:

- AND p q
- AND OR p q r
- NOT OR p q

Así, una expresión más compleja `(p OR q) AND (NOT r)` en infija, se traduce de forma directa a `AND OR p q NOT r` en prefija, eliminando cualquier ambigüedad respecto al orden de evaluación.

Ahora bien, las expresiones lógicas no se resuelven de forma aislada: dependen del valor de verdad que tomen sus variables en un momento dado. Por ejemplo, la expresión `AND p q` puede ser verdadera o falsa según si las variables p y q valen verdadero o falso en ese contexto. Por lo tanto, un evaluador de expresiones lógicas necesita un mecanismo para asociar a cada variable su valor actual.

Como parte de este trabajo práctico se propone diseñar e implementar en Java un **evaluador de expresiones booleanas usando notación Prefija**, que además de resolver un problema concreto, servirá como ejercicio para aplicar conceptos de POO y estructuras de datos.

## Estructura del Proyecto

El desarrollo del evaluador de expresiones booleanas se organizará en torno a varios componentes principales. El objetivo es que se experimente con el diseño de clases y estructuras de datos. En particular, se solicita diseñar e implementar una estructura de datos propia para almacenar el estado de las variables involucradas en las expresiones booleanas. Esta estructura deberá ser capaz de:

- Registrar variables junto con su valor de verdad.
- Actualizar el valor de variables ya registradas.
- Consultar el valor actual de una variable en tiempo de evaluación.
- Detectar si una variable no tiene valor asignado, de manera de poder informar un error.

De este modo, el sistema podrá evaluar expresiones prefijas de forma dinámica, tomando los valores desde esta estructura y aplicando las operaciones lógicas correspondientes.

Cabe aclarar que, si bien ciertos aspectos del diseño quedan a criterio del grupo de trabajo (como la implementación interna de la estructura de datos, la estrategia de búsqueda, o la forma de manejar excepciones), otros elementos están previamente definidos para garantizar uniformidad.

Es por ello, que en el código fuente que acompaña a este enunciado se incluyen los siguientes archivos:

- Una interfaz que caracteriza el TAD Pila, con métodos para manipular y mostrar la misma.
- Una interfaz base de las operaciones necesarias para la representación del estado de las variables.
- Una interfaz para el evaluador de expresiones, que especificará los métodos básicos de análisis y cálculo del resultado.

De esta manera, cada grupo podrá explorar diferentes alternativas de implementación, pero al mismo tiempo se mantendrá la compatibilidad necesaria para poder probar y validar las soluciones de manera homogénea.

## Actividad

Para dar solución a este problema vamos a empezar resolviendo problemas más simples que nos ayuden a calcular lo que queremos. Se deberán completar las siguientes consignas:

1. Inscribirse en GitHub Classroom y obtener el código base del proyecto.
2. Registrar su nombre de usuario en el siguiente formulario: https://forms.gle/NPQFid2wYtLYjrn56
3. Completar los integrates del grupo en el archivo `INTEGRANTES.txt`
4. Un primer paso es implementar el TAD Pila dado, en este caso sobre Listas Doblemente Enlazadas.
   Para ello tendrán que analizar la interfaz que caracteriza este TAD, y luego completar el archivo ‘PilaDoblementeEnlazada.java’ dado.

- `Pila.java` —> Interfaz que especifica las operaciones del TAD.
- `PilaDoblementeEnlazada.java` —> Clase que implementa la interfaz Pila.java y la cual deberán completar.
- `PruebaPila.java` —> Programa de prueba de la pila.Compilar y ejecutar una vez finalizada la implementación para comprobar que el comportamiento es el esperado.

5. En segundo lugar, se deberá implementar una estructura de datos que permita gestionar el estado de las variables en expresiones booleanas. Esta estructura debe ser capaz de registrar y actualizar sus valores de verdad, consultar el valor actual durante la evaluación y detectar si alguna variable no tiene un valor asignado, con el fin de reportar un error. Para ello se proveen los siguientes archivos:

- `Estado.java` —> Interfaz que especifica las operaciones necesarias para manejar el estado de las variables involucradas en las expresiones booleanas.
- `EstadoVariables.java` —> Clase que implementa la interfaz ` Estado.java` y la cual deberán completar. (**Leer restricciones debajo**)
- `PruebaEstado.java` —> Programa de prueba para los estados. Compilar y ejecutar una vez implementado el Estado, para comprobar que el comportamiento es el esperado.

**IMPORTANTE:** A la hora de diseñar e implementar la clase `EstadoVariables.java` deberán tener en cuenta las siguientes condiciones:

- Los nombres de las variables sólo podrán ser caracteres en minúsculas del rango `[a-z]`, podrán existir como máximo 26 variables distintas.
- Para llevar a cabo la implementación de la clase `EstadoVariables.java`, **no se permitirá utilizar la clase HashMap de Java**.

6. Por último, deberán integrar todo lo previamente desarrollado para implementar el Evaluador. Para ello se proveen los siguientes archivos:

- `Evaluador.java` —> Interfaz que caracteriza las operaciones necesarias del evaluador de expresiones, para el análisis y cálculo del resultado.
- `EvaluadorPrefijo.java` —> Clase que implementa la interfaz `Evaluador.java` y es la que deberán diseñar y completar. (**Leer restricciones debajo**)
- `PruebaEvaluador.java`—> Programa de prueba para el evaluador. Compilar y ejecutar una vez finalizada la implementación para comprobar que el comportamiento es el esperado.

**IMPORTANTE:**
A la hora de diseñar e implementar la clase `EvaluadorPrefijo.java` deberán tener en cuenta las siguientes condiciones:

- El evaluador tiene un método que recibe un `String` que representa la expresión booleana a evaluar. El mismo debera respetar el siguiente formato:

- exp ::= `NOT` exp | `OR` exp exp | `AND` exp exp | variable
- variable ::= [a-z]

  Es decir serán secuencias de operadores lógicos y variables, separadas por un espacio simple. Los operadores lógicos deberan estar escritos en mayúscula y en ingles,

- `NOT`: representa la **negación** lógica, con su semántica usual. (Op. Unario)
- `AND`: representa la **conjunción** lógica, con su semántica usual. (Op. Binario)
- `OR`: representa la **disjunción** lógica, con su semántica usual. (Op Binario)

7. Entregar la solución completa del proyecto en tiempo y forma a través de GitHub Classroom.

**IMPORTANTE:** Se pueden agregar métodos y clases auxiliares en caso de ser necesario. Pero, se deberá respetar el perfil de los métodos ya definidos. Y NO ESTÁ PERMITIDO cambiar el nombre o estructura de las clases de Java provistas.

## Compilación y Ejecución

El proyecto se creó utilizando solamente Java, por lo que no debería ser necesario instalar otra herramienta. Además, se incluyeron test para que puedas validar tu implementación.

Algunos comandos útiles:

- Compilación: `javac *.java` permite compilar todas las clases Java utilizadas en el proyecto.
  
- Ejecución/Test: Sólo 3 clases tienen definido el método main(), y permiten ejecutar una serie de test sobre los distintos componentes de tu solución:
  
   - `java PruebaPila` permite ejecutar los tests definidos sobre tu implementación de `PilaDoblementeEnlazada`.

   - `java PruebaEstado`  permite ejecutar los tests definidos sobre tu implementación de `EstadoVariables`.
     
   - `java PruebaEvaluador`  permite ejecutar los tests definidos sobre tu implementación de `EvaluadorPrefijo`.
     
## Envío del proyecto: GitHub Classroom

Utilizaremos GitHub Classroom. Accede al link del trabajo práctico que te enviamos por Classroom y/ó Slack. Unite para tener acceso a la actividad. (Si es la primera vez que utilizas GitHub Classroom te pedirá que otorgues permisos para acceder a tu repositorio de GitHub.)

Para trabajar en los archivos del proyecto, es necesario crear una copia local en tu computadora, agregar tu solución en los archivos locales, y luego subir los cambios a GitHub.

- Abre tu terminal o línea de comandos. Elige un directorio de trabajo donde agregarás tu carpeta con el proyecto a editar y ejecuta el siguiente comando, tendrás una copia local del repositorio:

```
git clone <link de tu repositorio>
```

![git clone](/img/clone.png)

- Una vez clonado, utiliza el siguiente comando para entrar al directorio del proyecto:

```
cd <directorio del repositorio clonado (tu copia local)>
```

- Utiliza tu editor de código favorito (Visual Studio Code, Sublime Text, Atom, etc.) para abrir los archivos del proyecto y realizar los cambios necesarios.

- Git realiza un seguimiento de los cambios que realizas en los archivos. Para registrar estos cambios localmente, utiliza el comando “git add”.

```
git add <nombre-del-archivo>
```

- Cuando esté listo para subir, primero deberás “asegurar tus cambios” con el comando `commit`. Ete comando toma una “foto instantánea” de tu código y permite que tus cambios queden registrados en tu máquina. Deberás agregarle un mensaje descriptivo que identifique los cambios realizados, por ejemplo:

```
git commit -m “Agrego fn factorizar”
```

Es importante destacar que la operación commit no realiza los cambios en el repositorio remoto (el que está subido en gitHub). La operación commit solamente permite guardar los cambios en tu copia local.

- Para enviar todos tus cambios al repositorio remoto de gitHub, utiliza el comando “git push”

```
git push
```

NOTA: Si hiciste 5 commits en tu repositorio local, al hacer "git push" se enviaran todos los cambios hechos en esos 5 commits al repositorio remoto. Es decir el push envía TODOS los cambios realizados al repositorio remoto.

![git push](/img/push.png)

- Otros comandos útiles son

`git status`: permite visualizar el estado actual de tu repositorio (archivos modificados, listos para commit, etc).

`git log`: permite ver el historial de commits
