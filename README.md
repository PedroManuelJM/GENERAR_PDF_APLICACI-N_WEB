# GENERAR_PDF_APLICACION_WEB
En este ejemplo se muestra de 2 maneras como se genera el PDF , una usando la librería  ITEXTPDF  y otra que tiene HTML la función PRINT. Los datos que se utilizarán viene de una base de datos MySQL. 

```diff
! LIBRERIAS USADAS:
```

:ballot_box_with_check: Conector MySQL

:ballot_box_with_check: itextpdf-5.5.9.jar

##### Se muestra la página principal "index.jsp" donde hay 2 opciones : La primera opción se genera el PDF gracias a la librería itextpdf y la segunda opción ,el mismo HTML tiene una función PRINT la cual te generá el PDF.
![principal](https://user-images.githubusercontent.com/71619972/103463824-4f8cda80-4cfd-11eb-8ece-02cb8be4ef52.PNG)
#### IMAGEN 1 - GENERAR PDF - LIBRERIA ITEXTPDF
![generar_pdf](https://user-images.githubusercontent.com/71619972/103463825-5b789c80-4cfd-11eb-9e32-b193260f9949.PNG)
#### IMAGEN 2 - GENERAR PDF - FUNCIÓN HTML PRINT 
![print](https://user-images.githubusercontent.com/71619972/103463828-5fa4ba00-4cfd-11eb-90e9-b043bf898e6e.PNG)

:memo: Conocimientos:

:ballot_box_with_check: JAVA

:ballot_box_with_check: MySQL

:ballot_box_with_check:HTML y CSS

** SCRIPT BASE DE DATOS **

create database bd_usuarios;

use bd_usuarios;

create table usuario(

idusuario INT NOT NULL auto_increment primary key,

nombres VARCHAR(32) NOT NULL,

apellidos VARCHAR(32) NOT NULL,

correo varchar(32) NOT NULL

);

:blush: Compartiendo con la comunidad .


