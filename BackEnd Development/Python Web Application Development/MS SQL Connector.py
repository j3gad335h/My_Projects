import pyodbc 
cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER=JEGADEESH;DATABASE=UserCredentials;Trusted_Connection=yes;')

def sql_read():
    print("---Read---")
    cursor = cnxn.cursor()
    cursor.execute("SELECT * from USERCREDS")
    for row in cursor:
        print(row)
        
        
sql_read()