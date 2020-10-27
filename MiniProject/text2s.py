from gtts import gTTS
import os


def hello():
    mytext = "What is the person's name?"
    language = 'en'
    myobj = gTTS(text=mytext, lang=language, slow=False)
    myobj.save("name.wav")
    os.system("mpg321 name.wav")


def errors():
    mytext = 'Try again'
    language = 'en'
    myobj = gTTS(text=mytext, lang=language, slow=False)
    myobj.save("error.wav")
    os.system("mpg321 error.wav")
