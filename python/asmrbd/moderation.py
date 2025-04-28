from db import db

db = db()
db.create()

while True:
    i = input()
    if(not "https" in i):
        db.query("insert into asmr (url) values ('{0}');".format("https://www.youtube.com/embed/"+i.split("v=")[1]))