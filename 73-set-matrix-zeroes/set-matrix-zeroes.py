class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n=len(matrix)
        m=len(matrix[0])
        V=[]

        for i in range(n):
            for j in range(m):
                if matrix[i][j]==0:
                    V.append((i,j))


        for row,col in V:
            matrix[row]=[0]*m

            for i in range(n):
                matrix[i][col]=0