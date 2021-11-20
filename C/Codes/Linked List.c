#include <stdio.h>
#include <stdlib.h>

typedef struct NODE{
	int number;
	char name[20];
	char surname[20];
	char branch[40];
	char class_[3];
	struct NODE* next;
	struct NODE* prev;
}NODE;

typedef struct LIST{
	int count;
	NODE* first;
	NODE* last;
	NODE* pos;
	NODE* display;
}LIST;s



LIST* createlist(){
	LIST* list = (LIST*)malloc(sizeof(LIST));
	if(list){
		list->count = 0;
		list->first = 0;
		list->last = 0;
		list->pos = 0;
		list->display = 0;
	} 
	
	return list;
}






void searchnode(LIST* list, int num){
	
	if(list->first == 0){
		printf("Empty List\n");
		list->pos = 0;
		return;
	}
	
	list->pos = list->first;
	
	while(list->pos != 0){
		if(list->pos->number == num){
			printf("Node found.\n");
			return;
		}
		list->pos = list->pos->next;
	}
	
	printf("Node not found.\n");
	return;
}






void addnode(LIST* list){
	NODE* ptr = (NODE*)malloc(sizeof(NODE));
	if(ptr == 0){
		printf("Overflow\n");
		return;
	}
	
	int num;
	printf("Input student number\n");
	scanf("%d", &num);
	
	//Duplicate Key Test
	searchnode(list, num);
	if(list->pos != 0){
		printf("Duplicate key occurred, node is not added.\n");
		return;
	}
	
	ptr->number = num;
	
	//Add Head Node
	if(list->first == 0){
		ptr->next = 0;
		ptr->prev = 0;
		list->first = ptr;
		list->last = ptr;
		
		printf("First node added\n");
		
	}
	
	else{
		printf("1 : Add node at the beginning\n2 : Add node after specified node\n3 : Add node at the end\n");
		int choice;
		scanf("%d", &choice);
		
		//Add node at the beginning
		if(choice == 1){
			ptr->prev = 0;
			ptr->next = list->first;
			list->first->prev = ptr;
			list->first = ptr;
			
			printf("Node added at the beginning\n");
		}
		
		//Add node in the middle
		else if(choice == 2){
			printf("Input the student number of a node that you want to add the new node after that.\n");
			scanf("%d", &num);
			
			if(num == list->last->number){
				printf("You tried to add a node after the last node which would not be in the middle.\n");
				return;
			}
			
			searchnode(list, num);
			if(list->pos == 0){
				printf("The node you are looking for not found.\n");
				return;
			}
			
			
			ptr->next = list->pos->next;
			list->pos->next->prev = ptr;
			
			ptr->prev = list->pos;
			list->pos->next = ptr;
			
			printf("Node added in the middle\n");
		}
		
		//Add node at the end
		else if(choice == 3){
			ptr->next = 0;
			list->last->next = ptr;
			ptr->prev = list->last;
			list->last = ptr;
			
			printf("Node added at the end\n");
		}
		
		else{
			printf("No accepted number were input.\n");
			return;
		}
	}
	
		printf("Input student name\n");
		scanf("%s", ptr->name);
		
		printf("Input student surname\n");
		scanf("%s", ptr->surname);
		
		printf("Input student branch\n");
		scanf("%s", ptr->branch);
		
		printf("Input student class\n");
		scanf("%s", ptr->class_);
		
		list->count++;
		return;
	
}


