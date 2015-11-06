""" This is code entirely written by me, with no help from any outside source. --Alexander Hoppe """
from random import randint 

big_list = []
for i in range(100):
    value = randint(1,1000)
    big_list.append(value)
# print(big_list)
# print(len(big_list))
def list_function(numbers):
    div4 = [] # I thought it would be easier to read as a list
    largest = 0
    count = 0
    odd = 0
    for i in numbers:
        if i % 4 == 0:
            div4.append(i)
    for i in numbers:
        if i > largest: 
            largest = i
    for i in numbers:
        if i % 3 == 0:
            count += 1
    for i in numbers:
        if i % 2 == 1:
            odd += 1
    even = 100 - odd
    print("The following numbers from the Big List are divisible by four:")
    print(div4)
    print("The largest number in the Big List is", str(largest))
    print("There are %s even numbers and %s odd numbers in the Big List" % (even, odd))
    return count
    
    
print("Here's the Big List:")
print(big_list)
print("It's", len(big_list), "numbers long.")
print(list_function(big_list))
print("^ That\'s how many number in the big list are divisible by 3")