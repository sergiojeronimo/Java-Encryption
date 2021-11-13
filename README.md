# Encriptación en Java - XOR y CESAR

## _Introducción_

Este proyecto consiste en un programa diseñado en JAVA para el cifrado y descifrado de mensajes.
Actualemte se puede cifrar y descifrar mensajes con XOR y CESAR.

## _Clases del proyecto_

Dentro del proyecto tenemos distintas clases. Explicaremos aquellas que permiten el cifrado y descifrado de mensajes.
>_Cifrado XOR_

En esta clase del proyecto hemos empleado 3 funciones, una pública y dos privadas:
- _procesoCifrado_: Esta clase nos sirve de control, para introducir los datos a cifrar y la clave y llamar a las otras funciones y realizar el cifrado.
Una vez que se obtiene el mensaje cifrado final, se le manda a la clase XORCifrado para que lo muetre en un *textField*.
```
public String procesoCifrado(String mensaje, int clave){
        String mensajeCifrado, mensajeEnBinario;
        mensajeEnBinario = textoABinario(mensaje);
        mensajeCifrado = cifradoXOR(mensajeEnBinario, clave);
        return mensajeCifrado;
    }
```
- _textoABinario_: Con esta clase transformamos el texto introducido a binario. Para ello hacemos uso del bucle *for*, en el cual comprobamos la longitud del mensaje con la función *lenght()*. 
En el bucle, cojemos de la cadena de caracteres el caracter *i* y mediante la clase Integer, usamos la función *toBinaryString* para pasarlo a binario (esto se hace gracias al código ASCII). 
Al termiar cambiar cada caracter de la cadena a un número binario introducimos un espacio para separar cada letra y después comprobamos que la cadena de binario sea de longitud 8. Si no lo es, añadimos un 8 al principio de la cadena. 
Esto lo hacemos porque a la hora de pasar caracteres a binario, obtenemos un número de este estilo; *01001101*, al que para hacerlo más corto le quitamos el cero de delante; *1001101*. 
De esta forma nos aseguramos de que se mantenga el cero para luego no tener problemas con la clave de cifrado.
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
- _cifradoXOR_: Esta es la última clase del cifrado, con la que usamos la clave para codificar el mensaje en binario.
Lo primero que hacemos es pasar el entero *clave* a una cadena _String_.
Después para su mejor manejo, creamos una array de caracteres con la cadena de la clave usando la función *toCharArray()*.
Declaramos una variable para poder guardar el mensaje cifrado y así poder mandarlo a la función _procesoCifrado_.
En el siguiente paso, separamos el mensaje por palabras con la función *split("\s")* (siendo \s el caracter que hará que se separe la cadena de caracteres).
Creamos una variable de tipo entero para la longitud del mensaje y con esa longitu, creamos una array de cadena de caracteres del mensaje cifrado.
Ahora nos toca comparar los dígitos de la clave con los del mensaje. Lo que hacemos es coger cada palabra y serpararla por caracteres para meterlos en una array de caracteres.
Una vez echo esto, comparamos cada cifra con la de la clave mediante la funcion lógica XOR; consiste en si las cifras son iguales, su salida será 0 y si son distintas su salida será 1.
Una vez cifrada la palbra, la introducimos en en la cadena *mensajeFinal*, separando cada palabra con un espacio. Realiamos esto con cada palabra del mensaje y mandamos el mensaje final cuando se termine de cifrar.
```
private String cifradoXOR(String mensaje, int clave){
        String claveS = String.valueOf(clave);
        char[] digitosClave = claveS.toCharArray();
        String mensajeFinal = "";
        String[] mensajePartes = mensaje.split("\s");
        int longitud = mensajePartes.length;
        String[] mensajeCifrado = new String[longitud];
        for(int j=0; j<longitud; j++){
            String[] letraCifrada = new String[8];
            char[] letraBinaria = mensajePartes[j].toCharArray();
            for (int i=0; i<8; i++){
                if(digitosClave[i]==letraBinaria[i]){
                    letraCifrada[i]="0";
                }else if(digitosClave[i]!=letraBinaria[i]){
                    letraCifrada[i]="1";
                }
            }
            String palabraCifrada = letraCifrada[0]+letraCifrada[1]+letraCifrada[2]+letraCifrada[3]+letraCifrada[4]+letraCifrada[5]+letraCifrada[6]+letraCifrada[7];
            mensajeCifrado[j]= palabraCifrada;
        }
        for (int k=0; k<longitud; k++){
            mensajeFinal += mensajeCifrado[k] + " ";
        }
        return mensajeFinal;
    }
```
>_Descifrado XOR_
