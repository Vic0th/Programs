#include <stdio.h>

//Armstrong checker function
int asc(int x) {
	
	int sum=0, sumt;
	int y = x;
	
	while(x > 0){
		
		sumt = (x%10);
		sumt = sumt * sumt * sumt;
		sum += sumt;
		
		printf("%d", sumt);
		
		x /= 10;
		
		if(x > 0)
		printf(" + ");	
	}
	
	printf(" = %d\n", sum);
	
	if(y == sum)
	return 1;
	
	else if(y == 0)
	return 1;
	
	else
	return 0;
	
}


void main(){
	int x;
	
	printf("Input a number to calculate if it's an armstrong number or not.\n");
	printf("Reminder : Armstrong number is a number that is equal to the sum of cubes of its digits.\n");
	printf("To exit, input 0\n");
	
	while(1){
		scanf("%d", &x);
	
		if(x == 0)
		break;
	
		else if(asc(x) == 1)
		printf("%d is an armstrong number.\n", x);
	
		else
		printf("%d is not an armstrong number.\n", x);
	}
	
	
	
}
