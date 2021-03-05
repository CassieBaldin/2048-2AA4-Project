## @file SeqServicesLibrary.py
#  @author Cassidy Baldin
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021

def max_val(s):
    if len(s) == 0:
        raise ValueError("Sequence must have a length")

    m = 0
    for x in s:
        if abs(x) >= abs(m):
            m = x
    return m

def count(t, s):
    if len(s) == 0:
        raise ValueError("Sequence must have a length")

    count = 0
    for x in s:
        if x == t:
            count += 1
    return count

def spices(s):
    if len(s) == 0:
        raise ValueError("Sequence must have a length")

    list_of_spices = []
    for x in s:
        if x <= 0:
            list_of_spices.append("nutmeg")
        else:
            list_of_spices.append("ginger")
    return list_of_spices

def new_max_val(s, f):
    if len(s) == 0:
        raise ValueError("Sequence must have a length")

    list_f = []
    for x in s:
        list_f.append(f(x))

    return max_val(list_f)
