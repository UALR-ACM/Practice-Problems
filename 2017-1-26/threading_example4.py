#!/usr/bin/python3

import threading
import time


class myThread1(threading.Thread):
    def __init__(self, threadID, name, counter):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name
        self.counter = counter

    def run(self):
        print('Starting ' + self.name)
        threadLock.acquire()
        calculateMass(self.name, self.counter, 5)
        threadLock.release()
        print('Exiting ' + self.name)


class myThread2(threading.Thread):
    def __init__(self, threadID, name):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name

    def run(self):
        print('Starting ' + self.name)
        with threadLock:
            calculateDensity(self.name)
        print('Exiting ' + self.name)


calculations = {}
threadLock = threading.Lock()
# threadLock = threading.RLock()


def calculateMass(threadName, delay, counter):
    for i in range(counter):
        time.sleep(delay)
        print('{0}: on iteration {1}'.format(threadName, i+1))

    # Mass has been calculated. Store final computation.
    calculations['mass'] = calculations['density'] / 2
    print('{} finished calculating mass...'.format(threadName))

def calculateDensity(threadName):
    print('{} starting to calculate the density...'.format(threadName))
    total = 0
    for i in range(6555):
        for j in range(9999):
            total += 1
    calculations['density'] = total
    print('{} finished calculating density...'.format(threadName))


thread1 = myThread1(1, 'Thread-1', 1)
thread2 = myThread2(2, 'Thread-2')

# Start threads
thread2.start()
thread1.start()

print('Exiting main thread...')