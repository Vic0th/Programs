#include <stdio.h>
#include <stdlib.h>

typedef struct NODE{
	
	char var;
	struct NODE* next;
	
}NODE;

typedef struct STACK{
	int count;
	NODE* top;
	
}STACK;

STACK* CreateStack(){
	
	STACK* stack = (STACK*) malloc(sizeof(STACK));
	if(stack == 0){
		printf("Memory Overflow occurred.\n");
		return;
	}
	
	stack->count = 0;
	stack->top = 0;
	
	return stack;
}



void PushStack(STACK* stack,char input){
	
	NODE* push = (NODE*) malloc(sizeof(NODE));
	if(push == 0){
		printf("Memory overflow occurred. Aborting process.\n");
		return;
	}
	
	
	push->var = input;
	
	if(stack->top == 0){
		push->next = 0;
	}
	
	else{
		push->next = stack->top;
	}
	
	stack->top = push;
	stack->count = stack->count + 1;
	
	return;
}



char PopStack(STACK* stack){
	NODE* ptr = (NODE*) malloc(sizeof(NODE));
	
	if(ptr == 0){
		printf("Memory overflow occurred. Aborting process.\n");
		return '0';
	}
	
	if(stack->top == 0){
		return '\0';
	}
	
	char pop = stack->top->var;
	
	ptr = stack->top;
	stack->top = stack->top->next;
	
	free(ptr);
	stack->count = stack->count - 1;
	
	return pop;
	
}

void DestroyStack(STACK* stack){
	
	NODE* ptr = stack->top;
	
	while(stack->top != 0){
		
		ptr = stack->top;
		stack->top = stack->top->next;
		free(ptr);
		
	}
	
	free(stack);
	return;
	
}

int balanced(const char input[], size_t n){
	STACK* stack = CreateStack();
	char temp;
	int index = 0;
	
	while(1){
		
		if(input[index] == '\0'){
			temp = PopStack(stack);
			
			if(temp == '\0'){
				DestroyStack(stack);
				return 1;
			}
			else{
				DestroyStack(stack);
				return 0;
			}
		}
		
		else if(input[index] == '('){
			PushStack(stack,'(');
		}
		
		else if(input[index] == '{'){
			PushStack(stack,'{');
		}
		
		else if(input[index] == ')'){
			temp = PopStack(stack);
			if(temp != '('){
				DestroyStack(stack);
				return 0;
			}
		}
		
		else if(input[index] == '}'){
			temp = PopStack(stack);
			if(temp != '{'){
				DestroyStack(stack);
				return 0;
			}
		}
			
		index++;
	}
	
}

int main(){
	char input[101];
	
	printf("Karakter ciftlerinin eslesip eslesmedigini bulmak istediginiz metni giriniz.\n");
	scanf("%s", input);
	
	
	int x = balanced(input, sizeof(input));
	
	if(x == 1)
	printf("Tebrikler, karakter ciftleri eslesmektedir.\n");
	else
	printf("Karakter ciftleri eslesmemektedir.\n");
	
	
	return 7;
	
}
