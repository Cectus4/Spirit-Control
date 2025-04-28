from db import db

db = db()
db.create()

while True:
    db.query("insert into asmr (url) values ('{0}');".format(input()))