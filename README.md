\# Examen Final - Automatización de Pruebas



\## Descripción del Proyecto



Este proyecto implementa una solución completa de automatización de pruebas 

utilizando \*\*Maven\*\*, \*\*JUnit 5\*\* y \*\*Selenium\*\*, junto con pipelines de 

\*\*Integración Continua\*\* y \*\*Despliegue Continuo\*\* con 

\*\*GitHub Actions\*\*.



El objetivo es demostrar la aplicación de buenas prácticas de testing, 

versionado y automatización en un flujo de trabajo profesional.



\## Estrategia de pruebas implementada



Se implementaron \*\*dos tipos de pruebas\*\* para cubrir diferentes niveles 

del sistema:



\### 1. Pruebas Unitarias (JUnit 5)



\- \*\*Herramienta:\*\* JUnit 5 (`junit-jupiter-api` y `junit-jupiter-engine` versión 5.9.2).

\- \*\*Clase bajo prueba:\*\* `Calculadora.java`

\- \*\*Pruebas implementadas:\*\*

&#x20; - `testSumar()` - Verifica que 2 + 3 = 5.

&#x20; - `testRestar()` - Verifica que 5 - 3 = 2.

&#x20; - `testMultiplicar()` - Verifica que 4 \* 3 = 12.

&#x20; - `testDividir()` - Verifica que 10 / 2 = 5.

&#x20; - `testDividirPorCero()` - Verifica que dividir por cero lance `ArithmeticException`.

\- \*\*Justificación:\*\* JUnit 5 es el estándar actual para pruebas unitarias en Java. 

&#x20; Permite usar anotaciones como `@Test` y `@DisplayName`, y ofrece aserciones 

&#x20; claras (`assertEquals`, `assertThrows`).



\### 2. Pruebas de Integración (Selenium WebDriver)



\- \*\*Herramienta:\*\* Selenium WebDriver.

\- \*\*Prueba implementada:\*\*

&#x20; - `testTituloGoogle()` - Abre Chrome en modo headless, navega a Google 

&#x20;   y verifica que el título contenga "Google".

\- \*\*Justificación:\*\* Selenium permite automatizar navegadores reales. 

&#x20; Se configuró Chrome en \*\*modo headless\*\* para que pudiera ejecutarse en el 

&#x20; pipeline de CI sin necesidad de interfaz gráfica.





\## Flujo de Ramas (GitFlow)



Se implementó el flujo \*\*GitFlow\*\* con las siguientes ramas:



`main` Código estable, listo para producción. 

`develop` Integración de features antes de pasar a `main`. 

`feature/pruebas-unitarias` Desarrollo de las pruebas unitarias y de integración. 



\*\*Justificación:\*\* Se eligió GitFlow en vez de Trunk-Based porque permite 

trabajar en ramas aisladas, integrar cambios de forma controlada y mantener 

una rama estable para producción.





\## Pipelines de CI/CD



\### CI Pipeline (`ci-pipeline.yml`)



Se ejecuta en cada push a `main` y `develop`. Contiene los siguientes stages:



1\. \*\*Checkout del código\*\* - Descarga el código del repositorio.

2\. \*\*Configurar JDK 11\*\* - Instala Java 11 con distribución Temurin.

3\. \*\*Compilar el proyecto\*\* - Ejecuta `mvn clean compile`.

4\. \*\*Ejecutar pruebas unitarias\*\* - Ejecuta `CalculadoraTest` con JUnit 5.

5\. \*\*Ejecutar pruebas de integración\*\* - Ejecuta `SeleniumIntegrationTest`.



\### Deployment Pipeline (`deploy-pipeline.yml`)



Se ejecuta en cada push a `main`. Contiene los siguientes stages:



1\. \*\*Checkout del código\*\* - Descarga el código.

2\. \*\*Configurar JDK 11\*\* - Instala Java 11.

3\. \*\*Dar permisos de ejecución\*\* - Ejecuta `chmod +x deploy/deploy.sh`.

4\. \*\*Ejecutar Deployment Pipeline\*\* - Ejecuta `deploy.sh` que realiza:

&#x20;  - \*\*Build:\*\* Compila el proyecto con Maven.

&#x20;  - \*\*Despliegue:\*\* Copia el JAR al ambiente de pruebas (`/tmp/ambiente-pruebas`).

&#x20;  - \*\*Acceptance Tests:\*\* Verifica que el JAR esté desplegado correctamente.

&#x20;  - \*\*Rollback:\*\* Restaura el ambiente anterior si los tests fallan.

5\. \*\*Simular Rollback (si falla)\*\* - Se activa únicamente si el despliegue falla.



\---



\## Cómo se deben ejecutar las pruebas



```bash

mvn clean test

```



\### Ejecutar solo las pruebas unitarias



```bash

mvn test -Dtest=CalculadoraTest

```



\### Ejecutar solo la prueba de integración



```bash

mvn test -Dtest=SeleniumIntegrationTest

```



\### Ejecutar el script de despliegue localmente (requiere Bash)



```bash

chmod +x deploy/deploy.sh

./deploy/deploy.sh

```



\---



\## Evidencias



\### Capturas de ejecución exitosa



\- \*\*CI Pipeline:\*\* Ejecución exitosa en GitHub Actions (build + pruebas).

\- \*\*Deployment Pipeline:\*\* Ejecución exitosa con acceptance tests.

\- \*\*Rollback:\*\* Evidencia del fallo simulado y restauración automática.



\*(Las capturas las podemos encontrar en orden en el documento Word)\*

\---



\## Enlaces



\- \*\*Repositorio GitHub:\*\* https://github.com/irozas21/Automatizacion\_De\_Pruebas

\- \*\*Pipeline CI:\*\* https://github.com/irozas21/Automatizacion\_De\_Pruebas/actions

\- \*\*Pipeline Deployment:\*\* https://github.com/irozas21/Automatizacion\_De\_Pruebas/actions



\---



\## Conclusión



En el proyecto demostramos la implementación de un flujo completo de 

automatización de pruebas con CI/CD, aplicando buenas prácticas de 

versionado, testing y despliegue. La combinación de JUnit 5, Selenium 

y GitHub Actions permite detectar errores tempranamente y garantizar 

la estabilidad del sistema.

