public class CesarDescifrado {
    public String descifradoCesar(String mensaje, int clave){
        String mensajeCifrado = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] mensajePartes = mensaje.toCharArray();
        for (int i=0; i<mensajePartes.length; i++){
            if(mensajePartes[i]==' '){
                mensajeCifrado += ' ';
            }else{
                for(int j=0; j<alphabet.length; j++){
                    if (alphabet[j]==mensajePartes[i]){
                        if(j<clave){
                            int avanza = (clave-j);
                            mensajeCifrado += alphabet[alphabet.length-(avanza)];
                        }else{
                            mensajeCifrado += alphabet[(j)-clave];
                        }
                    }
                }
            }
        }
        return mensajeCifrado;
    }
}
