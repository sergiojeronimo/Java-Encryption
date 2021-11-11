public class XORDescifrado {
    public String procesoDescifrado(String mensaje, int clave){
        String mensajeDescifrado, mensajeEnBinario;
        mensajeEnBinario = descifradoXOR(mensaje, clave);
        mensajeDescifrado = binarioAtexto(mensajeEnBinario);
        return mensajeDescifrado;
    }
    private String binarioAtexto(String mensaje){
        String mensajeFinal = "";
        String[] mensajePartes = mensaje.split("\s");
        for(int i=0; i<mensajePartes.length; i++){
            int charCode = Integer.parseInt(mensajePartes[i], 2);
            String str = Character.toString((char) charCode);
            mensajeFinal += str;
        }
        return mensajeFinal;
    }

    private String descifradoXOR(String mensaje, int clave){
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
}
