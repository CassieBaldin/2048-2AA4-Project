## @file complex_adt.py
#  @author Cassidy Baldin 
#  @brief Contains a class for creating a complex number
#  @date January 21st, 2021

import math

## @brief An ADT for complex numbers
#  @details A complex number composed of a real value x, and an imaginary value y
class ComplexT:

    ## @brief Constructor for ComplexT
    #  @details Creates a complex number given a real value x, and imaginary value y
    #  @param x Float representing real value of complex number
    #  @param y Float representing imaginary value of complex number
    def __init__ (self, x, y):
        self.x = x
        self.y = y

    ## @brief Gets the real value of the complex number
    #  @return Float value representing real number
    def real(self)
    	return self.x

    ## @brief Gets the imaginary number of the complex number
    #  @return Float value representing imaginary number
    def imag(self):
    	return self.y

    ## @brief Gets the absolute value (or modulus/magnitude) of the complex number
    #  @return Float representing absolute value of the complex number
    def get_r(self):
    	return math.sqrt(self.x**2 + self.y**2)

    ## @brief Gets the argument (or phase) of the complex number in radians
    #  @return Float representing the phase of the complex number in radians
    def get_phi(self):
        if (self.x < 0 and self.y == 0):
            return math.pi
        try:
            return 2*(math.atan(self.y/((math.sqrt(self.x**2 + self.y**2)) + self.x)))
        except ZeroDivisionError:
            return "undefined"

    ## @brief Checks if argument and current object are equal
    #  @return True if the argument and the current object are equal
    def equal(self, e):
        if (e.x == self.x) and (e.y == self.y):
            return True
        else:
            return False
            