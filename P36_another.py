import re
pattern = re.compile(r'\(?(\d{3})\)?[ -.]?(\d{3})[ -.]?(\d{4})')

try:
    with open("input.txt", 'r') as inf:
        lines = inf.readlines() 
        
        if lines: 
            # Find the length of the longest line(s)
            max_length = max(len(line) for line in lines)
            
            print(f"Length of the line: {max_length} characters.")
            print("Longest line(s):")
            for line in lines:
                if len(line) == max_length:
                    print(line.strip())

            # Print all phone numbers
            inf.seek(0) 
            content = inf.read()
            numbers = pattern.finditer(content)

            print("\nPhone numbers found in the file:")
            for i in numbers:
                print(i.group())

            # Remove comment lines
            non_comment_lines = [line for line in lines if not line.strip().startswith('#') and line.strip()]  # and line.strip() => strip any unnecessary blank lines

            with open("output.txt", 'w') as outf:
                outf.writelines(non_comment_lines)
            print("\nComment lines have been removed and saved to 'output.txt'.")
            

except IOError as e:
    print(f"Error opening file: {e}")