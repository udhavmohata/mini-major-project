import mysql.connector
from mysql.connector import Error
from mysql.connector import errorcode
try:
    connection = mysql.connector.connect(host='localhost',
                                         database='python_db',
                                         user='pynative',
                                         password='pynative@#29')

    sql_insert_query = """ INSERT INTO `persons`
                          (`s.no`, `name`, `Mean`, `Standard Deviation`, Variance) VALUES (1,'Udhav', 1, 26, 1)"""

    cursor = connection.cursor()
    result = cursor.execute(sql_insert_query)
    connection.commit()
    print("Record inserted successfully into python_users table")

except mysql.connector.Error as error:
    connection.rollback()
    # rollback if any exception occured
    print("Failed inserting record into python_users table {}".format(error))

finally:
    # closing database connection.
    if connection.is_connected():
        cursor.close()
        connection.close()
        print("MySQL connection is closed")
