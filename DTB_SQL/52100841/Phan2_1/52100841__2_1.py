fread = open("input.txt", "r")
count = 0
table = ""

tableName = ""

listTable = dict()

for x in fread:
    if(('{'   in x )  or ('}'  in x) or ("]," in x)):
        continue
    if("CAC_THUC_THE" in x):
        count = 2
        continue

    if("CAC_MOI_QUAN_HE" in x):
        count = 1
        table += "\n<<<<<<<<<< Mỗi quan hệ giữa các thực thể >>>>>>>>>>\n\n"
        continue

    if(count == 1):
        table = table + "\t" + x.strip().replace("\"","").replace("'","") + "\n\n"

    if(count == 2):
        data = x.strip().replace("\n", "")
        tableName = data[(data.find("\"")+1):(data.rfind("\""))]
        listItemTable = data[(data.find("[")+1):(data.rfind("]"))]
        listItemTable = listItemTable.split(", ")
        for i in range(len(listItemTable)):
            listTable.setdefault(tableName, []).append(listItemTable[i])
    
    if(count == 1):
        data = x.strip()
        relationShip = data[(data.find("<")+1):(data.find(">"))]
        tableName_1 = data[(data.find("\"")+1):(data.rfind("\""))]
        tableName_2 = data[(data.find("'")+1):(data.rfind("'"))]


        if("CHA_CON" in relationShip):
            for i in listTable[tableName_2]:
                if("PK__" in i):
                    i =  "FK__" + i + "   REFERENCES   " + tableName_2
                    listTable.setdefault(tableName_1, []).append(i)
                    break
        elif("DATRI" in relationShip):
            for i in listTable[tableName_2]:
                if("PK__" in i):
                    i =  "FK__" + i + "   REFERENCES   " + tableName_2
                    listTable.setdefault(relationShip, []).append(i)
                    break
        else:
            quanHe_1 = data[(data.find("(")+1):(data.find(")"))]
            quanHe_2 = data[(data.rfind("(")+1):(data.rfind(")"))]
            # print(quanHe_1, quanHe_2)
            if("1,n" in quanHe_1 and "1,1" in quanHe_2):
                for k in listTable[tableName_2]:
                    x = k.replace("PK", "FK") +  "   REFERENCES   " + tableName_2
                    listTable.setdefault(tableName_1, []).append(x)
                    break
            elif("1,n" in quanHe_2 and "1,1" in quanHe_1):
                for k in listTable[tableName_1]:
                    if("PK" in k):
                        x = k.replace("PK", "FK") +  "   REFERENCES   " + tableName_1
                        listTable.setdefault(tableName_2, []).append(x)
                        break
            elif("1,1" in quanHe_2 and "1,1" in quanHe_1):
                for k in listTable[tableName_2]:
                    if("PK" in k):
                        x = k.replace("PK", "FK") +  "   REFERENCES   " + tableName_2
                        listTable.setdefault(tableName_1, []).append(x)
                        break
            elif("1,n" in quanHe_2 and "1,n" in quanHe_1):
                for k in listTable[tableName_2]:
                    if("PK" in k):
                        x = "FK__" + k +  "   REFERENCES   " + tableName_2
                        listTable.setdefault(relationShip, []).append(x)
                        break
                for k in listTable[tableName_1]:
                    if("PK" in k):
                        x = "FK__" + k +  "   REFERENCES   " + tableName_1
                        listTable.setdefault(relationShip, []).append(x)
                        break

table = table.replace("]", "")

table += "<<<<<<<<<< Danh sách bảng của các thực thể >>>>>>>>>>\n\n"

for x in listTable:
    table += "\tBảng  " + x + ":"
    for y in range(len(listTable[x])-1):
        if(listTable[x][y] == ''):
            continue
        table  = table + "\n\t\t\t" + listTable[x][y]
    table  = table + "\n\t\t\t" + listTable[x][len(listTable[x])-1] + "\n\n\n"


# print(listTable)
with open('output.txt', 'w', encoding='utf-8') as f:
    f.write(table)

fread.close()
f.close()