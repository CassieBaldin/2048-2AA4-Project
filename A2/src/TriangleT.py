## @file TriangleT.py
#  @author Cassidy Baldin
#  @brief Contains a module for a triangle
#  @date February 12th, 2021

from Shape import Shape


##  @brief Triangle is used as a constructor for a triangle
class TriangleT(Shape):
    ## @brief constructor for method TriangleT
    #  @details Assumes that arguments provided to the access programs
    #           will be of the correct type
    #  @param xs value representing the x value of the center of mass
    #  @param ys value representing the y value of the center of mass
    #  @param rs value representing the side length of the triangle
    #  @param ms value representing mass of the triangle
    #  @throws ValueError is side length and mass are less than zero
    def __init__(self, xs, ys, ss, ms):
        self.x = xs
        self.y = ys
        self.s = ss
        self.m = ms

        if not ((self.s > 0) and (self.m > 0)):
            raise ValueError

    ## @brief cm_x returns the x value of the center of mass
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        return self.x

    ## @brief cm_y returns the y value of the center of mass
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        return self.y

    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        return self.m

    ## @brief mass returns the inertia of the object
    #  @return value representing the inertia of the object
    def m_inert(self):
        return (self.m * self.s**2) / 12
