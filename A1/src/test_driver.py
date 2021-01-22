## @file test_driver.py
#  @author Cassidy Baldin
#  @brief Tests for complex_adt.py and triangle_adt.py
#  @date January 21st, 2021

#Citation: some code taken from test_expt.py file

from complex_adt import ComplexT
from triangle_adt import TriangleT, TriType
import math

###TEST CASES FOR COMPLEX_ADT.PY###
complex_test_pass_count = 0
complex_test_fail_count = 0
complex_test_total = 0
a = ComplexT(3.0, 4.0)
b = ComplexT(1.5, -2.0)
c = ComplexT(-2.0, 3.0)
zero_x = ComplexT(0.0, 2.5)
zero_y = ComplexT(2.5, 0.0)

# real
if (a.real() == 3.0):
    complex_test_pass_count += 1
else:
    print("real test FAILS")
    complex_test_fail_count += 1
complex_test_total += 1

# imag
if (a.imag() == 4.0):
    complex_test_pass_count += 1
else:
    print("imag test FAILS")
    complex_test_fail_count += 1
complex_test_total += 1

# get_r
if (a.get_r() == 5.0):
    complex_test_pass_count += 1
else:
    print("r test FAILS")
    complex_test_fail_count += 1
if (b.get_r() == 2.5):
    complex_test_pass_count += 1
