#!/usr/bin/python
import RPi.GPIO as GPIO  
import time  

# blinking function  
def blink(pin, sleeptime=0.5, blinks=1): 
        GPIO.setmode(GPIO.BOARD)  
        GPIO.setup(pin, GPIO.OUT)  
        for i in range(0,blinks):
            GPIO.output(pin,GPIO.HIGH)  
            time.sleep(sleeptime)  
            GPIO.output(pin,GPIO.LOW)  
            time.sleep(sleeptime)
        GPIO.cleanup()   
        return