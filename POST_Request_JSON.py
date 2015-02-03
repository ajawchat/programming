# Program to send a POST request with the message body as JSON object.

import json, requests

url = "http://requestb.in/1m57jby1"

jsonData = {
  "name": "Ajinkya Awchat",
  "email": "ajawchat@indiana.com",
  "resume": "Ajinkya_Awchat_Resume.pdf",
  "other": {
    "linkedin": "linkedin.com/in/ajinkyaawchat/",
    "CoverLetter": "Cover_Letter.pdf"
  }
}


headers = {'Content-type': 'application/json'}
r = requests.post(url, data=json.dumps(jsonData), headers=headers)

print r.status_code
print r.headers
