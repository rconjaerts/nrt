#!/usr/bin/python
from __future__ import division
from PIL import Image
import numpy as np
import sys
import requests
import json
import time

# Our first arguement passed is an image file name
img_path = sys.argv[1]

# We load it and calculate a single scalar value for the motion ('activity')
# in this image
img = np.asarray(Image.open(img_path).convert('L'))
img = 1 * (img == 25) 
m,n = img.shape

motion_pixels = img.sum()
total_pixels = m*n

value = motion_pixels / total_pixels * 100

# Send the event to our server
url = 'http://192.168.137.1:8080/BigSister/webresources/entities.eventvideo'
payload = {'timestamp': int(time.time()), 
          'filename': img_path,
          'value': value,
          'accountId': 1}
headers = {'content-type': 'application/json'}

r = requests.post(url, data=json.dumps(payload), headers=headers)

print r
