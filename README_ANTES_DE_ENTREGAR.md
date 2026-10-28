# Taller 3 — SumadoraUAE

**Universidad Agraria del Ecuador**  
**Carrera:** Ciencias de la Computación — Sexto semestre  
**Asignatura:** Lenguaje de Programación 5  
**Docente:** Ing. Bryan Vélez MSc.  
**Estudiante:** Jorge Luis Sanaguaray Gusqui  

## Contenido entregado

El ZIP contiene el proyecto Android `SumadoraUAE`, con los siguientes archivos principales comentados: 

- `app/src/main/java/ec/edu/agraria/sumadorauae/MainActivity.java`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/values/strings.xml`

También incluye `AndroidManifest.xml`, ícono, tema, colores y configuración Gradle.

## Cómo abrir en Android Studio

1. Descomprime el ZIP.
2. En **Android Studio**, selecciona **Open** y abre la carpeta `SumadoraUAE` (no la carpeta `app`).
3. Deja que termine **Gradle Sync** y que se descarguen las dependencias requeridas con conexión a Internet. Necesitas **Android SDK Platform 35**, herramientas de compilación Android y **JDK 17 o superior compatible con AGP 8.7.3**.
4. Selecciona un emulador o un equipo Android (API 24+); pulsa **Run ▶**.
5. Introduce **7** en el primer campo, **5** en el segundo y pulsa **Sumar**. Debe salir **Resultado: 12** y un Toast de confirmación.

## Captura de Logcat exigida por el PDF

1. En Android Studio abre **View > Tool Windows > Logcat**.
2. Selecciona el emulador y el proceso de `ec.edu.agraria.sumadorauae`.
3. Filtra por `tag:APP` (o busca `APP` si tu Logcat usa la interfaz clásica).
4. Pulsa nuevamente **Sumar** con 7 y 5.
5. Toma una **captura real del emulador con `Resultado: 12` y una captura real de Logcat**. Adjunta ambas si tu docente las solicita.

Las líneas clave que deberías ver en Logcat serán similares a:

```text
D/APP: sumar() inicio
D/APP: n1 = 7
D/APP: n2 = 5
D/APP: resultado = 12
```

> Estas líneas son un **ejemplo esperado**, no una captura real. El equipo donde se preparó la entrega no dispone de Android SDK ni de un emulador, así que la compilación y las capturas de ejecución deben verificarse en Android Studio.

## Pruebas recomendadas

| Campo 1 | Campo 2 | Resultado esperado |
| --- | --- | --- |
| `7` | `5` | `Resultado: 12` y Toast |
| `10` | `25` | `Resultado: 35` y Toast |
| vacío | `5` | `setError` en el primer campo |
| `7` | vacío | `setError` en el segundo campo |

**Nota:** El diseño utiliza `inputType="number"` tal como exige el taller. Por tanto, los campos están destinados a **enteros no negativos**. Se limitan a nueve dígitos por campo para que la suma de dos entradas válidas no exceda el rango de `int`.
