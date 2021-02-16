## @file Plot.py
#  @author Cassidy Baldin
#  @brief Contains a module for plotting
#  @date February 12th, 2021

from matplotlib.pyplot import *

def Plot(w, t):
    ## @brief does something **FIX
    #  @details Assumes that the sequence will be built in order of increasing i values.

    if not (len(w) == len(t)):
        raise ValueError

    fig, (ax1, ax2, ax3) = subplots(3, sharex=True)
    fig.suptitle("Motion Simulation")
    ax1.plot(w[0], t)
    ax2.plot(w[1], t)
    ax3.plot(w[1], w[0])

    #     tight_layout()  ##to space the axis labels out more if you need to

    show()

#print(Plot([[0, 2, 3, 4],[2, 4, 6, 8]], [1, 2]))
