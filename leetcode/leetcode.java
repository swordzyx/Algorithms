import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Mul;

class leetcode {
  //滚动矩阵
  public int climbStairs1(int n) {
    int q = 0, p = 0, r = 1;
     
    for(int i=0; i<n; i++) {
        q = p;
        p = r;
        r = q + p;
    }
    return r;
  }

  //矩阵快速幂
  public int climbStairs2(int n) {
    int[][] q = {{1, 1}, {1, 0}};
    int[][] ret = row(q, n);
    return ret[0][0];
  }

  //斐波那契数列通项公式
  public int climbStairs3(int n) {
    double ret = Math.sqrt(5);
    double result = Math.pow((1 + ret) / 2, n + 1) - Math.pow((1 - ret) / 2, n + 1);
    return (int)Math.round((result / ret));
  }
      
  public int[][] row(int[][] q, int n) {
    int[][] ret = {{1, 1}, {1, 0}};
    int[][] a = {{1, 1}, {1, 0}};

    while(n > 0) {
      if((n & 1) == 1) {
        ret = multi(ret, a);
      }
      ret = multi(ret, ret);
    }
    return ret;
  }

  public int[][] multi(int[][] a1, int[][] a2) {
    int[][] result = new int[2][2];
    for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
            result[i][j]  = a1[i][0] * a2[0][j] + a1[i][1] * a2[1][j];
        }
    }
    return result;
  }
}