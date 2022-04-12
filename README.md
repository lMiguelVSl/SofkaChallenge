# SofkaChallenge

Challenge Sofka 

Concurso de preguntas y respuestas

Programa de modelado de un concurso de preguntas y respuestas.

1. Precondiciones: Debe de tener 25 preguntas (5 preguntas por categorías) para 5
rondas, cada categoría tiene una complejidad o nivel de dificultad, cada ronda debe
asignarle un premio que el jugador va a ganar, el premio puede ser puntos o dinero.

2. El jugador inicia con la primera ronda, el sistema busca la categoría del primer nivel y
escoge una pregunta de esa categoría.

3. El Jugador selecciona una opción de las 4 opciones que tiene, si pierde se finaliza el
juego si gana continua a la siguiente ronda.

4. La siguiente ronda selecciona una pregunta de un grado de complejidad mayor según
la categoría. Hace el mismo comportamiento del ítem 4.

5. Si llega a la ronda 5 y pasa, entonces gana el juego, el premio mayor debería estar en
la última ronda.

Funcionalidades
● Configurar Juego: Crear las preguntas y respuestas (con 3 opciones erradas y 1
valida) con sus categorías correspondientes (mínimo 25 preguntas).

● Iniciar el juego: se debe iniciar el juego con la primera ronda y de forma aleatoria debe
seleccionar una pregunta según la categoría más baja.

● Responder a la pregunta: debes seleccionar una opción de 4 posibles.

● Aumentar de nivel: al responder de forma correcta deberás aumentar de nivel y de esa
manera otorgar premios según la ronda que este. Ordena primero tus categorías y de
esa manera sabrás en qué ronda estás ubicado.

● Acomular premio: cada vez que ganes debes tener un premio total que tienes como
jugador.

● Fin del juego voluntario o ganara ronda final: se finaliza el juego porque el jugador
deci y el acomulado pasa a l jugador (guarda los datos del jugador)

● Fin del juego forzado: el sistema finaliza el juego porque no selecciono una pregunta
correcta. (guarda los datos del jugador)

● Persistencia de datos: al finalizar el juego se debe guardar los datos del jugador como
histórico del juego.

