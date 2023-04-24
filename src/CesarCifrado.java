import java.awt.*;
public class CesarCifrado {
    public String cifradoCesar(String mensaje, int clave){
        String mensajeCifrado = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] mensajePartes = mensaje.toCharArray();
        for (int i=0; i<mensajePartes.length; i++){
            if(mensajePartes[i]==' '){
                mensajeCifrado += ' ';
            }else{
                for(int j=0; j<alphabet.length; j++){
                    if (alphabet[j]==mensajePartes[i]){
                        if(clave+j > alphabet.length-1){
                            int avanza = (clave+j) - (alphabet.length-1);
                            mensajeCifrado += alphabet[avanza-1];
                        }else{
                            mensajeCifrado += alphabet[j+clave];
                        }
                    }
                }
            }
        }
        return mensajeCifrado;
    }
}
