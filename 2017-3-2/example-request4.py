import requests

# Link to request data about the characters
url = 'http://anapioficeandfire.com/api/characters?name=Jon%20Snow'

# Make an HTTP request and the API will respond with a JSON output
response = requests.get(url)
 
# Get our data on Jon Snow
jon_snow = response.json()[0] # Returns a list of characters from the search results (only one in Jon Snow's case) 

print('Jon Snow is played by ' + ', '.join(jon_snow['playedBy']) + ' and is found in seasons ' + ', '.join(jon_snow['tvSeries']))
print('Jon Snow has the following aliases:')
for alias in jon_snow['aliases']:
    print('\t- ' + alias)

print('\nMore information on Jon Snow can be found here: ' + jon_snow['url'])