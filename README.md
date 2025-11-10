# 🚗 Proyecto Semaphore: Simulación de Aparcamiento con Hilos en Java

Este proyecto es una **simulación de un aparcamiento** que utiliza **concurrencia en Java** 🧵 para controlar cuántos coches pueden entrar y salir de un parking con plazas limitadas.  
Se implementa usando **`Semaphore`** y **`CountDownLatch`** para gestionar el acceso de múltiples hilos de forma sincronizada.

---

## 🧠 ¿Qué hace el programa?
Simula la entrada y salida de varios coches 🚙 en un aparcamiento con **capacidad limitada**.  
Solo pueden entrar un número determinado de coches al mismo tiempo, y los demás deben **esperar hasta que haya sitio libre**.

---

## ⚙️ Tecnologías utilizadas
- ☕ **Java 17+**
- 🔒 **java.util.concurrent.Semaphore**
- ⏱️ **java.util.concurrent.CountDownLatch**
- 🎯 **Programación concurrente (multithreading)**

---

## 🧩 Estructura del proyecto

```
📦 src
 ┣ 📂 java
 ┃ ┣ 📂 Model
 ┃ ┃ ┣ 📜 Aparcamiento.java
 ┃ ┃ ┗ 📜 Coche.java
 ┃ ┗ 📂 View
 ┃ ┃ ┗ 📜 PrincipalParking.java
```

---

## 🧱 Clases principales

### 🚦 `Aparcamiento`
Gestiona las plazas disponibles del parking.  
- Controla cuántos coches pueden entrar al mismo tiempo usando un `Semaphore`.
- Utiliza `CountDownLatch` para coordinar las primeras entradas.
- Métodos principales:
  - `entrar(String nombreCoche)` → intenta acceder al parking.
  - `salir(String nombreCoche)` → libera una plaza al salir.

### 🚗 `Coche`
Representa cada coche como un **hilo independiente**.  
- Intenta entrar al aparcamiento.  
- Espera un tiempo aleatorio mientras “está aparcado”.  
- Luego sale y libera su plaza.

### 🖥️ `PrincipalParking`
Clase principal que **inicia la simulación**.  
- Crea un aparcamiento con 3 plazas.  
- Lanza 7 coches como hilos.  
- Controla el orden de entrada con pausas entre lanzamientos.

---

## 💡 Ejemplo de salida
```
Coche - 1 ha entrado. Plazas ocupadas: 1
Coche - 2 ha entrado. Plazas ocupadas: 2
Coche - 3 ha entrado. Plazas ocupadas: 3
Coche - 4 está esperando...
Coche - 1 ha salido. Plazas ocupadas: 2
Coche - 4 ha entrado. Plazas ocupadas: 3
...
```

---

## 🚀 Cómo clonar y ejecutar el proyecto

```bash
# Clonar el repositorio
git clone https://github.com/Ivannovichh/Semaphore.git

# Entrar al directorio del proyecto
cd Semaphore

# Compilar los archivos Java
javac src/java/Model/*.java src/java/View/*.java -d bin

# Ejecutar la clase principal
java -cp bin View.PrincipalParking
```

---

## 🧩 Conceptos aprendidos
✅ Control de concurrencia con **Semaphore**  
✅ Sincronización de hilos con **CountDownLatch**  
✅ Creación y manejo de **múltiples hilos en Java**  
✅ Buenas prácticas de sincronización con `synchronized`

---

## 🧑‍💻 Autor
**Iván Sánchez Juárez**  
📚 Proyecto educativo sobre sincronización de hilos en Java.
