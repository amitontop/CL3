
					a1.py

import time
import unittest
class MyTest(unittest.TestCase):
	def setUp(self):
		self.binary_2=List([1,2,3,4,5,10],10)
	def test_0(self):
		self.assertEqual(self.binary_2.binary_search(),5)
	def test_1(self):
		self.assertEqual(self.binary_2.binary_search_nonrecursive(),5)
	def test_2(self):
		self.assertEqual(self.binary_2.linear_search(),5)


class List:
	def __init__(self,asdf,key):
		self.a = asdf
		self.low=0
		self.high=len(asdf)-1
		self.key=key

	def sort_list(self):
		print("\nBefore sorted array is: ")
		print(self.a)
		for k in range(len(self.a)-1,0,-1):
			for i in range(k):
				if(self.a[i]>self.a[i+1]):
					self.a[i+1],self.a[i]=self.a[i],self.a[i+1]
		print("\nAfter sorted array is: ")
		print(self.a)

	def binary_search(self):
		mid=int((self.low+self.high)/2)
		if(mid>self.high or mid<self.low):
			return len(self.a)

		elif(self.a[mid]==self.key):
			return mid
	
		elif(self.a[mid]<self.key):
			self.low=mid+1

		elif(self.a[mid]>self.key):
			self.high=mid-1
		return self.binary_search()

	def binary_search_nonrecursive(self):
		while self.low<=self.high:
			mid=(self.low+self.high)//2
			if(self.a[mid]==self.key):
				return mid

			elif(self.a[mid]<self.key):
				self.low=mid+1

			elif(self.a[mid]>self.key):
				self.high=mid-1 
		return len(self.a)

	def linear_search(self):
		a=self.a
		j=-1
		for i in range(len(a)):
			if a[i]==self.key:
				j=i
				break
		return j			

def main():
	choice=int(input("1. Binary search with recursion\n2. Binary search without recursion\n3. Linear search\nEnter your Choice: "))
	filename=raw_input("Enter filename: \n")
	key=int(input("Enter key to be searched: \n"))
	asdf=[]
	with open(filename, 'r') as f:
		while True:
			line = f.readline()
			if not line:
				break
			asdf.append(int(line))

	bsObj=List(asdf,key)
	bsObj.sort_list()
	if choice==1:
		asdf=bsObj.binary_search()
	elif choice==2:
		asdf=bsObj.binary_search_nonrecursive()	
	elif choice==3:
		asdf=bsObj.linear_search()
	print(asdf)
	print("***********************")
main()
print("testing output: ")
unittest.main()



						inputa.txt

10
20
80
1
5
100
