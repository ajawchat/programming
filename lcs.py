# Ajinkya Awchat

def getLCS(A,B):
    # Initialize the 2D array
    LCS = list()

    m = len(A)+1
    n = len(B)+1

    for i in range(m):
        LCS.append(list())
        LCS[i] = [None  for j in range(n)]

        

    for i in range(0,n):
        LCS[0][i] = 0

    for j in range(0,m):
        LCS[j][0] = 0

    aFlag = None
    bFlag = None

    seq = []

    for i in range(1,m):
        for j in range(1,n):
            if A[i-1] == B[j-1]:
                LCS[i][j] = 1 + LCS[i-1][j-1]
                if (i > aFlag) and (j > bFlag):
                    seq.append(A[i-1])
                    aFlag = i
                    bFlag = j
            else:
                LCS[i][j] = max(LCS[i-1][j] , LCS[i][j-1])
        


    
    print "The longest common subsequence is ","".join(seq)," of length ",len(seq)
    

#main

A = [char for char in "GTCGTTCGGAATGCCGTTGCTCTGTAAA"]
B= [char for char in "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"]


getLCS(A,B)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
