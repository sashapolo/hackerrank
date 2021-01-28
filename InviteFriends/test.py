import unittest

from InviteFriends.solution import invite_max_friends


class MyTestCase(unittest.TestCase):
    def test_no_friends(self):
        friends = [
            (1, 2),
            (2, 3)
        ]
        self.assertEqual(0, invite_max_friends(friends))

    def test_some_friends(self):
        friends = [
            (1, 2),
            (1, 3),
            (1, 4),
            (2, 3),
            (2, 4),
            (3, 4),
            (6, 7),
            (7, 8),
            (8, 9)
        ]
        self.assertEqual(4, invite_max_friends(friends))


if __name__ == '__main__':
    unittest.main()
