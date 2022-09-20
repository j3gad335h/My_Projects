from flask import Flask, render_template
import pyodbc

carsales = Flask(__name__)

def connection():
    s = 'JEGADEESH' #Your server name 
    d = 'CarSales' 
    u = '' #Your login
    p = '' #Your login password
    cstr = f'DRIVER=ODBC Driver 17 for SQL Server;SERVER={s};DATABASE={d};trusted_connection=yes'
    conn = pyodbc.connect(cstr)
    return conn

@carsales.route("/")
def main():
    cars = []
    conn = connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM dbo.TblCars")
    for row in cursor.fetchall():
        cars.append({"id": row[0], "name": row[1], "year": row[2], "price": row[3]})
    conn.close()
    return render_template("carslist.html", cars = cars)

if(__name__ == "__main__"):
    carsales.run()