## @file test_driver.py
#  @author Cassidy Baldin
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date January 21st, 2021

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType

#TEST CASES FOR COMPLEX_ADT.PY
complex_test_pass_count = 0
complex_test_fail_count = 0
complex_test_total = 0
a = ComplexT(3.0, 4.0)
b = ComplexT(1.5, -2)

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


#####END TEST#####
print()
if complex_test_total == complex_test_pass_count:
	print("Congrats! All tests passed")
print("Passed: ", complex_test_pass_count)
print("Failed: ", complex_test_fail_count)
print("Score: ", complex_test_pass_count, "/", complex_test_total)