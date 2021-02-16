## @file BodyT.py
#  @author Cassidy Baldin
#  @brief Contains a module for an unspecified body in space
#  @date February 12th, 2021

from Shape import Shape


##  @brief BodyT is used as a constructor for a body of unknown shape in space
class BodyT(Shape):
    ## @brief constructor for method BodyT
    #  @details Assumes that arguments provided to the access programs
    #           will be of the correct type
    #  @param xs value representing the x value of the center of mass
    #  @param ys value representing the y value of the center of mass
    #  @param ms value representing mass of the object
    #  @throws ValueError if the length of all input sequences are not equal
    #  @throws ValueError if values in sequence ms are less than zero
    def __init__(self, xs, ys, ms):
        if not (len(xs) == len(ys) == len(ms)):
            raise ValueError
        for i in range(0, len(ms)):
            if not (ms[i] > 0):
                raise ValueError

        self.__cmx = self.__cm(xs, ms)
        self.__cmy = self.__cm(ys, ms)
        self.__m = sum(ms)
        self.__moment = self.__mmom(xs, ys, ms) \
            - sum(ms) * (self.__cm(xs, ms)**2 + self.__cm(ys, ms)**2)

    ## @brief cm returns the center of mass of the object
    #  @return value representing the center of mass of the object
    def __cm(self, z, m):
        cm = 0
        for i in range(0, len(m)):
            cm = cm + (z[i] * m[i])
        return cm / sum(m)

        ## @brief mmom returns the value of the moment of inertia of the body
        #  @return value of the moment of inertia of the body
    def __mmom(self, x, y, m):
        mmom = 0
        for i in range(0, len(m)):
            mmom = mmom + m[i] * (x[i]**2 + y[i]**2)
        return mmom

    ## @brief cm_x returns the x value of the center of mass
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        return self.__cmx

    ## @brief cm_y returns the y value of the center of mass
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        return self.__cmy

    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        return self.__m

    ## @brief m_inert returns the moment of inertia of the object
    #  @return value representing the moment inertia of the object
    def m_inert(self):
        return self.__moment
