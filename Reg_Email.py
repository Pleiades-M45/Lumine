import re

email_pattern = re.compile(r'\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}\b')

try:
    with open('email_file.txt', 'r') as f:
        inf = f.read()
        emails = email_pattern.findall(inf)
        print(emails)

except IOError as e:
    print(f"Error opening file: {e}")
