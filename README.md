-----------------------Convertidor de Divisas-------------------------------------

Este proyecto es un convertidor de divisas simple programado en Java, que permite convertir el valor de varias monedas comunes en tiempo real usando una API de tasas de cambio. 
Es ideal para aquellos interesados en la programación en Java y la integración con servicios externos.

+ Descripción

El convertidor de divisas utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas y calcular el valor de una cantidad de una divisa de origen a una divisa de destino. 
La interfaz es sencilla y amigable, basada en un menú de opciones en la terminal.

+ Monedas admitidas:

        *USD - Dólar estadounidense
        *EUR - Euro
        *COP - Peso colombiano
        *MXN - Peso mexicano


+ Requisitos previos

        *Java 11 o superior instalado en el sistema.
        *Una cuenta en ExchangeRate-API para obtener una clave API válida (se proporciona una clave de ejemplo en el código, pero debe reemplazarse por una clave personal).

+ Cómo usar el Convertidor de Divisas
  
        *Descargar o clonar el repositorio: Descargue el archivo ZIP o clone el repositorio en su entorno local.

+ Configuración de la API:

        *Inicie sesión en ExchangeRate-API y obtenga una clave de API.
        *Reemplace API_KEY en el código por su propia clave API en esta línea:
                -private static final String API_KEY = "SU_CLAVE_API_AQUI";
        *Luego de tener la Key de la API cambie el dato y prosiga a concatenar y ejecutar.

+ Uso del programa:

Seleccione la divisa de origen y la divisa de destino de las opciones que se muestran en pantalla.
Ingrese la cantidad que desea convertir.
El programa mostrará el valor convertido según la tasa de cambio actual.

+ Ejemplo de ejecución:

       Bienvenido al Convertidor de Divisas
       
       Seleccione la divisa de origen:
       1. USD - Dólar estadounidense
       2. EUR - Euro
       3. COP - Peso colombiano
       4. MXN - Peso mexicano
       
       Seleccione una opción: 1
       
       Seleccione la divisa de destino:
       1. USD - Dólar estadounidense
       2. EUR - Euro
       3. COP - Peso colombiano
       4. MXN - Peso mexicano
          
       Seleccione una opción: 2
       
       Ingrese la cantidad a convertir: 100
       
       100.00 USD son 85.34 EUR
   
+ Apartado de Ayuda

Error en la API: Si el programa muestra un mensaje de error al conectarse a la API, verifique su conexión a internet y que su clave API esté activa.
Formato de entrada inválido: Asegúrese de ingresar solo números al introducir la cantidad de divisa para evitar errores en el programa.
No se encuentra la tasa de cambio: Esto puede ocurrir si la API no admite la conversión solicitada. Verifique si las divisas seleccionadas están habilitadas en su clave de API.
Para más información o problemas técnicos, consulte la documentación de ExchangeRate-API.

+ Autor

Este proyecto fue desarrollado por Mateo Rozo Torres como parte del curso de Java Backend de Oracle. Es un ejercicio práctico para aprender a consumir APIs en Java y manipular datos en tiempo real.
