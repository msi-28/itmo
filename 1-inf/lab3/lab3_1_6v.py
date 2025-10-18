from re import *

with open('sours.txt', encoding="utf8") as file:
    text = (file.readlines())

pattern = r'(?<=id=").*?(?=")'
ans = []
for st in text:
    m = findall(pattern, st)
    ans += m
for i in ans:
    print(i)