#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node
{
 int data;
 struct node *prev;
 struct node *next;
};
struct node *start=NULL,*temp=NULL,*ptr=NULL;
void insert()
{
 int item,pos;
 printf("Enter item to insert : ");
 scanf("%d",&item);
 printf("Enter position : ");
 scanf("%d",&pos);
 ptr=(struct node*)malloc(sizeof(struct node));
 if(pos==1)
 {
  if(start==NULL)
  {
   ptr->data=item;
   ptr->prev=ptr->next=NULL;
   start=ptr;
   return;
  }
  else
  {
   temp=start;
   ptr->data=item;
   ptr->next=temp;
   ptr->prev=NULL;
   temp->prev=ptr;
   start=ptr;
   return;
  }
 }
 else
 {
  int i;
  temp=start;
  for(i=1;i<pos-1 && temp->next!=NULL;i++)
   temp=temp->next;
  ptr->data=item;
  ptr->prev=temp;
  ptr->next=temp->next;
  temp->next=ptr;
 }
}
void deletion()
{
 int i,item,f=0;
 if(start==NULL)
 {
  printf("Empty List\n");
  return;
 }
 printf("Enter position to delete : ");
 scanf("%d",&item);

 temp=start;
 while(temp!=NULL)
 {
   f=f+1;
   temp=temp->next;
 }
 if(item>f  || item<1)
 {
  printf("Invalid Position\n");
  return;
 }

 if(item==1 && start->prev==NULL && start->next==NULL)
 {
  printf("%d deleted\n",start->data);
  free(start);
  start=NULL;
  return;
 }
 temp=start->next;
 if(item==1)
 {
  printf("%d deleted\n",start->data);
  free(start);
  start=temp;
  return;
 }
 temp=start;

 for(i=1;i<item && temp!=NULL;i++)
  temp=temp->next;
 ptr=temp;
 temp->prev->next=temp->next;
 temp->next->prev=temp->prev;
 printf("%d deleted\n",ptr->data);
 free(ptr);

  //printf("%d not found\n",item);
}
void mini()
{
 int minimum;
 if(start==NULL)
 {
  printf("Empty List\n");
  return;
 }
 if(start->prev==NULL && start->next==NULL)
 {
  printf("%d\n",start->data);
  return;
 }
 temp=start;
 minimum=temp->data;
 while(temp!=NULL)
 {
  if((temp->data) < minimum)
   minimum=temp->data;
  temp=temp->next;
 }
 printf("Minimum = %d\n",minimum);
}
void display()
{
 temp=start;
 if(start==NULL)
 {
  printf("Empty List\n");
  return;
 }
 while(temp!=NULL)
 {
  printf("%d\t",temp->data);
  temp=temp->next;
 }
}
void main()
{
 int ch;
 clrscr();
 while(1)
 {
  printf("\n1.Insert\n2.Delete\n3.Display\n4.Mininum\n5.Exit\nEnter choice : ");
  scanf("%d",&ch);
  switch(ch)
  {
   case 1:insert();
	  break;
   case 2:deletion();
	  break;
   case 3:display();
	  break;
   case 4:mini();
	  break;
   case 5:exit(0);
  }
 }
}