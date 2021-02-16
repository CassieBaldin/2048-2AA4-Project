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

    def test_mass(self):
        assert self.c1.mass() == 5.0

    def test_m_inert(self):
        assert self.c1.m_inert() == 0.625

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

    def test_mass(self):
        assert self.t1.mass() == 24.0

    def test_m_inert(self):
        assert self.t1.m_inert() == 0.5

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
            TriangleT(1.0, 10.0, 0, 0)

# class TestBodyT:




# class TestSceneT:
