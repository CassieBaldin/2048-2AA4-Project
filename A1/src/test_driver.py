## @file test_driver.py
#  @author Cassidy Baldin
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date January 21st, 2021

#some code taken from test_expt.py

from complex_adt import ComplexT
from triangle_adt import TriangleT#, TriType

###TEST CASES FOR COMPLEX_ADT.PY
complex_test_pass_count = 0
complex_test_fail_count = 0
complex_test_total = 0
a = ComplexT(3.0, 4.0)
b = ComplexT(1.5, -2.0)
c = ComplexT(-2.0, 3.0)

#real
if (a.real() == 3.0):
    print("real test passes")
    complex_test_pass_count += 1
else:
    print("real test FAILS")
    complex_test_fail_count += 1
complex_test_total += 1

#imag
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
if ((a.equal(ComplexT(3.0,4.0)))):
    print("complex equal test passes")
    complex_test_pass_count += 1
else:
    print("complex equal test FAILS")
    complex_test_fail_count += 1
if ((a.equal(ComplexT(1, 1))) == False):
    print("complex equal test2 passes")
    complex_test_pass_count += 1
else:
    print("complex equal test2 FAILS")
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

#mult
mult_ab = a.mult(b)
mult_ac = a.mult(c)
if (mult_ab.equal(ComplexT(12.5, 0))):
    print("mult test passes")
    complex_test_pass_count += 1
else:
    print("mult test FAILS")
    complex_test_fail_count += 1
if (mult_ac.equal(ComplexT(-18.0, 1.0))):
    print("mult test2 passes")
    complex_test_pass_count += 1
else:
    print("mult test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#recip
recip_a = a.recip()
recip_b = b.recip()
if (recip_a.equal(ComplexT(0.12, -0.16))):
    print("recip test passes")
    complex_test_pass_count += 1
else:
    print("recip test FAILS")
    complex_test_fail_count += 1
if (recip_b.equal(ComplexT(0.24, 0.32))):
    print("recip test2 passes")
    complex_test_pass_count += 1
else:
    print("recip test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#div
div_ab = a.div(b)
div_ac = a.div(c)
if (div_ab.equal(ComplexT(-0.56, 1.92))):
    print("div test passes")
    complex_test_pass_count += 1
else:
    print("div test FAILS")
    complex_test_fail_count += 1
if (div_ac.equal(ComplexT(0.46153846153846156, -1.3076923076923077))):
    print("div test2 passes")
    complex_test_pass_count += 1
else:
    print("div test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

#sqrt
sq_a = a.sqrt()
sq_b = b.sqrt()
if (sq_a.equal(ComplexT(2.0, 1.0))):
    print("sqrt test passes")
    complex_test_pass_count += 1
else:
    print("sqrt test FAILS")
    complex_test_fail_count += 1
if (sq_b.equal(ComplexT(1.4142135623730951, -0.7071067811865476))):
    print("sqrt test2 passes")
    complex_test_pass_count += 1
else:
    print("dsqrt test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

###TEST CASES FOR TRIANGLE_ADT.PY
triangle_test_pass_count = 0
triangle_test_fail_count = 0
triangle_test_total = 0
t1 = TriangleT(3, 4, 5)
t2 = TriangleT(4, 3, 5)
t3 = TriangleT(1, 4, 3)

#get_sides
if (t1.get_sides() == (3, 4, 5)):
    print("side test passes")
    triangle_test_pass_count += 1
else:
    print("side test FAILS")
    triangle_test_fail_count += 1
triangle_test_total += 1

#equal
if (t1.equal(t2)):
   print("triangle equal test passes")
   triangle_test_pass_count += 1
else:
   print("triangle equal test FAILS")
   triangle_test_fail_count += 1
if (t1.equal(t3) == False):
   print("triangle equal test2 passes")
   triangle_test_pass_count += 1
else:
   print("triangle equal test2 FAILS")
   triangle_test_fail_count += 1
triangle_test_total += 2

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