#!/usr/bin/python
import RPi.GPIO as GPIO  
import time  

# blinking function  
def blink(pin, sleeptime=0.5, blinks=1): 
        for i in range(0,blinks):
            GPIO.output(pin,GPIO.HIGH)  
            time.sleep(sleeptime)  
            GPIO.output(pin,GPIO.LOW)  
            time.sleep(sleeptime)  
        return  
        
        
def setup():
    # to use Raspberry Pi board pin numbers  
    GPIO.setmode(GPIO.BOARD)  
    
    # set up GPIO output channel  
    GPIO.setup(11, GPIO.OUT)  

    # blink GPIO17 50 times  
    blink(11, 0.5, 50)  
    GPIO.cleanup()   