void deletenode(LIST* list){
	if(list->count == 0){
		printf("Underflow occurred\n");
		return;
	}
	
	printf("1 : Delete node at the beginning\n2 : Delete specified node\n3 : Delete node at the end\n");
		int choice;
		scanf("%d", &choice);
	
	NODE* ptr;
	
	//Delete first node
	if(choice == 1){
		
		if(list->first->next == 0){
			ptr = list->first;
			
			free(list->first);
		}
		
		else{
			ptr = list->first;
			list->first = list->first->next;
			list->first->prev = 0;
			
			free(ptr);
		}		
		
	}
	
	//Delete node in middle
	else if(choice == 2){
		printf("Input the number of student you want to delete\n");
		int num;
		scanf("%d", &num);
		
		searchnode(list,num);
		if(list->pos == 0){
			printf("The node you are looking for not found.\n");
			return;
		}
		
		//Delete the only node
		if(list->first->next == 0){
			ptr = list->first;
			
			free(list->first);
		}
		
		//Delete the first node
		else if(list->pos == list->first){
			ptr = list->first;
			list->first = list->first->next;
			list->first->prev = 0;
			
			free(ptr);
		}
		
		//Delete the last node
		else if(list->pos == list->last){
			ptr = list->last;
			list->last = list->last->prev;
			list->last = 0;
			
			free(ptr);
		}
		
		//Delete the node in the middle
		else{
			NODE* prevnode = list->pos->prev;
			NODE* nextnode = list->pos->next;
			
			prevnode->next = nextnode;
			nextnode->prev = prevnode;
			
			ptr = list->pos;
			list->pos = 0;
			
			free(ptr);
			
		}
	}
	
	//Delete last node
	else if(choice == 3){
		if(list->last->prev == 0){
			
			free(ptr);
		}
		
		else{
			ptr = list->last;
			list->last = list->last->prev;
			list->last = 0;
			
			free(ptr);
		}
	}
	
	else{
		printf("No accecptable number were given.\n");
		return;
	}
	
	
	list->count--;
	printf("Node destroyed\n");
	return;
	
}




void destroylist(LIST* list){
	NODE* eraser;
	
	if(list->first == 0){
		printf("List is empty\n");
		free(list);
		printf("List destroyed\n");
		return;
	}
	
	while(list->first != 0){
		free(list->first->branch);
		free(list->first->name);
		free(list->first->surname);
		free(list->first->class_);
		
		eraser = list->first;
		list->first = list->first->next;
		list->first->prev = 0;
		
		list->count--;
		free(eraser);
	}
	
	printf("List destroyed\n");
	return;
}




void displaylist(LIST* list){
	
	if(list->first == 0){
		printf("List is empty\n");
		return;
	}
	
	if(list->display == 0){
		list->display = list->first;
		
		printf("\nStudent number : %d\n", list->display->number);
		printf("\nStudent name : %s\n", list->display->name);
		printf("\nStudent surname : %s\n", list->display->surname);
		printf("\nStudent branch : %s\n", list->display->branch);
		printf("\nStudent class : %s\n", list->display->class_);
	}
	else{
		if(list->display->next == 0){
			printf("End of the list\n");
			list->display = 0;
			return;
		}
		else{
			list->display = list->display->next;
			printf("\nStudent number : %d\n", list->display->number);
			printf("\nStudent name : %s\n", list->display->name);
			printf("\nStudent surname : %s\n", list->display->surname);
			printf("\nStudent branch : %s\n", list->display->branch);
			printf("\nStudent class : %s\n\n", list->display->class_);
		}
	}
	
	return;
}

int main(){
	
	LIST* list = 0;
	int opt;
	int temp;
	
	printf("Enter any number below to proceed.\n");
	
	while(1){
		printf("1 : Create List\n2 : Add node\n3 : Search node\n4 : Delete node\n5 : Display list\n6 : Destroy linked list\n7 : Exit\n");
		scanf("%d", &opt);
		
		if(opt == 1){
			if(list != 0)
				printf("List already exist\n");
			
			else{
				list = createlist();
				printf("Created list\n");
			}
		}
		
		else if(opt == 2){
		
		if(list == 0)
		printf("List does not exist. You have to create the list first.\n");
		
		else
		addnode(list);
		}
		
		else if(opt == 3){
			if(list == 0)
			printf("List does not exist. You have to create the list first.\n");
			
			else{
				printf("Input the student number\n");
				scanf("%d", &temp);
			
				searchnode(list,temp);
			}
		}
		
		else if(opt == 4){
			if(list == 0)
			printf("List does not exist. You have to create the list first.\n");
			
			else
			deletenode(list);
		}
		
		else if(opt == 5){
			if(list == 0)
			printf("List does not exist. You have to create the list first.\n");
			
			else
			displaylist(list);
		}
		
		else if(opt == 6){
			
			if(list == 0)
			printf("List doesn't exist\n");
			
			else
			destroylist(list);
		}
		
		else
		break;
	}
	
	return 7;
}




