# ChatClientServer

Para hacerlo funcionar : una vez clonado el proyecto, abrir 2 consolas y ubicar cada consola en cada uno de los jar de la aplicacion(el jar del servidor se encuentra en resources/server-jar y el del cliente en resources/client-jar), luego escribir el comando "java -jar Server.jar" y "java -jar Client.jar" respectivamente para el servidor y el cliente. Una vez hecho esto el servidor ya estara funcionando, y luego de introducir las credenciales(ip y puerto del servidor) en la consola del cliente, este ya estara funcionando y podra empezar la conversacion. Cabe mencionar que puede abrir muchas consolas con clientes a la vez, y manejar con el servidor las respuestas a cada cliente.

Preguntas

¿Que es un puerto?

Un puerto es una interfaz a través de la cual se pueden enviar y recibir los diferentes tipos de datos. En este caso usamos un "puerto logico" que es una localización de la RAM de la computadora que se asocia con un puerto físico o un canal de comunicación, y que proporciona un espacio para el almacenamiento temporal de la información que se va a transferir entre la localización de memoria y el canal de comunicación.

¿Como estan formados los endpoints?

Un endpoint está conformado por un número de IP, un número de puerto y una request. Ejemplo: 192.168.0.1:3000/users/

¿Que es un socket?

Un socket es conocido como un tipo de software que actúa como un punto final que funciona estableciendo un enlace de comunicación de red bidireccional entre el extremo del servidor y el programa receptor del cliente. También se le conoce como un punto final en un canal de comunicación bidireccional.

¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque?

La comunicación mediante sockets es una interfaz entre la capa de aplicacion y la capa de transporte del modelo OSI. La filosofía de la división por capas de un sistema es encapsular, dentro de cada una de ellas, detalles que conciernen sólo a cada capa, y presentársela al usuario de tal forma que este pueda trabajar con ella sin necesidad de conocer sus detalles de implementación.

¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets?

Para un modelo cliente-servidor orientado a la conexión, el socket en el proceso del servidor espera la petición de un cliente. Para hacer esto, el servidor necesita principalmente establecer una dirección que los clientes puedan usar para encontrar y conectarse al servidor. Cuando se establece una conexión con éxito, el servidor esperará a que los clientes soliciten un servicio. El intercambio de datos cliente-servidor tendrá lugar si el cliente se conecta al servidor a través del socket. El servidor responderá a la solicitud del cliente y enviará una respuesta.
La mayoría de las veces, las URL y sus conexiones se utilizan para acceder a Internet. Los programas requerirán un simple enlace de comunicación entre el cliente del programa y el servidor. Esta función está asociada a un socket que ayuda a vincular los extremos del cliente y del servidor del programa. Si un cliente comienza a establecer comunicación con el servidor, se realizará una conexión fiable entre el servidor y el cliente a través del canal de comunicación TCP. Con este tipo de comunicación, tanto el cliente como el servidor pueden leer o escribir en sockets que están conectados a un canal de comunicación específico.

¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle?

⦁	El servidor no se encuentra habilitado y por esto el cliente no puede conectarse al mismo.
⦁	El puerto de recepción del servidor está bloqueado o cerrado.
⦁	El cliente intenta utilizar un endpoint que se encuentra ya en uso por otro.
⦁	El servidor intenta enviar datos a un cliente que ya se ha desconectado.
⦁	El cliente utiliza una dirección de host y/o un puerto inválido para conectarse al servidor.

Diferencias entre sockets UDP y TCP

⦁ TCP está orientado a la conexión, mientras que UDP es un protocolo sin conexión.
⦁ TCP es altamente confiable para transferir datos útiles ya que toma el acuse de recibo de la información enviada. Y vuelve a enviar los paquetes perdidos si los hay. Mientras que en el caso de UDP, si el paquete se pierde, no solicitará su retransmisión y el ordenador de destino recibirá un dato corrupto. Por lo tanto, UDP es un protocolo poco fiable.
⦁ TCP es más lento en comparación con UDP, ya que TCP establece la conexión antes de transmitir los datos y garantiza la entrega adecuada de los paquetes. Por otro lado, UDP no reconoce si los datos transmitidos son recibidos o no.
⦁ El tamaño de cabecera de UDP es de 8 bytes, y el de TCP es más del doble. El tamaño de la cabecera TCP es de 20 bytes desde entonces, y la cabecera TCP contiene opciones, relleno, suma de comprobación, banderas, desplazamiento de datos, número de confirmación, número de secuencia, puertos de origen y destino, etc.
⦁ Tanto TCP como UDP pueden comprobar si hay errores, pero sólo TCP puede corregir el error ya que tiene control de congestión y de flujo.

Diferencia entre sync & async sockets?

Las diferencias es que uno es un proceso bloqueante y el otro no. La asincronía es esencial para las actividades que son potencialmente bloqueantes, por ejemplo cuando su aplicación accede a la web. El acceso a un recurso web a veces es lento o con retrasos. Si esta actividad está bloqueada dentro de un proceso sincrónico, la aplicación completa debe esperar. En cambio con un proceso asíncrono, la aplicación puede continuar con otro trabajo que no depende del recurso web hasta que la tarea potencialmente bloqueante o síncrona finaliza.




