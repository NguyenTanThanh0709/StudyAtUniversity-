from unittest import result


day = int(input("Enter a day : "))
month = int(input("Enter a month : "))
year = int(input("Enter a year : "))

def  masterNumber(day, month, year):
    masterNumber1 = 0
    while day:
        masterNumber1 += day%10;
        day//=10

    while month:
        masterNumber1 += month%10;
        month//=10

    while year:
        masterNumber1 += year%10;
        year//=10
    if masterNumber1 > 11:
        hihi = 0
        while masterNumber1:
            hihi += masterNumber1 % 10
            masterNumber1 //= 10
        if hihi <= 11:
            return hihi
        
    if hihi> 11:
        haha = 0
        while hihi:
            haha += hihi % 10
            hihi //= 10
    
        return haha


    return masterNumber1

def  personNumber(day, month, year):
    year =2022
    masterNumber1 = 0
    while day:
        masterNumber1 += day%10;
        day//=10

    while month:
        masterNumber1 += month%10;
        month//=10

    while year:
        masterNumber1 += year%10;
        year//=10
    if masterNumber1 > 11:
        hihi = 0
        while masterNumber1:
            hihi += masterNumber1 % 10
            masterNumber1 //= 10
        if hihi <= 11:
            return hihi
        
    if hihi> 11:
        haha = 0
        while hihi:
            haha += hihi % 10
            hihi //= 10
    
        return haha


    return masterNumber1

def totalDigitsOfNumber(n):
    total = 0
    while (n > 0):
        total = total + n % 10
        n = int(n / 10)
    return total

def destinyNumber(Name):
    destinyNumber1 = 0
    for i in Name:
        if i =='A' or i == 'J' or i == 'S':
            destinyNumber1 += 1
        if i =='B' or i == 'K' or i == 'T':
            destinyNumber1 += 2
        if i =='C' or i == 'L' or i == 'U':
            destinyNumber1 += 3
        if i =='D' or i == 'M' or i == 'V':
            destinyNumber1 += 4
        if i =='E' or i == 'N' or i == 'W':
            destinyNumber1 += 5
        if i =='F' or i == 'O' or i == 'X':
            destinyNumber1 += 6
        if i =='G' or i == 'P' or i == 'Y':
            destinyNumber1 += 7
        if i =='H' or i == 'Q' or i == 'Z':
            destinyNumber1 += 8
        if i =='I' or i == 'R':
            destinyNumber1 += 9
    
        
    if(destinyNumber1 <= 9 or destinyNumber1 == 11 or destinyNumber1 == 22):
        return destinyNumber1
    else:
        return totalDigitsOfNumber(destinyNumber1)


def impressionNumber(Name):
    soulNumber1 = 0
    for i in Name:
        
            if i =='A' or i == 'J' or i == 'S':
                soulNumber1 += 1
            if i =='B' or i == 'K' or i == 'T':
                soulNumber1 += 2
            if i =='C' or i == 'L' or i == 'U':
                soulNumber1 += 3
            if i =='D' or i == 'M' or i == 'V':
                soulNumber1 += 4
            if i =='E' or i == 'N' or i == 'W':
                soulNumber1 += 5
            if i =='F' or i == 'O' or i == 'X':
                soulNumber1 += 6
            if i =='G' or i == 'P' or i == 'Y':
                soulNumber1 += 7
            if i =='H' or i == 'Q' or i == 'Z':
                soulNumber1 += 8
            if i =='I' or i == 'R':
                soulNumber1 += 9
    
    if soulNumber1 > 11:
        return totalDigitsOfNumber(soulNumber1)
    else:
        return soulNumber1




listthanSoHoc = {2:"Nh???y c???m, tr???c gi??c cao, Ngh??? Thu???t, ??t tham v???ng",
             3:"t?? duy t???t, gi???i ????nh gi??, h??i h?????c, v?? c??ng l?? tr??",
             4:"sang ch???nh, ki???m ti???n, th???c t???, truy???n th???ng",
             5:"y??u t??? do, nh???y c???m, t??nh th????ng, ngh??? thu???t, l??ng m???n",
             6:"s??ng t???o, c???ng hi???n, m???nh m???, bao dung",
             7:"tr???i nghi???m, n???i lo???n, h???c h???i t???t",
             8:"t??? tin, kinh doanh t???t, c?? t??nh m???nh",
             9:"ho??i b??o l???n, tr???i nghi???m, nghi??m t??c",
             10:"???????c nhi???u ng?????i y??u th??ch, l???c quan, th???ng th???n, linh ho???t",
             11:"t??m linh m???nh, tinh t???, c??i ?????p, nh???y c???m, ch??n th???t"}



thansoHoc = masterNumber(day, month, year)
ThanSoHoc2 = personNumber(day, month, year)
print("CAU A: ")
print(thansoHoc)
print(listthanSoHoc[thansoHoc])

print("CAU B: ")
print("th???n s??? h???c l?? : ",ThanSoHoc2)

print("C??u C: ")
#destinyNumber("Nguyen Van Huy")
print(destinyNumber("NGUYEN VAN HUY"))

print("CAU E : ")
print(impressionNumber("HUY"))






