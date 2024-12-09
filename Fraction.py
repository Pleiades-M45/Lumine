class Fraction:

    def __init__(self, num=0, deno=1):
        self.num = num 
        if not deno:
            print("Denominator cannot be zero.")
        else:
            self.deno = deno

    def set_num(self, num):
        self.num = num
    
    def set_deno(self, deno):
        if not deno:
            print("Denominator cannot be zero.")
        else:
            self.deno = deno

    def get_num(self):
        return self.num
    
    def get_deno(self):
        return self.deno

    def display(self):
        return f"{self.num}/{self.deno}"

f1 = Fraction()
f2 = Fraction(3,4)

print("Fraction 1:", f1.display())
print("Fraction 2:", f2.display())

f2.set_num(5)
f2.set_deno(8)

print("Updated Fraction 2:", f2.display())