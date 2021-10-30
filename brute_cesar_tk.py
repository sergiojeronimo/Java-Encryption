import string
def caesar_brute_force(file_path):
    output=[]
    file=open(file_path, "r").readlines()
    charset=list(string.ascii_lowercase)
    for z in range(len(charset)):
        for x in range(len(file)):
            file[x]=file[x].rstrip("\n")
            for y in range(len(file[x])):
                if (file[x][y]==' '):
                    output.append("_")
                else:
                    temp=charset.index(file[x][y])
                    temp+=z;
                    if (temp>=len(charset)):
                        temp-=len(charset);
                    output.append(charset[temp]) 
            output.append("\n");
    return(output)
