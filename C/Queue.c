#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Furkan Sayan
// 20360859093

typedef struct Node{
	int data;
	struct Node* link;
}Node;

typedef struct Que{
	Node* front;
	Node* rear;
	int count;
}Que;

Que* CreateQueue(){
	Que* q = (Que*) malloc(sizeof(Que));
	q->front = 0;
	q->rear = 0;
	q->count = 0;
	return q;
}

void Enqueue(Que* q, int datain){
	Node* ptr = (Node*) malloc(sizeof(Node));
	if(ptr == 0){
		printf("Memeory overflow.\n");
		return;
	}
	
	ptr->data = datain;
	
	if(q->front == 0){
		q->front = ptr;
	}
	else{
		q->rear->link = ptr;
	}
	
	ptr->link = 0;
	q->rear = ptr;
	q->count = q->count + 1;
	
	return;
}

int Dequeue(Que* q){
	
	if(q->front == 0){
		printf("Queue undeflow.\n");
		return 0;
	}
	Node* ptr = q->front;
	
	int dataout = q->front->data;
	
	ptr = q->front;
	q->front = q->front->link;
	
	q->count = q->count - 1;
	free(ptr);
	
	return dataout;
}

// -1 = +
// -2 = -
// -3 = *
// -4 = /
Que* organize(char* infix){
	
	Que* q = CreateQueue();
	
	int pos = 0;
	int num = 0;
	int digit;
	int cor;
	int temp;
	
	while(*(infix+pos) != '\0'){
		
		cor = (int)(*(infix+pos));
		
		//Eger string de karsilasilan karakter rakam ise
		if(cor >= 48 && cor <= 57){
			digit = 1;
			
			while( (int)(*(infix+pos+digit)) >= 48 && (int)(*(infix+pos+digit)) <= 57){
				digit++;
			}
			//Sayinin basamak sayisi bulunur.
			
			num = 0;
			for(temp = digit; temp > 0; temp--){
				num += ((int)(*(infix+pos-temp+digit))- 48) * pow(10,(temp-1));
			}
			Enqueue(q,num);
			pos += digit - 1;
			//Sayi bir queue'ya eklenir.
		}
		
		else if(cor == 43){
			Enqueue(q,(-1));
		}
		else if(cor == 45){
			Enqueue(q,(-2));
		}
		else if(cor == 42){
			Enqueue(q,(-3));
		}
		else if(cor == 47){
			Enqueue(q,(-4));
		}
		
		
		pos++;
	}
	
	
	
	return q;
}

Que* Evaluate(Que* q){
	
	Que* qnew = CreateQueue();
	Node* ptr = q->front;
	int temp;
	
	while(1){
		if(ptr == 0)
		break;
		
		if(ptr->data < 0){
			if(ptr->link->data > 0 && ptr->link->link->data > 0){
				
				if(ptr->data == (-1)){
					temp = ptr->link->data + ptr->link->link->data;
					Enqueue(qnew,temp);
					ptr = ptr->link->link;
				}
				else if(ptr->data == (-2)){
					temp = ptr->link->data - ptr->link->link->data;
					Enqueue(qnew,temp);
					ptr = ptr->link->link;
				}
				else if(ptr->data == (-3)){
					temp = ptr->link->data * ptr->link->link->data;
					Enqueue(qnew,temp);
					ptr = ptr->link->link;
				}
				else if(ptr->data == (-4)){
					temp = ptr->link->data / ptr->link->link->data;
					Enqueue(qnew,temp);
					ptr = ptr->link->link;
				}
			}
			else{
				temp = ptr->data;
				Enqueue(qnew,temp);
			}
		}
		else{
			temp = ptr->data;
			Enqueue(qnew,temp);
		}
		
		ptr = ptr->link;
	}
	
	printf("Bir tarama tamamlandi.\n");
	return qnew;
}

int main(){
	
	printf("Prefix ifadeyi giriniz.\n");
	char infix[61];
	gets(infix);
	
	Que* q = organize(infix);
	
	while(q->front->link != 0)
	q = Evaluate(q);
	
	int x = Dequeue(q);
	printf("Sonuc : %d", x);
	
	return 7;
}

// Furkan Sayan
// 20360859093






