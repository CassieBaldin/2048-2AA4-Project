## @file Plot.py
#  @author Cassidy Baldin
#  @brief Contains a module for plotting
#  @date February 12th, 2021

from matplotlib.pyplot import *

def Plot(w, t):
    ## @brief does somethin **FIX
    #  @details Assumes that the sequence will be built in order of increasing i values.
    
    if not (len(w) == len(t)):
        raise ValueError

    for i in range(len(w)):
        x = w[i][0]
        y = w[i][1]

        figure(dpi=100)
        plot(x, t)
        figure(dpi=100)
        plot(y, t)
        figure(dpi=100)
        plot(y, x)

    show()
