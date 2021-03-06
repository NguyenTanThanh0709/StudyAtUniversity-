import numpy as np

A = np.array([[0.61,0.29,0.15],[0.35,0.59,0.063],[0.04,0.12,0.787]])

# Red: X = 0.64, Y = 0.33, Z = 0.03
# Green: X = 0.29, Y = 0.60, Z = 0.15
# Blue: X = 0.15, Y = 0.06, Z = 0.79

# X = 0.412453 * R + 0.357580 * G + 0.180423 * B
# Y = 0.212671 * R + 0.715160 * G + 0.072169 * B
# Z = 0.019334 * R + 0.119193 * G + 0.950227 * B

X = 0.64
Y = 0.33
Z = 0.03

R = 3.240479 * X - 1.537150 * Y - 0.498535 * Z
G = -0.969256 * X + 1.875992 * Y + 0.041556 * Z
B = 0.055648 * X - 0.204043 * Y + 1.057311 * Z

L = (X + Y + Z) / 3