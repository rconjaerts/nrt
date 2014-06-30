#!/usr/bin/python
from __future__ import division
from PIL import Image
import numpy as np
import sys
import requests
import json
import time


def handle_motion(img_path):
    # We load it and calculate a single scalar value for the motion ('activity')
    # in this image
    img = np.asarray(Image.open(img_path).convert('L'))
    img = 1 * (img == 25) 
    m,n = img.shape

    motion_pixels = img.sum()
    total_pixels = m*n

    value = motion_pixels / total_pixels * 100

    # Send the event to our server
    url = 'http://192.168.137.1:8080/BigSisterReboot/webresources/entities.event'
    payload = {'timestamp': int(time.time()), 
              'filename': img_path,
              'value': value,
              'accountId': 1,
              'type_id': 2,}
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
img_path = sys.argv[1]

# motion pictures end with m.jpg, so here we differentiate between motion pics and snapshots
if img_path[-5:] == 'm.jpg':
    handle_motion(img_path)
else:
    handle_snapshot(img_path)
    
