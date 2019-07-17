package util;

import java.util.*;

import java.util.*;

public class Tsp {	
	private int cityNum;
	private int popSize = 50;
	private int maxgens = 20000;
	private double pxover = 0.8;
	private double pmultation = 0.05;
	private int[][] distance = new int[1000][1000];
	private int range = 2000;
	private ArrayList<String> pointList;
	private class genotype {
		int city[] = new int[10000];
		long fitness;
		double selectP;
		double exceptp;
		int isSelected;
	}
	private genotype[] citys = new genotype[popSize];

	public Tsp(int[][] distance,int cityNum,ArrayList<String> pointList) {
		this.cityNum=cityNum;
		this.distance=distance;
		this.pointList=pointList;
		for (int i = 0; i < popSize; i++) {
			citys[i] = new genotype();
			int[] num = new int[cityNum];
			for (int j = 0; j < cityNum; j++)
				num[j] = j;
			int temp = cityNum;
			for (int j = 0; j < cityNum; j++) {
				int r = (int) (Math.random() * temp);
				citys[i].city[j] = num[r];
				num[r] = num[temp - 1];
				temp--;
			}
			citys[i].fitness = 0;
			citys[i].selectP = 0;
			citys[i].exceptp = 0;
			citys[i].isSelected = 0;
		}
		
	}
	

	public void CalAll(){
		for( int i = 0; i< popSize; i++){
			citys[i].fitness = 0;
			citys[i].selectP = 0;
			citys[i].exceptp = 0;
			citys[i].isSelected = 0;
		}
		CalFitness();
		CalSelectP();
		CalExceptP();
		CalIsSelected();
	}

	public void pad(){
		int best = 0;
		int bad = 0;
		while(true){			
			while(citys[best].isSelected <= 1 && best<popSize-1)
				best ++;
			while(citys[bad].isSelected != 0 && bad<popSize-1)
				bad ++;
			for(int i = 0; i< cityNum; i++)
				citys[bad].city[i] = citys[best].city[i];
				citys[best].isSelected --;
				citys[bad].isSelected ++;
				bad ++;	
			if(best == popSize ||bad == popSize)
				break;
		}
	}
	

	public void crossover() {
		int x;
		int y;
		int pop = (int)(popSize* pxover /2);
		while(pop>0){
			x = (int)(Math.random()*popSize);
			y = (int)(Math.random()*popSize);
			
			executeCrossover(x,y);
			pop--;
		}
	}

	private void executeCrossover(int x,int y){
		int dimension = 0;
		for( int i = 0 ;i < cityNum; i++)
			if(citys[x].city[i] != citys[y].city[i]){
				dimension ++;
			}	
		int diffItem = 0;
		double[] diff = new double[dimension];

		for( int i = 0 ;i < cityNum; i++){
			if(citys[x].city[i] != citys[y].city[i]){
				diff[diffItem] = citys[x].city[i];
				citys[x].city[i] = -1;
				citys[y].city[i] = -1;
				diffItem ++;
			}	
		}
	
		Arrays.sort(diff);

		double[] temp = new double[dimension];
		temp = gp(x, dimension);

		for( int k = 0; k< dimension;k++)
			for( int j = 0; j< dimension; j++)
				if(temp[j] == k){
					double item = temp[k];
					temp[k] = temp[j];
					temp[j] = item;
					
					item = diff[k];
					diff[k] = diff[j];
					diff[j] = item;	
				}
		int tempDimension = dimension;
		int tempi = 0;

		while(tempDimension> 0 ){
			if(citys[x].city[tempi] == -1){
				citys[x].city[tempi] = (int)diff[dimension - tempDimension];
				
				tempDimension --;
			}	
			tempi ++;
		}

		Arrays.sort(diff);

		temp = gp(y, dimension);

		for( int k = 0; k< dimension;k++)
			for( int j = 0; j< dimension; j++)
				if(temp[j] == k){
					double item = temp[k];
					temp[k] = temp[j];
					temp[j] = item;
					
					item = diff[k];
					diff[k] = diff[j];
					diff[j] = item;	
				}

		tempDimension = dimension;
		tempi = 0;

		while(tempDimension> 0 ){
			if(citys[y].city[tempi] == -1){
				citys[y].city[tempi] = (int)diff[dimension - tempDimension];
				
				tempDimension --;
			}	
			tempi ++;
		}

	}

