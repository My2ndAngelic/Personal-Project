# Import the required modules
import numpy as np
from run_kut4 import *
import pylab

def G2(x,y):
    G2=np.zeros(2)
    G2[0]=y[1]
    G2[1]=-np.sin(y[0])+0.02*np.cos(y[0])*np.sin(x)
    return G2
x2=0.0
xstop2=40.0
y2=np.array([0.0,0.0])
h2=0.1#step size
#freq=1

X2,Y2=integrate(G2,x2,y2,xstop2,h2)

#pylab.plot(Y2[:,0],Y2[:,1])
pylab.xlabel('θ')
pylab.ylabel('dθ/dx')
pylab.title('Phase space trajectory (resonant case)')
pylab.show()

pylab.quiver(Y2[:-1,0], Y2[:-1,1], Y2[1:,0]-Y2[:-1,0], Y2[1:,1]-Y2[:-1, 1])
pylab.xlabel('θ')
pylab.ylabel('dθ/dx')
pylab.title('Phase space trajectory (resonant case)')
pylab.show()