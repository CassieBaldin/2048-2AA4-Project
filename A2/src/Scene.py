## @file Scene.py
#  @author Cassidy Baldin
#  @brief Contains a module for the scene of the graph I think
#  @date February 12th, 2021

from Shape import Shape
from SciPy import SciPy


##  @brief BodyT is used as a constructor for a body of unknown shape
class Scene(Shape, SciPy):
    def __init__(self, s, Fx, Fy, vx, vy):
        self.s = s_prime
        self.Fx = Fx_prime
        self.Fy = Fy_prime
        self,vx = vx_prime
        self.vy = vy_prime

    def get_shape():
        return self.s

    def get_unbal_forces():
        return self.Fx, self.Fy

    def get_init_velo():
        return self.vx, self.vy
