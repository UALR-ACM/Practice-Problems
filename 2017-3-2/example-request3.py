import requests

# The link to the API which we'll make our HTTP request to
# In this case, this request should return the available resources with this API
url = 'http://anapioficeandfire.com/api/'

# Make an HTTP request and the API will respond with a JSON output
response = requests.get(url)

# The `requests` module has a built-in JSON encoder
root_data = response.json() # returns the JSON data (dictionary/map)

# Now we can use the data dict any way we want (and possibly make more requests)
for resource in root_data:
    print('Requesting data from the API on `' + resource + '`...')
    sub_data = requests.get(root_data[resource]).json() # request the data for the corresponding resource

    for sub_resource in sub_data:
        print('\t- ' + str(sub_resource))

    print('\n')