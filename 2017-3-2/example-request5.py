import requests

# Link to request data about the characters
url = 'http://anapioficeandfire.com/api/characters?name='

# Get the character name to search for
name = input('Enter a name to search for: ')
url += name

# Make an HTTP request and the API will respond with a JSON output
response = requests.get(url)
 
# Get our data on Jon Snow
data = response.json() # returns a list of characters from search query

if (len(data) == 0):
    print('No character found by that name')
elif (len(data) == 1):
    character = data[0] 
    print(name + ' is played by ' + ', '.join(character['playedBy']) + ' and is found in seasons ' + ', '.join(character['tvSeries']))
    print(name + ' has the following aliases:')
    for alias in character['aliases']:
        print('\t- ' + alias)
    print('\nMore information on ' + name + ' can be found here: ' + character['url'])
else:
    print('Multiple characters were found by that name:')
    for character in data:
        print('\t- ' + character['name'] + ': ' + character['url'])