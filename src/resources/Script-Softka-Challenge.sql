create database personas;

CREATE TABLE Jugador(
IdJugador INT IDENTITY(1,1) PRIMARY KEY,
NickName   VARCHAR(MAX) NOT NULL,
accumulateReward int
)

CREATE TABLE Game(
IdGame INT IDENTITY(1,1) PRIMARY KEY,
IdRondaActual INT NOT NULL,
accumulateReward INT,
IdJugador INT FOREIGN KEY REFERENCES Jugador(IdJugador),
)

create table Round_(
IdRound int identity(1,1) primary key,
Nombre varchar(max),
Reward int 
)

create table Question (
IdQuestion int identity(1,1) primary key,
Options_1 varchar(max),
Options_2 varchar(max),
Options_3 varchar(max),
Options_4 varchar(max),
CorrectOption int,
Question varchar(max),
RoundQuestion int
)

insert into Round_ ( Nombre ,Reward ) values 
('Level 1',10),
('Level 2',20),
('Level 3',50),
('Level 4',100),
('Level 5',200)

insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion) VALUES
('JavaScript','HTML','Python','Java',3,'Cual de los siguientes es un lenguaje de programacion compilado?',1),
('foreach','for','do-while','if-else',0,'si quiero iterar o recorrer una coleccion de objetos, que puedo usar?',1),
('VBasic','MySQL','MongoDB','MariaDB',1,'Uno de los motores de bases de datos mas conocidos es?',1),
('Programacion funcional','Programacion orientada a objetos','Programacion orientada a atributos','Programacion orientado a clases',1,'Dentro de las bases de la programacion tenemos los siguientes paradigmas',1),
('JavaScript','HTML','Python','Java',1,'Que lenguaje de etiquetas se usa en un navegador',1)

insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('JavaScript','HTML','Python','Java',0,'Que lenguajes usamos mas al lado del navegador?',2)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('JavaScript','HTML','Python','Java',2,'Que lenaguajes usamos mas del lado del servidos?',2)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Unidades de persistencias de datos','Almacenamiento de celdas','Unidades contituidas por filas y columnas','Ninguna de las anteriores',0,'Cuando hablamos de tablas en el contexto de bases de datos nos referimos a...',2)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Una estructura programada orientada a una sintaxis','Codigo fuente','Instrucciones logicas con un proposito especifico','Una funcion matematica',2,'Que es un algoritmo',2)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Orientada a objetos','Estructural','Funcional','Todas las anteriores',1,'Es un paradigma orientado a mejorar la claridad,calidad y tiempo de desarrollo de un programa de computadora recurriendo unicamente a subrutinas',2)

insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Debian','Windows','Ubuntu','Mac',0,'Los sitemas operativos que son libres y estan basados en Unix son: ',3)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('<TITLE></TITLE>','<H3></H3>','<TH></TH>','<B></B>',2,'Una etiqueta HTML que se usa para mostrar un titulo resaltado en negrilla',3)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Programacion funcional','Abstracciones por metodos','Evitar efectos secundarios','Encapsulamietno',3,'Para una clase que tena metodos get y set pero con atributos privados, que pilar de la programacion se esta aplicando',3)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Es una coleccion de datos o informacion concreta','Es un grupo de datos efimeros','Un repositorio de datos','Es un servidor que permite persistir informacion o datos concretos',3,'Que es una base de datos',3)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Todo lo relacionado con flujo de intercambios logicos','Interacciones para la gestion del flujo de trabajo','Condicionales y preguntar para tomar decisiones','Controla para la toma de decisiones de computo(if,else,switch,etcetera)',3,'Un ciclo de conrtol es...',3)

insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Un tipo determinado para crear objetos de ese mismo tipo','Ninguna de las anteriores','Son varios objetos heredados','Es una categoria del mismo tipo',0,'Una clase es...',4)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Una forma de disenar codigo para la maquina','Lo relacionado con la codificacion de paginas web y sitios interactivos','Una manera definida para escribir instrucciones claras para programar aplicaciones a alto nivel','Una manera de comunicarse con el hardware',2,'Que entendemos como lenguaje de programacion',4)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Es un metodo que tiene un efecto secundario que incrementa un valor global','Es una funcion para determinar un resultado','Determina el ganador del juego, ya sea el jugador 1 o el 2','Es un metodo dentro de un objeto de clase',0,'Que podemos decir de un metodo que tiene asignacion a una variable global de clase?',4)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Clases relacionales','Entidades de datos relacionadas','Objetos relacionados','Entidades de clases relacionados',1,'Un modelo Entidad Relacion  => MER nos refereimos a...',4)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Crear una instancia','Cambiar los estados a la interna de la clase','Usar los metodos de la clase','Extender o heredar',3,'Una clase final no permite...',4)

insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Es un metodo de acceso a los datos','Es un mecanismo para consultar informacion','Es una declaracion dentro del programa para definir un valor dinamico','Es un elemento del programa que puede cambiar',2,'Que es una variable',5)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Programacion orientada a objetos','Programacion estructurada','Programacion funcional','Programacion orientado a etiquetas',0,'Con java que paradigmas se puede trabajar?',5)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('A y B','Ninguna de las anteriores','No-Relacional','Relacional',3,'MySQL es una base de datos de tipo...',5)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('Un perfil que se dedica a los elementos visuales com la UI','Un perfil que solo se dedica a trabajar HTML+CSS','Un perfil que se orienta tanto en el Front como en el Back','Ninguna de las anteriores',0,'Cuando hablamos de un Front-end developer, nos referimos a...',5)
insert into Question (Options_1,Options_2,Options_3,Options_4,CorrectOption,Question,RoundQuestion)
values ('join, add joins, merge join','join reverse, join combination, inner join','inner, full, left, right','Ninguna de las anteriores',2,'Que combinaciones de join podemos hacer? para una base de datos relacional',5)


