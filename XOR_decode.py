def encode(mensaje, llave):
    arr =bytes(open(mensaje,"r").read(),'utf-8')
    key=open(llave,"r").read().replace('\n', '')
    key_part=0
    output=[]
    encoded=""
    for byte in arr:
        byte=bin(byte)[2:]
        byte=str(byte.zfill(8))
        temp_output=[0,0,0,0,0,0,0,0]
        for x in range(8):
            if (byte[x]!=key[x%len(key)+key_part*8]):
                temp_output[x]=1;
            else:
                temp_output[x]=0;
        output.append(temp_output)
        key_part+=1
        if ((8*key_part)>=len(key)):
            key_part=0

    for x in range(len(output)):
        temp=""
        for y in range(len(output[x])):
            temp+=str(output[x][y])
        encoded+=chr(int(temp,2))

    encoded=encoded.replace("Ã","")
    encoded=encoded.replace("Â","")
    encoded=encoded.replace("á","")
    encoded=encoded.replace("â","")
    encoded=encoded.replace("ÀÜ","“")
    encoded=encoded.replace("ÀÝ","”")
    print(encoded)
    open("decoded.txt","w+").write(encoded)
