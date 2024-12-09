import re

pattern = re.compile(r'\b[aeiouAEIOU]\w*[aeiouAEIOU]\b')

try:
    with open('input.txt', 'r') as inf:
        content = inf.read()
        words = pattern.findall(content)
        unique_words = list(set(words))
        print("Words that start and end with a vowel:", unique_words)

except IOError as e:
    print(f"Error opening file: {e}")