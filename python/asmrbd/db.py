import psycopg2

def postgres_connect():

    return psycopg2.connect(
        dbname="spirit_control_db",
        user="postgres",
        password="147896313",
        host="localhost",
        port="5432"
    )

class db:

    def __init__(self, selectDatabase="postgres"):

        self.connection = postgres_connect()
        self.cursor = self.connection.cursor()

    def query(self, query):

        self.cursor.execute(query)
        self.connection.commit()

    def create(self):self.query("CREATE TABLE IF NOT EXISTS public.asmr(id serial NOT NULL, url character varying(255) NOT NULL, PRIMARY KEY (id));")

