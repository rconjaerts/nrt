#!/usr/bin/python
from __future__ import division
import sys
import requests
import json
import time


threshold = sys.argv[1]
amplitude = sys.argv[2]

value = 100 * (amplitude - threshold) / threshold

# Send the event to our server
url = 'http://192.168.137.1:8080/BigSister/webresources/entities.eventaudio'
payload = {'timestamp': int(time.time()), 
          'value': value,
          'accountId': 1}
headers = {'content-type': 'application/json'}

r = requests.post(url, data=json.dumps(payload), headers=headers)

print r
