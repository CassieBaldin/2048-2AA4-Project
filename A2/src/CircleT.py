## @file CircleT.py
#  @author Cassidy Baldin
#  @brief Contains a module for a circle
#  @date February 12th, 2021


from Shape import Shape


##  @brief CircleT is used as a constructor for a circle
class CircleT(Shape):
    ## @brief constructor for method CircleT
    #  @details Assumes that arguments provided to the access programs
    #           will be of the correct type
    #  @param xs value representing the x value of the center of mass
    #  @param ys value representing the y value of the center of mass
    #  @param rs value representing the radius of the circle
    #  @param ms value representing mass of circle
    #  @throws ValueError if either radius or mass are less than zero
    def __init__(self, xs, ys, rs, ms):
        self.__x = xs
        self.__y = ys
        self.__r = rs
        self.__m = ms

        if not ((self.__r > 0) and (self.__m > 0)):
            raise ValueError("Radius and Mass must be greater than zero")

    ## @brief cm_x returns the x value of the center of mass
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        return self.__x

    ## @brief cm_y returns the y value of the center of mass
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        return self.__y

    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        return self.__m

    ## @brief m_inert returns the moment of inertia of the object
    #  @return value representing the moment of inertia of the object
    def m_inert(self):
        return (self.__m * self.__r**2) / 2
