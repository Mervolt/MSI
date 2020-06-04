import random

first_file_object = open("wodeckiapi.txt", "r", encoding="utf-8")
second_file_object = open("dżemapi.txt", "r", encoding="utf-8")
first_file_content = first_file_object.readlines()
second_file_content = second_file_object.readlines()

target = open("data.txt", "w+", encoding="utf-8")

iterator = 0

final_file = []

result = first_file_content + second_file_content

random.shuffle(result)

print(result)

for line in result:
    target.write(line)
