import speech_recognition as sr
import text2s


def name():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        text2s.hello()
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio)
            print(text)
            return text
        except:
            text2s.errors()
