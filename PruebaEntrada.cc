<!-- Mi primer captcha 
en el curso de Organización de Lenguajes y Compiladores 1 
-->
<c_cc [id="captcha_asdf_1" ] [name="Captcha Matemático 1" ]> !! El encabezado de
    la página que tendrá mi captcha
    <c_head>
        <c_link !! El link al que redirige mi captcha
            [href=“https://www.mclibre.org/consultar/htmlcss/html/html-etiquetas.html”]>
        </c_link>
        !! El título de mi página
        <c_title> Mi primer Captcha Matemático</c_title>
    </c_head>
    !! El cuerpo de la página
    <c_body [background="#e5e6ea" ]>
        !! un título simple estilizado
        <c_h1 [id="title_1" ] [text-align="center" ] [color="#7eff33" ]> Mi
            primer Captcha Matemático
        </c_h1>
        !! Un salto normal
        <c_br>
            !! Información de la operación a resolver en el captcha
            <c_spam [id="mostrar_1" ] [text-align="center" ] [color="#3366ff" ]>
                ¿ Qué resultado genera la operación
                siguiente: 5+5 ?
            </c_spam>

            !! Input para la Respuesta del usuario generado con un scripting
            <c_input [type="text" ] [text-align="center" ] [id="entrada_1"
                ]></c_input>
            <c_scripting>
                ON_LOAD () [
                !!Estas instrucciones se ejecutan media vez se entra al scripting 
                !! Insertamos el input con sus parámetros con la instrucción INSERT
                ]
            </c_scripting>
            !! Boton que llama a la funcionalidad calc
            <c_button [id="boton_1" ] [onclick="FUNCTION_calc()" ]
                [background="green" ]> Procesar...
            </c_button>
            !! Scripting para la función calc
            <c_scripting>
                FUNCTION_calc() [
                !! Estas instrucciones no se ejecutan hasta llamar a FUNCTION_calc()
                integer @global contador_fallas = 5;
                string result_caja_texto = getElemenById('entrada_1');
                string result = "10";
                string mensaje_fallo =
                "El captcha no fue validado intente otra vez";
                string mensaje_acierto = "El captcha fue validado";
                string mensaje_final =
                "El captcha no logró ser validado :( intente mas tarde";
                !! Validacion del numero de oportunidades restantes
                IF (contador_fallas == 0) THEN
                INIT {:
                ALERT_INFO(mensaje_final);
                EXIT();
                :} END
                !! Validación de fallas y aciertos
                IF (result_caja_texto == result ) THEN
                !!si el resultado es correcto
                INIT {:
                ALERT_INFO(mensaje_acierto);
                REDIRECT(); !!puede usarALERT_INFO(mensaje_acierto);se también EXIT() para redirigir
                :} END
                ELSE
                !!si el intento es incorrecto
                INIT {:
                ALERT_INFO(mensaje_fallo);
                contador_fallas = contador_fallas - 1;
                :} END
                ]
            </c_scripting>
    </c_body>
</c_cc>
