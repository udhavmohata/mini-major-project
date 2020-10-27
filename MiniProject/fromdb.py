import mysql.connector
from mysql.connector import Error

try:
    mySQLconnection = mysql.connector.connect(host='localhost',
                                              database='python_db',
                                              user='pynative',
                                              password='pynative@#29')

    sql_select_Query = "select * from persons"
    cursor = mySQLconnection.cursor()
    cursor.execute(sql_select_Query)
    records = cursor.fetchall()

    print("Total number of rows in python_developers is - ", cursor.rowcount)
    print("Printing each row's column values i.e.  developer record")
    for row in records:
        print("s.no = ", row[0], )
        print("Name = ", row[1], "\n")
    cursor.close()

except Error as e:
    print("Error while connecting to MySQL", e)
finally:
    # closing database connection.
    if mySQLconnection.is_connected():
        mySQLconnection.close()
        print("MySQL connection is closed")
