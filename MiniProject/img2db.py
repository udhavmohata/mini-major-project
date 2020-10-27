import mysql.connector
import speech2t
import text2s
from mysql.connector import Error
from mysql.connector import errorcode


def convertToBinaryData(filename):
    with open(filename, 'rb') as file:
        binaryData = file.read()
    return binaryData


def insertBLOB(emp_id, name, photo, biodataFile):
    print("Inserting BLOB into python_employee table")

    try:
        connection = mysql.connector.connect(host='host',
                                             database='python_db',
                                             user='pynative',
                                             password='pynative@#29')

        cursor = connection.cursor(prepared=True)

        sql_insert_blob_query = """ INSERT INTO `people`
                          (`id`, `name`, `photo`, `biodata`) VALUES (%s,%s,%s,%s)"""

        empPicture = convertToBinaryData(photo)
        file = convertToBinaryData(biodataFile)

        insert_blob_tuple = (emp_id, name, empPicture, file)

        result = cursor.execute(sql_insert_blob_query, insert_blob_tuple)
        connection.commit()
        print("Image and file inserted successfully as a BLOB into python_employee table", result)

    except mysql.connector.Error as error:
        connection.rollback()
        print("Failed inserting BLOB data into MySQL table {}".format(error))
        text2s.errors()
    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")

text = speech2t.name()
insertBLOB(1, text, "D:\Python\Articles\my_SQL\images\eric_photo.png",
           "D:\Python\Articles\my_SQL\images\eric_bioData.txt")
