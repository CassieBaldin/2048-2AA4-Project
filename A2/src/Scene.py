## @file Scene.py
#  @author Cassidy Baldin
#  @brief Contains a module for the scene of the graph I think
#  @date February 12th, 2021

from Shape import Shape
from SciPy import SciPy


##  @brief Scene is used as ...
class Scene(Shape):
    ## @brief constructor for method Scene
    #  @details Assumes that arguments provided to the access programs
    #           will be of the correct type
    #  @param s value representing the shape
    #  @param Fx value unbalanced force function in x direction
    #  @param Fy value unbalanced force function in y direction
    #  @param vx value representing initial velocity in x direction
    #  @param vy value representing initial velocity in y direction
    def __init__(self, s, Fx, Fy, vx, vy):
        self.s = s_prime
        self.Fx = Fx_prime
        self.Fy = Fy_prime
        self,vx = vx_prime
        self.vy = vy_prime

    ## @brief gets the shape of the body
    #  @return value representing the shape of the body
    def get_shape():
        return self.s

    ## @brief gets the unbalanced forces of the body in the x and y direction
    #  @return value of the unbalanced forces in the x direction
    def get_unbal_forces():
        return self.Fx, self.Fy

    ## @brief gets the initial velocity of the body in the x and y direction
    #  @return value of initial velocity in the x direction
    def get_init_velo():
        return self.vx, self.vy

    ## @brief sets the shape of the body
    def set_shape(s_prime):
        self.s = s_prime

    ## @brief sets the unbalanced forces of the body
    def set_unbal_forces(Fx_prime, Fy_prime):
        self.Fx = Fx_prime
        self.Fy = Fy_prime

    ## @breif sets the initial velocity of the body
    def set_init_velo(vx_prime, vy_prime):
        self.vx = vx_prime
        self.vy = vy_prime