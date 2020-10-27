import cv2
import time
import getpass
import os

getUser = getpass.getuser()
save = 'C:/Users/' + getUser + "/Desktop"

camera_port = 0
camera = cv2.VideoCapture(camera_port)
time.sleep(0.1)
return_value, image = camera.read()
cv2.imwrite(os.path.join(save, "user.png"), image)
del camera
