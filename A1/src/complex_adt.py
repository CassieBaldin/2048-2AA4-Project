## @file complex_adt.py
#  @author Cassidy Baldin 
#  @brief Contains a class for creating a complex number
#  @date January 21st, 2021

import math

## @brief An ADT for complex numbers
#  @details A complex number of form  z = x + yi, given a real value x, and an
#           imaginary value y. Uses equations from this source: 
#           https://en.wikipedia.org/wiki/Complex_number
class ComplexT:

    ## @brief Constructor for ComplexT
    #  @details Creates a complex number of form  z = x + yi
    #           given real value x, and an imaginary value y. It assumes
    #           that input values are float values.
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

    ## @brief Gets absolute value (or modulus/magnitude) of the complex number
    #  @return Float representing absolute value of the complex number
    def get_r(self):
        return math.sqrt(self.x**2 + self.y**2)

    ## @brief Gets the argument (or phase) of the complex number in radians
    #  @details It is also assumed here that the range of values is 
    #           between (-pi, pi] (uses the principal value)
    #  @throws Throws a ZeroDivisionError if both x and y are equal to 0, and 
    #          the phase of the complex number is "undefined" as per the
    #          equation you cannot divide by zero
    #  @return Float representing the phase of the complex number in radians
    def get_phi(self):
        if ((self.x == 0) and (self.y == 0)):
            raise ZeroDivisionError("Cannot divide by zero: undefined")
        if (self.x < 0 and self.y == 0):
            return math.pi
        else:
            arg = self.y/((math.sqrt(self.x**2 + self.y**2)) + self.x)
            return 2*(math.atan(arg))

    ## @brief Checks if argument and current object are equal
    #  @details They are considered equal if both the real and imaginary
    #           values are equal to the current real and imaginary
    #           values respectively. It assumes the input is of type ComplexT
    #  @param e ComplexT to compare to current object
    #  @return True if the argument and the current object are equal
    def equal(self, e):
        if (e.x == self.x) and (e.y == self.y):
            return True
        else:
            return False

    ## @brief Gets the complex conjugate of the current object
    #  @details It assumes that it mutates the current object to its conjugate
    def conj(self):
        self.y = self.y*(-1)
    
    ## @brief Adds argument object to current object
    #  @details It assumes the input is of type ComplexT and mutates current
    #           argument to be the addition of the argument and current object
    #  @param a ComplexT to add to current object
    def add(self, a):
        self.x = self.x + a.x
        self.y = self.y + a.y

    ## @brief Adds argument object to current object
    #  @details It assumes the input is of type ComplexT and mutates the 
    #           current argument to be the subtraction of the argument from 
    #           the current object
    #  @param s ComplexT to subtract from current object
    def sub(self, s):
        self.x = self.x - s.x
        self.y = self.y - s.y

    ## @brief Multiplies argument object to current object
    #  @details It assumes the input is of type ComplexT and mutates the 
    #           current argument to be the multiplication of the argument
    #           and the current object
    #  @param m ComplexT to multiply to current object
    def mult(self, m):
        x_val = self.x*m.x - self.y*m.y
        y_val = self.x*m.y + self.y*m.x
        self.x = x_val
        self.y = y_val

    ## @brief Gets the reciprocal of the current object
    #  @details It assumes that it mutates the current argument to be the 
    #           reciprocal of the current object
    #  @throws Throws a ZeroDivisionError if both x and y are equal to 0, and
    #          the reciprocal is "undefined" as per the equation you cannot
    #          divide by zero
    def recip(self):
        if ((self.x == 0) and (self.y == 0)):
            raise ZeroDivisionError("Cannot divide by zero: undefined")
        x_val = self.x/(self.x**2 + self.y**2)
        y_val = (-1)*self.y/(self.x**2 + self.y**2)
        self.x = x_val
        self.y = y_val

    ## @brief Divides current object by argument object
    #  @details It assumes the input is of type ComplexT and mutates the 
    #           current argument to be the division of the current object
    #           by the argument
    #  @throws Throws a ZeroDivisionError if both x and y are equal to 0, and
    #          the division is "undefined" as per the equation you cannot
    #          divide by zero
    #  @param d ComplexT to divide current object
    def div(self, d):
        if ((self.x == 0) and (self.y == 0)):
            raise ZeroDivisionError("Cannot divide by zero: undefined")
        frac = 1/(self.x**2 + self.y**2)
        x_val = frac*((self.x*d.x) + (self.y*d.y))
        y_val = frac*((self.y*d.x) - (self.x*d.y)) 
        self.x = x_val
        self.y = y_val
