import random

draw=["+---+\n |  |\n    |\n    |\n    |\n    |\n=========\n"    #(0)
     ,"+---+\n |  |\n O  |\n    |\n    |\n    |\n=========\n"    #(1)
     ,"+---+\n |  |\n O  |\n |  |\n    |\n    |\n=========\n"    #(2)    
     ,"+---+\n |  |\n O  |\n/|  |\n    |\n    |\n=========\n"    #(3)
     ,"+---+\n |  |\n O  |\n/|\ |\n    |\n    |\n=========\n"    #(4)
     ,"+---+\n |  |\n O  |\n/|\ |\n/   |\n    |\n=========\n"    #(5)
     ,"+---+\n |  |\n O  |\n/|\ |\n/ \ |\n    |\n=========\n"    #(6)
     ] 

numGuess=0

listWords=["apple", "banana", "cherry", "grape", "strawberry"]
name=random.choice(listWords)

result= ["-"]*len(name)

while (numGuess<6):

  flag= True

  print("The size of the world is "+ str(len(name)))

  print(draw[numGuess])

  print(result)
  print("\n")

  answer=input("please enter your guess: ")
  while(len(answer)>len(name)):
    print("error enter characters less than the size of the world")
    answer=input("please enter your guess: ")

  print("\n","\n")

  if (len(answer)>1):
    j=0
    while(j<len(answer)):
      if (answer[j]==name[j]):
        result[j]=answer[j]
        flag=False
      j=j+1
      

  else:
    j=0
    while (j<len(name)):
      if (answer==name[j]):
        result[j]=answer
        flag=False
      j=j+1
      
    
  print(result)
  print("\n")
  print(draw[numGuess])

  if (flag):
    numGuess=numGuess+1
    
  print("\033c", end='')  # clear console in replit
  if (flag):
    print("mistake ,the word or character ("+ answer +") was not the answer\n")
  else:
    print("good job ("+answer+") was in the word")
  
  result2=" ".join(result)  # make a list string to an string
  if (result2.find("-")==-1):
    print("You have won the answer was "+name)
    break

if(numGuess==6):
  print("You lost the word was "+name)
  print(draw[6])