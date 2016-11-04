import unittest
import sys

if len(sys.argv) != 2:
    sys.exit(-1)

tl = unittest.defaultTestLoader

testsuite = tl.discover(sys.argv[1])


def getTests(testsuite):
    l = []
    for t in testsuite:
        if isinstance(t, unittest.TestSuite):
            l += getTests(t)
        elif isinstance(t, unittest.TestCase):
            l.append(t)
    return l

tests = getTests(testsuite)

for t in tests:
    print(t)





