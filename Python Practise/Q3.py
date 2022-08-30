# 3. You are given a square matrix of size n.
# Rows are indexed 1 to n from top to bottom and columns are indexed 1 to n form left to right.
# Matrix consists of only '*' and '.'.
# You need to check whether
#   	The matrix is symmetric or not.
#   	if it is, check whether it is symmetric about vertical axis or horizontal axis or both.
# A matrix is said to be symmetric about horizontal axis
#   if 1st row is identical to nth row, 2nd row is identical to (n-1) th row and so on…
# A matrix is said to be symmetric about vertical axis
#   if 1st column is identical to nth column, 2nd identical to (n-1) th and so on for all columns.

# Assuming it's a square matrix having equal number of rows and columns in each list


def check_symmetry(mat):
    row_size = len(matrix)
    col_size = len(matrix[0])

    row_symmetry = True
    col_symmetry = True
    # Checking Row Matrix symmetry
    i = 0
    k = row_size - 1
    while i < row_size // 2:
        for j in range(0, row_size):
            if matrix[j][i] != matrix[k][i]:
                row_symmetry = False
                break
            k += -1
        i += 1

    # Checking Col Matrix symmetry
    i = 0
    k = col_size - 1
    while i < col_size // 2:
        for j in range(0, col_size):
            if matrix[i][j] != matrix[i][k]:
                col_symmetry = False
                break

            k += -1
        i += 1
    print("Row Symmetry ", row_symmetry)
    print("Col Symmetry ", col_symmetry)


matrix = [['*', '.', '.', '*'], ['*', '.', '.', '*'], ['*', '.', '.', '*']]
check_symmetry(matrix)
matrix = [['*', '.', '*', '*'], ['*', '.', '.', '*'], ['*', '.', '.', '*']]
check_symmetry(matrix)
matrix = [['*', '.', '.', '*'], ['*', '.', '.', '*'], ['*', '.', '.', '*']]
check_symmetry(matrix)