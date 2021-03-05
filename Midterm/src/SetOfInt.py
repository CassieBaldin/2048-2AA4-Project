## @file SetOfInt.py
#  @author Cassidy Baldin
#  @brief Set of integers
#  @date 03/04/2021

class SetOfInt:

    def __init__(self, xs):
        #self.s is the union of all values in the sequence xs made into a set of ints
        self.s = set(xs)

    def is_member(self, x):
        for i in self.s:
            if x == i:
                return True
        return False
    
    def to_seq(self):
        return self.__set_to_seq__(self.s)
    
    def union(self, t):
        #retuns a new object of the class that is a union of the two sets of ints
        new = self.__set_to_seq__(self.s)
        for i in range(len(t.to_seq())):
            new.append(t[i])

        #where new is the new sequence of ints including all values from s and t
        return SetOfInt(new)

    def size(self):
        return len(self.s)

    def empty(self):
        return self.s == []

    def equals(self, t):
        return self.to_seq() == t.to_seq()

    def __set_to_seq__(self, s):
        return list(s)

    def __complement__(self, a):
        #takes out all members of set that are not ints

        new = {}
        # for i in self.s:
        #     if type(i) == int:
        #         new.add(i)
        return new
