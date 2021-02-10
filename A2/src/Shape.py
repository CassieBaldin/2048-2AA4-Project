## @file Shape.py
#  @author Cassidy Baldin
#  @brief Contains an interface for the shape of the object
#  @date February 12th, 2021

from abc import ABC, abstractmethod


##  @brief Contains an interface for the shape of the object
class Shape(ABC):
    @abstractmethod
    ## @brief cm_x returns the center of mass of the x value of the object
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        return self.__cmx

    ## @brief cm_y returns the center of mass of the y value of the object
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        return self.__cmy

    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        return self.__mass

    ## @brief m_inert returns the inertia of the object
    #  @return value representing the inertia of the object
    def m_inter(self):
        return self.__minert
