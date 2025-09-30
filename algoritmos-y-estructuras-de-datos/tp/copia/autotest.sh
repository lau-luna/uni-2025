#!/bin/bash

# Compilar todos los archivos .java
javac *.java -encoding UTF-8
if [ $? -ne 0 ]; then
  echo "Error: Fallo en la compilación."
  rm *.class
  exit 1
fi

# Ejecutar Test de Estado
java PruebaEstado
if [ $? -ne 0 ]; then
  echo "Error: Fallo al ejecutar los tests sobre Estado"
  rm *.class
  exit 1
fi

# Ejecutar Test de Pila
java PruebaPila
if [ $? -ne 0 ]; then
  echo "Error: Fallo al ejecutar los tests sobre Pila"
  rm *.class
  exit 1
fi

# Ejecutar Test de Evaluador
java PruebaEvaluador
if [ $? -ne 0 ]; then
  echo "Error: Fallo al ejecutar los tests sobre Evaluador"
  rm *.class
  exit 1
fi

echo "Script ejecutado correctamente."
rm *.class
exit 0