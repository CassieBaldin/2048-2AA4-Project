## @file test_All.py
#  @author Cassidy Baldin
#  @brief A module for testing modules CircleT, TriangleT, BodyT, and Scene.py
#  @date February 12th, 2021

from CircleT import CircleT
from TriangleT import TriangleT
from BodyT import BodyT
from Scene import Scene

from pytest import *


class TestCircleT:
    def setup_method(self, method):
        self.c1 = CircleT(1.0, 10.0, 0.5, 5.0)
        self.c2 = CircleT(0, 0, 1.0, 1.0)

    def teardown_method(self, method):
        self.c1 = None
        self.c2 = None

    def test_cm_x(self):
        assert self.c1.cm_x() == 1.0

    def test_cm_x_zero(self):
        assert self.c2.cm_x() == 0

    def test_cm_y(self):
        assert self.c1.cm_y() == 10.0

    def test_cm_y_zero(self):
        assert self.c2.cm_y() == 0

    def test_mass1(self):
        assert self.c1.mass() == 5.0

    def test_mass2(self):
        assert self.c2.mass() == 1.0

    def test_m_inert1(self):
        assert self.c1.m_inert() == 0.625

    def test_m_inert2(self):
        assert self.c2.m_inert() == 0.5

    def test_neg_mass(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, 0.5, -5.0)

    def test_neg_rad(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, -0.5, 5.0)

    def test_neg_both(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, -0.5, -5.0)

    def test_zero_mass(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, 0.5, 0)

    def test_zero_rad(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, 0, 5.0)

    def test_zero_both(self):
        with raises(ValueError):
            CircleT(1.0, 10.0, 0, 0)


class TestTriangleT:
    def setup_method(self, method):
        self.t1 = TriangleT(1.0, 10.0, 0.5, 24.0)
        self.t2 = TriangleT(0, 0, 1.0, 1.0)

    def teardown_method(self, method):
        self.t1 = None
        self.t2 = None

    def test_cm_x(self):
        assert self.t1.cm_x() == 1.0

    def test_cm_x_zero(self):
        assert self.t2.cm_x() == 0

    def test_cm_y(self):
        assert self.t1.cm_y() == 10.0

    def test_cm_y_zero(self):
        assert self.t2.cm_y() == 0

    def test_mass1(self):
        assert self.t1.mass() == 24.0

    def test_mass2(self):
        assert self.t2.mass() == 1.0

    def test_m_inert1(self):
        assert self.t1.m_inert() == 0.5

    def test_m_inert(self):
        assert self.t2.m_inert() == approx(0.08333, abs=1e-3)

    def test_neg_mass(self):
        with raises(ValueError):
            TriangleT(1.0, 10.0, 0.5, -5.0)

    def test_neg_side(self):
        with raises(ValueError):
            TriangleT(1.0, 10.0, -0.5, 5.0)

    def test_neg_both(self):
        with raises(ValueError):
            TriangleT(1.0, 10.0, -0.5, -5.0)

    def test_zero_mass(self):
        with raises(ValueError):
            TriangleT(1.0, 10.0, 0.5, 0)

    def test_zero_side(self):
        with raises(ValueError):
            TriangleT(1.0, 10.0, 0, 5.0)

    def test_zero_both(self):
        with raises(ValueError):
            TriangleT(0, 0, 0, 0)


class TestBodyT:
    def setup_method(self, method):
        self.b1 = BodyT([5, -7.5, -9.5, 11], [12, 6.5, -1, -10], [10, 10, 50, 30])
        self.b2 = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])

    def teardown_method(self, method):
        self.b1 = None
        self.b2 = None

    def test_cm_x(self):
        assert self.b1.cm_x() == -1.7

    def test_cm_x_zero(self):
        assert self.b2.cm_x() == 0

    def test_cm_y(self):
        assert self.b1.cm_y() == -1.65

    def test_cm_y_zero(self):
        assert self.b2.cm_y() == 0

    def test_mass1(self):
        assert self.b1.mass() == 100

    def test_mass2(self):
        assert self.b2.mass() == 40.0

    def test_m_inert1(self):
        assert self.b1.m_inert() == 13306.25

    def test_m_inert2(self):
        assert self.b2.m_inert() == 80.0

    def test_len_xs(self):
        with raises(ValueError):
            BodyT([1, -1, -1, 1, 1], [1, 1, -1, -1], [10, 10, 10, 10])

    def test_len_ys(self):
        with raises(ValueError):
            BodyT([1, -1, -1, 1], [1, 1, -1, -1, 1], [10, 10, 10, 10])

    def test_len_ms(self):
        with raises(ValueError):
            BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10, 1])

    def test_neg_mass(self):
        with raises(ValueError):
            BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, -10, 10])

    def test_zero_mass(self):
        with raises(ValueError):
            BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 0])

    def test_empty(self):
        with raises(ValueError):
            BodyT([], [1, 1, -1, -1], [10, 10, 10, 10])

    def test_zero_xy(self):
        b3 = BodyT([0, 0, 0, 0], [0, 0, 0, 0], [1, 1, 1, 1])
        assert b3.m_inert() == 0


