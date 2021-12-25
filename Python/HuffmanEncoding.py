def counter(strin):
    dic = {}

    for i in strin:
        if i not in dic:
            dic[i] = 0
        dic[i] = dic[i] + 1

    dic = dict(sorted(dic.items(),key = lambda x:x[1], reverse=True))
    return dic


class tree:
    def __init__(self):
        self.ch = None
        self.leftChild = None   
        self.rightChild = None

    def addLeft(self,child):
        self.leftChild = child

    def addRight(self,child):
        self.rightChild = child


def makeDict(text):
    counts = counter(text)

    theTree = tree()
    brn = theTree

    max = len(counts)
    count = 0
    
    for i in counts:
        if count == max-1:
            brn.ch = i[0]
            break
        count += 1
        brn.addLeft(tree())
        brn.leftChild.ch = i[0]
        brn.addRight(tree())
        brn = brn.rightChild
    

    dic = {}
    brn = theTree
    code = ""

    while True:
        if brn.rightChild is None:
            dic[brn.ch] = code[:-1] + "1"
            break
        dic[brn.leftChild.ch] = code + "0"
        code = code + "1"
        brn = brn.rightChild
    return counts , dic
    

def huffmanCoding(text):
    text = text.lower()

    counts , dic = makeDict(text)
    comp = ""
    for i in range(len(text)):
        comp = comp + str(dic[text[i]])

    return counts, dic, comp


#text = "Yeet the child mate"
text = input()
counts, dic, compressed = huffmanCoding(text)

print(f"\nOriginal Text : \n{text}\n")
print(f"Character Repetitions : \n{counts}\n")
print(f"Codes : \n{dic}\n")
print(f"Compressed Text: \n{compressed}")
