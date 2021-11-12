# Java Encryption - XOR and CESAR

## _Introducción_

Este proyecto consiste en un programa diseñado en JAVA para el cifrado y descifrado de mensajes.
Actualemte se puede cifrar y descifrar mensajes con XOR y CESAR.

## _Clases del proyecto_

Dentro del proyecto tenemos distintas clases. Explicaremos aquellas que permiten el cifrado y descifrado de mensajes.
>_Cifrado XOR_

En esta clase del proyecto hemos empleado 3 funciones, una pública y dos privadas.
- _procesoCifrado_: esta clase nos sirve de control, para introducir los datos a cifrar y la clave y llamar a las otras funciones y realizar el cifrado.
```
public String procesoCifrado(String mensaje, int clave){
        String mensajeCifrado, mensajeEnBinario;
        mensajeEnBinario = textoABinario(mensaje);
        mensajeCifrado = cifradoXOR(mensajeEnBinario, clave);
        return mensajeCifrado;
    }
```
- _textoABinario_: Con esta clase transformamos el texto introducido a binario. Para ello hacemos uso del bucle *for*, en el cual comprobamos la longitud del mensaje con la función *lenght()*. En el bucle, cojemos de la cadena de caracteres el caracter *i* y mediante la clase Integer, usamos la función *toBinaryString* para pasarlo a binario (esto se hace gracias al código ASCII).
```
private String textoABinario(String mensaje){
        String textoEnBinario = "";
        for(int i=0; i<mensaje.length(); i++){
            char caracterI = mensaje.charAt(i);
            String binario = Integer.toBinaryString(caracterI);
            if(binario.length() != 8){
                for(int j=0; binario.length()<8; j++){
                    binario = "0" + binario;
                }
            }
            textoEnBinario += binario + " ";
        }
        return textoEnBinario;
    }
```

>_Descifrado XOR_
