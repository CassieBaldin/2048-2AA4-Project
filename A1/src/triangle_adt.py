## @file triangle_adt.py
#  @author Cassidy Baldin
#  @brief Contains a class for creating a triangle
#  @date January 21st, 2021

import math

## @brief An ADT for triangles
#  @details A triangle composed of three sides; x, y, and z
#  @details ASSUMPTIONS
class TriangleT:

    ## @brief Constructor for TriangleT
    #  @details Creates a triangle composed of three sides; x, y, and z. 
    #           It is assumed that the input sides will be integer values.
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
    #  @return True if the argument and the current object are equal
    def equal(self, e):
    	list1 = [e.x, e.y, e.z]
        list2 = [self.x, self.y, self.z]
        list1.sort()
        list2.sort()
        if (list1[0] == list2[0]) and (list1[1] == list2[1]) and (list1[2] == list2[2]):
            return True
        else:
            return False

    ## @brief Gets the perimeter of the current triangle
    #  @return Integer representing the perimeter of the triangle
    def perim(self):
        return self.x + self.y + self.z

    ## @brief Gets the area of the current triangle
    #  @details Uses equation from this source: 
    #           https://www.mathsisfun.com/geometry/herons-formula.html
    #  @return Float representing the area of the triangle
    def area(self):
        if (self.is_valid() == False):
            return "This is not a valid triangle"
        s = self.perim()/2
        return math.sqrt(s*(s-self.x)*(s-self.y)*(s-self.z))

    ## @brief Checks whether or not the triangle is valid
    #  @details Uses equation from this source: 
    #           https://www.wikihow.com/Determine-if-Three-Side-Lengths-Are-a-Triangle
    def is_valid(self):
        x = self.x
        y = self.y
        z = self.z
        if (x + y > z) and (x + z > y) and (y + z > x):
            return True
        else:
            return False