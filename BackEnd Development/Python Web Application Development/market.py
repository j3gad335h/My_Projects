from flask import Flask, render_template
import pyodbc
cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER=JEGADEESH;DATABASE=UserCredentials;Trusted_Connection=yes;')

app = Flask(__name__)


def sql_read():
    print("Read")
    cursor = cnxn.cursor()
    cursor.execute("SELECT * from USERCREDS")
    for row in cursor:
        print(row)


@app.route('/')
def home_page():
    return render_template('home.html')


@app.route('/about')
def about_page():
    return render_template('about.html')


@app.route('/register')
def register_page():
    return render_template('registration.html')


sql_read()