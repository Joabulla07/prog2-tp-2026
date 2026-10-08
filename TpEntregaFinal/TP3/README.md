# Trabajo Práctico N° 3: Pilares de la POO

**Unidad:** Unidad 2 – Paradigma Orientado a Objetos (Continuación)  
**Tema:** Herencia, Polimorfismo y Clases Internas

## Descripción

Este trabajo práctico cubre los conceptos fundamentales de la Programación Orientada a Objetos en Java:
- Herencia (extends) y reutilización de código
- Polimorfismo dinámico
- Sobreescritura (Overriding) vs Sobrecarga (Overloading)
- Clases y métodos abstractos (abstract)
- Interfaces (implements)
- Clases internas (Inner Classes) y clases anónimas (Java 8)

## Estructura del Proyecto

```
TP3/
├── Ejercicio1/
│   ├── Empleado.java              (Clase abstracta)
│   ├── EmpleadoContratado.java    (Subclase concreta)
│   ├── EmpleadoEfectivo.java      (Subclase concreta)
│   └── MainEmpleado.java          (Demostración de polimorfismo)
├── Ejercicio2/
│   ├── Facturable.java            (Interfaz)
│   ├── PedidoOnline.java          (Implementación de interfaz)
│   ├── ContratoServicio.java      (Implementación de interfaz)
│   └── MainFacturable.java        (Demostración de desacoplamiento)
├── Ejercicio3/
│   ├── Outer.java                 (Clase contenedora con Inner class)
│   └── MainClasesInternas.java    (Demostración de clases internas y anónimas)
└── README.md
```

## Ejercicio 1: Jerarquía Abstracta y Polimorfismo

### Objetivo
Diseñar una clase abstracta `Empleado` con atributos privados y un método abstracto `calcularSalario()`. Implementar dos subclases concretas y demostrar polimorfismo dinámico.

### Clases
- **Empleado**: Clase abstracta con atributos `nombre`, `id`, `salarioBase` y método abstracto `calcularSalario()`
- **EmpleadoContratado**: Subclase que calcula salario basado en tarifa por hora y horas trabajadas
- **EmpleadoEfectivo**: Subclase que calcula salario con bono y deducciones

### Ejecución
```bash
cd Ejercicio1
javac *.java
java MainEmpleado
```

### Conceptos Demostrados
- Uso de `abstract` para clases y métodos
- Uso de `extends` para herencia
- Uso de `@Override` para sobreescritura
- Polimorfismo dinámico con arreglos homogéneos
- Referencia `super` para acceder a miembros de la clase padre

## Ejercicio 2: Diseño Basado en Interfaces

### Objetivo
Diseñar la interfaz `Facturable` con el método `emitirFactura()`. Implementar la interfaz en dos clases sin relación jerárquica y demostrar desacoplamiento.

### Clases
- **Facturable**: Interfaz con firma del método `emitirFactura()`
- **PedidoOnline**: Implementa Facturable para pedidos en línea
- **ContratoServicio**: Implementa Facturable para contratos de servicio

### Ejecución
```bash
cd Ejercicio2
javac *.java
java MainFacturable
```

### Conceptos Demostrados
- Definición de interfaces con `interface`
- Implementación de interfaces con `implements`
- Desacoplamiento de comportamiento
- Polimorfismo a través de interfaces
- Módulos procesadores que aceptan parámetros de tipo interfaz

## Ejercicio 3: Clases Internas y Anónimas (Java 8)

### Objetivo
Programar un escenario con clases internas que acceden a miembros privados de la clase contenedora. Implementar clases anónimas para responder a eventos o interfaces.

### Clases
- **Outer**: Clase contenedora con clase interna `Inner`
- **MainClasesInternas**: Demostración de clases internas y anónimas

### Ejecución
```bash
cd Ejercicio3
javac *.java
java MainClasesInternas
```

### Conceptos Demostrados
- Clases internas (Inner Classes)
- Sintaxis `Outer.Inner inner = outer.new Inner()`
- Acceso a miembros privados de la clase contenedora desde la clase interna
- Clases anónimas implementando interfaces (ej. `Runnable`)
- Clases anónimas pasadas directamente como argumentos de métodos
- Uso de clases anónimas para responder a eventos

## Criterios de Evaluación

✅ Correcto diseño de la clase abstracta e interfaces  
✅ Uso apropiado de la anotación `@Override` y la referencia `super`  
✅ Invocaciones polimórficas exitosas en tiempo de ejecución  
✅ Declaración limpia de clases internas y anónimas  

## Requisitos

- JDK 8 o superior
- IDE (IntelliJ IDEA, Eclipse, NetBeans) o compilador desde línea de comandos

## Resultados Esperados

Capacidad para construir arquitecturas orientadas a objetos desacopladas, extensibles y mantenibles utilizando los pilares fundamentales de la POO.
