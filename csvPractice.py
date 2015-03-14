import csv

def writeData(fileName, csv1, headers):
    writer = csv.writer(open(fileName,"wb"))
    writer.writerow(headers)
    
    for row in csv1:
        elements = []
        for elem in headers:
            elements.append(row[elem])
        print elements
        writer.writerow(elements)
        

    


def openFile(fileName):
    fileOpen = open(fileName)
    csvData = csv.DictReader(fileOpen)
    return csvData


def getHeaders(fileName):
    fileOpen = open(fileName).readlines()[0].strip("\n").split(",")
    print fileOpen
    return fileOpen



if __name__ == "__main__":

    #file1 = raw_input("Enter file 1: ")
    #file2 = raw_input("Enter file 2: ")

    csv1 = openFile("data1.csv")
    csv2Headers = getHeaders("data2.csv")

    writeData("sample.csv",csv1, csv2Headers)
