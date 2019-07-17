#include<stdio.h>
int main()
{
	float angle;
	printf("Input a angle:");
	scanf("%f",&angle);
	if(angle>0&&angle<90)
	   printf("¢ñ\n");
	else if(angle>90&&angle<180)
		   printf("¢ò\n");
		 else if(angle>180&&angle<270)
			    printf("¢ó\n");
			  else if(angle>270&&angle<350)
				     printf("¢ô\n");
				   else if(angle==0||angle==90||angle==180||angle==270)
					     printf("The corresponding line does not reside in any quadrant but lies on an axis.\n");
					    else
					        printf("The angle is not in the range\n");
	return 0;
}