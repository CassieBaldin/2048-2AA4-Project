## @file Plot.py
#  @author Cassidy Baldin
#  @brief Contains a module for plotting
#  @date February 12th, 2021

from matplotlib.pyplot import *


def plot(w, t):
    ## @brief does something **FIX
    #  @details Assumes that the sequence will be built in order of increasing i values.
    if not (len(w) == len(t)):
        raise ValueError

    x, y = [], []

    for i in range(0, len(w)):
        x.append(w[i][0])
        y.append(w[i][1])

    fig, (ax1, ax2, ax3) = subplots(3)
    fig.suptitle("Motion Simulation")
    ax1.plot(t, x)
    ax1.set(ylabel="x(m)")
    ax2.plot(t, y)
    ax2.set(ylabel="y(m)")
    ax3.plot(x, y)
    ax3.set(ylabel="y(m)")
    ax3.set(xlabel="x(m)")
    show()
