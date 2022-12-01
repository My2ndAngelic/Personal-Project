k=5;
spacing = 0.2;
[x, y] = meshgrid(-3:spacing:3);
% define ODE:
dy = k*x;
dx = -k*y;
Z = X.*exp(-X.^2 - Y.^2);
[DX,DY] = gradient(Z,spacing);
% normalizes vectors
norm_factor = sqrt(dx.^2 + dy.^2);
dy_norm = dy./norm_factor;
dx_norm = dx./norm_factor;

quiver(x, y, dx_norm, dy_norm);