	private double[] gp(int individual, int dimension){
		double[] temp = new double[dimension];
		double[] temp1 = new double[dimension];
		int p = 2 * dimension + 3;

		while(!isSushu(p))
			p++;

		for( int i = 0; i< dimension; i++){
			temp[i] = 2*Math.cos(2*Math.PI*(i+1)/p) * (individual+1);
			temp[i] = temp[i] - (int)temp[i];
			if( temp [i]< 0)
				temp[i] = 1+temp[i];

		}
		for( int i = 0; i< dimension; i++)
			temp1[i] = temp[i];
		Arrays.sort(temp1);	

		for( int i = 0; i< dimension; i++)
			for( int j = 0; j< dimension; j++)
				if(temp[j]==temp1[i])
					temp[j] = i;	
		return temp;
	}
	

	public void mutate(){
		double random;
		int temp;
		int temp1;
		int temp2;
		for( int i = 0 ; i< popSize; i++){
			random = Math.random();
			if(random<=pmultation){
				temp1 = (int)(Math.random() * (cityNum));
				temp2 = (int)(Math.random() * (cityNum));
				temp = citys[i].city[temp1];
				citys[i].city[temp1] = citys[i].city[temp2];
				citys[i].city[temp2] = temp;

			}
		}		
	}
	

	public void print() {
	}


	private void CalFitness() {
		for (int i = 0; i < popSize; i++) {
			for (int j = 0; j < cityNum - 1; j++)
				citys[i].fitness += distance[citys[i].city[j]][citys[i].city[j + 1]];
			citys[i].fitness += distance[citys[i].city[0]][citys[i].city[cityNum - 1]];
		}
	}

	private void CalSelectP(){
		long sum = 0;
		for( int i = 0; i< popSize; i++)
			sum += citys[i].fitness;
		for( int i = 0; i< popSize; i++)
			citys[i].selectP = (double)citys[i].fitness/sum;

	}

	private void CalExceptP(){
		for( int i = 0; i< popSize; i++)
			citys[i].exceptp = (double)citys[i].selectP * popSize;
	}
	

	private void CalIsSelected(){
		int needSelecte = popSize;
		for( int i = 0; i< popSize; i++)
			if( citys[i].exceptp<1){
				citys[i].isSelected++;
				needSelecte --;
			}
		double[] temp = new double[popSize];
		for (int i = 0; i < popSize; i++) {
//			temp[i] = citys[i].exceptp - (int) citys[i].exceptp;
//			temp[i] *= 10;
			temp[i] = citys[i].exceptp*10;
		}
		int j = 0;
		while (needSelecte != 0) {
			for (int i = 0; i < popSize; i++) {
				if ((int) temp[i] == j) {
					citys[i].isSelected++;
					needSelecte--;
					if (needSelecte == 0)
						break;
				}
			}
			j++;
		}
		
	}

	private boolean isSushu( int x){
		   if(x<2) return false;
		   for(int i=2;i<=x/2;i++)
		   if(x%i==0&&x!=2) return false;

		   return true;
		}
	

	private boolean isSame(long[] x){
		for( int i = 0; i< x.length -1; i++)
			if(x[i] !=x[i+1])
				return false;
		return true;
	}

	private String printBestRoute(){
		CalAll();
		String result=" ";
		long temp = citys[0].fitness;
		int index = 0;
		for (int i = 1; i < popSize; i++) {
			if(citys[i].fitness<temp){
				temp = citys[i].fitness;
				index = i;
			}
		}
		System.out.println();
		System.out.println("最佳路径的序列：");
		for (int j = 0; j < cityNum; j++){

			result=result+pointList.get(citys[index].city[j])+"-";

		}

		return result;
	}

	public String run(){
		long[] result = new long[range];

		for( int i  = 0; i< range; i++)
			result[i] = i;
		int index = 0;
		int num = 1;
		while(maxgens>0){

			CalAll();
			print();
			pad();
			crossover();
			mutate();
			maxgens --;
			long temp = citys[0].fitness;
			for ( int i = 1; i< popSize; i++)
				if(citys[i].fitness<temp){
					temp = citys[i].fitness;
				}

			result[index] = temp;
			if(isSame(result))
				break;
			index++;
			if(index==range)
				index = 0;
			num++;
		}
		return  printBestRoute();
	}
	

	public void CalTime(Calendar a,Calendar b){
		long x = b.getTimeInMillis() - a.getTimeInMillis();
		long y = x/1000;
		x = x - 1000*y;

	}


}