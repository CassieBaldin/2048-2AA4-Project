## @file test_driver.py
#  @author Cassidy Baldin
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date January 21st, 2021

from complex_adt import ComplexT
from triangle_adt import TriangleT#, TriType

###TEST CASES FOR COMPLEX_ADT.PY
complex_test_pass_count = 0
complex_test_fail_count = 0
complex_test_total = 0
a = ComplexT(3.0, 4.0)
b = ComplexT(1.5, -2.0)
c = ComplexT(-2.0, 3.0)

#get_real
if (a.real() == 3.0):
    print("real test passes")
    complex_test_pass_count += 1
else:
    print("real test FAILS")
    complex_test_fail_count += 1
complex_test_total += 1

#get_imag
if (a.imag() == 4.0):
    print("imag test passes")
    complex_test_pass_count += 1
else:
    print("imag test FAILS")
    complex_test_fail_count += 1
complex_test_total += 1

#get_r
if (a.get_r() == 5.0):
    print("r test passes")
    complex_test_pass_count += 1
else:
    print("r test FAILS")
    complex_test_fail_count += 1
if (b.get_r() == 2.5):
    print("r test2 passes")
    complex_test_pass_count += 1
else:
    print("r test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2 

#get_phi
if (a.get_phi() == 0.9272952180016122):
    print("phi test passes")
    complex_test_pass_count += 1
else:
    print("phi test FAILS")
    complex_test_fail_count += 1
if (b.get_phi() == -0.9272952180016122):
    print("phi test2 passes")
    complex_test_pass_count += 1
else:
    print("phi test2 FAILS")
    complex_test_fail_count += 1
if (c.get_phi() == 2.1587989303424644):
    print("phi test3 passes")
    complex_test_pass_count += 1
else:
    print("phi test3 FAILS")
    complex_test_fail_count += 1
complex_test_total += 3

#equal
if ((a.equal(ComplexT(3.0,4.0))) == True):
    print("equal test passes")
    complex_test_pass_count += 1
else:
    print("equal test FAILS")
    complex_test_fail_count += 1
if ((a.equal(ComplexT(1, 1))) == False):
    print("equal test2 passes")
    complex_test_pass_count += 1
else:
    print("equal test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#conj
a_conj = a.conj() 
b_conj = b.conj()
if (a_conj.equal(ComplexT(3, -4))):
    print("conj test passes")
    complex_test_pass_count += 1
else:
    print("conj test FAILS")
    complex_test_fail_count += 1
if (b_conj.equal(ComplexT(1.5, 2))):
    print("conj test2 passes")
    complex_test_pass_count += 1
else:
    print("conj test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#add
add_ab = a.add(b)
add_ac = a.add(c)
if (add_ab.equal(ComplexT(4.5, 2.0))):
    print("add test passes")
    complex_test_pass_count += 1
else:
    print("add test FAILS")
    complex_test_fail_count += 1
if (add_ac.equal(ComplexT(1.0, 7.0))):
    print("add test2 passes")
    complex_test_pass_count += 1
else:
    print("add test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#sub
sub_ab = a.sub(b)
sub_ac = a.sub(c)
if (sub_ab.equal(ComplexT(1.5, 6.0))):
    print("sub test passes")
    complex_test_pass_count += 1
else:
    print("sub test FAILS")
    complex_test_fail_count += 1
if (sub_ac.equal(ComplexT(5.0, 1.0))):
    print("sub test2 passes")
    complex_test_pass_count += 1
else:
    print("sub test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

###TEST CASES FOR TRIANGLE_ADT.PY
triangle_test_pass_count = 0
triangle_test_fail_count = 0
triangle_test_total = 0

#####END Of TESTS#####
print()
print("Complex Tests Summary")
if complex_test_total == complex_test_pass_count:
    print("Congrats! All complex_adt.py tests passed")
print("Passed: ", complex_test_pass_count, " Failed: ", complex_test_fail_count)
print("Score: ", complex_test_pass_count, "/", complex_test_total)

print()
print("Triangle Tests Summary")
if triangle_test_total == triangle_test_pass_count:
    print("Congrats! All triangle_adt.py tests passed")
print("Passed: ", triangle_test_pass_count, " Failed: ", triangle_test_fail_count)
print("Score: ", triangle_test_pass_count, "/",triangle_test_total)