# TODO: Write out the other 3 functions - subtract, multiply and divide.
def add(n1, n2):
    return n1 + n2

def sub(n1, n2):
    return n1 - n2

def mult(n1, n2):
    return n1 * n2

def div(n1, n2):
    return n1 / n2

# TODO: Add these 4 functions into a dictionary as the values. Keys = "+", "-", "*", "/"
operations = {
    "+": add,
    "-": sub,
    "*": mult,
    "/": div
}

def calculator(decision, total):
    # TODO: Use the dictionary operations to perform the calculations. Multiply 4 * 8 using the dictionary.
    choice = input("What operation do you want to do? ")
    if decision == "yes":
        num1 = total
    else:
        num1 = int(input("Enter the first number: "))
    num2 = int(input("Enter the second number: "))

    for operation in operations:
        if choice == operation:
            calculate = operations[operation]
            result = calculate(num1, num2)
            print(f"The result is: {result}")
            return result

total = calculator("", 0)

run = True

while run:
    decide = input("Would you like to continue with the previous result? Type 'yes' or 'no': ").lower()
    if decide == "yes":
        total = calculator("yes", total)
    else:
        total = calculator("no", 0)