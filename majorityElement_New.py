
def majorityElement(num):
    N = len(num)
    if N == 1:
        print num[0]
        return num[0]
    elif N > 1:
        k = N/2
        resLeft = majorityElement(num[0:k])
        resRight = majorityElement(num[k:N])

        print resLeft
        print resRight
        
        if(resLeft == resRight):
            return resLeft
        else:
            #Get the count of each element
            counts = getFreq(num,resLeft,resRight)
            if counts[0] > N/2 and counts[0] != "nm":
                return resLeft
            elif counts[1] > N/2 and counts[1] != "nm":
                return resRight
            else:
                return "nm"
                
                
            
            
def getFreq(num,resLeft,resRight):
    counts = [0,0]
    if resLeft == "nm":
        counts[0] = "nm"
        for elem in num:
            if elem == resRight:
                counts[1] += 1
    if resRight == "nm":
        counts[1] == "nm"
        for elem in num:
            if elem == resLeft:
                counts[0] += 1
    if resLeft != "nm" and resRight != "nm":
        for elem in num:
            if elem == resLeft:
                counts[0] += 1
            elif elem == resRight:
                counts[1] += 1
            
    return counts        
    

#MAIN
print majorityElement([2,2])
