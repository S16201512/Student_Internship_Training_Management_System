package util;

public class CargoCarrier {
            private  int n;//城市个数
            private  int[][] cost;//费用矩阵
            private  int start;//起始位置
            private  int[] path;//最优路径
            private  boolean[]flag;//0未访问，1已被访问
            public String getShortpath(int[][] cost) {
            n = cost.length;
            this.cost=cost;
       // System.out.println("请输入城市之间的权值代价(注：城市自己到自己记为0意为无穷的意思)");
            flag = new boolean[n];
            printFun();
            while(true) {
            System.out.print("输入起始位置start=");
            start = 1;
            if((start>=1&&start<=n)) {
                break;
            }
        }
            initFun();
            return  "最小费用"+workFun(n,start-1);
   }
    /**
          * 这里先来了解一下算法思路：
          *         1：由上面树状图我们不难解除此算法需要两层循环
          *         2：每次循环遍历的节点总是剔除了所有的父辈节点，比如当你是d(2,{3,4})的时候就不用访问节点1，当你是d(3,{4})的时候就不用访问节点1，2
          *         3：由2不难看出需要一个以为数组判断当前节点是否已被访问记flag[n]
          */
    public  int workFun(int num,int spot) {
        if(num==1) {//极限情况，当只剩最后一个节点则返回该节点到起点的距离，这里是一个回路所以返回的是cost[spot][start],如果只是遍历所有点不用返回起始则直接返回0
            return cost[spot][start-1];
        }
        int mincost = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
        if(!flag[i]&& i!=(start-1)) {//该节点在此次循环中未被访问，并且该节点不是起始节点
            if(mincost <= cost[spot][i]+cost[i][start]){

                    continue; //其作用为结束本次循环。即跳出循环体中下面尚未执行的语句。区别于break 
                }
                flag[i] = true;//递归调用时，防止重复调用
                int value = cost[spot][i]+workFun(num-1, i);
                if(value<mincost) {
                    System.out.println("spot:"+spot+"i:"+i);
                    mincost = value;

                }

            flag[i] = false;//本次递归调用完毕，让下次递归调用
            }
        }
        return mincost;

        }
        //答应费用矩阵
     public  void printFun() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
            System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
    }
    //初始化flag,所有节点未访问
    private  void initFun() {
        for(int i=0;i<flag.length;i++) {
            flag[i] = false;
        }
    }




}