else:
    print("r test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2 

# get_phi
if (math.isclose(a.get_phi(), 0.927295218, abs_tol = 0.00000001)):
    complex_test_pass_count += 1
else:
    print("phi test FAILS")
    complex_test_fail_count += 1
if (math.isclose(b.get_phi(), -0.927295218, abs_tol = 0.00000001)):
    complex_test_pass_count += 1
else:
    print("phi test2 FAILS")
    complex_test_fail_count += 1
if (math.isclose(c.get_phi(), 2.158798931, abs_tol = 0.00000001)):
    complex_test_pass_count += 1
else:
    print("phi test3 FAILS")
    complex_test_fail_count += 1
complex_test_total += 3

# equal
eq_float = ComplexT(3.00000000012345, 4.0)
eq_pre = ComplexT(0.3+0.3+0.3, 0)
if ((a.equal(ComplexT(3.0, 4.0)))):
    complex_test_pass_count += 1
else:
    print("complex equal test FAILS")
    complex_test_fail_count += 1
if (a.equal(ComplexT(3.0, -4.0)) == False):
    complex_test_pass_count += 1
else:
    print("complex equal test2 FAILS")
    complex_test_fail_count += 1
# testing zero and float rounding case (should round to true ans)
if (zero_x.equal(ComplexT(0, 2.50000000000000012))):
    complex_test_pass_count += 1
else:
    print("complex equal test3 FAILS")
    complex_test_fail_count += 1
# rounded to 9 decimal places, they should be equal, imag is equal from above
if (math.isclose(a.real(), eq_float.real(), abs_tol = 0.00000001)):
    complex_test_pass_count += 1
else:
    print("complex equal test4 FAILS")
    complex_test_fail_count += 1
# test for float precision error (eq_pre.real() = 0.89999999...)
if (eq_pre.equal(ComplexT(0.9, 0.0))):
    complex_test_pass_count += 1
else:
    print("add/equal test FAILS")
    complex_test_fail_count += 1
complex_test_total += 5

# conj
a_conj = a.conj() 
b_conj = b.conj()
if (a_conj.equal(ComplexT(3.0, -4.0))):
    complex_test_pass_count += 1
else:
    print("conj test FAILS")
    complex_test_fail_count += 1
if (b_conj.equal(ComplexT(1.5, 2.0))):
    complex_test_pass_count += 1
else:
    print("conj test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

# add
add_ab = a.add(b)
add_ac = a.add(c)
if (add_ab.equal(ComplexT(4.5, 2.0))):
    complex_test_pass_count += 1
else:
    print("add test FAILS")
    complex_test_fail_count += 1
if (add_ac.equal(ComplexT(1.0, 7.0))):
    complex_test_pass_count += 1
else:
    print("add test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

# sub
sub_ab = a.sub(b)
sub_ac = a.sub(c)
if (sub_ab.equal(ComplexT(1.5, 6.0))):
    complex_test_pass_count += 1
else:
    print("sub test FAILS")
    complex_test_fail_count += 1
if (sub_ac.equal(ComplexT(5.0, 1.0))):
    complex_test_pass_count += 1
else:
    print("sub test2 FAILS")
    complex_test_fail_count += 1
complex_test_total += 2

# mult
mult_ab = a.mult(b)
mult_ac = a.mult(c)
mult_azx = a.mult(zero_x)
mult_azy = a.mult(zero_y)
if (mult_ab.equal(ComplexT(12.5, 0))):
    complex_test_pass_count += 1
else:
    print("mult test FAILS")
    complex_test_fail_count += 1
if (mult_ac.equal(ComplexT(-18.0, 1.0))):
    complex_test_pass_count += 1
else:
    print("mult test2 FAILS")
    complex_test_fail_count += 1
if (mult_azx.equal(ComplexT(-10.0, 7.5))):
    complex_test_pass_count += 1
else:
    print("mult test3 FAILS")
    complex_test_fail_count += 1
if (mult_azy.equal(ComplexT(7.5, 10))):
    complex_test_pass_count += 1
else:
    print("mult test4 FAILS")
    complex_test_fail_count += 1
complex_test_total += 4

# recip
recip_a = a.recip()
recip_b = b.recip()
recip_zx = zero_x.recip()
recip_zy = zero_y.recip()
if (recip_a.equal(ComplexT(0.12, -0.16))):
    complex_test_pass_count += 1
else:
    print("recip test FAILS")
    complex_test_fail_count += 1
if (recip_b.equal(ComplexT(0.24, 0.32))):
    complex_test_pass_count += 1
else:
    print("recip test2 FAILS")
    complex_test_fail_count += 1
if (recip_zx.equal(ComplexT(0.0, -0.4))):
    complex_test_pass_count += 1
else:
    print("recip test3 FAILS")
    complex_test_fail_count += 1
if (recip_zy.equal(ComplexT(0.4, 0.0))):
    complex_test_pass_count += 1
else:
    print("recip test4 FAILS")
    complex_test_fail_count += 1
complex_test_total += 4

# div
div_ab = a.div(b)
div_ac = a.div(c)
div_azx = a.div(zero_x)
div_azy = a.div(zero_y)
if (div_ab.equal(ComplexT(-0.56, 1.92))):
    complex_test_pass_count += 1
else:
    print("div test FAILS")
    complex_test_fail_count += 1
if (div_ac.equal(ComplexT(0.46153846153846156, -1.3076923076923077))):
    complex_test_pass_count += 1
else:
    print("div test2 FAILS")
    complex_test_fail_count += 1
if (div_azx.equal(ComplexT(1.6, -1.2))):
    complex_test_pass_count += 1
else:
    print("div test3 FAILS")
    complex_test_fail_count += 1
if (div_azy.equal(ComplexT(1.2, 1.6))):
    complex_test_pass_count += 1
else:
    print("div test4 FAILS")
    complex_test_fail_count += 1
complex_test_total += 4

# sqrt
sq_a = a.sqrt()
sq_b = b.sqrt()
sq_zx = zero_x.sqrt()
sq_zy = zero_y.sqrt()
if (sq_a.equal(ComplexT(2.0, 1.0))):
    complex_test_pass_count += 1
else:
    print("sqrt test FAILS")
    complex_test_fail_count += 1
if (sq_b.equal(ComplexT(1.414213562, -0.707106781))):
    complex_test_pass_count += 1
else:
    print("sqrt test2 FAILS")
    complex_test_fail_count += 1
if (sq_zx.equal(ComplexT(1.118033988, 1.118033988))):
    complex_test_pass_count += 1
else:
    print("sqrt test3 FAILS")
    complex_test_fail_count += 1
if (sq_zy.equal(ComplexT(1.581138830, 0))):
    complex_test_pass_count += 1
else:
    print("sqrt test4 FAILS")
    complex_test_fail_count += 1
complex_test_total += 4

###TEST CASES FOR TRIANGLE_ADT.PY###
triangle_test_pass_count = 0
triangle_test_fail_count = 0
triangle_test_total = 0
t1 = TriangleT(3, 4, 5)
t2 = TriangleT(4, 3, 5)
t3 = TriangleT(1, 4, 3)
t4 = TriangleT(3, 4, 3)

# get_sides
if (t1.get_sides() == (3, 4, 5)):
    triangle_test_pass_count += 1
else:
    print("side test FAILS")
    triangle_test_fail_count += 1
triangle_test_total += 1

# equal
if (t1.equal(t2)):
   triangle_test_pass_count += 1
else:
   print("triangle equal test FAILS")
   triangle_test_fail_count += 1
if (t1.equal(t3) == False):
   triangle_test_pass_count += 1
else:
   print("triangle equal test2 FAILS")
   triangle_test_fail_count += 1
if (t1.equal(t4) == False):
   triangle_test_pass_count += 1
else:
   print("triangle equal test3 FAILS")
   triangle_test_fail_count += 1
triangle_test_total += 3

# perim
if (t1.perim() == 12):
    triangle_test_pass_count += 1
else:
    print("perim test FAILS")
    triangle_test_fail_count += 1
triangle_test_total += 1

# area
if (t1.area() == 6.0):
    triangle_test_pass_count += 1
else:
    print("area test FAILS")
    triangle_test_fail_count += 1
if (t3.area() == "This is not a valid triangle"):
    triangle_test_pass_count += 1
else:
    print("area test2 FAILS")
    triangle_test_fail_count += 1
triangle_test_total += 2

# is_valid
if (t1.is_valid()):
    triangle_test_pass_count += 1
else:
    print("valid test FAILS")
    triangle_test_fail_count += 1
if (t3.is_valid() == False):
    triangle_test_pass_count += 1
else:
    print("valid test2 FAILS")
    triangle_test_fail_count += 1
if (t4.is_valid()):
    triangle_test_pass_count += 1
else:
    print("valid test3 FAILS")
    triangle_test_fail_count += 1
triangle_test_total += 3

# tri_type
if (t1.tri_type() == TriType.right):
    triangle_test_pass_count += 1
else:
   print("tri_type test FAILS")
   triangle_test_fail_count += 1
if (t1.tri_type() != TriType.isosceles):
    triangle_test_pass_count += 1
else:
   print("tri_type test2 FAILS")
   triangle_test_fail_count += 1
if (t4.tri_type() == TriType.isosceles):
    triangle_test_pass_count += 1
else:
   print("tri_type test3 FAILS")
   triangle_test_fail_count += 1
triangle_test_total += 3

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
