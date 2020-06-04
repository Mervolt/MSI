file_object = open("wodecki.txt", "r", encoding="utf-8")
content = file_object.readlines()

target = open("wodeckiapi.txt", "w+", encoding="utf-8")

for x in content:
    x = x.strip()
    if x:
        length = len(x)
        last_char = x[length-1]
        if last_char not in ";":
            x = x + ";"
        x = x + "wodecki"
        x = x + "\n"
        target.write(x)



#print(content)