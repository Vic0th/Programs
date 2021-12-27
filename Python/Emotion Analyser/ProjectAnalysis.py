from snowballstemmer import stemmer
import pandas as pan
import re
# -*- coding: utf-8 -*-



#Furkan Sayan
#20360859093



st = stemmer("turkish")
punc = ",.;:'""?/\\-_!`İ"
spaces = " " * (len(punc)-1) + "i"


#Girdi olarak verilen cümle noktalama işaretlerinden arındırılır,
#tamamı küçük harflere çevrilir ve kelimelerine ayrılarak bir liste haline çevrilir.
def slicer(inp):
    inp = inp.translate(inp.maketrans(punc,spaces))
    inp = inp.lower()
    inp = inp.split()
    return inp



#Kelimenin duygu analizi yapılır.
#Kelime tüm kelimelerin olduğu excel dosyasında aranır ve eğer bulunursa içerdiği duygu,
#yoksa nötr yani 0 döndürülür.
def emotionizer(st):
    x = len(wordList["olumlu isim&sıfat"])
    for i in range(x):
        for j in range(4):
            tm = wordList.iloc[i][j]
            if tm is None:
                continue
            elif st == tm:
                #if j > 2:
                if j > 1:
                    return -1
                else:
                    return 1
    return 0



#Her bir cümlenin duygu analizin yapıldığı fonksiyondur.
#Girilen cümle slicer fonksiyonu ile kelimelerine ayrılır ve stemWords fonksiyonu ile kökleri alınır.
#Sonra döngü ile cümledeki tüm kökü alınan kelimelerin duygu analizi yapılır.
#Eğer kelime negatif bir ek içeriyorsa halihazırdaki duygu tahminin tersi,
#eğer halihazırda bir duygu tahmini yoksa duygu tahmini negatif olarak düzenlenir.
def proc(sent):
    sliced = slicer(sent)
    stemmed = st.stemWords(sliced)

    #print(stemmed)

    emot = 0


    for i in range(len(stemmed)):
        t = emotionizer(stemmed[i])

        #Burada gelen duygu tahminini direk atama yapmamamızın sebebi,
        #tahmin nötr gelirse cümlenin duygu tahminine etki etmemesi gerekmesidir.
        if t > 0:
            emot = 1
        elif t < 0:
            emot = -1

        #Kelimede negatif çekim eki aranır veya kelimenin negatif olank değil kelimesi olup olmadığı aranır.
        if re.search("..+(me|ma|mı|mi)...?.?.?.?",stemmed[i]) or "değil" in stemmed[i]:
            emot *= -1
            if emot == 0:
                emot = -1
            break

    return emot



#Bu fonksiyon excel dosyasındaki tüm cümleleri döngü ile gezer,
#her birinin duygusunu proc fonksiyonu ile alır.
#Her bir duygudaki cümle sayısını ve o duygudaki doğru tahmin edilen cümle sayısını hesaplar.
#En sonunda ise tüm doğru tahminlerin sayısını tüm cümlelerin sayısına bölerek programın
#çalışma doğruluğunun yüzdesi hesaplanarak kullanıcıya çıktı alınır.
def final():
    res = [[0,0],[0,0],[0,0]]
    y = list(senList)

    z = len(senList[y[0]])

    prev = 0
    
    for i in range(z):

        #Tahmini yapılan cümle sayısının tüm cümlelere olan yüzdeliği ekrana yazdırılarak
        #işlemin ne kadarının gerçekleştiği çıktı alınır.
        if int(i/z*100) != prev:
            prev = int(i/z*100)
            print(f"{prev}% completed")


        em = proc(senList.iloc[i][0])
        
        veril = senList.iloc[i][1].lower()

        if veril == "pozitif":
            veril = 1
        
        elif veril == "negatif":
            veril = -1
        
        else:
            veril = 0

        ###################
        #print(f"{i+2} | Org:{veril} - Pred:{em}", end=" ")

        if em == veril:
            res[em+1][0] += 1
            
        #else:
            #print("///False///", end=" ")
        res[veril+1][1] += 1
        #print("\n")
        

    print("Process is complete.\n")

    #Burada ise her bir duygunun doğru tahmin oranları çıktı alınır.
    print(f"Positive: {res[2][0]}/{res[2][1]}")
    print(f"Neutral: {res[1][0]}/{res[1][1]}")
    print(f"Negative: {res[0][0]}/{res[0][1]}")
    print()

    #Tüm duygular hesaba katarak asıl başarılı tahmin oranı çıktılanır.
    a = res[2][0] + res[1][0] + res[0][0]
    b = res[2][1] + res[1][1] + res[0][1]
    print(f"Success Rate: {a/b*100}%")



#wordList değişkeni ile tüm kelimelerin olduğu excel dosyası açılır.
wordList = pan.read_excel("Kelimeler ve Sınıflar.xlsx")

#senList değişkeni ile tüm cümlelerin olduğu excel dosyası açılır.
senList = pan.read_excel("ornek_duygu-analizi-verisi.xlsx")

#final fonksiyonu ile cümelelerin olduğu excel dosyasının tamamının duygu analizi yapılır.
final()

#Eğer sadece bir cümlenin duygu analizi ise aşağıdaki gibi yapılabilir.
"""
exSen = input()
sw = ["Negatif","Nötr","Pozitif"]
print(sw[proc(exSen)+1])
"""


input()