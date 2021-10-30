import tkinter as tk
from tkinter.filedialog import askopenfilename, asksaveasfilename
import brute_cesar_tk as b1
import caesar_cyper_tk as b2
import XOR_decode as b3
import XOR_encode as b4
from tkinter import simpledialog

def decode_cesar():
    filepath = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not filepath:
        return
    temp=b1.caesar_brute_force(filepath)
    txt_show.delete("1.0", tk.END)
    txt_show.insert(tk.END, temp)
    
def encode_cesar():
    txt_show.insert(tk.END, "inserte archivo de entrada, archivo de salida y offset")
    filepath = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not filepath:
        return
    
    output = asksaveasfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not output:
        return
    offset = simpledialog.askinteger("Input", "set the offset",
                                 parent=window,
                                 minvalue=0, maxvalue=100)
    b2.caesar_cypher(filepath,output,offset)
    txt_show.delete("1.0", tk.END)
    with open(output, "r") as input_file:
        text = input_file.read()
    txt_show.insert(tk.END, text)
    
def decode_xor():
    txt_show.insert(tk.END, "inserta archivo a cifrar y archivo con clave (0 y 1)")
    filepath = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not filepath:
        return
    key = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not key:
        return
    
    b3.decode(filepath,key)
    txt_show.delete("1.0", tk.END)
    txt_show.insert(tk.END, temp)
    
def encode_xor():
    txt_show.insert(tk.END, "inserta archivo a descifrar y archivo con clave (0 y 1)")
    filepath = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not filepath:
        return
    key = askopenfilename(
        defaultextension="txt",
        filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")],
    )
    if not key:
        return
    
    b4.encode(filepath,key)
    txt_show.delete("1.0", tk.END)
    txt_show.insert(tk.END, temp)
    
#cyper : hide file, "unhide" file, xor cypher and decypher, zip bomb maker
window = tk.Tk()
window.title("core_test_03")
window.rowconfigure(0, minsize=800, weight=1)
window.columnconfigure(1, minsize=800, weight=1)

txt_show = tk.Text(window)
fr_buttons = tk.Frame(window, relief=tk.RAISED, bd=2)
btn_cesar_brut = tk.Button(fr_buttons, text="Decode cesar brute", command=decode_cesar)
btn_enco_cesar = tk.Button(fr_buttons, text="Encode cesar", command=encode_cesar)
btn_xor_enco = tk.Button(fr_buttons, text="Encode xor", command=encode_xor)
btn_xor_desco = tk.Button(fr_buttons, text="Decode xor", command=decode_xor)

btn_cesar_brut.grid(row=0, column=0, sticky="ew", padx=5)
btn_enco_cesar.grid(row=1, column=0, sticky="ew", padx=5)
btn_xor_enco.grid(row=2, column=0, sticky="ew", padx=5)
btn_xor_desco.grid(row=3, column=0, sticky="ew", padx=5)

fr_buttons.grid(row=0, column=0, sticky="ns")
txt_show.grid(row=0, column=1, sticky="nsew")

window.mainloop()
