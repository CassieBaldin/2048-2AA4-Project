## @file complex_adt.py
#  @author Cassidy Baldin 
#  @brief Contains a class for creating a complex number
#  @date January 21st, 2021

import math

## @brief An ADT for representing dates
#  @details A complex number composed of a real value x, and an imaginary value y
class ComplexT:

    ## @brief Constructor for ComplexT
    #  @details Creates a complex number given a real value x, and imaginary value y
    #  @param x Float representing real value of complex number
    #  @param y Float representing imaginary value of complex number
    def __init__ (self, x, y):
        self.x = x
        self.y = y
