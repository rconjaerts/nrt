#!/usr/bin/python
from __future__ import division
import sys
import requests
import json
import time
import blinker

threshold = float(sys.argv[1])
amplitude = float(sys.argv[2])

value = 100 * (amplitude - threshold) / (1-threshold)


blinker.blink(15, 5, 0.1)


# Send the event to our server
url = 'http://192.168.137.1:8080/BigSisterReboot/webresources/entities.event'
payload = {'timestamp': int(time.time()), 
          'value': value,
          'accountId': 1,
          'typeId': 1,}
headers = {'content-type': 'application/json'}

r = requests.post(url, data=json.dumps(payload), headers=headers)

#print r
