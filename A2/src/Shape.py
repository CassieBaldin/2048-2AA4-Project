## @file Shape.py
#  @author Cassidy Baldin
#  @brief Contains an interface for the shape of the object
#  @date February 12th, 2021

from abc import ABC, abstractmethod


##  @brief Shape is used as an interface for the shape of the object
class Shape(ABC):
    @abstractmethod
    ## @brief cm_x returns the x value of the center of mass
    #  @return value representing the center of mass of the x value
    def cm_x(self):
        pass

    @abstractmethod
    ## @brief cm_y returns the y value of the center of mass
    #  @return value representing the center of mass of the y value
    def cm_y(self):
        pass

    @abstractmethod
    ## @brief mass returns the mass of the object
    #  @return value representing the mass of the object
    def mass(self):
        pass

    @abstractmethod
    ## @brief m_inert returns the inertia of the object
    #  @return value representing the inertia of the object
    def m_inert(self):
        pass
