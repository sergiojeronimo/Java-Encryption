import string
def caesar_cypher(file_path,output_path,n):
    output=open(output_path, "w")
    file=open(file_path, "r").readlines()
    charset=list(string.ascii_lowercase)
    for x in range(len(file)):
        file[x]=file[x].rstrip("\n")
        for y in range(len(file[x])):
            if (file[x][y]==' '):
                output.write(' ')
            else:
                   temp=charset.index(file[x][y])
            temp+=n;
            if (temp>=len(charset)):
                temp-=len(charset);
            output.write(charset[temp]) 
        output.write("\n")
    output.close()