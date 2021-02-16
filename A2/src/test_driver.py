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
    def test_cm_x(self):
        c = CircleT(1.0, 10.0, 0.5, 5.0)
        assert c.cm_x() == 1.0

    def test_cm_y(self):
        c = CircleT(1.0, 10.0, 0.5, 5.0)
        assert c.cm_y() == 10.0

    def test_mass(self):
        c = CircleT(1.0, 10.0, 0.5, 5.0)
        assert c.mass() == 5.0

    def test_m_inert(self):
        c = CircleT(1.0, 10.0, 0.5, 5.0)
        assert c.m_inert() == 0.625

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
    def test_cm_x(self):
        t = TriangleT(1.0, 10.0, 0.5, 5.0)
        assert t.cm_x() == 1.0

    def test_cm_y(self):
        t = TriangleT(1.0, 10.0, 0.5, 5.0)
        assert t.cm_y() == 10.0

    def test_mass(self):
        t = TriangleT(1.0, 10.0, 0.5, 5.0)
        assert t.mass() == 5.0

    def test_m_inert(self):
        t = TriangleT(1.0, 10.0, 0.5, 24.0)
        assert t.m_inert() == 0.5

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
