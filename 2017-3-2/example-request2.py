import requests
import json

# The link to the API which we'll make our HTTP request to
# In this case, this request should return the available resources with this API
url = 'http://anapioficeandfire.com/api/'

# Make an HTTP request and the API will respond with a JSON output
response = requests.get(url)

# The `requests` module has a built-in JSON encoder
data = response.json() # returns the JSON data (dictionary/map)

# Now we can use the data dict any way we want (and possibly make more requests)
for resource in data:
    print('-\t' + resource + ': ' + data[resource])

