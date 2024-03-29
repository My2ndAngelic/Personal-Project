## module run_kut4

import numpy as np
def integrate(F,x,y,xStop,h):
    K0 = h * F(x, y)
    K1 = h * F(x + h / 2.0, y + K0 / 2.0)
    K2 = h * F(x + h / 2.0, y + K1 / 2.0)
    K3 = h * F(x + h, y + K2)
    return (K0 + 2.0 * K1 + 2.0 * K2 + K3) / 6.0

def run_kut4(F,x,y,h):

    X = []
    Y = []
    X.append(x)
    Y.append(y)
    while x < xStop:
        h = min(h, xStop - x)
        y = y + run_kut4(F,x,y,h)
        x = x + h
        X.append(x)
        Y.append(y)
    return np.array(X),np.array(Y)