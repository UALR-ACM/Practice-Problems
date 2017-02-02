import threading
import time

def hello():
    print('Hello')

t = threading.Timer(5.0, hello)
t.start()
print('After started the timer')