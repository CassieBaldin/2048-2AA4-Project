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
    #           that input values are float values, and that the input will
    #           never be z = 0 + 0i.
    #  @param x Float representing real value of complex number
    #  @param y Float representing imaginary value of complex number
    def __init__ (self, x, y):
        self.x = x
        self.y = y

    ## @brief Gets the real value of the complex number
    #  @return Float value representing real number
    def real(self):
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
    #           between (-pi, pi]
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
    #  @details It assumes that it makes a new ComplexT that is the conjugate
    #           of the current object
    #  @return The complex conjugate of the current object as a ComplexT
    def conj(self):
        new_y = self.y*(-1)
        return ComplexT(self.x, new_y)
    
    ## @brief Adds argument object to current object
    #  @details It assumes the input is of type ComplexT and makes a new 
    #           ComplexT that is the addition of the argument and current object
    #  @param a ComplexT to add to current object
    #  @return The addition of the current object and argument as a ComplexT
    def add(self, a):
        new_x = self.x + a.x
        new_y = self.y + a.y
        return ComplexT(new_x, new_y)

    ## @brief Subtracts argument object from current object
    #  @details It assumes the input is of type ComplexT and makes a new 
    #           ComplexT that is the subtraction of the argument and current object
    #  @param a ComplexT to subtract from current object
    #  @return The subtraction of argument from current object as a ComplexT
    def sub(self, s):
        new_x = self.x - s.x
        new_y = self.y - s.y
        return ComplexT(new_x, new_y)

    ## @brief Multiplies argument object to current object
    #  @details It assumes the input is of type ComplexT and makes a new 
    #           ComplexT that is the multiplication of argument and current object
    #           and the current object
    #  @param m ComplexT to multiply to current object
    #  @return The multiplication of argument and current object as a ComplexT
    def mult(self, m):
        new_x = self.x*m.x - self.y*m.y
        new_y = self.x*m.y + self.y*m.x
        return ComplexT(new_x, new_y)

    ## @brief Gets the reciprocal of the current object
    #  @details It assumes that it makes a new ComplexT that is the reciprocal
    #           of the current object, and input is not z = 0 + 0i
    #  @return The division of current object by argument as a ComplexT
    def recip(self):
        new_x = self.x/(self.x**2 + self.y**2)
        new_y = (-1)*(self.y/(self.x**2 + self.y**2))
        return ComplexT(new_x, new_y)

    ## @brief Divides current object by argument object
    #  @details It assumes the input is of type ComplexT and makes a new 
    #           ComplexT that is the division of the current object
    #           by the argument, and input is not z = 0 + 0i
    #  @param d ComplexT to divide current object
    #  @return The division of current object by argument as a ComplexT
    def div(self, d):
        frac = 1/(d.x**2 + d.y**2)
        new_x = frac*((self.x*d.x) + (self.y*d.y))
        new_y = frac*((self.y*d.x) - (self.x*d.y)) 
        return ComplexT(new_x, new_y)

    ## @brief Gets the positive square root current object
    #  @details It assumes it makes a new ComplexT that is the positive
    #           square root of the current object
    #  @return If imaginary part is 0, it returns the square root of the real 
    #          part. If not, returns 
    def sqrt(self):
        if (self.y == 0):
            return ComplexT(math.sqrt(self.x), self.y)
        sq_ab = math.sqrt(self.x**2 + self.y**2)
        new_x = math.sqrt((self.x + sq_ab)/2)
        sgn = 1
        if self.y < 0:
            sgn = -1
        new_y = sgn*math.sqrt((((-1)*self.x) + sq_ab)/2)
        return ComplexT(new_x, new_y)
