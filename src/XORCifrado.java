public class XORCifrado {
    public String procesoCifrado(String mensaje, int clave){
        String mensajeCifrado, mensajeEnBinario;
        mensajeEnBinario = textoABinario(mensaje);
        mensajeCifrado = cifradoXOR(mensajeEnBinario, clave);
        return mensajeCifrado;
    }

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
}
