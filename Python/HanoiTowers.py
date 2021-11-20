
towers = []
n = int(input())
moveCount = 0

def InitializeHanoi(n):
    tower1 = list(range(n,0,-1))
    tower2 = list([0]*n)
    tower3 = list([0]*n)

    global towers
    towers.append(tower1)
    towers.append(tower2)
    towers.append(tower3)

def PrintTowers():
    for i in range(3):
        tmp = f"Tower {i+1}: "
        for j in range(n):
            x = towers[i][j]
            if x != 0:
                tmp += str(x) + " "
        print(tmp)
    print()

def Swap(a , b):
    global moveCount
    #Transfer from a tower to b tower
    if(towers[a][0] == 0 or towers[b][n-1] != 0):
        return


    #Indexing of Tower A
    if(towers[a][n-1] != 0):
        IndexA = n-1
    
    else:
        for x in range(0,n-1,1):
            if(towers[a][x] != 0 and towers[a][x+1] == 0):
                IndexA = x
                break


    #Indexing of Tower B
    if(towers[b][0] == 0):
        IndexB = 0
    
    else:
        for x in range(0,n-1,1):
            if(towers[b][x] != 0 and towers[b][x+1] == 0):
                IndexB = x+1
                break

    if IndexB != 0:
        if towers[b][IndexB-1] < towers[a][IndexA]:
            return   


    towers[b][IndexB] = towers[a][IndexA]
    towers[a][IndexA] = 0
    PrintTowers()
    moveCount += 1


def SolveHanoi(diskCount, source, secondary, destination):

    if(diskCount == 1):
        Swap(source,destination)
    else:
        SolveHanoi(diskCount-1, source, destination, secondary)

        Swap(source,destination)

        SolveHanoi(diskCount-1, secondary, source, destination)



InitializeHanoi(n)
PrintTowers()

SolveHanoi(n,0,1,2)

print("Movement Count: " + str(moveCount))


input()