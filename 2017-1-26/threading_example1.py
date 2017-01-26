#!/usr/bin/python3

import threading
import time


class myThread(threading.Thread):
    def __init__(self, threadID, name, counter):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name
        self.counter = counter

    def run(self):
        print('Starting ' + self.name)
        calculateMass(self.name, self.counter, 5)
        print('Exiting ' + self.name)

def calculateMass(threadName, delay, counter):
    for i in range(counter):    
        time.sleep(delay)
        print('{0}: on iteration {1}'.format(threadName, i+1))


thread1 = myThread(1, 'Thread-1', 1)
thread2 = myThread(2, 'Thread-2', 2)

# Start threads
thread1.start()
thread2.start()

print('Exiting main thread...')