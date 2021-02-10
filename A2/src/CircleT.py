## @file CircleT.py
#  @author Cassidy Baldin
#  @brief Contains a module for a circle
#  @date February 12th, 2021


from Shape import Shape


##  @brief CircleT is used as a constructor for a circle
class CircleT():
    ## @brief constructor for method CircleT
    #  @details 
    #  @param xs value representing the x value of the center of mass
    #  @param ys value representing the y value of the center of mass
    #  @param rs value representing the radius of the circle
    #  @param ms value representing mass of circle
    #  @return value representing 
    def __init__(self, xs, ys, rs, ms):
    	self.x = xs
    	self.y = ys
    	self.r = rs
    	self.m = ms

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
   		return (self.m * self.r**2)/2
