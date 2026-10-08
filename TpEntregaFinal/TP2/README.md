# Trabajo Práctico N° 2: Fundamentos de POO, Encapsulamiento y Modificadores de Acceso

## Descripción
Modelado de clases de dominio aplicando encapsulamiento estricto, especificación JAVABeans, modificadores de acceso (public, private, protected, default), miembros estáticos, enumeraciones (enum) y manipulación de variables de referencia.

## Objetivos Específicos
- Diseñar clases cumpliendo la convención JAVABean (atributos privados, getters/setters, constructor público sin argumentos)
- Aplicar modificadores de acceso para controlar la visibilidad e integridad del estado entre diferentes paquetes
- Diferenciar variables de instancia de miembros estáticos (static) y manipular referencias a objetos en memoria
- Utilizar enumeraciones (enum) y operaciones de casting sobre variables de referencia con el operador instanceof

## Estructura del Proyecto

```
TP2/
└── org/
    └── curso/
        ├── externo/
        │   └── CelularPremium.java
        ├── modelo/
        │   ├── Celular.java
        │   └── EstadoLlamada.java
        └── test/
            └── TestCelular.java
```

## Clases Implementadas

### 1. Celular.java (Paquete: org.curso.modelo)
Clase de dominio que implementa el patrón JAVABean con:

**Atributos privados:**
- `marca`: String - Marca del celular
- `modelo`: String - Modelo del celular
- `color`: String - Color del celular
- `saldo`: double - Saldo disponible

**Miembro estático:**
- `contadorInstancias`: static int - Cuenta el total de instancias creadas

**Constructores:**
- Constructor público sin argumentos (JAVABean)
- Constructor parametrizado con todos los atributos

**Getters/Setters con validaciones:**
- Validan que no se asignen valores nulos o vacíos a String
- Validan que el saldo no sea negativo
- Lanzan `IllegalArgumentException` ante valores inválidos

**Métodos de comportamiento:**
- `llamar(String nombre)`: Simula una llamada telefónica, descuenta $0.50 del saldo
- `cortarLlamada()`: Finaliza la llamada en curso
- `informarCaracteristicas()`: Muestra las características del celular por consola

**Enumeración:**
- `EstadoLlamada`: enum con estados `ACTIVA` e `INACTIVA` para el ciclo de llamada.

**Modificadores de acceso adicionales:**
- Método `protected`: `getCostoLlamadaProtegido()` y `estaEnLlamadaProtegido()`
- Método `default` (package-private): `getResumenTecnico()`

### 2. CelularPremium.java (Paquete: org.curso.externo)
Subclase de `Celular` en otro paquete que demuestra:
- Acceso válido a miembros `protected` mediante herencia.
- Imposibilidad de acceder a miembros `default` fuera del paquete de origen (documentado con error esperado).

### 3. TestCelular.java (Paquete: org.curso.test)
Clase de prueba que demuestra:

1. **Constructores y miembros estáticos**: Muestra cómo el contador de instancias se incrementa con cada nueva instancia
2. **Getters/Setters con validaciones**: Prueba las validaciones de los setters
3. **Métodos de comportamiento**: Ejecuta llamadas y muestra el comportamiento
4. **Igualación de referencias**: Demuestra cómo múltiples referencias pueden apuntar al mismo objeto en el Heap
5. **Operador instanceof + casting**: Verifica tipos y aplica cast seguro sobre referencia `Object`
6. **Modificadores de acceso**: Demuestra `public`, documenta errores esperados de `private/protected/default`
7. **Enumeraciones (enum)**: Muestra cambios de estado de llamada (`INACTIVA`/`ACTIVA`)

## Compilación y Ejecución

### Compilar
```bash
javac org/curso/modelo/*.java org/curso/externo/*.java org/curso/test/*.java
```

### Ejecutar
```bash
java org.curso.test.TestCelular
```

## Conceptos Demostrados

### Encapsulamiento Estricto
- Todos los atributos son `private`
- Acceso solo a través de getters/setters públicos
- Validaciones en los setters para mantener la integridad del estado

### Modificadores de Acceso
- **public**: Constructores, getters, setters y métodos de comportamiento son accesibles desde cualquier paquete
- **private**: Atributos solo accesibles dentro de la clase
- **protected**: Accesible desde subclases en otros paquetes (demostrado en `CelularPremium`)
- **default**: Accesible solo dentro del mismo paquete (error esperado fuera de `org.curso.modelo`)

### Enumeraciones (enum)
- `EstadoLlamada` representa estados válidos de llamada
- Evita uso de Strings "mágicos" para estado interno
- Se observa en consola el cambio `INACTIVA -> ACTIVA -> INACTIVA`

### Miembros Estáticos (static)
- La variable `contadorInstancias` es compartida por todas las instancias
- Se accede a través del nombre de la clase: `Celular.getContadorInstancias()`
- Se incrementa en cada llamada al constructor

### Referencias en Memoria
- Múltiples variables pueden referenciar al mismo objeto
- La igualación de referencias (`==`) compara direcciones de memoria, no contenido
- Modificar el objeto a través de una referencia afecta a todas las referencias

### Operador instanceof
- Permite verificar si un objeto es instancia de una clase específica
- Se usa junto al casting explícito: `if (obj instanceof Celular) { Celular c = (Celular) obj; }`

## Criterios de Evaluación Cumplidos

✓ Aplicación consistente de modificadores private y accesores public validados
✓ Manejo correcto de construcciones sobrecargadas y autoreferencia 'this'
✓ Integridad sintáctica y aplicación estricta de normas Naming Conventions (CamelCase)
✓ Organización en paquetes lógicos (org.curso.modelo y org.curso.test)
✓ Demostración práctica de niveles de acceso
✓ Implementación de miembros estáticos y demostración de su comportamiento
