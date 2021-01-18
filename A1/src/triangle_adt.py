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
    #  @details Creates a triangle composed of three sides; x, y, and z
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
    #  @return True if the argument and the current object are equal
    def equal(self, e):
        if (e.x == self.x) and (e.y == self.y) and (e.z == self.z):
            return True
        else:
            return False

    ## @brief Gets the perimeter of the current triangle
    #  @return Integer representing the perimeter of the triangle
    def perim(self):
        return self.x + self.y + self.z

    ## @brief Gets the area of the current triangle
    #  @return Float representing the area of the triangle
    def area(self):
        if (self.is_valid() == False):
            return "This is not a valid triangle"
        else:
            s = self.perim()/2
            return math.sqrt(s*(s-self.x)*(s-self.y)*(s-self.z))

    ## @brief Checks whether or not the triangle is valid
    #  @return True if valid triangle
    def is_valid(self):
        x = self.x
        y = self.y
        z = self.z
        if (x + y > z) and (x + z > y) and (y + z > x):
            return True
        else:
            return False