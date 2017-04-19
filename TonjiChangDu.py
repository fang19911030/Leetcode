import numpy as np
import matplotlib.pyplot as plt

f=open("paperTitle.txt","r")

length = [0 for i in range(301)]

for line in f:
	if len(line)>300:
		print("Here is the title longer than 300")
	else:
		length[len(line)]+=1


ind = np.arrange(301)

ax = plt.subplots()

res = ax.bar(ind,length,0.05,color='b')

plt.show()

TESTPI AOHIF OUH 