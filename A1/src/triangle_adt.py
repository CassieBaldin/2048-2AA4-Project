## @file triangle_adt.py
#  @author Cassidy Baldin
#  @brief Contains a class for creating a triangle
#  @date January 21st, 2021

import math
from enum import Enum

## @brief An ADT for triangles
#  @details A triangle composed of three sides; x, y, and z
class TriangleT:

    ## @brief Constructor for TriangleT
    #  @details Creates a triangle composed of three sides; x, y, and z. 
    #           It is assumed that the input sides will be positive,
    #           non-zero integer values.
    #  @param x Integer representing side x
    #  @param y Integer representing side y
    #  @param z Integer representing side z
    def __init__ (self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    ## @brief Gets the sides of the triangles
    #  @return Integer tuple value representing sides as a tuple
    def get_sides(self):
        return (self.x, self.y, self.z)
    
    ## @brief Checks if argument and current object are equal
    #  @details They are considered to be equal if all side lengths are equal.
    #           It assumes the input is of type TriangleT.
    #  @param e TriangleT to compare to current object
    #  @return True if the argument and the current object are equal, else False
    def equal(self, e):
        list1 = [e.x, e.y, e.z]
        list2 = [self.x, self.y, self.z]
        list1.sort()
        list2.sort()
        if (list1[0] == list2[0]) and (list1[1] == list2[1]) and (list1[2] == list2[2]):
            return True
        return False

    ## @brief Gets the perimeter of the current triangle
    #  @return Integer representing the perimeter of the triangle
    def perim(self):
        return self.x + self.y + self.z

    ## @brief Gets the area of the current triangle
    #  @details It assumes input is valid triangle. Uses equation from this 
    #           source: https://www.mathsisfun.com/geometry/herons-formula.html
    #  @return Float representing the area of the triangle
    def area(self):
        s = self.perim()/2
        return math.sqrt(s*(s-self.x)*(s-self.y)*(s-self.z))

    ## @brief Checks whether or not the triangle is valid
    #  @details Considered valid if the sum of two sides is smaller than third side.
    #           Uses equation from this source: 
    #           https://www.wikihow.com/Determine-if-Three-Side-Lengths-Are-a-Triangle
    #  @return True if valid triangle, else False
    def is_valid(self):
        x = self.x
        y = self.y
        z = self.z
        if (x + y > z) and (x + z > y) and (y + z > x):
            return True
        return False

    ## @brief Returns a TriType corresponding to the type of triangle that was input
    #  @details Creates an element of set {equilat, isosceles, scalene, right}.
    #           The assumed priority label is that if the triangle is a 
    #           right triangle, it will take on this identity first. It also
    #           assumes that the triangle is valid. 
    #  @return TriType element that corresponds to the type of triangle it is.
    def tri_type(self):
        r = (self.x**2 + self.y**2 == self.z**2) or (self.x**2 + self.z**2 == self.y**2) or (self.z**2 + self.y**2 == self.x**2)
        eq = (self.x == self.y == self.z)
        iso = (self.x == self.y) or (self.x == self.z) or (self.y == self.z)
        scal = (self.x != self.y != self.z)

        if (r):
            return TriType(1)
        elif(eq):
            return TriType(2)
        elif(iso):
            return TriType(3)
        return TriType(4)

## @brief A Enum class for triangle types
#  @details Priority order is right, equilat, isosceles, scalene
class TriType(Enum):
            right = 1
            equilat = 2
            isosceles = 3
            scalene = 4
