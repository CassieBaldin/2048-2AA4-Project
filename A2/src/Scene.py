## @file Scene.py
#  @author Cassidy Baldin
#  @brief Contains a module to construct motion simulation
#  @date February 12th, 2021

from scipy import integrate


##  @brief Scene is used as a way to construct a motion simulation
class Scene:
    ## @brief constructor for method Scene
    #  @param s_prime value representing the shape
    #  @param Fx_prime value unbalanced force function in x direction
    #  @param Fy_prime value unbalanced force function in y direction
    #  @param vx_prime value representing initial velocity in x direction
    #  @param vy_prime value representing initial velocity in y direction
    def __init__(self, s_prime, Fx_prime, Fy_prime, vx_prime, vy_prime):
        self.__s = s_prime
        self.__Fx = Fx_prime
        self.__Fy = Fy_prime
        self.__vx = vx_prime
        self.__vy = vy_prime

    ## @brief gets the shape of the body
    #  @return value representing the shape of the body
    def get_shape(self):
        return self.__s

    ## @brief gets the unbalanced forces of the body in the x and y direction
    #  @return value of the unbalanced forces in the x direction
    def get_unbal_forces(self):
        return self.__Fx, self.__Fy

    ## @brief gets the initial velocity of the body in the x and y direction
    #  @return value of initial velocity in the x direction
    def get_init_velo(self):
        return self.__vx, self.__vy

    ## @brief sets the shape of the body
    #  @param s_prime value representing the shape
    def set_shape(self, s_prime):
        self.__s = s_prime

    ## @brief sets the unbalanced forces of the body
    #  @param Fx_prime value unbalanced force function in x direction
    #  @param Fy_prime value unbalanced force function in y direction
    def set_unbal_forces(self, Fx_prime, Fy_prime):
        self.__Fx = Fx_prime
        self.__Fy = Fy_prime

    ## @brief sets the initial velocity of the body
    #  @param vx_prime value representing initial velocity in x direction
    #  @param vy_prime value representing initial velocity in y direction
    def set_init_velo(self, vx_prime, vy_prime):
        self.__vx = vx_prime
        self.__vy = vy_prime

    ## @brief simulates the  solution to the ode function to simulate motion
    #  @param t_final value representing the final time
    #  @param n_steps value representing the number of steps to divide the time interval
    def sim(self, t_final, nsteps):
        ## @brief calculates the resulting ode of the input
        #  @return solution to resulting ode
        def __ode__(w, t):
            return [w[2], w[3],
                    self.__Fx(t) / self.__s.mass(), self.__Fy(t) / self.__s.mass()]

        t = []
        for i in range(0, nsteps):
            t.append((i * t_final) / (nsteps - 1))

        return t, integrate.odeint(__ode__, [self.__s.cm_x(), self.__s.cm_y(),
                                           self.__vx, self.__vy], t)
