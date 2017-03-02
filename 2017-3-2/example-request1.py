import requests

# The link to the API which we'll make our HTTP request to
# In this case, this request should return the available resources with this API
url = 'http://anapioficeandfire.com/api/'

# Make an HTTP request and the API will respond with a JSON output
response = requests.get(url)
print('Content:')
print(response.text)

# Show the HTTP status code (200's is success)
print('\nStatus Code: ' + str(response.status_code)) 

# Other data with the response
print('\nHeaders:')
for header in response.headers:
    print('-\t' + header + ': ' + response.headers[header])

