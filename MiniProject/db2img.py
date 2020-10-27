import mysql.connector
from mysql.connector import Error
from mysql.connector import errorcode


def write_file(data, filename):
    with open(filename, 'wb') as file:
        file.write(data)


def readBLOB(emp_id, photo, bioData):
    print("Reading BLOB data from python_employee table")

    try:
        connection = mysql.connector.connect(host='host',
                                             database='python_db',
                                             user='pynative',
                                             password='pynative@#29')

        cursor = connection.cursor(prepared=True)

        sql_fetch_blob_query = """SELECT photo from people where id = %s"""

        cursor.execute(sql_fetch_blob_query, (emp_id, ))
        record = cursor.fetchall()
        for row in record:
            print("Id = ", row[0], )
            print("Name = ", row[1])
            image = row[2]
            file = row[3]
            print("Storing employee image and bio-data on disk \n")
            write_file(image, photo)
            write_file(file, bioData)

    except mysql.connector.Error as error:
        connection.rollback()
        print("Failed to read BLOB data from MySQL table {}".format(error))

    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")

readBLOB(1, "D:\Python\Articles\my_SQL\query_output\eric_photo.png", "D:\Python\Articles\my_SQL\query_output\eric_bioData.txt")
readBLOB(2, "D:\Python\Articles\my_SQL\query_output\scott_photo.png", "D:\Python\Articles\my_SQL\query_output\scott_bioData.txt")