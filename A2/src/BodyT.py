## @file BodyT.py
#  @author Cassidy Baldin
#  @brief Contains a module for a body
#  @date February 12th, 2021

from Shape import Shape


##  @brief BodyT is used as a constructor for a body of unknown shape
class BodyT(Shape):
    ## @brief constructor for method BodyT
    #  @details Assumes that arguments provided to the access programs
    #           will be of the correct type
    #  @param xs value representing the x value of the center of mass
    #  @param ys value representing the y value of the center of mass
    #  @param ms value representing mass of the object
    #  @throws ValueError if
    def __init__(self, xs, ys, ms):
        if not (len(xs) == len(ys) == len(ms)):
            raise ValueError

        self.cmx = self.__cm(xs, ms)
        self.cmy = self.__cm(ys, ms)
        self.m = self.__sum(ms)
        self.moment = self.__mmom(xs, ys, ms) \
            - self.__sum(ms) * (self.__cm(xs, ms)**2 + self.__cm(ys, ms)**2)

    ## @brief cm_x returns the x value of the center of mass
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        return self.cmx

    ## @brief cm_y returns the y value of the center of mass
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        return self.cmy

    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        return self.m

    ## @brief m_inert returns the moment of inertia of the object
    #  @return value representing the moment inertia of the object
    def m_inert(self):
        return self.moment

    ## @brief sum returns the sum of a sequence of numbers
    #  @return value representing the sum of the input sequence
    def __sum(self, ms):
        sum = 0
        for u in range(len(ms)):
            sum = sum + ms[u]
        return sum

    ## @brief cm returns the center of mass of the object?
    #  @return value representing the center of mass of the object
    def __cm(self, z, m):
        cm = 0
        for i in range(len(m)):
            cm = cm + (z[i] * m[i]) / sum(m)
        return cm

    ## @brief 
    #  @return 
    def __mmom(self, x, y, m):
        mmom = 0
        for i in range(len(m)):
            mmom = mmom + m[i] * (x[i]**2 + y[i]**2)
        return mmom
