#!/usr/bin/python
from __future__ import division
from PIL import Image
import numpy as np
import sys
import requests
import json
import time

def handle_motion(img_path):
    print "handling motion"
    # We load it and calculate a single scalar value for the motion ('activity')
    # in this image
    img = np.asarray(Image.open(img_path).convert('L'))
    img = 1 * (img == 25) 
    m,n = img.shape

    motion_pixels = img.sum()
    total_pixels = m*n

    motion_value = motion_pixels / total_pixels * 100
    
    # see if we should do some shit with the baby
    try:
        amplitude_value = float(open('/home/pi/nrt/raspy/last_amplitude').readline())
    except Error:
        amplitude_value = 0
        
    if amplitude_value > 0.20 && motion_value > 0.20:
        print "BABY IS AWAKE."

    # Send the event to our server
    url = 'http://192.168.137.1:8080/BigSisterReboot/webresources/entities.event'
    payload = {'timestamp': int(time.time()), 
              'filename': img_path,
              'value': motion_value,
              'accountId': 1,
              'typeId': 2,
          }
    headers = {'content-type': 'application/json'}

    r = requests.post(url, data=json.dumps(payload), headers=headers)
    
    

def handle_snapshot(img_path):
    pass
    # Send the raw image to our server
    # url = 'http://192.168.137.1:8080/BigSister/webresources/entities.eventvideo'
    # payload = {'timestamp': int(time.time()),
#               'filename': img_path,
#               'value': value,
#               'accountId': 1,}
#     headers = {'content-type': 'application/json'}
#
#     r = requests.post(url, data=json.dumps(payload), headers=headers)



# Our first arguement passed is an image file name
img_path = str(sys.argv[1]).strip()

# motion pictures end with m.jpg, so here we differentiate between motion pics and snapshots
if img_path[-5:] == 'm.jpg':
    handle_motion(img_path)
else:
    handle_snapshot(img_path)
    