class TestSceneT:
    def setup_method(self, method):
        def Fx(t):
            return 0

        def Fy(t):
            return -9.81

        self.c = CircleT(1.0, 10.0, 0.5, 5.0)
        self.c2 = CircleT(1.0, 10.0, 0.5, 1.0)
        self.t = TriangleT(1.0, 10.0, 0.5, 24.0)
        self.b = BodyT([1, -1, -1, 1], [1, 1, -1, -1], [10, 10, 10, 10])
        self.s1 = Scene(self.c, Fx, Fy, 0, 0)
        self.s2 = Scene(self.t, Fx, Fy, 10, -10)
        self.s3 = Scene(self.c2, Fx, Fy, 0, 0)

    def teardown_method(self, method):
        self.c = None
        self.c2 = None
        self.t = None
        self.s1 = None
        self.s2 = None

    def test_get_shape1(self):
        assert self.s1.get_shape() == self.c

    def test_get_shape2(self):
        assert self.s2.get_shape() == self.t

    def test_get_init_velo1(self):
        assert self.s1.get_init_velo() == (0, 0)

    def test_get_init_velo12(self):
        assert self.s2.get_init_velo() == (10, -10)

    def test_set_shape1(self):
        self.s1.set_shape(self.b)
        assert self.s1.get_shape() == self.b

    def test_undo_set1(self):
        self.s1.set_shape(self.c)
        assert self.s1.get_shape() == self.c

    def test_set_shape2(self):
        self.s2.set_shape(self.b)
        assert self.s2.get_shape() == self.b

    def test_undo_set2(self):
        self.s2.set_shape(self.t)
        assert self.s2.get_shape() == self.t

    def test_set_init_velo1(self):
        self.s1.set_init_velo(25, 12)
        assert self.s1.get_init_velo() == (25, 12)

    def test_undo_init_velo1(self):
        self.s1.set_init_velo(0, 0)
        assert self.s1.get_init_velo() == (0, 0)

    def test_set_init_velo2(self):
        self.s2.set_init_velo(300, 3)
        assert self.s2.get_init_velo() == (300, 3)

    def test_undo_init_velo2(self):
        self.s2.set_init_velo(10, -10)
        assert self.s2.get_init_velo() == (10, -10)

    def test_sim_t(self):
        t, wsol = self.s3.sim(10, 10)
        exp_t = [0.0, 1.111, 2.222, 3.333, 4.444, 5.555, 6.666, 7.777, 8.888, 10.0]

        diff_t = []
        for i in range(0, len(t)):
            diff_t.append(t[i] - exp_t[i])

        norm_t = 0
        for i in range(0, len(diff_t)):
            if abs(i) > norm_t:
                norm_t = i

        norm_exp = 0
        for i in range(0, len(exp_t)):
            if abs(i) > norm_exp:
                norm_exp = i

        assert (norm_t / norm_exp) == approx(1, rel=1e-3)

    #I couldn't figure out how to effectively test this method :(
    # def test_sim_wsol(self):
    #     t, wsol = self.s3.sim(10, 10)
    #     exp_wsol = [[1, 10, 0, 0],
    #                 [1, 3.94444444, 0, -10],
    #                 [1, -14.22222222, 0, -21.8],
    #                 [1, -44.5, 0, -32.7],
    #                 [1, -86.88888889, 0, -43.6],
    #                 [1, -141.38888889, 0, -54.5],
    #                 [1, -208, 0, -65.4],
    #                 [1, -286.72222222, 0, -76.3],
    #                 [1, -377.55555556, 0, -87.2],
    #                 [1, -480.5, 0, -98.1]]

    #     wsol_all = []
    #     for i in wsol:
    #         for j in range(len(i)):
    #             wsol_all.append(i[j])

    #     exp_all = []
    #     for i in exp_wsol:
    #         for j in range(len(i)):
    #             exp_all.append(i[j])

    #     diff_wsol = []
    #     for i in wsol_all:
    #         diff_wsol.append(wsol_all[i] - exp_all[i])

    #     norm_wsol = 0
    #     for i in range(0, len(diff_wsol)):
    #         if abs(i) > norm_wsol:
    #             norm_wsol = i

    #     norm_exp = 0
    #     for i in range(0, len(exp_all)):
    #         if abs(i) > norm_exp:
    #             norm_exp = i

    #     assert (norm_wsol / norm_exp) == approx(1, rel=1e-3)
