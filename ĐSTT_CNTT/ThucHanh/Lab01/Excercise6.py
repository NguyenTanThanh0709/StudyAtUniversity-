#Write a program to convert a distance with units of either kilometers, meters, centimeters, or milimeters into meters.
print("1.km->m")
print("2.m->m")
print("3.cm->m")
print("4.mm->m")

choose = int(input("Enter your choose : "))


if choose == 1:
    km = float(input("Enter a number km : "))
    m = km * 1000
    print(m)
elif choose == 2:
    m = float(input("Enter a number m : "))
    print(m)
elif choose == 3:
    cm = float(input("Enter a number cm : "))
    m = cm / 100
    print(m)
elif choose == 4:
    mm = float(input("Enter a number mm : "))
    m = mm / 1000
    print(m)